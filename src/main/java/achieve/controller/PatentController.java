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
public class PatentController {

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private TeacherAchieService teacherAchieService;

    private static PatentDaoImpl patentDaoImpl =  new PatentDaoImpl();
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
        List<Patent> patentList = patentDaoImpl.findAll(teacher.getId());
        model.put("patentList", patentList);

        return "patent/index";
    }

    @RequestMapping("/add")
    public String add(){
        return "patent/add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Patent patent, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("patent=" + patent);

        String url = QiniuUtil.uploadToQiNiuYun(file);

        System.out.println("last_result===" + url);

        int patentId = patentDaoImpl.addPatent(patent);
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);

//        int attachmentGroupId = AttachmentGroupService.getOrSetValue(patentId, "Patent", userId);

        attachmentService.setValue(file, url, userId, patentId, "Patent");

        teacherAchieService.setValue(patentId, teacher);

        return "redirect:index";
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
        String url = QiniuUtil.uploadToQiNiuYun(file);

        Integer userId = (Integer) session.getAttribute("userId");

        System.out.println("patent=" + patent);
        System.out.println("file=" + file);

        patentDaoImpl.editPatent(patent);

        System.out.println("patentId=" + patent.getId());

        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(patent.getId(), "Patent");

        System.out.println("原来的attachment=" + attachment);

        if (attachment != null) {
            System.out.println("进来了1");
            attachmentDaoImpl.deleteAttachment(attachment.getId());
        }

        attachmentService.setValue(file, url, userId, patent.getId(), "Patent");

        return "redirect:index";
    }

}
