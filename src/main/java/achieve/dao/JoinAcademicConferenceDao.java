package achieve.dao;

import achieve.pojo.JoinAcademicConference;

import java.util.List;

public interface JoinAcademicConferenceDao {

    List<JoinAcademicConference> findAll(Integer teacherId, String querySql);

    List<JoinAcademicConference> adminFindAll(String querySql);

    Integer addJoinAcademicConference(JoinAcademicConference joinAcademicConference);

    JoinAcademicConference findById(Integer id) ;

    int editJoinAcademicConference(JoinAcademicConference joinAcademicConference) ;

}
