package achieve.dao;

import achieve.pojo.JoinAcademicConference;

import java.util.List;

public interface JoinAcademicConferenceDao {

    List<JoinAcademicConference> findAll(Integer teacherId);

    Integer addJoinAcademicConference(JoinAcademicConference joinAcademicConference);

    JoinAcademicConference findById(Integer id) ;

    int editJoinAcademicConference(JoinAcademicConference joinAcademicConference) ;

}
