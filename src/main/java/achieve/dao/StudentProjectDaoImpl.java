package achieve.dao;

import achieve.pojo.StudentProject;
import achieve.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentProjectDaoImpl implements StudentProjectDao {

    public List<StudentProject> findAll(Integer teacherId) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM student_project " +
                    "LEFT JOIN teacher_achie ON student_project.id = teacher_achie.achieId " +
                    "WHERE teacher_achie.achieType = 'StudentProject' AND teacher_achie.teacherId = " + teacherId.toString();
            Statement state = conn.createStatement() ;
            ResultSet rs = state.executeQuery(sql) ;
            List<StudentProject> list = new ArrayList<StudentProject>() ;
            while(rs.next()){
                StudentProject studentProject = new StudentProject() ;
                studentProject.setId(rs.getInt("id")) ;
                studentProject.setCode(rs.getString("code")) ;
                studentProject.setName(rs.getString("name")) ;
                studentProject.setProjectType(rs.getString("projectType")) ;
                studentProject.setLeader(rs.getString("leader")) ;
                studentProject.setStudentNum(rs.getString("studentNum")) ;
                studentProject.setMentorName(rs.getString("mentorName")) ;
                studentProject.setRemark(rs.getString("remark")) ;
                studentProject.setCreatedAt(rs.getTimestamp("createdAt"));
                studentProject.setUpdatedAt(rs.getTimestamp("updatedAt"));
                list.add(studentProject) ;
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

    public Integer addStudentProject(StudentProject studentProject) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "INSERT INTO student_project " +
                    "(code , name , projectType , leader, studentNum, mentorName , remark, createdAt, updatedAt) " +
                    "VALUES " +
                    "(? , ? , ? , ? , ?, ?, ?, ?, ?)" ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, studentProject.getCode()) ;
            ps.setString(2, studentProject.getName()) ;
            ps.setString(3, studentProject.getProjectType()) ;
            ps.setString(4, studentProject.getLeader()) ;
            ps.setString(5, studentProject.getStudentNum()) ;
            ps.setString(6, studentProject.getMentorName()) ;
            ps.setString(7, studentProject.getRemark()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(8, timeStamp);
            ps.setTimestamp(9, timeStamp);

            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("新建成功") ;
            }
            ResultSet rs = ps.getGeneratedKeys();
            int studentProjectId = 0;
            if(rs.next())
            {
                studentProjectId = rs.getInt(1);
            }
            ps.close() ;
            return studentProjectId ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null;
        }finally{
            DBUtil.close(conn) ;
        }
    }

    public StudentProject findById(Integer id) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM student_project " +
                    "WHERE id = ? "	;
            PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setInt(1, id) ;
            StudentProject studentProject = null ;
            ResultSet rs = ps.executeQuery() ;
            while(rs.next()){
                studentProject = new StudentProject() ;
                studentProject.setId(rs.getInt("id")) ;
                studentProject.setCode(rs.getString("code")) ;
                studentProject.setName(rs.getString("name")) ;
                studentProject.setProjectType(rs.getString("projectType")) ;
                studentProject.setLeader(rs.getString("leader")) ;
                studentProject.setStudentNum(rs.getString("studentNum")) ;
                studentProject.setMentorName(rs.getString("mentorName")) ;
                studentProject.setRemark(rs.getString("remark")) ;
                studentProject.setCreatedAt(rs.getTimestamp("createdAt"));
                studentProject.setUpdatedAt(rs.getTimestamp("updatedAt"));
            }
            rs.close() ;
            ps.close() ;
            return studentProject ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null ;
        }finally{
            DBUtil.close(conn) ;
        }

    }

    public int editStudentProject(StudentProject studentProject) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "UPDATE student_project " +
                    "SET code = ?, " +
                    "name = ?, " +
                    "projectType = ?, " +
                    "leader = ?, " +
                    "studentNum = ?, " +
                    "mentorName = ?, " +
                    "remark = ?, " +
                    "updatedAt = ?" +
                    "WHERE id = ? " ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, studentProject.getCode()) ;
            ps.setString(2, studentProject.getName()) ;
            ps.setString(3, studentProject.getProjectType()) ;
            ps.setString(4, studentProject.getLeader()) ;
            ps.setString(5, studentProject.getStudentNum()) ;
            ps.setString(6, studentProject.getMentorName()) ;
            ps.setString(7, studentProject.getRemark()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(8, timeStamp);
            ps.setInt(9, studentProject.getId()) ;
            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("更新成功") ;
            }
            ResultSet rs = ps.getGeneratedKeys();
            int studentProjectId = 0;
            if(rs.next())
            {
                studentProjectId = rs.getInt(1);
            }
            ps.close() ;
            return studentProjectId ;
        } catch (Exception e) {
            System.out.println("出错原因" + e);
            e.printStackTrace() ;
            return 0;
        }finally{
            DBUtil.close(conn) ;
        }

    }

}
