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
@RequestMapping("/joinAcademicConference")
public class JoinAcademicConferenceController {

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private TeacherAchieService teacherAchieService;

    private static JoinAcademicConferenceDaoImpl joinAcademicConferenceDaoImpl =  new JoinAcademicConferenceDaoImpl();
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
        List<JoinAcademicConference> joinAcademicConferenceList = joinAcademicConferenceDaoImpl.findAll(teacher.getId());
        model.put("joinAcademicConferenceList", joinAcademicConferenceList);

        return "joinAcademicConference/index";
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

        return "redirect:index";
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

        return "redirect:index";
    }

}
