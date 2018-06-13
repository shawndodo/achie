package achieve.controller;

import achieve.dao.AttachmentDaoImpl;
import achieve.dao.PatentDaoImpl;
import achieve.dao.TeacherAchieDaoImpl;
import achieve.dao.TeacherDaoImpl;
import achieve.pojo.*;
import achieve.service.AttachmentGroupService;
import achieve.service.AttachmentService;
import achieve.service.TeacherAchieService;
import achieve.util.QiniuUtil;
import achieve.util.QueryUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletSecurityElement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/patent")
public class PatentController extends BaseController {

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private TeacherAchieService teacherAchieService;

    private static PatentDaoImpl patentDaoImpl =  new PatentDaoImpl();
    private static TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
    private static AttachmentDaoImpl attachmentDaoImpl = new AttachmentDaoImpl();

    @RequestMapping("/index")
    public String index(Map<String,Object> model, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);
        List<Patent> patentList = patentDaoImpl.findAll(teacher.getId(), "");
        model.put("patentList", patentList);

        return "patent/index";
    }

    @RequestMapping("/admin_index")
    public String admin_index(Map<String,Object> model, HttpSession session){
        List<Patent> patentList = patentDaoImpl.adminFindAll("");
        model.put("patentList", patentList);

        return "patent/admin_index";
    }

    @RequestMapping("/add")
    public String add(){
        return "patent/add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Patent patent, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("patent=" + patent);

        String url = null;
        if(!file.isEmpty()){
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        System.out.println("last_result===" + url);

        int patentId = patentDaoImpl.addPatent(patent);
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);

//        int attachmentGroupId = AttachmentGroupService.getOrSetValue(patentId, "Patent", userId);

        if(url != null) {
            attachmentService.setValue(file, url, userId, patentId, "Patent");
        }

        teacherAchieService.setValue(patentId, teacher, "Patent", "research", "submit");

        String userType = (String) session.getAttribute("userType");

        if("admin".equals(userType)){
            return "redirect:admin_index";
        }else{
            return "redirect:index";
        }
    }

    @RequestMapping("/show")
    public String show(Map<String,Object> model, HttpServletRequest request){
        String patentId = request.getParameter("patentId");
        Patent patent = patentDaoImpl.findById(Integer.parseInt(patentId));
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(patent.getId(), "Patent");
        model.put("patent", patent);
        System.out.println("patent=" + patent);
        System.out.println("file=" + attachment);
        model.put("attachment", attachment);
        System.out.println("model=" + model);
        return "patent/show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, Map<String,Object> model){
        String patentId = request.getParameter("patentId");
        Patent patent = patentDaoImpl.findById(Integer.parseInt(patentId));
        model.put("patent", patent);
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(patent.getId(), "Patent");
        model.put("attachment", attachment);
        return "patent/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("patent") Patent patent, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("file1=" + file);
        String url = null;
        if(!file.isEmpty()) {
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        Integer userId = (Integer) session.getAttribute("userId");

        System.out.println("patent=" + patent);
        System.out.println("file=" + file);

        patentDaoImpl.editPatent(patent);

        System.out.println("patentId=" + patent.getId());

        if(url != null) {
            Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(patent.getId(), "Patent");

            System.out.println("原来的attachment=" + attachment);

            if (attachment != null) {
                System.out.println("进来了1");
                attachmentDaoImpl.deleteAttachment(attachment.getId());
            }

            attachmentService.setValue(file, url, userId, patent.getId(), "Patent");

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

            List<Patent> patentList = patentDaoImpl.findAll(teacher.getId(), querySql);

            System.out.println("patentList====>" + patentList);

            model.put("patentList", patentList);

            System.out.println("model====>" + model);

            return "patent/search";

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

            List<Patent> patentList = patentDaoImpl.adminFindAll(querySql);

            System.out.println("patentList====>" + patentList);

            model.put("patentList", patentList);

            System.out.println("model====>" + model);

            return "patent/admin_search";

        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

}
