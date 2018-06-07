package achieve.dao;

import achieve.pojo.Patent;

import java.util.List;

public interface PatentDao {

    List<Patent> findAll(Integer teacherId, String querySql);

    List<Patent> adminFindAll(String querySql);

    Integer addPatent(Patent patent);

    Patent findById(Integer id) ;

    int editPatent(Patent patent) ;

}
