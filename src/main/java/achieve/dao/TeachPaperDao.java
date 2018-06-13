package achieve.dao;

import achieve.pojo.TeachPaper;

import java.util.List;

public interface TeachPaperDao {

    List<TeachPaper> findAll(Integer teacherId, String querySql);

    List<TeachPaper> adminFindAll(String querySql);

    Integer addTeachPaper(TeachPaper teachPaper);

    TeachPaper findById(Integer id) ;

    int editTeachPaper(TeachPaper teachPaper) ;

}
