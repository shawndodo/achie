package achieve.dao;

import achieve.pojo.ResearchAward;

import java.util.List;

public interface ResearchAwardDao {

    List<ResearchAward> findAll(Integer teacherId, String querySql);

    Integer addResearchAward(ResearchAward researchAward);

    ResearchAward findById(Integer id) ;

    int editResearchAward(ResearchAward researchAward) ;

}
