package achieve.dao;

import achieve.pojo.Paper;
import achieve.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaperDaoImpl implements PaperDao {

    public List<Paper> findAll(Integer teacherId, String querySql) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM paper " +
                    "LEFT JOIN teacher_achie ON paper.id = teacher_achie.achieId " +
                    "WHERE teacher_achie.achieType = 'Paper' AND teacher_achie.teacherId = " + teacherId.toString() + querySql;
            Statement state = conn.createStatement() ;
            ResultSet rs = state.executeQuery(sql) ;
            List<Paper> list = new ArrayList<Paper>() ;
            while(rs.next()){
                Paper paper = new Paper() ;
                paper.setId(rs.getInt("id")) ;
                paper.setPaperName(rs.getString("paperName")) ;
                paper.setPaperType(rs.getString("paperType")) ;
                paper.setSelfRank(rs.getInt("selfRank")) ;
                paper.setIsAlone(rs.getString("isAlone")) ;
                paper.setMessageAuthor(rs.getString("messageAuthor")) ;
                paper.setPeriodicalName(rs.getString("periodicalName")) ;
                paper.setInclusionSearch(rs.getString("inclusionSearch")) ;
                paper.setPublishTime(rs.getDate("publishTime")) ;
                paper.setKeyWord(rs.getString("keyWord")) ;
                paper.setRelatedCourseName(rs.getString("relatedCourseName")) ;
                paper.setRemark(rs.getString("remark")) ;
                paper.setEdition(rs.getString("edition")) ;
                paper.setStartEndPageNum(rs.getString("startEndPageNum")) ;
                paper.setDoiNum(rs.getString("doiNum")) ;
                paper.setIssnNum(rs.getString("issnNum")) ;
                paper.setCnNum(rs.getString("cnNum")) ;
                paper.setImpactFactor(rs.getString("impactFactor")) ;
                paper.setQuotesNum(rs.getString("quotesNum")) ;
                paper.setCreatedAt(rs.getTimestamp("createdAt"));
                paper.setUpdatedAt(rs.getTimestamp("updatedAt"));
                list.add(paper) ;
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

    public Integer addPaper(Paper paper) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "INSERT INTO paper " +
                    "(paperName , paperType , selfRank , isAlone , messageAuthor, periodicalName, inclusionSearch, publishTime, keyWord, relatedCourseName, remark, edition, startEndPageNum, doiNum, issnNum, cnNum, impactFactor, quotesNum, createdAt, updatedAt) " +
                    "VALUES " +
                    "(? , ? , ? , ? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, paper.getPaperName()) ;
            ps.setString(2, paper.getPaperType()) ;
            ps.setInt(3, paper.getSelfRank()) ;
            ps.setString(4, paper.getIsAlone()) ;
            ps.setString(5, paper.getMessageAuthor()) ;
            ps.setString(6, paper.getPeriodicalName()) ;
            ps.setString(7, paper.getInclusionSearch()) ;
            if(paper.getPublishTime() != null){
                ps.setDate(8, new java.sql.Date(paper.getPublishTime().getTime()));
            }else{
                ps.setDate(8, null);
            }
            ps.setString(9, paper.getKeyWord()) ;
            ps.setString(10, paper.getRelatedCourseName()) ;
            ps.setString(11, paper.getRemark()) ;
            ps.setString(12, paper.getEdition()) ;
            ps.setString(13, paper.getStartEndPageNum()) ;
            ps.setString(14, paper.getDoiNum()) ;
            ps.setString(15, paper.getIssnNum()) ;
            ps.setString(16, paper.getCnNum()) ;
            ps.setString(17, paper.getImpactFactor()) ;
            ps.setString(18, paper.getQuotesNum()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(19, timeStamp);
            ps.setTimestamp(20, timeStamp);

            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("新建成功") ;
            }
            ResultSet rs = ps.getGeneratedKeys();
            int paperId = 0;
            if(rs.next())
            {
                paperId = rs.getInt(1);
            }
            ps.close() ;
            return paperId ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null;
        }finally{
            DBUtil.close(conn) ;
        }
    }

    public Paper findById(Integer id) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM paper " +
                    "WHERE id = ? "	;
            PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setInt(1, id) ;
            Paper paper = null ;
            ResultSet rs = ps.executeQuery() ;
            while(rs.next()){
                paper = new Paper() ;
                paper.setId(rs.getInt("id")) ;
                paper.setPaperName(rs.getString("paperName")) ;
                paper.setPaperType(rs.getString("paperType")) ;
                paper.setSelfRank(rs.getInt("selfRank")) ;
                paper.setIsAlone(rs.getString("isAlone")) ;
                paper.setMessageAuthor(rs.getString("messageAuthor")) ;
                paper.setPeriodicalName(rs.getString("periodicalName")) ;
                paper.setInclusionSearch(rs.getString("inclusionSearch")) ;
                paper.setPublishTime(rs.getDate("publishTime")) ;
                paper.setKeyWord(rs.getString("keyWord")) ;
                paper.setRelatedCourseName(rs.getString("relatedCourseName")) ;
                paper.setRemark(rs.getString("remark")) ;
                paper.setEdition(rs.getString("edition")) ;
                paper.setStartEndPageNum(rs.getString("startEndPageNum")) ;
                paper.setDoiNum(rs.getString("doiNum")) ;
                paper.setIssnNum(rs.getString("issnNum")) ;
                paper.setCnNum(rs.getString("cnNum")) ;
                paper.setImpactFactor(rs.getString("impactFactor")) ;
                paper.setQuotesNum(rs.getString("quotesNum")) ;
                paper.setCreatedAt(rs.getTimestamp("createdAt"));
                paper.setUpdatedAt(rs.getTimestamp("updatedAt"));
            }
            rs.close() ;
            ps.close() ;
            return paper ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null ;
        }finally{
            DBUtil.close(conn) ;
        }

    }

    public int editPaper(Paper paper) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "UPDATE paper " +
                    "SET paperName = ?, " +
                    "paperType = ?, " +
                    "selfRank = ?, " +
                    "isAlone = ?, " +
                    "messageAuthor = ?, " +
                    "periodicalName = ?, " +
                    "inclusionSearch = ?, " +
                    "publishTime = ?, " +
                    "keyWord = ?, " +
                    "relatedCourseName = ?, " +
                    "remark = ?, " +
                    "edition = ?, " +
                    "startEndPageNum = ?, " +
                    "doiNum = ?, " +
                    "issnNum = ?, " +
                    "cnNum = ?, " +
                    "impactFactor = ?, " +
                    "quotesNum = ?, " +
                    "updatedAt = ?" +
                    "WHERE id = ? " ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, paper.getPaperName()) ;
            ps.setString(2, paper.getPaperType()) ;
            ps.setInt(3, paper.getSelfRank()) ;
            ps.setString(4, paper.getIsAlone()) ;
            ps.setString(5, paper.getMessageAuthor()) ;
            ps.setString(6, paper.getPeriodicalName()) ;
            ps.setString(7, paper.getInclusionSearch()) ;
            if(paper.getPublishTime() != null){
                ps.setDate(8, new java.sql.Date(paper.getPublishTime().getTime()));
            }else{
                ps.setDate(8, null);
            }
            ps.setString(9, paper.getKeyWord()) ;
            ps.setString(10, paper.getRelatedCourseName()) ;
            ps.setString(11, paper.getRemark()) ;
            ps.setString(12, paper.getEdition()) ;
            ps.setString(13, paper.getStartEndPageNum()) ;
            ps.setString(14, paper.getDoiNum()) ;
            ps.setString(15, paper.getIssnNum()) ;
            ps.setString(16, paper.getCnNum()) ;
            ps.setString(17, paper.getImpactFactor()) ;
            ps.setString(18, paper.getQuotesNum()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(19, timeStamp);
            ps.setInt(20 , paper.getId()) ;
            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("更新成功") ;
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
            System.out.println("出错原因" + e);
            e.printStackTrace() ;
            return 0;
        }finally{
            DBUtil.close(conn) ;
        }

    }

}
