package achieve.dao;

import achieve.pojo.ResearchAward;
import achieve.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResearchAwardDaoImpl implements ResearchAwardDao {

    public List<ResearchAward> findAll(Integer teacherId, String querySql) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM research_award " +
                    "LEFT JOIN teacher_achie ON research_award.id = teacher_achie.achieId " +
                    "WHERE teacher_achie.achieType = 'ResearchAward' AND teacher_achie.teacherId = " + teacherId.toString() + querySql;
            Statement state = conn.createStatement() ;
            ResultSet rs = state.executeQuery(sql) ;
            List<ResearchAward> list = new ArrayList<ResearchAward>() ;
            while(rs.next()){
                ResearchAward researchAward = new ResearchAward() ;
                researchAward.setId(rs.getInt("id")) ;
                researchAward.setAwardName(rs.getString("awardName")) ;
                researchAward.setPublishJournal(rs.getString("publishJournal")) ;
                researchAward.setPublisher(rs.getString("publisher")) ;
                researchAward.setPublishDate(rs.getDate("publishDate")) ;
                researchAward.setAwardWinningName(rs.getString("awardWinningName")) ;
                researchAward.setAwardType(rs.getString("awardType")) ;
                researchAward.setAwardDepartment(rs.getString("awardDepartment")) ;
                researchAward.setAwardDate(rs.getDate("awardDate")) ;
                researchAward.setAwardNumber(rs.getString("awardNumber")) ;
                researchAward.setUnitRank(rs.getInt("unitRank")) ;
                researchAward.setSelfRank(rs.getInt("selfRank")) ;
                researchAward.setSubjectCategory(rs.getString("subjectCategory")) ;
                researchAward.setRemark(rs.getString("remark")) ;
                researchAward.setCreatedAt(rs.getTimestamp("createdAt"));
                researchAward.setUpdatedAt(rs.getTimestamp("updatedAt"));
                list.add(researchAward) ;
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

    public List<ResearchAward> adminFindAll(String querySql) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * , user.realName AS teacherName, teacher.id AS teacherId FROM research_award " +
                    "LEFT JOIN teacher_achie ON research_award.id = teacher_achie.achieId " +
                    "LEFT JOIN teacher ON teacher_achie.teacherId = teacher.id " +
                    "LEFT JOIN user ON teacher.userId = user.id " +
                    "WHERE teacher_achie.achieType = 'ResearchAward' " + querySql;
            Statement state = conn.createStatement() ;
            ResultSet rs = state.executeQuery(sql) ;
            List<ResearchAward> list = new ArrayList<ResearchAward>() ;
            while(rs.next()){
                ResearchAward researchAward = new ResearchAward() ;
                researchAward.setId(rs.getInt("id")) ;
                researchAward.setAwardName(rs.getString("awardName")) ;
                researchAward.setPublishJournal(rs.getString("publishJournal")) ;
                researchAward.setPublisher(rs.getString("publisher")) ;
                researchAward.setPublishDate(rs.getDate("publishDate")) ;
                researchAward.setAwardWinningName(rs.getString("awardWinningName")) ;
                researchAward.setAwardType(rs.getString("awardType")) ;
                researchAward.setAwardDepartment(rs.getString("awardDepartment")) ;
                researchAward.setAwardDate(rs.getDate("awardDate")) ;
                researchAward.setAwardNumber(rs.getString("awardNumber")) ;
                researchAward.setUnitRank(rs.getInt("unitRank")) ;
                researchAward.setSelfRank(rs.getInt("selfRank")) ;
                researchAward.setSubjectCategory(rs.getString("subjectCategory")) ;
                researchAward.setRemark(rs.getString("remark")) ;
                researchAward.setCreatedAt(rs.getTimestamp("createdAt"));
                researchAward.setUpdatedAt(rs.getTimestamp("updatedAt"));
                researchAward.setTeacherName(rs.getString("teacherName"));
                list.add(researchAward) ;
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

    public Integer addResearchAward(ResearchAward researchAward) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "INSERT INTO research_award " +
                    "(awardName , publishJournal , publisher , publishDate, awardWinningName, awardType, awardDepartment, awardDate, awardNumber, unitRank, selfRank, subjectCategory, remark, createdAt, updatedAt) " +
                    "VALUES " +
                    "(? , ? , ? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, researchAward.getAwardName()) ;
            ps.setString(2, researchAward.getPublishJournal()) ;
            ps.setString(3, researchAward.getPublisher()) ;
            if(researchAward.getPublishDate() != null){
                ps.setDate(4, new java.sql.Date(researchAward.getPublishDate().getTime()));
            }else{
                ps.setDate(4, null);
            }
            ps.setString(5, researchAward.getAwardWinningName()) ;
            ps.setString(6, researchAward.getAwardType()) ;
            ps.setString(7, researchAward.getAwardDepartment()) ;
            if (researchAward.getAwardDate() != null){
                ps.setDate(8, new java.sql.Date(researchAward.getAwardDate().getTime()));
            }else{
                ps.setDate(8, null);
            }
            ps.setString(9, researchAward.getAwardNumber()) ;
            ps.setInt(10, researchAward.getUnitRank()) ;
            ps.setInt(11, researchAward.getSelfRank()) ;
            ps.setString(12, researchAward.getSubjectCategory()) ;
            ps.setString(13, researchAward.getRemark()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(14, timeStamp);
            ps.setTimestamp(15, timeStamp);

            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("新建成功") ;
            }
            ResultSet rs = ps.getGeneratedKeys();
            int researchAwardId = 0;
            if(rs.next())
            {
                researchAwardId = rs.getInt(1);
            }
            ps.close() ;
            return researchAwardId ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null;
        }finally{
            DBUtil.close(conn) ;
        }
    }

    public ResearchAward findById(Integer id) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM research_award " +
                    "WHERE id = ? "	;
            PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setInt(1, id) ;
            ResearchAward researchAward = null ;
            ResultSet rs = ps.executeQuery() ;
            while(rs.next()){
                researchAward = new ResearchAward() ;
                researchAward.setId(rs.getInt("id")) ;
                researchAward.setAwardName(rs.getString("awardName")) ;
                researchAward.setPublishJournal(rs.getString("publishJournal")) ;
                researchAward.setPublisher(rs.getString("publisher")) ;
                researchAward.setPublishDate(rs.getDate("publishDate")) ;
                researchAward.setAwardWinningName(rs.getString("awardWinningName")) ;
                researchAward.setAwardType(rs.getString("awardType")) ;
                researchAward.setAwardDepartment(rs.getString("awardDepartment")) ;
                researchAward.setAwardDate(rs.getDate("awardDate")) ;
                researchAward.setAwardNumber(rs.getString("awardNumber")) ;
                researchAward.setUnitRank(rs.getInt("unitRank")) ;
                researchAward.setSelfRank(rs.getInt("selfRank")) ;
                researchAward.setSubjectCategory(rs.getString("subjectCategory")) ;
                researchAward.setRemark(rs.getString("remark")); ;
                researchAward.setCreatedAt(rs.getTimestamp("createdAt"));
                researchAward.setUpdatedAt(rs.getTimestamp("updatedAt"));
            }
            rs.close() ;
            ps.close() ;
            return researchAward ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null ;
        }finally{
            DBUtil.close(conn) ;
        }

    }

    public int editResearchAward(ResearchAward researchAward) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "UPDATE research_award " +
                    "SET awardName = ?, " +
                    "publishJournal = ?, " +
                    "publisher = ?, " +
                    "publishDate = ?, " +
                    "awardWinningName = ?, " +
                    "awardType = ?, " +
                    "awardDepartment = ?, " +
                    "awardDate = ?, " +
                    "awardNumber = ?, " +
                    "unitRank = ?, " +
                    "selfRank = ?, " +
                    "subjectCategory = ?, " +
                    "remark = ?, " +
                    "updatedAt = ?" +
                    "WHERE id = ? " ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, researchAward.getAwardName()) ;
            ps.setString(2, researchAward.getPublishJournal()) ;
            ps.setString(3, researchAward.getPublisher()) ;
            if(researchAward.getPublishDate() != null){
                ps.setDate(4, new java.sql.Date(researchAward.getPublishDate().getTime()));
            }else{
                ps.setDate(4, null);
            }
            ps.setString(5, researchAward.getAwardWinningName()) ;
            ps.setString(6, researchAward.getAwardType()) ;
            ps.setString(7, researchAward.getAwardDepartment()) ;
            if (researchAward.getAwardDate() != null){
                ps.setDate(8, new java.sql.Date(researchAward.getAwardDate().getTime()));
            }else{
                ps.setDate(8, null);
            }
            ps.setString(9, researchAward.getAwardNumber()) ;
            ps.setInt(10, researchAward.getUnitRank()) ;
            ps.setInt(11, researchAward.getSelfRank()) ;
            ps.setString(12, researchAward.getSubjectCategory()) ;
            ps.setString(13, researchAward.getRemark()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(14, timeStamp);
            ps.setInt(15 , researchAward.getId()) ;
            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("更新成功") ;
            }
            ResultSet rs = ps.getGeneratedKeys();
            int researchAwardId = 0;
            if(rs.next())
            {
                researchAwardId = rs.getInt(1);
            }
            ps.close() ;
            return researchAwardId ;
        } catch (Exception e) {
            System.out.println("出错原因" + e);
            e.printStackTrace() ;
            return 0;
        }finally{
            DBUtil.close(conn) ;
        }

    }

}
