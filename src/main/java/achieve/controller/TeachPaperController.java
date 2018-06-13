package achieve.controller;

import achieve.dao.AttachmentDaoImpl;
import achieve.dao.TeachPaperDaoImpl;
import achieve.dao.TeacherAchieDaoImpl;
import achieve.dao.TeacherDaoImpl;
import achieve.pojo.Attachment;
import achieve.pojo.TeachPaper;
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
@RequestMapping("/teachPaper")
public class TeachPaperController extends BaseController {

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private TeacherAchieService teacherAchieService;

    private static TeachPaperDaoImpl teachPaperDaoImpl =  new TeachPaperDaoImpl();
    private static TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
    private static AttachmentDaoImpl attachmentDaoImpl = new AttachmentDaoImpl();

    @RequestMapping("/index")
    public String index(Map<String,Object> model, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);
        List<TeachPaper> teachPaperList = teachPaperDaoImpl.findAll(teacher.getId(), "");
        model.put("teachPaperList", teachPaperList);

        return "teachPaper/index";
    }

    @RequestMapping("/admin_index")
    public String admin_index(Map<String,Object> model, HttpSession session){
        List<TeachPaper> teachPaperList = teachPaperDaoImpl.adminFindAll("");
        model.put("teachPaperList", teachPaperList);

        return "teachPaper/admin_index";
    }

    @RequestMapping("/add")
    public String add(){
        return "teachPaper/add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(TeachPaper teachPaper, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("teachPaper=" + teachPaper);

        String url = null;
        if(!file.isEmpty()){
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        System.out.println("last_result===" + url);

        int teachPaperId = teachPaperDaoImpl.addTeachPaper(teachPaper);
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);

//        int attachmentGroupId = AttachmentGroupService.getOrSetValue(teachPaperId, "TeachPaper", userId);

        if(url != null) {
            attachmentService.setValue(file, url, userId, teachPaperId, "TeachPaper");
        }

        teacherAchieService.setValue(teachPaperId, teacher, "TeachPaper", "teach", "submit");

        if(userId == 1){
            return "redirect:admin_index";
        }else{
            return "redirect:index";
        }
    }

    @RequestMapping("/show")
    public String show(Map<String,Object> model, HttpServletRequest request){
        String teachPaperId = request.getParameter("teachPaperId");
        TeachPaper teachPaper = teachPaperDaoImpl.findById(Integer.parseInt(teachPaperId));
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(teachPaper.getId(), "TeachPaper");
        model.put("teachPaper", teachPaper);
        System.out.println("teachPaper=" + teachPaper);
        System.out.println("file=" + attachment);
        model.put("attachment", attachment);
        System.out.println("model=" + model);
        return "teachPaper/show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, Map<String,Object> model){
        String teachPaperId = request.getParameter("teachPaperId");
        TeachPaper teachPaper = teachPaperDaoImpl.findById(Integer.parseInt(teachPaperId));
        model.put("teachPaper", teachPaper);
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(teachPaper.getId(), "TeachPaper");
        model.put("attachment", attachment);
        return "teachPaper/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("teachPaper") TeachPaper teachPaper, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("file1=" + file);
        String url = null;
        if(!file.isEmpty()) {
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        Integer userId = (Integer) session.getAttribute("userId");

        System.out.println("teachPaper=" + teachPaper);
        System.out.println("file=" + file);

        teachPaperDaoImpl.editTeachPaper(teachPaper);

        System.out.println("teachPaperId=" + teachPaper.getId());

        if(url != null) {
            Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(teachPaper.getId(), "TeachPaper");

            System.out.println("原来的attachment=" + attachment);

            if (attachment != null) {
                System.out.println("进来了1");
                attachmentDaoImpl.deleteAttachment(attachment.getId());
            }

            attachmentService.setValue(file, url, userId, teachPaper.getId(), "TeachPaper");

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

            List<TeachPaper> teachPaperList = teachPaperDaoImpl.findAll(teacher.getId(), querySql);

            System.out.println("teachPaperList====>" + teachPaperList);

            model.put("teachPaperList", teachPaperList);

            System.out.println("model====>" + model);

            return "teachPaper/search";

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

            List<TeachPaper> teachPaperList = teachPaperDaoImpl.adminFindAll(querySql);

            System.out.println("teachPaperList====>" + teachPaperList);

            model.put("teachPaperList", teachPaperList);

            System.out.println("model====>" + model);

            return "teachPaper/admin_search";

        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

}
