package achieve.dao;

import achieve.pojo.ResearchProject;

import java.util.List;

public interface ResearchProjectDao {

    List<ResearchProject> findAll(Integer teacherId);

    Integer addResearchProject(ResearchProject researchProject);

    ResearchProject findById(Integer id) ;

    int editResearchProject(ResearchProject researchProject) ;

}
