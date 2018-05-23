package achieve.service;

import achieve.dao.TeacherAchieDaoImpl;
import achieve.pojo.Teacher;
import achieve.pojo.TeacherAchie;
import org.springframework.stereotype.Service;

@Service
public class TeacherAchieService {

    private static TeacherAchieDaoImpl teacherAchieDaoImpl = new TeacherAchieDaoImpl();

    public static void setValue(int achieId, Teacher teacher){
        TeacherAchie teacherAchie = new TeacherAchie();
        teacherAchie.setAchieId(achieId);
        teacherAchie.setAchieType("Patent");
        teacherAchie.setLabel("research");
        teacherAchie.setTeacherContributeType("submit");
        teacherAchie.setTeacherId(teacher.getId());
        teacherAchieDaoImpl.addTeacherAchie(teacherAchie);
    }


}
