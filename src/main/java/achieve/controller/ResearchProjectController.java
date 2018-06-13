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
@RequestMapping("/researchProject")
public class ResearchProjectController extends BaseController {

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private TeacherAchieService teacherAchieService;

    private static ResearchProjectDaoImpl researchProjectDaoImpl =  new ResearchProjectDaoImpl();
    private static TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
    private static AttachmentDaoImpl attachmentDaoImpl = new AttachmentDaoImpl();

    @RequestMapping("/index")
    public String index(Map<String,Object> model, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);
        List<ResearchProject> researchProjectList = researchProjectDaoImpl.findAll(teacher.getId(), "");
        model.put("researchProjectList", researchProjectList);

        return "researchProject/index";
    }

    @RequestMapping("/admin_index")
    public String admin_index(Map<String,Object> model, HttpSession session){
        List<ResearchProject> researchProjectList = researchProjectDaoImpl.adminFindAll("");
        model.put("researchProjectList", researchProjectList);

        return "researchProject/admin_index";
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

        if(userId == 1){
            return "redirect:admin_index";
        }else{
            return "redirect:index";
        }
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

        if(userId == 1){
            return "redirect:admin_index";
        }else{
            return "redirect:index";
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(HttpServletRequest request, Map<String,Object> model, HttpSession session) throws Exception {

        try {

            System.out.println("request===>" + request);

            String querySql = QueryUtil.generateQuerySql(request);
            System.out.println("querysql====>" + querySql);

            Integer userId = (Integer) session.getAttribute("userId");
            Teacher teacher = teacherDaoImpl.findByUserId(userId);

            List<ResearchProject> researchProjectList = researchProjectDaoImpl.findAll(teacher.getId(), querySql);

            System.out.println("researchProjectList====>" + researchProjectList);

            model.put("researchProjectList", researchProjectList);

            System.out.println("model====>" + model);

            return "researchProject/search";

        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    @RequestMapping(value = "/admin_search", method = RequestMethod.POST)
    public String admin_search(HttpServletRequest request, Map<String,Object> model, HttpSession session) throws Exception {

        try {

            System.out.println("request===>" + request);

            String querySql = QueryUtil.generateQuerySql(request);
            System.out.println("querysql====>" + querySql);

            List<ResearchProject> researchProjectList = researchProjectDaoImpl.adminFindAll(querySql);

            System.out.println("researchProjectList====>" + researchProjectList);

            model.put("researchProjectList", researchProjectList);

            System.out.println("model====>" + model);

            return "researchProject/admin_search";

        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

}
