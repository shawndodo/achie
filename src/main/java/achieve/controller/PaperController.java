package achieve.controller;

import achieve.dao.AttachmentDaoImpl;
import achieve.dao.PaperDaoImpl;
import achieve.dao.TeacherAchieDaoImpl;
import achieve.dao.TeacherDaoImpl;
import achieve.pojo.Attachment;
import achieve.pojo.Paper;
import achieve.pojo.Teacher;
import achieve.service.AttachmentService;
import achieve.service.TeacherAchieService;
import achieve.util.QiniuUtil;
import achieve.util.QueryUtil;
import org.codehaus.jackson.map.Serializers;
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
@RequestMapping("/paper")
public class PaperController extends BaseController {

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private TeacherAchieService teacherAchieService;

    private static PaperDaoImpl paperDaoImpl =  new PaperDaoImpl();
    private static TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
    private static AttachmentDaoImpl attachmentDaoImpl = new AttachmentDaoImpl();

    @RequestMapping("/index")
    public String index(Map<String,Object> model, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);
        List<Paper> paperList = paperDaoImpl.findAll(teacher.getId(), "");
        model.put("paperList", paperList);

        return "paper/index";
    }

    @RequestMapping("/admin_index")
    public String admin_index(Map<String,Object> model, HttpSession session){
        List<Paper> paperList = paperDaoImpl.adminFindAll("");
        model.put("paperList", paperList);

        return "paper/admin_index";
    }

    @RequestMapping("/add")
    public String add(){
        return "paper/add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Paper paper, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("paper=" + paper);

        String url = null;
        if(!file.isEmpty()){
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        System.out.println("last_result===" + url);

        int paperId = paperDaoImpl.addPaper(paper);
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);

//        int attachmentGroupId = AttachmentGroupService.getOrSetValue(paperId, "Paper", userId);

        if(url != null) {
            attachmentService.setValue(file, url, userId, paperId, "Paper");
        }

        teacherAchieService.setValue(paperId, teacher, "Paper", "research", "submit");

        String userType = (String) session.getAttribute("userType");

        if("admin".equals(userType)){
            return "redirect:admin_index";
        }else{
            return "redirect:index";
        }
    }

    @RequestMapping("/show")
    public String show(Map<String,Object> model, HttpServletRequest request){
        String paperId = request.getParameter("paperId");
        Paper paper = paperDaoImpl.findById(Integer.parseInt(paperId));
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(paper.getId(), "Paper");
        model.put("paper", paper);
        System.out.println("paper=" + paper);
        System.out.println("file=" + attachment);
        model.put("attachment", attachment);
        System.out.println("model=" + model);
        return "paper/show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, Map<String,Object> model){
        String paperId = request.getParameter("paperId");
        Paper paper = paperDaoImpl.findById(Integer.parseInt(paperId));
        model.put("paper", paper);
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(paper.getId(), "Paper");
        model.put("attachment", attachment);
        return "paper/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("paper") Paper paper, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("file1=" + file);
        String url = null;
        if(!file.isEmpty()) {
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        Integer userId = (Integer) session.getAttribute("userId");

        System.out.println("paper=" + paper);
        System.out.println("file=" + file);

        paperDaoImpl.editPaper(paper);

        System.out.println("paperId=" + paper.getId());

        if(url != null) {
            Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(paper.getId(), "Paper");

            System.out.println("原来的attachment=" + attachment);

            if (attachment != null) {
                System.out.println("进来了1");
                attachmentDaoImpl.deleteAttachment(attachment.getId());
            }

            attachmentService.setValue(file, url, userId, paper.getId(), "Paper");

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

            List<Paper> paperList = paperDaoImpl.findAll(teacher.getId(), querySql);

            System.out.println("paperList====>" + paperList);

            model.put("paperList", paperList);

            System.out.println("model====>" + model);

            return "paper/search";

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

            List<Paper> paperList = paperDaoImpl.adminFindAll(querySql);

            System.out.println("paperList====>" + paperList);

            model.put("paperList", paperList);

            System.out.println("model====>" + model);

            return "paper/admin_search";

        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

}
