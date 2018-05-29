package achieve.dao;

import achieve.pojo.SoftwareCopyright;

import java.util.List;

public interface SoftwareCopyrightDao {

    List<SoftwareCopyright> findAll(Integer teacherId);

    Integer addSoftwareCopyright(SoftwareCopyright softwareCopyright);

    SoftwareCopyright findById(Integer id) ;

    int editSoftwareCopyright(SoftwareCopyright softwareCopyright) ;

}