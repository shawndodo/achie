package achieve.controller;

import achieve.dao.*;
import achieve.pojo.Attachment;
import achieve.pojo.Paper;
import achieve.pojo.Teacher;
import achieve.service.AttachmentService;
import achieve.service.TeacherAchieService;
import achieve.util.QiniuUtil;
import achieve.util.QueryUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/statistics")
public class StatisticsController extends BaseController {

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private TeacherAchieService teacherAchieService;

    private static StatisticsDaoImpl statisticsDaoImpl =  new StatisticsDaoImpl();

    @RequestMapping("/index")
    public String index(Map<String,Object> model, HttpSession session){
//        Integer userId = (Integer) session.getAttribute("userId");
//        Teacher teacher = teacherDaoImpl.findByUserId(userId);
        List<HashMap> list = statisticsDaoImpl.findBasicInfo("");
        model.put("list", list);

        return "statistics/index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(HttpServletRequest request, Map<String,Object> model) throws Exception {

        try {

            System.out.println("request===>" + request);

            String nameValue = request.getParameter("like_user.realName");
            String createdAt = request.getParameter("between_teacher_achie.createdAt");

            System.out.println("nameValue===>" + nameValue);
            System.out.println("createdAt===>" + createdAt);

            Map<String, Object> map = new HashMap<String, Object>();

            if(nameValue != null){
                map.put("like_user.realName", nameValue);
                map.put("between_teacher_achie.createdAt", createdAt);
            }

            String querySql = QueryUtil.convertQueryParams(map);

            System.out.println("querysql====>" + querySql);


            List<HashMap> list = statisticsDaoImpl.findBasicInfo(querySql);

            System.out.println("list====>" + list);

            model.put("list", list);

            System.out.println("model====>" + model);

            return "statistics/search";

//            if(list != null && !list.isEmpty()){
//                System.out.println("2222");
//                return "statistics/search";
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
