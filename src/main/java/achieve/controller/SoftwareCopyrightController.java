package achieve.controller;

import achieve.dao.*;
import achieve.pojo.Attachment;
import achieve.pojo.SoftwareCopyright;
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
@RequestMapping("/softwareCopyright")
public class SoftwareCopyrightController {

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private TeacherAchieService teacherAchieService;

    private static SoftwareCopyrightDaoImpl softwareCopyrightDaoImpl =  new SoftwareCopyrightDaoImpl();
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
        List<SoftwareCopyright> softwareCopyrightList = softwareCopyrightDaoImpl.findAll(teacher.getId());
        model.put("softwareCopyrightList", softwareCopyrightList);

        return "softwareCopyright/index";
    }

    @RequestMapping("/add")
    public String add(){
        return "softwareCopyright/add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(SoftwareCopyright softwareCopyright, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("softwareCopyright=" + softwareCopyright);

        String url = null;
        if(!file.isEmpty()){
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        System.out.println("last_result===" + url);

        int softwareCopyrightId = softwareCopyrightDaoImpl.addSoftwareCopyright(softwareCopyright);
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);

//        int attachmentGroupId = AttachmentGroupService.getOrSetValue(softwareCopyrightId, "SoftwareCopyright", userId);

        if(url != null) {
            attachmentService.setValue(file, url, userId, softwareCopyrightId, "SoftwareCopyright");
        }

        teacherAchieService.setValue(softwareCopyrightId, teacher, "SoftwareCopyright", "research", "submit");

        return "redirect:index";
    }

    @RequestMapping("/show")
    public String show(Map<String,Object> model, HttpServletRequest request){
        String softwareCopyrightId = request.getParameter("softwareCopyrightId");
        SoftwareCopyright softwareCopyright = softwareCopyrightDaoImpl.findById(Integer.parseInt(softwareCopyrightId));
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(softwareCopyright.getId(), "SoftwareCopyright");
        model.put("softwareCopyright", softwareCopyright);
        System.out.println("softwareCopyright=" + softwareCopyright);
        System.out.println("file=" + attachment);
        model.put("attachment", attachment);
        System.out.println("model=" + model);
        return "softwareCopyright/show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, Map<String,Object> model){
        String softwareCopyrightId = request.getParameter("softwareCopyrightId");
        SoftwareCopyright softwareCopyright = softwareCopyrightDaoImpl.findById(Integer.parseInt(softwareCopyrightId));
        model.put("softwareCopyright", softwareCopyright);
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(softwareCopyright.getId(), "SoftwareCopyright");
        model.put("attachment", attachment);
        return "softwareCopyright/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("softwareCopyright") SoftwareCopyright softwareCopyright, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("file1=" + file);
        String url = null;
        if(!file.isEmpty()) {
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        Integer userId = (Integer) session.getAttribute("userId");

        System.out.println("softwareCopyright=" + softwareCopyright);
        System.out.println("file=" + file);

        softwareCopyrightDaoImpl.editSoftwareCopyright(softwareCopyright);

        System.out.println("softwareCopyrightId=" + softwareCopyright.getId());

        if(url != null) {
            Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(softwareCopyright.getId(), "SoftwareCopyright");

            System.out.println("原来的attachment=" + attachment);

            if (attachment != null) {
                System.out.println("进来了1");
                attachmentDaoImpl.deleteAttachment(attachment.getId());
            }

            attachmentService.setValue(file, url, userId, softwareCopyright.getId(), "SoftwareCopyright");

        }

        return "redirect:index";
    }

}
