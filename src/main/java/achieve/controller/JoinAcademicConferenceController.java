package achieve.controller;

import achieve.dao.AttachmentDaoImpl;
import achieve.dao.JoinAcademicConferenceDaoImpl;
import achieve.dao.TeacherAchieDaoImpl;
import achieve.dao.TeacherDaoImpl;
import achieve.pojo.Attachment;
import achieve.pojo.JoinAcademicConference;
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
@RequestMapping("/joinAcademicConference")
public class JoinAcademicConferenceController extends BaseController {

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private TeacherAchieService teacherAchieService;

    private static JoinAcademicConferenceDaoImpl joinAcademicConferenceDaoImpl =  new JoinAcademicConferenceDaoImpl();
    private static TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
    private static AttachmentDaoImpl attachmentDaoImpl = new AttachmentDaoImpl();

    @RequestMapping("/index")
    public String index(Map<String,Object> model, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);
        List<JoinAcademicConference> joinAcademicConferenceList = joinAcademicConferenceDaoImpl.findAll(teacher.getId(), "");
        model.put("joinAcademicConferenceList", joinAcademicConferenceList);

        return "joinAcademicConference/index";
    }

    @RequestMapping("/admin_index")
    public String admin_index(Map<String,Object> model, HttpSession session){
        List<JoinAcademicConference> joinAcademicConferenceList = joinAcademicConferenceDaoImpl.adminFindAll("");
        model.put("joinAcademicConferenceList", joinAcademicConferenceList);

        return "joinAcademicConference/admin_index";
    }

    @RequestMapping("/add")
    public String add(){
        return "joinAcademicConference/add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(JoinAcademicConference joinAcademicConference, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("joinAcademicConference=" + joinAcademicConference);

        String url = null;
        if(!file.isEmpty()){
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        System.out.println("last_result===" + url);

        int joinAcademicConferenceId = joinAcademicConferenceDaoImpl.addJoinAcademicConference(joinAcademicConference);
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);

//        int attachmentGroupId = AttachmentGroupService.getOrSetValue(joinAcademicConferenceId, "JoinAcademicConference", userId);

        if(url != null) {
            attachmentService.setValue(file, url, userId, joinAcademicConferenceId, "JoinAcademicConference");
        }

        teacherAchieService.setValue(joinAcademicConferenceId, teacher, "JoinAcademicConference", "research", "submit");

        if(userId == 1){
            return "redirect:admin_index";
        }else{
            return "redirect:index";
        }
    }

    @RequestMapping("/show")
    public String show(Map<String,Object> model, HttpServletRequest request){
        String joinAcademicConferenceId = request.getParameter("joinAcademicConferenceId");
        JoinAcademicConference joinAcademicConference = joinAcademicConferenceDaoImpl.findById(Integer.parseInt(joinAcademicConferenceId));
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(joinAcademicConference.getId(), "JoinAcademicConference");
        model.put("joinAcademicConference", joinAcademicConference);
        System.out.println("joinAcademicConference=" + joinAcademicConference);
        System.out.println("file=" + attachment);
        model.put("attachment", attachment);
        System.out.println("model=" + model);
        return "joinAcademicConference/show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, Map<String,Object> model){
        String joinAcademicConferenceId = request.getParameter("joinAcademicConferenceId");
        JoinAcademicConference joinAcademicConference = joinAcademicConferenceDaoImpl.findById(Integer.parseInt(joinAcademicConferenceId));
        model.put("joinAcademicConference", joinAcademicConference);
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(joinAcademicConference.getId(), "JoinAcademicConference");
        model.put("attachment", attachment);
        return "joinAcademicConference/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("joinAcademicConference") JoinAcademicConference joinAcademicConference, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("file1=" + file);
        String url = null;
        if(!file.isEmpty()) {
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        Integer userId = (Integer) session.getAttribute("userId");

        System.out.println("joinAcademicConference=" + joinAcademicConference);
        System.out.println("file=" + file);

        joinAcademicConferenceDaoImpl.editJoinAcademicConference(joinAcademicConference);

        System.out.println("joinAcademicConferenceId=" + joinAcademicConference.getId());

        if(url != null) {
            Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(joinAcademicConference.getId(), "JoinAcademicConference");

            System.out.println("原来的attachment=" + attachment);

            if (attachment != null) {
                System.out.println("进来了1");
                attachmentDaoImpl.deleteAttachment(attachment.getId());
            }

            attachmentService.setValue(file, url, userId, joinAcademicConference.getId(), "JoinAcademicConference");

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

            List<JoinAcademicConference> joinAcademicConferenceList = joinAcademicConferenceDaoImpl.findAll(teacher.getId(), querySql);

            System.out.println("joinAcademicConferenceList====>" + joinAcademicConferenceList);

            model.put("joinAcademicConferenceList", joinAcademicConferenceList);

            System.out.println("model====>" + model);

            return "joinAcademicConference/search";

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

            List<JoinAcademicConference> joinAcademicConferenceList = joinAcademicConferenceDaoImpl.adminFindAll(querySql);

            System.out.println("joinAcademicConferenceList====>" + joinAcademicConferenceList);

            model.put("joinAcademicConferenceList", joinAcademicConferenceList);

            System.out.println("model====>" + model);

            return "joinAcademicConference/admin_search";

        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

}
