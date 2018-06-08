package achieve.dao;

import achieve.pojo.TeachAward;

import java.util.List;

public interface TeachAwardDao {

    List<TeachAward> findAll(Integer teacherId, String querySql);

    List<TeachAward> adminFindAll(String querySql);

    Integer addTeachAward(TeachAward TeachAward);

    TeachAward findById(Integer id) ;

    int editTeachAward(TeachAward TeachAward) ;

}
