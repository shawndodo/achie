package achieve.dao;

import achieve.pojo.TeachPaper;
import achieve.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeachPaperDaoImpl implements TeachPaperDao {

    public List<TeachPaper> findAll(Integer teacherId) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM teach_paper " +
                    "LEFT JOIN teacher_achie ON teach_paper.id = teacher_achie.achieId " +
                    "WHERE teacher_achie.achieType = 'TeachPaper' AND teacher_achie.teacherId = " + teacherId.toString();
            Statement state = conn.createStatement() ;
            ResultSet rs = state.executeQuery(sql) ;
            List<TeachPaper> list = new ArrayList<TeachPaper>() ;
            while(rs.next()){
                TeachPaper teachPaper = new TeachPaper() ;
                teachPaper.setId(rs.getInt("id")) ;
                teachPaper.setPaperName(rs.getString("paperName")) ;
                teachPaper.setPeriodicalName(rs.getString("periodicalName")) ;
                teachPaper.setVol(rs.getString("vol")) ;
                teachPaper.setPage(rs.getString("page")) ;
                teachPaper.setRemark(rs.getString("remark")) ;
                teachPaper.setRelatedCourseName(rs.getString("relatedCourseName")) ;
                teachPaper.setCreatedAt(rs.getTimestamp("createdAt"));
                teachPaper.setUpdatedAt(rs.getTimestamp("updatedAt"));
                list.add(teachPaper) ;
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

    public Integer addTeachPaper(TeachPaper teachPaper) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "INSERT INTO teach_paper " +
                    "(paperName , periodicalName , vol , page, remark, relatedCourseName , createdAt, updatedAt) " +
                    "VALUES " +
                    "(? , ? , ? , ? , ?, ?, ?, ?)" ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, teachPaper.getPaperName()) ;
            ps.setString(2, teachPaper.getPeriodicalName()) ;
            ps.setString(3, teachPaper.getVol()) ;
            ps.setString(4, teachPaper.getPage()) ;
            ps.setString(5, teachPaper.getRemark()) ;
            ps.setString(6, teachPaper.getRelatedCourseName()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(7, timeStamp);
            ps.setTimestamp(8, timeStamp);

            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("新建成功") ;
            }
            ResultSet rs = ps.getGeneratedKeys();
            int teachPaperId = 0;
            if(rs.next())
            {
                teachPaperId = rs.getInt(1);
            }
            ps.close() ;
            return teachPaperId ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null;
        }finally{
            DBUtil.close(conn) ;
        }
    }

    public TeachPaper findById(Integer id) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM teach_paper " +
                    "WHERE id = ? "	;
            PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setInt(1, id) ;
            TeachPaper teachPaper = null ;
            ResultSet rs = ps.executeQuery() ;
            while(rs.next()){
                teachPaper = new TeachPaper() ;
                teachPaper.setId(rs.getInt("id")) ;
                teachPaper.setPaperName(rs.getString("paperName")) ;
                teachPaper.setPeriodicalName(rs.getString("periodicalName")) ;
                teachPaper.setVol(rs.getString("vol")) ;
                teachPaper.setPage(rs.getString("page")) ;
                teachPaper.setRemark(rs.getString("remark")) ;
                teachPaper.setRelatedCourseName(rs.getString("relatedCourseName")) ;
                teachPaper.setCreatedAt(rs.getTimestamp("createdAt"));
                teachPaper.setUpdatedAt(rs.getTimestamp("updatedAt"));
            }
            rs.close() ;
            ps.close() ;
            return teachPaper ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null ;
        }finally{
            DBUtil.close(conn) ;
        }

    }

    public int editTeachPaper(TeachPaper teachPaper) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "UPDATE teach_paper " +
                    "SET paperName = ?, " +
                    "periodicalName = ?, " +
                    "vol = ?, " +
                    "page = ?, " +
                    "remark = ?, " +
                    "relatedCourseName = ?, " +
                    "updatedAt = ?" +
                    "WHERE id = ? " ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, teachPaper.getPaperName()) ;
            ps.setString(2, teachPaper.getPeriodicalName()) ;
            ps.setString(3, teachPaper.getVol()) ;
            ps.setString(4, teachPaper.getPage()) ;
            ps.setString(5, teachPaper.getRemark()) ;
            ps.setString(6, teachPaper.getRelatedCourseName()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(7, timeStamp);
            ps.setInt(8, teachPaper.getId()) ;
            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("更新成功") ;
            }
            ResultSet rs = ps.getGeneratedKeys();
            int teachPaperId = 0;
            if(rs.next())
            {
                teachPaperId = rs.getInt(1);
            }
            ps.close() ;
            return teachPaperId ;
        } catch (Exception e) {
            System.out.println("出错原因" + e);
            e.printStackTrace() ;
            return 0;
        }finally{
            DBUtil.close(conn) ;
        }

    }

}
