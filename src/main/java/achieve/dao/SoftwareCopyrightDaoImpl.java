package achieve.dao;

import achieve.pojo.Patent;
import achieve.pojo.SoftwareCopyright;
import achieve.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SoftwareCopyrightDaoImpl implements SoftwareCopyrightDao {

    public List<SoftwareCopyright> findAll(Integer teacherId, String querySql) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM software_copyright " +
                    "LEFT JOIN teacher_achie ON software_copyright.id = teacher_achie.achieId " +
                    "WHERE teacher_achie.achieType = 'SoftwareCopyright' AND teacher_achie.teacherId = " + teacherId.toString() + querySql;
            Statement state = conn.createStatement() ;
            ResultSet rs = state.executeQuery(sql) ;
            List<SoftwareCopyright> list = new ArrayList<SoftwareCopyright>() ;
            while(rs.next()){
                SoftwareCopyright softwareCopyright = new SoftwareCopyright() ;
                softwareCopyright.setId(rs.getInt("id")) ;
                softwareCopyright.setCopyrightName(rs.getString("copyrightName")) ;
                softwareCopyright.setCertificateNum(rs.getString("certificateNum")) ;
                softwareCopyright.setSelfRank(rs.getInt("selfRank")) ;
                softwareCopyright.setGetDate(rs.getDate("getDate")) ;
                softwareCopyright.setDevelopFinishDate(rs.getDate("developFinishDate")) ;
                softwareCopyright.setCopyrightType(rs.getString("copyrightType")) ;
                softwareCopyright.setCopyrightPerson(rs.getString("copyrightPerson")) ;
                softwareCopyright.setRelatedCourseName(rs.getString("relatedCourseName")) ;
                softwareCopyright.setRemark(rs.getString("remark")) ;
                softwareCopyright.setCreatedAt(rs.getTimestamp("createdAt"));
                softwareCopyright.setUpdatedAt(rs.getTimestamp("updatedAt"));
                list.add(softwareCopyright) ;
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

    public Integer addSoftwareCopyright(SoftwareCopyright softwareCopyright) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "INSERT INTO software_copyright " +
                    "(copyrightName , certificateNum , selfRank , getDate, developFinishDate, copyrightType , copyrightPerson, relatedCourseName, remark, createdAt, updatedAt) " +
                    "VALUES " +
                    "(? , ? , ? , ? , ?, ?, ?, ?, ?, ?, ?)" ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, softwareCopyright.getCopyrightName()) ;
            ps.setString(2, softwareCopyright.getCertificateNum()) ;
            ps.setInt(3, softwareCopyright.getSelfRank()) ;
            if(softwareCopyright.getGetDate() != null){
                ps.setDate(4, new java.sql.Date(softwareCopyright.getGetDate().getTime()));
            }else{
                ps.setDate(4, null);
            }
            if(softwareCopyright.getDevelopFinishDate() != null){
                ps.setDate(5, new java.sql.Date(softwareCopyright.getDevelopFinishDate().getTime()));
            }else{
                ps.setDate(5, null);
            }
            ps.setString(6, softwareCopyright.getCopyrightType()) ;
            ps.setString(7, softwareCopyright.getCopyrightPerson()) ;
            ps.setString(8, softwareCopyright.getRelatedCourseName()) ;
            ps.setString(9, softwareCopyright.getRemark()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(10, timeStamp);
            ps.setTimestamp(11, timeStamp);

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

    public SoftwareCopyright findById(Integer id) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM software_copyright " +
                    "WHERE id = ? "	;
            PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setInt(1, id) ;
            SoftwareCopyright softwareCopyright = null ;
            ResultSet rs = ps.executeQuery() ;
            while(rs.next()){
                softwareCopyright = new SoftwareCopyright() ;
                softwareCopyright.setId(rs.getInt("id")) ;
                softwareCopyright.setCopyrightName(rs.getString("copyrightName")) ;
                softwareCopyright.setCertificateNum(rs.getString("certificateNum")) ;
                softwareCopyright.setSelfRank(rs.getInt("selfRank")) ;
                softwareCopyright.setGetDate(rs.getDate("getDate")) ;
                softwareCopyright.setDevelopFinishDate(rs.getDate("developFinishDate")) ;
                softwareCopyright.setCopyrightType(rs.getString("copyrightType")) ;
                softwareCopyright.setCopyrightPerson(rs.getString("copyrightPerson")) ;
                softwareCopyright.setRelatedCourseName(rs.getString("relatedCourseName")) ;
                softwareCopyright.setRemark(rs.getString("remark"));
                System.out.println("rs======>" + rs.getTimestamp("createdAt"));
                softwareCopyright.setCreatedAt(rs.getTimestamp("createdAt"));
                softwareCopyright.setUpdatedAt(rs.getTimestamp("updatedAt"));
            }
            rs.close() ;
            ps.close() ;
            return softwareCopyright ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null ;
        }finally{
            DBUtil.close(conn) ;
        }

    }

    public int editSoftwareCopyright(SoftwareCopyright softwareCopyright) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "UPDATE software_copyright " +
                    "SET copyrightName = ?, " +
                    "certificateNum = ?, " +
                    "selfRank = ?, " +
                    "getDate = ?, " +
                    "developFinishDate = ?, " +
                    "copyrightType = ?, " +
                    "copyrightPerson = ?, " +
                    "relatedCourseName = ?, " +
                    "remark = ?, " +
                    "updatedAt = ?" +
                    "WHERE id = ? " ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, softwareCopyright.getCopyrightName()) ;
            ps.setString(2, softwareCopyright.getCertificateNum()) ;
            ps.setInt(3, softwareCopyright.getSelfRank()) ;
            if(softwareCopyright.getGetDate() != null){
                ps.setDate(4, new java.sql.Date(softwareCopyright.getGetDate().getTime()));
            }else{
                ps.setDate(4, null);
            }
            if(softwareCopyright.getDevelopFinishDate() != null){
                ps.setDate(5, new java.sql.Date(softwareCopyright.getDevelopFinishDate().getTime()));
            }else{
                ps.setDate(5, null);
            }
            ps.setString(6, softwareCopyright.getCopyrightType()) ;
            ps.setString(7, softwareCopyright.getCopyrightPerson()) ;
            ps.setString(8, softwareCopyright.getRelatedCourseName()) ;
            ps.setString(9, softwareCopyright.getRemark()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(10, timeStamp);
            ps.setInt(11, softwareCopyright.getId()) ;
            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("更新成功") ;
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
            System.out.println("出错原因" + e);
            e.printStackTrace() ;
            return 0;
        }finally{
            DBUtil.close(conn) ;
        }

    }

}
