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
        List<HashMap> list = statisticsDaoImpl.findBasicInfo("");
        model.put("list", list);

        return "statistics/index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(HttpServletRequest request, Map<String,Object> model) throws Exception {

        try {
//            Map<String, Object> testMap = request.getParameterMap();
//
//            for (Map<String, String[]>  m : testMap.entrySet())  {
//                System.out.println(m.getKey()+"\t"+m.getValue());
//            }

//            System.out.println("map====" + dataMap);

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


//            JSONObject jasonObject = JSONObject.fromObject(str);
//            Map map = (Map) jasonObject;


            List<HashMap> list = statisticsDaoImpl.findBasicInfo(querySql);

            System.out.println("list====>" + list);

            model.put("list", list);

            System.out.println("model====>" + model);

            if(list != null && !list.isEmpty()){
                System.out.println("2222");
                return "statistics/search";
            }else{
                System.out.println("3333");
                return "share/noDate";
            }


        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }


    }

    public static String getType(Object o){ //获取变量类型方法
        return o.getClass().toString(); //使用int类型的getClass()方法
    }

}
