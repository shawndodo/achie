package achieve.dao;

import achieve.pojo.Patent;
import achieve.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatentDaoImpl implements PatentDao {

    public List<Patent> findAll(Integer teacherId) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM patent " +
                    "LEFT JOIN teacher_achie ON patent.id = teacher_achie.achieId " +
                    "WHERE teacher_achie.achieType = 'Patent' AND teacher_achie.teacherId = " + teacherId.toString();
            Statement state = conn.createStatement() ;
            ResultSet rs = state.executeQuery(sql) ;
            List<Patent> list = new ArrayList<Patent>() ;
            while(rs.next()){
                Patent patent = new Patent() ;
                patent.setId(rs.getInt("id")) ;
                patent.setPatentName(rs.getString("patentName")) ;
                patent.setPatentType(rs.getString("patentType")) ;
                patent.setPatentStatus(rs.getString("patentStatus")) ;
                patent.setPatentCode(rs.getString("patentCode")) ;
                patent.setGetPatentDate(rs.getDate("getPatentDate")) ;
                patent.setApplyCode(rs.getString("applyCode")) ;
                patent.setApplyDate(rs.getDate("applyDate")) ;
                patent.setSelfRank(rs.getInt("selfRank")) ;
                patent.setRelatedCourseName(rs.getString("relatedCourseName")) ;
                patent.setRemark(rs.getString("remark")) ;
                list.add(patent) ;
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

    public Integer addPatent(Patent patent) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "INSERT INTO patent " +
                    "(patentName , patentType , patentStatus , patentCode , getPatentDate, applyCode, applyDate, selfRank, relatedCourseName, remark) " +
                    "VALUES " +
                    "(? , ? , ? , ? , ?, ?, ?, ?, ?, ?)" ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, patent.getPatentName()) ;
            ps.setString(2, patent.getPatentType()) ;
            ps.setString(3, patent.getPatentStatus()) ;
            ps.setString(4, patent.getPatentCode()) ;
            if(patent.getGetPatentDate() != null){
                ps.setDate(5, new java.sql.Date(patent.getGetPatentDate().getTime()));
            }else{
                ps.setDate(5, null);
            }
            ps.setString(6, patent.getApplyCode()) ;
            if (patent.getApplyDate() != null){
                ps.setDate(7, new java.sql.Date(patent.getApplyDate().getTime()));
            }else{
                ps.setDate(7, null);
            }
            ps.setInt(8, patent.getSelfRank()) ;
            ps.setString(9, patent.getRelatedCourseName()) ;
            ps.setString(10, patent.getRemark()) ;
            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("新建成功") ;
            }
            ResultSet rs = ps.getGeneratedKeys();
            int patentId = 0;
            if(rs.next())
            {
                patentId = rs.getInt(1);
            }
            ps.close() ;
            return patentId ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null;
        }finally{
            DBUtil.close(conn) ;
        }
    }

    public Patent findById(Integer id) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM patent " +
                    "WHERE id = ? "	;
            PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setInt(1, id) ;
            Patent patent = null ;
            ResultSet rs = ps.executeQuery() ;
            while(rs.next()){
                patent = new Patent() ;
                patent.setId(rs.getInt("id")) ;
                patent.setPatentName(rs.getString("patentName")) ;
                patent.setPatentType(rs.getString("patentType")) ;
                patent.setPatentStatus(rs.getString("patentStatus")) ;
                patent.setPatentCode(rs.getString("patentCode")) ;
                patent.setGetPatentDate(rs.getDate("getPatentDate")) ;
                patent.setApplyCode(rs.getString("applyCode")) ;
                patent.setApplyDate(rs.getDate("applyDate")) ;
                patent.setSelfRank(rs.getInt("selfRank")) ;
                patent.setRelatedCourseName(rs.getString("relatedCourseName")) ;
                patent.setRemark(rs.getString("remark")) ;
            }
            rs.close() ;
            ps.close() ;
            return patent ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null ;
        }finally{
            DBUtil.close(conn) ;
        }

    }

    public void editPatent(Patent patent) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "UPDATE patent " +
                    "SET patentName = ?, " +
                    "patentType = ?, " +
                    "patentStatus = ?, " +
                    "patentCode = ?, " +
                    "getPatentDate = ?, " +
                    "applyCode = ?, " +
                    "applyDate = ?, " +
                    "selfRank = ?, " +
                    "relatedCourseName = ?, " +
                    "remark = ?" +
                    "WHERE id = ? " ;
            PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setString(1, patent.getPatentName()) ;
            ps.setString(2, patent.getPatentType()) ;
            ps.setString(3, patent.getPatentStatus()) ;
            ps.setString(4, patent.getPatentCode()) ;
            if(patent.getGetPatentDate() != null){
                ps.setDate(5, new java.sql.Date(patent.getGetPatentDate().getTime()));
            }else{
                ps.setDate(5, null);
            }
            ps.setString(6, patent.getApplyCode()) ;
            if (patent.getApplyDate() != null){
                ps.setDate(7, new java.sql.Date(patent.getApplyDate().getTime()));
            }else{
                ps.setDate(7, null);
            }
            ps.setInt(8, patent.getSelfRank()) ;
            ps.setString(9, patent.getRelatedCourseName()) ;
            ps.setString(10, patent.getRemark()) ;
            ps.setInt(11 , patent.getId()) ;
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
