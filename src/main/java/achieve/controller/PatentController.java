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

    // 普通用户的专利管理页面
    @RequestMapping("/index")
    public String index(Map<String,Object> model, HttpSession session){
        // 从session缓存中取到用户id
        Integer userId = (Integer) session.getAttribute("userId");
        // 根据用户id获取到对应的老师记录
        Teacher teacher = teacherDaoImpl.findByUserId(userId);
        // 查询出当前用户的所有专利记录
        List<Patent> patentList = patentDaoImpl.findAll(teacher.getId(), "");
        // 放到model中推送到前端
        model.put("patentList", patentList);

        // 访问index.jsp前端页面
        return "patent/index";
    }

    // 管理员专利管理页面
    @RequestMapping("/admin_index")
    public String admin_index(Map<String,Object> model, HttpSession session){
        // 查看所有用户的专利信息
        List<Patent> patentList = patentDaoImpl.adminFindAll("");
        model.put("patentList", patentList);

        return "patent/admin_index";
    }

    // 新增专利页面
    @RequestMapping("/add")
    public String add(){
        return "patent/add";
    }

    // 新增专利的具体操作
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Patent patent, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("patent=" + patent);

        // 上传附件到七牛云
        String url = null;
        if(!file.isEmpty()){
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        System.out.println("last_result===" + url);

        // 新建专利数据
        int patentId = patentDaoImpl.addPatent(patent);
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);

//        int attachmentGroupId = AttachmentGroupService.getOrSetValue(patentId, "Patent", userId);

        // 如果成功上传，则在数据库创建attachment对象，为了之后在页面显示和下载
        if(url != null) {
            attachmentService.setValue(file, url, userId, patentId, "Patent");
        }

        // 创建中间表teacher_achie
        teacherAchieService.setValue(patentId, teacher, "Patent", "research", "submit");

        // 判断用户角色，如果是管理员，则跳转到管理员的列表页，如果是普通用户，就跳转到普通用户的列表页
        String userType = (String) session.getAttribute("userType");

        if("admin".equals(userType)){
            return "redirect:admin_index";
        }else{
            return "redirect:index";
        }
    }

    // 查看详情页面
    @RequestMapping("/show")
    public String show(Map<String,Object> model, HttpServletRequest request){
        // 获取到专利id
        String patentId = request.getParameter("patentId");
        // 根据专利id去数据库中查看专利数据
        Patent patent = patentDaoImpl.findById(Integer.parseInt(patentId));
        // 根据专利id去数据库中查看上传的附件
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(patent.getId(), "Patent");
        // 推送到前端显示
        model.put("patent", patent);
        System.out.println("patent=" + patent);
        System.out.println("file=" + attachment);
        model.put("attachment", attachment);
        System.out.println("model=" + model);
        return "patent/show";
    }

    // 编辑专利页面
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, Map<String,Object> model){
        // 获取到专利id
        String patentId = request.getParameter("patentId");
        // 根据id去数据库中得到专利信息
        Patent patent = patentDaoImpl.findById(Integer.parseInt(patentId));
        model.put("patent", patent);
        // 根据专利id去数据库中查看上传的附件
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(patent.getId(), "Patent");
        model.put("attachment", attachment);
        return "patent/edit";
    }

    // update是编辑专利的处理过程
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("patent") Patent patent, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("file1=" + file);
        // 上传新的附件
        String url = null;
        if(!file.isEmpty()) {
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        Integer userId = (Integer) session.getAttribute("userId");

        System.out.println("patent=" + patent);
        System.out.println("file=" + file);

        // 修改专利
        patentDaoImpl.editPatent(patent);

        System.out.println("patentId=" + patent.getId());

        // 如果有新的附件那么就要把之前的attachment删除并生成新的attachment对象
        if(url != null) {
            Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(patent.getId(), "Patent");

            System.out.println("原来的attachment=" + attachment);

            if (attachment != null) {
                System.out.println("进来了1");
                attachmentDaoImpl.deleteAttachment(attachment.getId());
            }

            attachmentService.setValue(file, url, userId, patent.getId(), "Patent");

        }

        // 根据用户角色跳转到不同的列表页
        String userType = (String) session.getAttribute("userType");

        if("admin".equals(userType)){
            return "redirect:admin_index";
        }else{
            return "redirect:index";
        }
    }

    // 查询按钮对应的方法
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(HttpServletRequest request, Map<String,Object> model, HttpSession session) throws Exception {

        try {

            System.out.println("request===>" + request);

            // 根据前端传的参数生成查询语句
            String querySql = QueryUtil.generateQuerySql(request);
            System.out.println("querysql====>" + querySql);

            Integer userId = (Integer) session.getAttribute("userId");
            Teacher teacher = teacherDaoImpl.findByUserId(userId);

            // 根据查询语句去数据库中查找
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

    // 管理员的查询按钮
    @RequestMapping(value = "/admin_search", method = RequestMethod.POST)
    public String admin_search(HttpServletRequest request, Map<String,Object> model, HttpSession session) throws Exception {

        try {

            System.out.println("request===>" + request);

            // 根据前端传的参数生成查询语句
            String querySql = QueryUtil.generateQuerySql(request);
            System.out.println("querysql====>" + querySql);

            // 管理员的查询方法 可以查看所有用户数据
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
