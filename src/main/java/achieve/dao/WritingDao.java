package achieve.dao;

import achieve.pojo.Writing;

import java.util.List;

public interface WritingDao {

    List<Writing> findAll(Integer teacherId, String querySql);

    Integer addWriting(Writing writing);

    Writing findById(Integer id) ;

    int editWriting(Writing writing) ;


}
