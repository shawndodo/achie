package achieve.controller;

import achieve.dao.TeacherAchieDaoImpl;
import achieve.dao.TeacherDaoImpl;
import achieve.dao.WritingDaoImpl;
import achieve.pojo.Teacher;
import achieve.pojo.TeacherAchie;
import achieve.pojo.Writing;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/writing")
public class WritingController {

    private static WritingDaoImpl writingDaoImpl =  new WritingDaoImpl();
    private static TeacherAchieDaoImpl teacherAchieDaoImpl = new TeacherAchieDaoImpl();
    private static TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();

    @RequestMapping("/index")
    public String index(Map<String,Object> model, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);
        List<Writing> writingList = writingDaoImpl.findAll(teacher.getId());
        model.put("writingList", writingList);

        return "writing/index";
    }

    @RequestMapping("/add")
    public String add(){
        return "writing/add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Writing writing, HttpSession session){
        int parentId = writingDaoImpl.addWriting(writing);
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);
        TeacherAchie teacherAchie = new TeacherAchie();
        teacherAchie.setAchieId(parentId);
        teacherAchie.setAchieType("Writing");
        teacherAchie.setLabel("teach");
        teacherAchie.setTeacherContributeType("submit");
        teacherAchie.setTeacherId(teacher.getId());
        teacherAchieDaoImpl.addTeacherAchie(teacherAchie);
        return "redirect:index";
    }

    @RequestMapping("/show")
    public String show(Map<String,Object> model, HttpServletRequest request){
        String writingId = request.getParameter("writingId");
        Writing writing = writingDaoImpl.findById(Integer.parseInt(writingId));
        model.put("writing", writing);
        return "writing/show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(HttpServletRequest request, Map<String,Object> model){
        String writingId = request.getParameter("writingId");
        Writing writing = writingDaoImpl.findById(Integer.parseInt(writingId));
        model.put("writing", writing);
        return "writing/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Writing writing, HttpServletRequest request){
//        String patentId = request.getParameter("patentId");
//        patent.setId(Integer.parseInt(patentId));
        writingDaoImpl.editWriting(writing);
        return "redirect:index";
    }

}
