package achieve.controller;

import achieve.dao.AttachmentDaoImpl;
import achieve.dao.TeacherAchieDaoImpl;
import achieve.dao.TeacherDaoImpl;
import achieve.dao.WritingDaoImpl;
import achieve.pojo.Attachment;
import achieve.pojo.Teacher;
import achieve.pojo.TeacherAchie;
import achieve.pojo.Writing;
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
@RequestMapping("/writing")
public class WritingController extends BaseController {

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private TeacherAchieService teacherAchieService;

    private static WritingDaoImpl writingDaoImpl =  new WritingDaoImpl();
    private static TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
    private static AttachmentDaoImpl attachmentDaoImpl = new AttachmentDaoImpl();

    @RequestMapping("/index")
    public String index(Map<String,Object> model, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);
        List<Writing> writingList = writingDaoImpl.findAll(teacher.getId(), "");
        model.put("writingList", writingList);

        return "writing/index";
    }

    @RequestMapping("/admin_index")
    public String admin_index(Map<String,Object> model, HttpSession session){
        List<Writing> writingList = writingDaoImpl.adminFindAll("");
        model.put("writingList", writingList);

        return "writing/admin_index";
    }

    @RequestMapping("/add")
    public String add(){
        return "writing/add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Writing writing, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("writing=" + writing);

        System.out.println("file=" + file.getSize());

        String url = null;
        if(!file.isEmpty()){
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        System.out.println("last_result===" + url);

        int writingId = writingDaoImpl.addWriting(writing);
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);

//        int attachmentGroupId = AttachmentGroupService.getOrSetValue(writingId, "Writing", userId);

        if(url != null){
            attachmentService.setValue(file, url, userId, writingId, "Writing");
        }


        teacherAchieService.setValue(writingId, teacher, "Writing", "teach", "submit");

        String userType = (String) session.getAttribute("userType");

        if("admin".equals(userType)){
            return "redirect:admin_index";
        }else{
            return "redirect:index";
        }
    }

    @RequestMapping("/show")
    public String show(Map<String,Object> model, HttpServletRequest request){
        String writingId = request.getParameter("writingId");
        Writing writing = writingDaoImpl.findById(Integer.parseInt(writingId));
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(writing.getId(), "Writing");
        model.put("writing", writing);
        System.out.println("writing=" + writing);
        System.out.println("file=" + attachment);
        model.put("attachment", attachment);
        System.out.println("model=" + model);
        return "writing/show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, Map<String,Object> model){
        String writingId = request.getParameter("writingId");
        Writing writing = writingDaoImpl.findById(Integer.parseInt(writingId));
        model.put("writing", writing);
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(writing.getId(), "Writing");
        model.put("attachment", attachment);
        return "writing/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("writing") Writing writing, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("file1=" + file);
        String url = null;
        if(!file.isEmpty()) {
            url = QiniuUtil.uploadToQiNiuYun(file);
        }
        Integer userId = (Integer) session.getAttribute("userId");

        System.out.println("url===" + url);
        System.out.println("writing=" + writing);
        System.out.println("file=" + file);

        writingDaoImpl.editWriting(writing);

        System.out.println("writingId=" + writing.getId());

        if(url != null){
            Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(writing.getId(), "Writing");

            System.out.println("原来的attachment=" + attachment);

            if (attachment != null) {
                System.out.println("进来了1");
                attachmentDaoImpl.deleteAttachment(attachment.getId());
            }

            attachmentService.setValue(file, url, userId, writing.getId(), "Writing");
        }

        String userType = (String) session.getAttribute("userType");

        if("admin".equals(userType)){
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

            List<Writing> writingList = writingDaoImpl.findAll(teacher.getId(), querySql);

            System.out.println("writingList====>" + writingList);

            model.put("writingList", writingList);

            System.out.println("model====>" + model);

            return "writing/search";

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

            List<Writing> writingList = writingDaoImpl.adminFindAll(querySql);

            System.out.println("writingList====>" + writingList);

            model.put("writingList", writingList);

            System.out.println("model====>" + model);

            return "writing/admin_search";


        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }


}
