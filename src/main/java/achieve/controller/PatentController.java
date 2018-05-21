package achieve.controller;

import achieve.dao.PatentDaoImpl;
import achieve.dao.TeacherAchieDaoImpl;
import achieve.dao.TeacherDaoImpl;
import achieve.pojo.Patent;
import achieve.pojo.Teacher;
import achieve.pojo.TeacherAchie;
import achieve.pojo.Writing;
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
@RequestMapping("/patent")
public class PatentController {

    private static PatentDaoImpl patentDaoImpl =  new PatentDaoImpl();
    private static TeacherAchieDaoImpl teacherAchieDaoImpl = new TeacherAchieDaoImpl();
    private static TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();

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

        System.out.println("has_wrong");

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


    //   文件参数
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Patent patent, HttpSession session, @RequestParam(value = "file") MultipartFile file){
        System.out.println("patent=" + patent);
        System.out.println("file=" + file);

//        int parentId = patentDaoImpl.addPatent(patent);
//        Integer userId = (Integer) session.getAttribute("userId");
//        Teacher teacher = teacherDaoImpl.findByUserId(userId);
//        TeacherAchie teacherAchie = new TeacherAchie();
//        teacherAchie.setAchieId(parentId);
//        teacherAchie.setAchieType("Patent");
//        teacherAchie.setLabel("research");
//        teacherAchie.setTeacherContributeType("submit");
//        teacherAchie.setTeacherId(teacher.getId());
//        teacherAchieDaoImpl.addTeacherAchie(teacherAchie);
        return "redirect:index";
    }

    @RequestMapping("/show")
    public String show(Map<String,Object> model, HttpServletRequest request){
        String patentId = request.getParameter("patentId");
        Patent patent = patentDaoImpl.findById(Integer.parseInt(patentId));
        model.put("patent", patent);
        return "patent/show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, Map<String,Object> model){
        String patentId = request.getParameter("patentId");
        Patent patent = patentDaoImpl.findById(Integer.parseInt(patentId));
        model.put("patent", patent);
        return "patent/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("patent") Patent patent){
//        System.out.println("日期1" + patent);
//        System.out.println("日期2" + patent.getApplyDate());
        patentDaoImpl.editPatent(patent);
//        System.out.println("has_wrong2");
        return "redirect:index";
    }

}
