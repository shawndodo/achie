package achieve.controller;

import achieve.dao.AttachmentDaoImpl;
import achieve.dao.TeachAwardDaoImpl;
import achieve.dao.TeacherAchieDaoImpl;
import achieve.dao.TeacherDaoImpl;
import achieve.pojo.Attachment;
import achieve.pojo.TeachAward;
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
@RequestMapping("/teachAward")
public class TeachAwardController extends BaseController {

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private TeacherAchieService teacherAchieService;

    private static TeachAwardDaoImpl teachAwardDaoImpl =  new TeachAwardDaoImpl();
    private static TeacherAchieDaoImpl teacherAchieDaoImpl = new TeacherAchieDaoImpl();
    private static TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
    private static AttachmentDaoImpl attachmentDaoImpl = new AttachmentDaoImpl();

    @RequestMapping("/index")
    public String index(Map<String,Object> model, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);
        List<TeachAward> teachAwardList = teachAwardDaoImpl.findAll(teacher.getId(), "");
        model.put("teachAwardList", teachAwardList);

        return "teachAward/index";
    }

    @RequestMapping("/add")
    public String add(){
        return "teachAward/add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(TeachAward teachAward, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("teachAward=" + teachAward);

        String url = null;
        if(!file.isEmpty()){
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        System.out.println("last_result===" + url);

        int teachAwardId = teachAwardDaoImpl.addTeachAward(teachAward);
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);

//        int attachmentGroupId = AttachmentGroupService.getOrSetValue(teachAwardId, "TeachAward", userId);

        if(url != null) {
            attachmentService.setValue(file, url, userId, teachAwardId, "TeachAward");
        }

        teacherAchieService.setValue(teachAwardId, teacher, "TeachAward", "teach", "submit");

        return "redirect:index";
    }

    @RequestMapping("/show")
    public String show(Map<String,Object> model, HttpServletRequest request){
        String teachAwardId = request.getParameter("teachAwardId");
        TeachAward teachAward = teachAwardDaoImpl.findById(Integer.parseInt(teachAwardId));
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(teachAward.getId(), "TeachAward");
        model.put("teachAward", teachAward);
        System.out.println("teachAward=" + teachAward);
        System.out.println("file=" + attachment);
        model.put("attachment", attachment);
        System.out.println("model=" + model);
        return "teachAward/show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, Map<String,Object> model){
        String teachAwardId = request.getParameter("teachAwardId");
        TeachAward teachAward = teachAwardDaoImpl.findById(Integer.parseInt(teachAwardId));
        model.put("teachAward", teachAward);
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(teachAward.getId(), "TeachAward");
        model.put("attachment", attachment);
        return "teachAward/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("teachAward") TeachAward teachAward, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("file1=" + file);
        String url = null;
        if(!file.isEmpty()) {
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        Integer userId = (Integer) session.getAttribute("userId");

        System.out.println("teachAward=" + teachAward);
        System.out.println("file=" + file);

        teachAwardDaoImpl.editTeachAward(teachAward);

        System.out.println("teachAwardId=" + teachAward.getId());

        if(url != null) {
            Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(teachAward.getId(), "TeachAward");

            System.out.println("原来的attachment=" + attachment);

            if (attachment != null) {
                System.out.println("进来了1");
                attachmentDaoImpl.deleteAttachment(attachment.getId());
            }

            attachmentService.setValue(file, url, userId, teachAward.getId(), "TeachAward");

        }

        return "redirect:index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(HttpServletRequest request, Map<String,Object> model, HttpSession session) throws Exception {

        try {

            System.out.println("request===>" + request);

//            String nameValue = request.getParameter("like_patent.patentName");
//            String createdAt = request.getParameter("between_join_academic_conference.createdAt");
//            String level = request.getParameter("between_patent.createdAt");
//
//            System.out.println("nameValue===>" + nameValue);
//            System.out.println("createdAt===>" + createdAt);

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("like_teach_award.awardName", request.getParameter("like_teach_award.awardName"));
            map.put("teach_award.level", request.getParameter("teach_award.level"));
            map.put("between_teach_award.createdAt", request.getParameter("between_teach_award.createdAt"));
            System.out.println("map====" + map);

            String querySql = QueryUtil.convertQueryParams(map);

            System.out.println("querysql====>" + querySql);

            Integer userId = (Integer) session.getAttribute("userId");
            Teacher teacher = teacherDaoImpl.findByUserId(userId);

            List<TeachAward> teachAwardList = teachAwardDaoImpl.findAll(teacher.getId(), querySql);

            System.out.println("teachAwardList====>" + teachAwardList);

            model.put("teachAwardList", teachAwardList);

            System.out.println("model====>" + model);

            return "teachAward/search";

//            if(teachAwardList != null && !teachAwardList.isEmpty()){
//                System.out.println("2222");
//                return "teachAward/search";
//            }else{
//                System.out.println("3333");
//                return "share/noDate";
//            }


        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

}
