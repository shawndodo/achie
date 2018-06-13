package achieve.controller;

import achieve.dao.AttachmentDaoImpl;
import achieve.dao.TeachReformResearchProjectDaoImpl;
import achieve.dao.TeacherAchieDaoImpl;
import achieve.dao.TeacherDaoImpl;
import achieve.pojo.Attachment;
import achieve.pojo.TeachReformResearchProject;
import achieve.pojo.Teacher;
import achieve.service.AttachmentService;
import achieve.service.TeacherAchieService;
import achieve.util.QiniuUtil;
import achieve.util.QueryUtil;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teachReformResearchProject")
public class TeachReformResearchProjectController extends BaseController {

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private TeacherAchieService teacherAchieService;

    private static TeachReformResearchProjectDaoImpl teachReformResearchProjectDaoImpl =  new TeachReformResearchProjectDaoImpl();
    private static TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
    private static AttachmentDaoImpl attachmentDaoImpl = new AttachmentDaoImpl();

    @RequestMapping("/index")
    public String index(Map<String,Object> model, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);
        List<TeachReformResearchProject> teachReformResearchProjectList = teachReformResearchProjectDaoImpl.findAll(teacher.getId(), "");
        model.put("teachReformResearchProjectList", teachReformResearchProjectList);

        return "teachReformResearchProject/index";
    }

    @RequestMapping("/add")
    public String add(){
        return "teachReformResearchProject/add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(TeachReformResearchProject teachReformResearchProject, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("teachReformResearchProject=" + teachReformResearchProject);

        String url = null;
        if(!file.isEmpty()){
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        System.out.println("last_result===" + url);

        int teachReformResearchProjectId = teachReformResearchProjectDaoImpl.addTeachReformResearchProject(teachReformResearchProject);
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);

//        int attachmentGroupId = AttachmentGroupService.getOrSetValue(teachReformResearchProjectId, "TeachReformResearchProject", userId);

        if(url != null) {
            attachmentService.setValue(file, url, userId, teachReformResearchProjectId, "TeachReformResearchProject");
        }

        teacherAchieService.setValue(teachReformResearchProjectId, teacher, "TeachReformResearchProject", "teach", "submit");

        return "redirect:index";
    }

    @RequestMapping("/show")
    public String show(Map<String,Object> model, HttpServletRequest request){
        String teachReformResearchProjectId = request.getParameter("teachReformResearchProjectId");
        TeachReformResearchProject teachReformResearchProject = teachReformResearchProjectDaoImpl.findById(Integer.parseInt(teachReformResearchProjectId));
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(teachReformResearchProject.getId(), "TeachReformResearchProject");
        model.put("teachReformResearchProject", teachReformResearchProject);
        System.out.println("teachReformResearchProject=" + teachReformResearchProject);
        System.out.println("file=" + attachment);
        model.put("attachment", attachment);
        System.out.println("model=" + model);
        return "teachReformResearchProject/show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, Map<String,Object> model){
        String teachReformResearchProjectId = request.getParameter("teachReformResearchProjectId");
        TeachReformResearchProject teachReformResearchProject = teachReformResearchProjectDaoImpl.findById(Integer.parseInt(teachReformResearchProjectId));
        model.put("teachReformResearchProject", teachReformResearchProject);
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(teachReformResearchProject.getId(), "TeachReformResearchProject");
        model.put("attachment", attachment);
        return "teachReformResearchProject/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("teachReformResearchProject") TeachReformResearchProject teachReformResearchProject, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("file1=" + file);
        String url = null;
        if(!file.isEmpty()) {
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        Integer userId = (Integer) session.getAttribute("userId");

        System.out.println("teachReformResearchProject=" + teachReformResearchProject);
        System.out.println("file=" + file);

        teachReformResearchProjectDaoImpl.editTeachReformResearchProject(teachReformResearchProject);

        System.out.println("teachReformResearchProjectId=" + teachReformResearchProject.getId());

        if(url != null) {
            Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(teachReformResearchProject.getId(), "TeachReformResearchProject");

            System.out.println("原来的attachment=" + attachment);

            if (attachment != null) {
                System.out.println("进来了1");
                attachmentDaoImpl.deleteAttachment(attachment.getId());
            }

            attachmentService.setValue(file, url, userId, teachReformResearchProject.getId(), "TeachReformResearchProject");

        }

        return "redirect:index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(HttpServletRequest request, Map<String,Object> model, HttpSession session) throws Exception {

        try {

            System.out.println("request===>" + request);

            String querySql = QueryUtil.generateQuerySql(request);
            System.out.println("querysql====>" + querySql);

            Integer userId = (Integer) session.getAttribute("userId");
            Teacher teacher = teacherDaoImpl.findByUserId(userId);

            List<TeachReformResearchProject> teachReformResearchProjectList = teachReformResearchProjectDaoImpl.findAll(teacher.getId(), querySql);

            System.out.println("teachReformResearchProjectList====>" + teachReformResearchProjectList);

            model.put("teachReformResearchProjectList", teachReformResearchProjectList);

            System.out.println("model====>" + model);

            return "teachReformResearchProject/search";

        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

}
