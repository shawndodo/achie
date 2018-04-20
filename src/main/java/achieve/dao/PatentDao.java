package achieve.dao;

import achieve.pojo.Patent;

import java.util.List;

public interface PatentDao {

    List<Patent> findAll(Integer teacherId);

    Integer addPatent(Patent patent);

    Patent findById(Integer id) ;

    void editPatent(Patent patent) ;

}
