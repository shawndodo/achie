package achieve.controller;

import achieve.dao.AttachmentDaoImpl;
import achieve.dao.ResearchAwardDaoImpl;
import achieve.dao.TeacherAchieDaoImpl;
import achieve.dao.TeacherDaoImpl;
import achieve.pojo.Attachment;
import achieve.pojo.ResearchAward;
import achieve.pojo.Teacher;
import achieve.service.AttachmentService;
import achieve.service.TeacherAchieService;
import achieve.util.QiniuUtil;
import achieve.util.QueryUtil;
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
@RequestMapping("/researchAward")
public class ResearchAwardController extends BaseController {

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private TeacherAchieService teacherAchieService;

    private static ResearchAwardDaoImpl researchAwardDaoImpl =  new ResearchAwardDaoImpl();
    private static TeacherAchieDaoImpl teacherAchieDaoImpl = new TeacherAchieDaoImpl();
    private static TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
    private static AttachmentDaoImpl attachmentDaoImpl = new AttachmentDaoImpl();

    @RequestMapping("/index")
    public String index(Map<String,Object> model, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);
        List<ResearchAward> researchAwardList = researchAwardDaoImpl.findAll(teacher.getId(), "");
        model.put("researchAwardList", researchAwardList);

        return "researchAward/index";
    }

    @RequestMapping("/add")
    public String add(){
        return "researchAward/add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(ResearchAward researchAward, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("researchAward=" + researchAward);

        String url = null;
        if(!file.isEmpty()){
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        System.out.println("last_result===" + url);

        int researchAwardId = researchAwardDaoImpl.addResearchAward(researchAward);
        Integer userId = (Integer) session.getAttribute("userId");
        Teacher teacher = teacherDaoImpl.findByUserId(userId);

//        int attachmentGroupId = AttachmentGroupService.getOrSetValue(researchAwardId, "ResearchAward", userId);

        if(url != null) {
            attachmentService.setValue(file, url, userId, researchAwardId, "ResearchAward");
        }

        teacherAchieService.setValue(researchAwardId, teacher, "ResearchAward", "research", "submit");

        return "redirect:index";
    }

    @RequestMapping("/show")
    public String show(Map<String,Object> model, HttpServletRequest request){
        String researchAwardId = request.getParameter("researchAwardId");
        ResearchAward researchAward = researchAwardDaoImpl.findById(Integer.parseInt(researchAwardId));
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(researchAward.getId(), "ResearchAward");
        model.put("researchAward", researchAward);
        System.out.println("researchAward=" + researchAward);
        System.out.println("file=" + attachment);
        model.put("attachment", attachment);
        System.out.println("model=" + model);
        return "researchAward/show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, Map<String,Object> model){
        String researchAwardId = request.getParameter("researchAwardId");
        ResearchAward researchAward = researchAwardDaoImpl.findById(Integer.parseInt(researchAwardId));
        model.put("researchAward", researchAward);
        Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(researchAward.getId(), "ResearchAward");
        model.put("attachment", attachment);
        return "researchAward/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("researchAward") ResearchAward researchAward, HttpSession session, @RequestParam(value = "file") MultipartFile file) throws Exception{
        System.out.println("file1=" + file);
        String url = null;
        if(!file.isEmpty()) {
            url = QiniuUtil.uploadToQiNiuYun(file);
        }

        Integer userId = (Integer) session.getAttribute("userId");

        System.out.println("researchAward=" + researchAward);
        System.out.println("file=" + file);

        researchAwardDaoImpl.editResearchAward(researchAward);

        System.out.println("researchAwardId=" + researchAward.getId());

        if(url != null) {
            Attachment attachment = attachmentDaoImpl.findByOwnerIdAndOwnerType(researchAward.getId(), "ResearchAward");

            System.out.println("原来的attachment=" + attachment);

            if (attachment != null) {
                System.out.println("进来了1");
                attachmentDaoImpl.deleteAttachment(attachment.getId());
            }

            attachmentService.setValue(file, url, userId, researchAward.getId(), "ResearchAward");

        }

        return "redirect:index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(HttpServletRequest request, Map<String,Object> model, HttpSession session) throws Exception {

        try {

            System.out.println("request===>" + request);

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("like_research_award.awardName", request.getParameter("like_research_award.awardName"));
            map.put("between_research_award.createdAt", request.getParameter("between_research_award.createdAt"));
            map.put("research_award.awardType", request.getParameter("research_award.awardType"));
            System.out.println("map====" + map);

            String querySql = QueryUtil.convertQueryParams(map);

            System.out.println("querysql====>" + querySql);

            Integer userId = (Integer) session.getAttribute("userId");
            Teacher teacher = teacherDaoImpl.findByUserId(userId);

            List<ResearchAward> researchAwardList = researchAwardDaoImpl.findAll(teacher.getId(), querySql);

            System.out.println("researchAwardList====>" + researchAwardList);

            model.put("researchAwardList", researchAwardList);

            System.out.println("model====>" + model);

            return "researchAward/search";

//            if(patentList != null && !patentList.isEmpty()){
//                System.out.println("2222");
//                return "patent/search";
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
