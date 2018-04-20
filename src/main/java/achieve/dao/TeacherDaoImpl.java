package achieve.dao;

import achieve.pojo.Teacher;
import achieve.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeacherDaoImpl implements TeacherDao {

    public Teacher findByUserId(Integer userId) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM teacher " +
                    "WHERE userId = ? "	;
            PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setInt(1, userId) ;
            Teacher teacher = null ;
            ResultSet rs = ps.executeQuery() ;
            while(rs.next()){
                teacher = new Teacher() ;
                teacher.setId(rs.getInt("id")) ;
                teacher.setFacultyId(rs.getInt("facultyId")) ;
                teacher.setUserId(rs.getInt("userId")) ;
            }
            rs.close() ;
            ps.close() ;
            return teacher ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null ;
        }finally{
            DBUtil.close(conn) ;
        }

    }

}
