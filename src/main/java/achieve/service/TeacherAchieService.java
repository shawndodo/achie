package achieve.service;

import achieve.dao.TeacherAchieDaoImpl;
import achieve.pojo.Teacher;
import achieve.pojo.TeacherAchie;
import org.springframework.stereotype.Service;

@Service
public class TeacherAchieService {

    private static TeacherAchieDaoImpl teacherAchieDaoImpl = new TeacherAchieDaoImpl();

    public void setValue(int achieId, Teacher teacher, String achieType, String label, String teacherContributeType){
        TeacherAchie teacherAchie = new TeacherAchie();
        teacherAchie.setAchieId(achieId);
        teacherAchie.setAchieType(achieType);
        teacherAchie.setLabel(label);
        teacherAchie.setTeacherContributeType(teacherContributeType);
        teacherAchie.setTeacherId(teacher.getId());
        teacherAchieDaoImpl.addTeacherAchie(teacherAchie);
    }


}
