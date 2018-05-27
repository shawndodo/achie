package achieve.controller;

import achieve.dao.AttachmentDaoImpl;
import achieve.dao.ResearchProjectDaoImpl;
import achieve.dao.TeacherAchieDaoImpl;
import achieve.dao.TeacherDaoImpl;
import achieve.pojo.Attachment;
import achieve.pojo.ResearchProject;
import achieve.pojo.Teacher;
import achieve.service.AttachmentService;
import achieve.service.TeacherAchieService;
import achieve.util.QiniuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/researchProject")
public class ResearchProjectController {

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private TeacherAchieService teacherAchieService;

    private static ResearchProjectDaoImpl researchProjectDaoImpl =  new ResearchProjectDaoImpl();
    private static TeacherAchieDaoImpl teacherAchieDaoImpl = new TeacherAchieDaoImpl();
    private static TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
    private static AttachmentDaoImpl attachmentDaoImpl = new AttachmentDaoImpl();

    @InitBinder
    public void InitBinder(HttpServletRequest request,
                           ServletRequestDataBinder binder) {
        // 不要删除下行注释!!! 将来"yyyy-MM-dd"将配置到properties文件中
        // SimpleDateFormat dateFormat = new
        // SimpleDateFormat(getText("date.format", request.getLocale()));
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null, new CustomDateEditor(
                dateFormat, true));
    }


    @RequestMapping("/index")
    public String index(Map<String,Object> model, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);
        List<ResearchProject> researchProjectList = researchProjectDaoImpl.findAll(teacher.getId());
        model.put("researchProjectList", researchProjectList);

        return "researchProject/index";
    }

    @RequestMapping("/add")
    public String add(){
        return "researchProject/add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(ResearchProject researchProject, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("researchProject=" + researchProject);

        String url = null;
        if(!file.isEmpty()){
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        System.out.println("last_result===" + url);

        int researchProjectId = researchProjectDaoImpl.addResearchProject(researchProject);
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);

//        int attachmentGroupId = AttachmentGroupService.getOrSetValue(researchProjectId, "ResearchProject", userId);

        if(url != null) {
            attachmentService.setValue(file, url, userId, researchProjectId, "ResearchProject");
        }

        teacherAchieService.setValue(researchProjectId, teacher, "ResearchProject", "research", "submit");

        return "redirect:index";
    }

    @RequestMapping("/show")
    public String show(Map<String,Object> model, HttpServletRequest request){
        String researchProjectId = request.getParameter("researchProjectId");
        ResearchProject researchProject = researchProjectDaoImpl.findById(Integer.parseInt(researchProjectId));
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(researchProject.getId(), "ResearchProject");
        model.put("researchProject", researchProject);
        System.out.println("researchProject=" + researchProject);
        System.out.println("file=" + attachment);
        model.put("attachment", attachment);
        System.out.println("model=" + model);
        return "researchProject/show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, Map<String,Object> model){
        String researchProjectId = request.getParameter("researchProjectId");
        ResearchProject researchProject = researchProjectDaoImpl.findById(Integer.parseInt(researchProjectId));
        model.put("researchProject", researchProject);
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(researchProject.getId(), "ResearchProject");
        model.put("attachment", attachment);
        return "researchProject/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("researchProject") ResearchProject researchProject, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("file1=" + file);
        String url = null;
        if(!file.isEmpty()) {
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        Integer userId = (Integer) session.getAttribute("userId");

        System.out.println("researchProject=" + researchProject);
        System.out.println("file=" + file);

        researchProjectDaoImpl.editResearchProject(researchProject);

        System.out.println("researchProjectId=" + researchProject.getId());

        if(url != null) {
            Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(researchProject.getId(), "ResearchProject");

            System.out.println("原来的attachment=" + attachment);

            if (attachment != null) {
                System.out.println("进来了1");
                attachmentDaoImpl.deleteAttachment(attachment.getId());
            }

            attachmentService.setValue(file, url, userId, researchProject.getId(), "ResearchProject");

        }

        return "redirect:index";
    }

}
