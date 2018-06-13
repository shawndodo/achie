package achieve.controller;

import achieve.dao.*;
import achieve.pojo.Attachment;
import achieve.pojo.StudentProject;
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
@RequestMapping("/studentProject")
public class StudentProjectController extends BaseController {

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private TeacherAchieService teacherAchieService;

    private static StudentProjectDaoImpl studentProjectDaoImpl =  new StudentProjectDaoImpl();
    private static TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
    private static AttachmentDaoImpl attachmentDaoImpl = new AttachmentDaoImpl();

    @RequestMapping("/index")
    public String index(Map<String,Object> model, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);
        List<StudentProject> studentProjectList = studentProjectDaoImpl.findAll(teacher.getId(), "");
        model.put("studentProjectList", studentProjectList);

        return "studentProject/index";
    }

    @RequestMapping("/add")
    public String add(){
        return "studentProject/add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(StudentProject studentProject, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("studentProject=" + studentProject);

        String url = null;
        if(!file.isEmpty()){
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        System.out.println("last_result===" + url);

        int studentProjectId = studentProjectDaoImpl.addStudentProject(studentProject);
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);

//        int attachmentGroupId = AttachmentGroupService.getOrSetValue(studentProjectId, "StudentProject", userId);

        if(url != null) {
            attachmentService.setValue(file, url, userId, studentProjectId, "StudentProject");
        }

        teacherAchieService.setValue(studentProjectId, teacher, "StudentProject", "teach", "submit");

        return "redirect:index";
    }

    @RequestMapping("/show")
    public String show(Map<String,Object> model, HttpServletRequest request){
        String studentProjectId = request.getParameter("studentProjectId");
        StudentProject studentProject = studentProjectDaoImpl.findById(Integer.parseInt(studentProjectId));
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(studentProject.getId(), "StudentProject");
        model.put("studentProject", studentProject);
        System.out.println("studentProject=" + studentProject);
        System.out.println("file=" + attachment);
        model.put("attachment", attachment);
        System.out.println("model=" + model);
        return "studentProject/show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, Map<String,Object> model){
        String studentProjectId = request.getParameter("studentProjectId");
        StudentProject studentProject = studentProjectDaoImpl.findById(Integer.parseInt(studentProjectId));
        model.put("studentProject", studentProject);
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(studentProject.getId(), "StudentProject");
        model.put("attachment", attachment);
        return "studentProject/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("studentProject") StudentProject studentProject, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("file1=" + file);
        String url = null;
        if(!file.isEmpty()) {
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        Integer userId = (Integer) session.getAttribute("userId");

        System.out.println("studentProject=" + studentProject);
        System.out.println("file=" + file);

        studentProjectDaoImpl.editStudentProject(studentProject);

        System.out.println("studentProjectId=" + studentProject.getId());

        if(url != null) {
            Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(studentProject.getId(), "StudentProject");

            System.out.println("原来的attachment=" + attachment);

            if (attachment != null) {
                System.out.println("进来了1");
                attachmentDaoImpl.deleteAttachment(attachment.getId());
            }

            attachmentService.setValue(file, url, userId, studentProject.getId(), "StudentProject");

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

            List<StudentProject> studentProjectList = studentProjectDaoImpl.findAll(teacher.getId(), querySql);

            System.out.println("studentProjectList====>" + studentProjectList);

            model.put("studentProjectList", studentProjectList);

            System.out.println("model====>" + model);

            return "studentProject/search";

        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

}
