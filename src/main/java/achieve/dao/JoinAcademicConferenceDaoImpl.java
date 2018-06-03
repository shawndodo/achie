package achieve.dao;

import achieve.pojo.JoinAcademicConference;
import achieve.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JoinAcademicConferenceDaoImpl implements JoinAcademicConferenceDao {

    public List<JoinAcademicConference> findAll(Integer teacherId, String querySql) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM join_academic_conference " +
                    "LEFT JOIN teacher_achie ON join_academic_conference.id = teacher_achie.achieId " +
                    "WHERE teacher_achie.achieType = 'JoinAcademicConference' AND teacher_achie.teacherId = " + teacherId.toString() + querySql;
            Statement state = conn.createStatement() ;
            ResultSet rs = state.executeQuery(sql) ;
            List<JoinAcademicConference> list = new ArrayList<JoinAcademicConference>() ;
            while(rs.next()){
                JoinAcademicConference joinAcademicConference = new JoinAcademicConference() ;
                joinAcademicConference.setId(rs.getInt("id")) ;
                joinAcademicConference.setName(rs.getString("name")) ;
                joinAcademicConference.setLocation(rs.getString("location")) ;
                joinAcademicConference.setLevel(rs.getString("level")) ;
                joinAcademicConference.setPaperName(rs.getString("paperName")) ;
                joinAcademicConference.setIsInviteReport(rs.getString("isInviteReport")) ;
                joinAcademicConference.setSubmitDate(rs.getDate("submitDate")) ;
                joinAcademicConference.setParticipant(rs.getString("participant"));
                joinAcademicConference.setTitle(rs.getString("title"));
                joinAcademicConference.setSubjectCategory(rs.getString("subjectCategory"));
                joinAcademicConference.setRemark(rs.getString("remark")) ;
                joinAcademicConference.setCreatedAt(rs.getTimestamp("createdAt"));
                joinAcademicConference.setUpdatedAt(rs.getTimestamp("updatedAt"));
                list.add(joinAcademicConference) ;
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

    public Integer addJoinAcademicConference(JoinAcademicConference joinAcademicConference) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "INSERT INTO join_academic_conference " +
                    "(name , location , level , paperName, isInviteReport, submitDate , remark, participant, title, subjectCategory, createdAt, updatedAt) " +
                    "VALUES " +
                    "(? , ? , ? , ? , ?, ?, ?, ?, ?, ?, ?, ?)" ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, joinAcademicConference.getName()) ;
            ps.setString(2, joinAcademicConference.getLocation()) ;
            ps.setString(3, joinAcademicConference.getLevel()) ;
            ps.setString(4, joinAcademicConference.getPaperName()) ;
            ps.setString(5, joinAcademicConference.getIsInviteReport()) ;
            if (joinAcademicConference.getSubmitDate() != null){
                ps.setDate(6, new java.sql.Date(joinAcademicConference.getSubmitDate().getTime()));
            }else{
                ps.setDate(6, null);
            }
            ps.setString(7, joinAcademicConference.getRemark()) ;
            ps.setString(8, joinAcademicConference.getParticipant()) ;
            ps.setString(9, joinAcademicConference.getTitle()) ;
            ps.setString(10, joinAcademicConference.getSubjectCategory()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(11, timeStamp);
            ps.setTimestamp(12, timeStamp);

            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("新建成功") ;
            }
            ResultSet rs = ps.getGeneratedKeys();
            int joinAcademicConferenceId = 0;
            if(rs.next())
            {
                joinAcademicConferenceId = rs.getInt(1);
            }
            ps.close() ;
            return joinAcademicConferenceId ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null;
        }finally{
            DBUtil.close(conn) ;
        }
    }

    public JoinAcademicConference findById(Integer id) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM join_academic_conference " +
                    "WHERE id = ? "	;
            PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setInt(1, id) ;
            JoinAcademicConference joinAcademicConference = null ;
            ResultSet rs = ps.executeQuery() ;
            while(rs.next()){
                joinAcademicConference = new JoinAcademicConference() ;
                joinAcademicConference.setId(rs.getInt("id")) ;
                joinAcademicConference.setName(rs.getString("name")) ;
                joinAcademicConference.setLocation(rs.getString("location")) ;
                joinAcademicConference.setLevel(rs.getString("level")) ;
                joinAcademicConference.setPaperName(rs.getString("paperName")) ;
                joinAcademicConference.setIsInviteReport(rs.getString("isInviteReport")) ;
                joinAcademicConference.setSubmitDate(rs.getDate("submitDate")) ;
                joinAcademicConference.setParticipant(rs.getString("participant"));
                joinAcademicConference.setTitle(rs.getString("title"));
                joinAcademicConference.setSubjectCategory(rs.getString("subjectCategory"));
                joinAcademicConference.setRemark(rs.getString("remark")) ;
                joinAcademicConference.setCreatedAt(rs.getTimestamp("createdAt"));
                joinAcademicConference.setUpdatedAt(rs.getTimestamp("updatedAt"));
            }
            rs.close() ;
            ps.close() ;
            return joinAcademicConference ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null ;
        }finally{
            DBUtil.close(conn) ;
        }

    }

    public int editJoinAcademicConference(JoinAcademicConference joinAcademicConference) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "UPDATE join_academic_conference " +
                    "SET name = ?, " +
                    "location = ?, " +
                    "level = ?, " +
                    "paperName = ?, " +
                    "isInviteReport = ?, " +
                    "submitDate = ?, " +
                    "remark = ?, " +
                    "participant = ?, " +
                    "title = ?, " +
                    "subjectCategory = ?, " +
                    "updatedAt = ?" +
                    "WHERE id = ? " ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, joinAcademicConference.getName()) ;
            ps.setString(2, joinAcademicConference.getLocation()) ;
            ps.setString(3, joinAcademicConference.getLevel()) ;
            ps.setString(4, joinAcademicConference.getPaperName()) ;
            ps.setString(5, joinAcademicConference.getIsInviteReport()) ;
            if (joinAcademicConference.getSubmitDate() != null){
                ps.setDate(6, new java.sql.Date(joinAcademicConference.getSubmitDate().getTime()));
            }else{
                ps.setDate(6, null);
            }
            ps.setString(7, joinAcademicConference.getRemark()) ;
            ps.setString(8, joinAcademicConference.getParticipant()) ;
            ps.setString(9, joinAcademicConference.getTitle()) ;
            ps.setString(10, joinAcademicConference.getSubjectCategory()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(11, timeStamp);
            ps.setInt(12, joinAcademicConference.getId()) ;
            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("更新成功") ;
            }
            ResultSet rs = ps.getGeneratedKeys();
            int joinAcademicConferenceId = 0;
            if(rs.next())
            {
                joinAcademicConferenceId = rs.getInt(1);
            }
            ps.close() ;
            return joinAcademicConferenceId ;
        } catch (Exception e) {
            System.out.println("出错原因" + e);
            e.printStackTrace() ;
            return 0;
        }finally{
            DBUtil.close(conn) ;
        }

    }

}
