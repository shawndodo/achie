package achieve.controller;

import achieve.dao.AttachmentDaoImpl;
import achieve.dao.UserDaoImpl;
import achieve.pojo.Attachment;
import achieve.pojo.User;
import achieve.util.QiniuUtil;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

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

    @RequestMapping("/login")
    public String login(){
        return "user/login";
    }

    @RequestMapping("/signIn")
    public String signIn(){
        return "redirect:/home/index";
    }

    private static UserDaoImpl userDaoImpl = new UserDaoImpl();
    private static AttachmentDaoImpl attachmentDaoImpl = new AttachmentDaoImpl();

    @RequestMapping("/show")
    public String show(Map<String,Object> model, HttpServletRequest request, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        User user = userDaoImpl.findById(userId);

//        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(user.getId(), "User");
        model.put("user", user);
        System.out.println("user=" + user);
//        System.out.println("file=" + attachment);
//        model.put("attachment", attachment);
        System.out.println("model=" + model);
        return "user/show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, Map<String,Object> model, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        User user = userDaoImpl.findById(userId);
        model.put("user", user);
//        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(user.getId(), "User");
//        model.put("attachment", attachment);
        return "user/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("user") User user, HttpSession session) throws Exception{
//        System.out.println("file1=" + file);
//        String url = null;
//        if(!file.isEmpty()) {
//            url = QiniuUtil.uploadToQiNiuYun(file);
//        }

//        Integer userId = (Integer) session.getAttribute("userId");

        System.out.println("user=" + user);
//        System.out.println("file=" + file);

        userDaoImpl.editUser(user);

        System.out.println("userId=" + user.getId());

//        if(url != null) {
//            Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(user.getId(), "User");
//
//            System.out.println("原来的attachment=" + attachment);
//
//            if (attachment != null) {
//                System.out.println("进来了1");
//                attachmentDaoImpl.deleteAttachment(attachment.getId());
//            }
//
//            attachmentService.setValue(file, url, userId, user.getId(), "User");
//
//        }

        return "redirect:index";
    }


}
