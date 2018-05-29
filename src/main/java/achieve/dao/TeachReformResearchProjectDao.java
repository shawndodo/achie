package achieve.dao;

import achieve.pojo.TeachReformResearchProject;

import java.util.List;

public interface TeachReformResearchProjectDao {

    List<TeachReformResearchProject> findAll(Integer teacherId);

    Integer addTeachReformResearchProject(TeachReformResearchProject teachReformResearchProject);

    TeachReformResearchProject findById(Integer id) ;

    int editTeachReformResearchProject(TeachReformResearchProject teachReformResearchProject) ;

}