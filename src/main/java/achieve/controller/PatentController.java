package achieve.controller;

import achieve.dao.PatentDaoImpl;
import achieve.dao.TeacherAchieDaoImpl;
import achieve.dao.TeacherDaoImpl;
import achieve.pojo.Patent;
import achieve.pojo.Teacher;
import achieve.pojo.TeacherAchie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/patent")
public class PatentController {

    private static PatentDaoImpl patentDaoImpl =  new PatentDaoImpl();
    private static TeacherAchieDaoImpl teacherAchieDaoImpl = new TeacherAchieDaoImpl();
    private static TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();

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
    public String create(Patent patent, HttpSession session){
        int parentId = patentDaoImpl.addPatent(patent);
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);
        TeacherAchie teacherAchie = new TeacherAchie();
        teacherAchie.setAchieId(parentId);
        teacherAchie.setAchieType("Patent");
        teacherAchie.setLabel("research");
        teacherAchie.setTeacherContributeType("submit");
        teacherAchie.setTeacherId(teacher.getId());
        teacherAchieDaoImpl.addTeacherAchie(teacherAchie);
        return "redirect:index";
    }

    @RequestMapping("/show")
    public String show(Map<String,Object> model, HttpServletRequest request){
        String patentId = request.getParameter("patentId");
        Patent patent = patentDaoImpl.findById(Integer.parseInt(patentId));
        model.put("patent", patent);
        return "patent/show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(HttpServletRequest request, Map<String,Object> model){
        String patentId = request.getParameter("patentId");
        Patent patent = patentDaoImpl.findById(Integer.parseInt(patentId));
        model.put("patent", patent);
        return "patent/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Patent patent, HttpServletRequest request){
//        String patentId = request.getParameter("patentId");
//        patent.setId(Integer.parseInt(patentId));
        patentDaoImpl.editPatent(patent);
        return "redirect:index";
    }

}
