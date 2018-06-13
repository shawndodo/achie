package achieve.dao;

import achieve.pojo.StudentProject;

import java.util.List;

public interface StudentProjectDao {

    List<StudentProject> findAll(Integer teacherId, String querySql);

    List<StudentProject> adminFindAll(String querySql);

    Integer addStudentProject(StudentProject studentProject);

    StudentProject findById(Integer id) ;

    int editStudentProject(StudentProject studentProject) ;

}
