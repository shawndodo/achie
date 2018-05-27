package achieve.dao;

import achieve.pojo.TeachAward;
import achieve.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeachAwardDaoImpl implements TeachAwardDao {

    public List<TeachAward> findAll(Integer teacherId) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM teach_award " +
                    "LEFT JOIN teacher_achie ON teach_award.id = teacher_achie.achieId " +
                    "WHERE teacher_achie.achieType = 'TeachAward' AND teacher_achie.teacherId = " + teacherId.toString();
            Statement state = conn.createStatement() ;
            ResultSet rs = state.executeQuery(sql) ;
            List<TeachAward> list = new ArrayList<TeachAward>() ;
            while(rs.next()){
                TeachAward teachAward = new TeachAward() ;
                teachAward.setId(rs.getInt("id")) ;
                teachAward.setAwardName(rs.getString("awardName")) ;
                teachAward.setSelfRank(rs.getInt("selfRank")) ;
                teachAward.setLevel(rs.getString("level")) ;
                teachAward.setAwardDepartment(rs.getString("awardDepartment")) ;
                teachAward.setAwardDate(rs.getDate("awardDate")) ;
                teachAward.setRemark(rs.getString("remark")) ;
                teachAward.setRelatedCourseName(rs.getString("relatedCourseName")) ;
                teachAward.setCreatedAt(rs.getTimestamp("createdAt"));
                teachAward.setUpdatedAt(rs.getTimestamp("updatedAt"));
                list.add(teachAward) ;
            }
            rs.close() ;
            state.close() ;
            return list ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null ;
        }finally{
            DBUtil.close(conn) ;
        }
    }

    public Integer addTeachAward(TeachAward teachAward) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "INSERT INTO teach_award " +
                    "(awardName , selfRank , level , awardDepartment, awardDate, remark , relatedCourseName, createdAt, updatedAt) " +
                    "VALUES " +
                    "(? , ? , ? , ? , ?, ?, ?, ?, ?)" ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, teachAward.getAwardName()) ;
            ps.setInt(2, teachAward.getSelfRank()) ;
            ps.setString(3, teachAward.getLevel()) ;
            ps.setString(4, teachAward.getAwardDepartment()) ;
            if(teachAward.getAwardDate() != null){
                ps.setDate(5, new java.sql.Date(teachAward.getAwardDate().getTime()));
            }else{
                ps.setDate(5, null);
            }

            ps.setString(6, teachAward.getRemark()) ;
            ps.setString(7, teachAward.getRelatedCourseName()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(8, timeStamp);
            ps.setTimestamp(9, timeStamp);

            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("新建成功") ;
            }
            ResultSet rs = ps.getGeneratedKeys();
            int softwareCopyrightId = 0;
            if(rs.next())
            {
                softwareCopyrightId = rs.getInt(1);
            }
            ps.close() ;
            return softwareCopyrightId ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null;
        }finally{
            DBUtil.close(conn) ;
        }
    }

    public TeachAward findById(Integer id) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM teach_award " +
                    "WHERE id = ? "	;
            PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setInt(1, id) ;
            TeachAward teachAward = null ;
            ResultSet rs = ps.executeQuery() ;
            while(rs.next()){
                teachAward = new TeachAward() ;
                teachAward.setId(rs.getInt("id")) ;
                teachAward.setAwardName(rs.getString("awardName")) ;
                teachAward.setSelfRank(rs.getInt("selfRank")) ;
                teachAward.setLevel(rs.getString("level")) ;
                teachAward.setAwardDepartment(rs.getString("awardDepartment")) ;
                teachAward.setAwardDate(rs.getDate("awardDate")) ;
                teachAward.setRemark(rs.getString("remark")) ;
                teachAward.setRelatedCourseName(rs.getString("relatedCourseName")) ;
                teachAward.setCreatedAt(rs.getTimestamp("createdAt"));
                teachAward.setUpdatedAt(rs.getTimestamp("updatedAt"));
            }
            rs.close() ;
            ps.close() ;
            return teachAward ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null ;
        }finally{
            DBUtil.close(conn) ;
        }

    }

    public int editTeachAward(TeachAward teachAward) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "UPDATE teach_award " +
                    "SET awardName = ?, " +
                    "selfRank = ?, " +
                    "level = ?, " +
                    "awardDepartment = ?, " +
                    "awardDate = ?, " +
                    "remark = ?, " +
                    "relatedCourseName = ?, " +
                    "updatedAt = ?" +
                    "WHERE id = ? " ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, teachAward.getAwardName()) ;
            ps.setInt(2, teachAward.getSelfRank()) ;
            ps.setString(3, teachAward.getLevel()) ;
            ps.setString(4, teachAward.getAwardDepartment()) ;
            if(teachAward.getAwardDate() != null){
                ps.setDate(5, new java.sql.Date(teachAward.getAwardDate().getTime()));
            }else{
                ps.setDate(5, null);
            }

            ps.setString(6, teachAward.getRemark()) ;
            ps.setString(7, teachAward.getRelatedCourseName()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(8, timeStamp);
            ps.setInt(9, teachAward.getId()) ;
            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("更新成功") ;
            }
            ResultSet rs = ps.getGeneratedKeys();
            int teachAwardId = 0;
            if(rs.next())
            {
                teachAwardId = rs.getInt(1);
            }
            ps.close() ;
            return teachAwardId ;
        } catch (Exception e) {
            System.out.println("出错原因" + e);
            e.printStackTrace() ;
            return 0;
        }finally{
            DBUtil.close(conn) ;
        }

    }

}
