package achieve.dao;

import achieve.pojo.Paper;

import java.util.List;

public interface PaperDao {

    List<Paper> findAll(Integer teacherId, String querySql);

    List<Paper> adminFindAll(String querySql);

    Integer addPaper(Paper paper);

    Paper findById(Integer id) ;

    int editPaper(Paper paper) ;

}
