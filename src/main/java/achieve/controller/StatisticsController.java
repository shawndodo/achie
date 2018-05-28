package achieve.controller;

import achieve.dao.*;
import achieve.pojo.Attachment;
import achieve.pojo.Paper;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private TeacherAchieService teacherAchieService;

    private static StatisticsDaoImpl statisticsDaoImpl =  new StatisticsDaoImpl();

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
//        Integer userId = (Integer) session.getAttribute("userId");
//        Teacher teacher = teacherDaoImpl.findByUserId(userId);
        List<HashMap> list = statisticsDaoImpl.findBasicInfo();
        model.put("list", list);

        return "statistics/index";
    }



}
