package achieve.dao;

import achieve.pojo.Writing;
import achieve.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WritingDaoImpl implements WritingDao {

    public List<Writing> findAll(Integer teacherId) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM writing " +
                    "LEFT JOIN teacher_achie ON writing.id = teacher_achie.achieId " +
                    "WHERE teacher_achie.achieType = 'Writing' AND teacher_achie.teacherId = " + teacherId.toString();
            Statement state = conn.createStatement() ;
            ResultSet rs = state.executeQuery(sql) ;
            List<Writing> list = new ArrayList<Writing>() ;
            while(rs.next()){
                Writing writing = new Writing() ;
                writing.setId(rs.getInt("id")) ;
                writing.setWritingName(rs.getString("writingName")) ;
                writing.setPublicationNumber(rs.getString("publicationNumber")) ;
                writing.setSelfPosition(rs.getString("selfPosition")) ;
                writing.setSelfRank(rs.getInt("selfRank")) ;
                writing.setPress(rs.getString("press")) ;
                writing.setWritingType(rs.getString("writingType")) ;
                writing.setPublishTime(rs.getDate("publishTime")) ;
                writing.setRelatedCourseName(rs.getString("relatedCourseName")) ;
                writing.setRemark(rs.getString("remark")) ;
                list.add(writing) ;
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

    public Integer addWriting(Writing writing) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "INSERT INTO writing " +
                    "(writingName , publicationNumber , selfPosition , selfRank , press, writingType, publishTime, relatedCourseName, remark) " +
                    "VALUES " +
                    "(? , ? , ? , ? , ?, ?, ?, ?, ?)" ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, writing.getWritingName()) ;
            ps.setString(2, writing.getPublicationNumber()) ;
            ps.setString(3, writing.getSelfPosition()) ;
            ps.setInt(4, writing.getSelfRank()) ;
            ps.setString(5, writing.getPress()) ;
            ps.setString(6, writing.getWritingType()) ;
            if(writing.getPublishTime() != null){
                ps.setDate(7, new java.sql.Date(writing.getPublishTime().getTime()));
            }else{
                ps.setDate(7, null);
            }
            ps.setString(8, writing.getRelatedCourseName()) ;
            ps.setString(9, writing.getRemark()) ;
            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("新建成功") ;
            }
            ResultSet rs = ps.getGeneratedKeys();
            int writingId = 0;
            if(rs.next())
            {
                writingId = rs.getInt(1);
            }
            ps.close() ;
            return writingId ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null;
        }finally{
            DBUtil.close(conn) ;
        }
    }

    public Writing findById(Integer id) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM writing " +
                    "WHERE id = ? "	;
            PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setInt(1, id) ;
            Writing writing = null ;
            ResultSet rs = ps.executeQuery() ;
            while(rs.next()){
                writing = new Writing() ;
                writing.setId(rs.getInt("id")) ;
                writing.setWritingName(rs.getString("writingName")) ;
                writing.setPublicationNumber(rs.getString("publicationNumber")) ;
                writing.setSelfPosition(rs.getString("selfPosition")) ;
                writing.setSelfRank(rs.getInt("selfRank")) ;
                writing.setPress(rs.getString("press")) ;
                writing.setWritingType(rs.getString("writingType")) ;
                writing.setPublishTime(rs.getDate("publishTime")) ;
                writing.setRelatedCourseName(rs.getString("relatedCourseName")) ;
                writing.setRemark(rs.getString("remark")) ;
            }
            rs.close() ;
            ps.close() ;
            return writing ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null ;
        }finally{
            DBUtil.close(conn) ;
        }

    }

    public void editWriting(Writing writing) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "UPDATE writing " +
                    "SET writingName = ?, " +
                    "publicationNumber = ?, " +
                    "selfPosition = ?, " +
                    "selfRank = ?, " +
                    "press = ?, " +
                    "writingType = ?, " +
                    "publishTime = ?, " +
                    "relatedCourseName = ?, " +
                    "remark = ?" +
                    "WHERE id = ? " ;
            PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setString(1, writing.getWritingName()) ;
            ps.setString(2, writing.getPublicationNumber()) ;
            ps.setString(3, writing.getSelfPosition()) ;
            ps.setInt(4, writing.getSelfRank()) ;
            ps.setString(5, writing.getPress()) ;
            ps.setString(6, writing.getWritingType()) ;
            if(writing.getPublishTime() != null){
                ps.setDate(7, new java.sql.Date(writing.getPublishTime().getTime()));
            }else{
                ps.setDate(7, null);
            }
            ps.setString(8, writing.getRelatedCourseName()) ;
            ps.setString(9, writing.getRemark());
            ps.setInt(10 , writing.getId()) ;
            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("更新成功") ;
            }
            ps.close() ;
        } catch (Exception e) {
            e.printStackTrace() ;
        }finally{
            DBUtil.close(conn) ;
        }

    }

}
