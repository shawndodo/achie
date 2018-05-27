package achieve.dao;

import achieve.pojo.StudentProject;

import java.util.List;

public interface StudentProjectDao {

    List<StudentProject> findAll(Integer teacherId);

    Integer addStudentProject(StudentProject studentProject);

    StudentProject findById(Integer id) ;

    int editStudentProject(StudentProject studentProject) ;

}
