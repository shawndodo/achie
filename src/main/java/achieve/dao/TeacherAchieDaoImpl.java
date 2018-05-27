package achieve.dao;

import achieve.pojo.TeacherAchie;
import achieve.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;

public class TeacherAchieDaoImpl implements TeacherAchieDao{

    public void addTeacherAchie(TeacherAchie teacherAchie) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "INSERT INTO teacher_achie " +
                    "(teacherId , achieId , achieType , teacherContributeType , label, createdAt, updatedAt) " +
                    "VALUES " +
                    "(? , ? , ? , ? , ?, ?, ?)" ;
            PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setInt(1, teacherAchie.getTeacherId()) ;
            ps.setInt(2, teacherAchie.getAchieId()) ;
            ps.setString(3, teacherAchie.getAchieType()) ;
            ps.setString(4, teacherAchie.getTeacherContributeType()) ;
            ps.setString(5, teacherAchie.getLabel()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(6, timeStamp);
            ps.setTimestamp(7, timeStamp);
            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("新建成功") ;
            }
            ps.close() ;
        } catch (Exception e) {
            e.printStackTrace() ;
        }finally{
            DBUtil.close(conn) ;
        }
    }


}
