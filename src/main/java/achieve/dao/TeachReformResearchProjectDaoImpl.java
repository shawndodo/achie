package achieve.dao;

import achieve.pojo.TeachReformResearchProject;
import achieve.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeachReformResearchProjectDaoImpl implements TeachReformResearchProjectDao {

    public List<TeachReformResearchProject> findAll(Integer teacherId, String querySql) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM teach_reform_research_project " +
                    "LEFT JOIN teacher_achie ON teach_reform_research_project.id = teacher_achie.achieId " +
                    "WHERE teacher_achie.achieType = 'TeachReformResearchProject' AND teacher_achie.teacherId = " + teacherId.toString() + querySql;
            Statement state = conn.createStatement() ;
            ResultSet rs = state.executeQuery(sql) ;
            List<TeachReformResearchProject> list = new ArrayList<TeachReformResearchProject>() ;
            while(rs.next()){
                TeachReformResearchProject teachReformResearchProject = new TeachReformResearchProject() ;
                teachReformResearchProject.setId(rs.getInt("id")) ;
                teachReformResearchProject.setCode(rs.getString("code")) ;
                teachReformResearchProject.setName(rs.getString("name")) ;
                teachReformResearchProject.setLevel(rs.getString("level")) ;
                teachReformResearchProject.setLeader(rs.getString("leader")) ;
                teachReformResearchProject.setYear(rs.getString("year")) ;
                teachReformResearchProject.setRemark(rs.getString("remark")) ;
                teachReformResearchProject.setCreatedAt(rs.getTimestamp("createdAt"));
                teachReformResearchProject.setUpdatedAt(rs.getTimestamp("updatedAt"));
                list.add(teachReformResearchProject) ;
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

    public List<TeachReformResearchProject> adminFindAll(String querySql) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * , user.realName AS teacherName, teacher.id AS teacherId FROM teach_reform_research_project " +
                    "LEFT JOIN teacher_achie ON teach_reform_research_project.id = teacher_achie.achieId " +
                    "LEFT JOIN teacher ON teacher_achie.teacherId = teacher.id " +
                    "LEFT JOIN user ON teacher.userId = user.id " +
                    "WHERE teacher_achie.achieType = 'TeachReformResearchProject' " + querySql;
            Statement state = conn.createStatement() ;
            ResultSet rs = state.executeQuery(sql) ;
            List<TeachReformResearchProject> list = new ArrayList<TeachReformResearchProject>() ;
            while(rs.next()){
                TeachReformResearchProject teachReformResearchProject = new TeachReformResearchProject() ;
                teachReformResearchProject.setId(rs.getInt("id")) ;
                teachReformResearchProject.setCode(rs.getString("code")) ;
                teachReformResearchProject.setName(rs.getString("name")) ;
                teachReformResearchProject.setLevel(rs.getString("level")) ;
                teachReformResearchProject.setLeader(rs.getString("leader")) ;
                teachReformResearchProject.setYear(rs.getString("year")) ;
                teachReformResearchProject.setRemark(rs.getString("remark")) ;
                teachReformResearchProject.setCreatedAt(rs.getTimestamp("createdAt"));
                teachReformResearchProject.setUpdatedAt(rs.getTimestamp("updatedAt"));
                teachReformResearchProject.setTeacherName(rs.getString("teacherName"));
                list.add(teachReformResearchProject) ;
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

    public Integer addTeachReformResearchProject(TeachReformResearchProject teachReformResearchProject) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "INSERT INTO teach_reform_research_project " +
                    "(code , name , level , leader, year, remark , createdAt, updatedAt) " +
                    "VALUES " +
                    "(? , ? , ? , ? , ?, ?, ?, ?)" ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, teachReformResearchProject.getCode()) ;
            ps.setString(2, teachReformResearchProject.getName()) ;
            ps.setString(3, teachReformResearchProject.getLevel()) ;
            ps.setString(4, teachReformResearchProject.getLeader()) ;
            ps.setString(5, teachReformResearchProject.getYear()) ;
            ps.setString(6, teachReformResearchProject.getRemark()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(7, timeStamp);
            ps.setTimestamp(8, timeStamp);

            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("新建成功") ;
            }
            ResultSet rs = ps.getGeneratedKeys();
            int teachReformResearchProjectId = 0;
            if(rs.next())
            {
                teachReformResearchProjectId = rs.getInt(1);
            }
            ps.close() ;
            return teachReformResearchProjectId ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null;
        }finally{
            DBUtil.close(conn) ;
        }
    }

    public TeachReformResearchProject findById(Integer id) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM teach_reform_research_project " +
                    "WHERE id = ? "	;
            PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setInt(1, id) ;
            TeachReformResearchProject teachReformResearchProject = null ;
            ResultSet rs = ps.executeQuery() ;
            while(rs.next()){
                teachReformResearchProject = new TeachReformResearchProject() ;
                teachReformResearchProject.setId(rs.getInt("id")) ;
                teachReformResearchProject.setCode(rs.getString("code")) ;
                teachReformResearchProject.setName(rs.getString("name")) ;
                teachReformResearchProject.setLevel(rs.getString("level")) ;
                teachReformResearchProject.setLeader(rs.getString("leader")) ;
                teachReformResearchProject.setYear(rs.getString("year")) ;
                teachReformResearchProject.setRemark(rs.getString("remark")) ;
                teachReformResearchProject.setCreatedAt(rs.getTimestamp("createdAt"));
                teachReformResearchProject.setUpdatedAt(rs.getTimestamp("updatedAt"));
            }
            rs.close() ;
            ps.close() ;
            return teachReformResearchProject ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null ;
        }finally{
            DBUtil.close(conn) ;
        }

    }

    public int editTeachReformResearchProject(TeachReformResearchProject teachReformResearchProject) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "UPDATE teach_reform_research_project " +
                    "SET code = ?, " +
                    "name = ?, " +
                    "level = ?, " +
                    "leader = ?, " +
                    "year = ?, " +
                    "remark = ?, " +
                    "updatedAt = ?" +
                    "WHERE id = ? " ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, teachReformResearchProject.getCode()) ;
            ps.setString(2, teachReformResearchProject.getName()) ;
            ps.setString(3, teachReformResearchProject.getLevel()) ;
            ps.setString(4, teachReformResearchProject.getLeader()) ;
            ps.setString(5, teachReformResearchProject.getYear()) ;
            ps.setString(6, teachReformResearchProject.getRemark()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(7, timeStamp);
            ps.setInt(8, teachReformResearchProject.getId()) ;
            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("更新成功") ;
            }
            ResultSet rs = ps.getGeneratedKeys();
            int teachReformResearchProjectId = 0;
            if(rs.next())
            {
                teachReformResearchProjectId = rs.getInt(1);
            }
            ps.close() ;
            return teachReformResearchProjectId ;
        } catch (Exception e) {
            System.out.println("出错原因" + e);
            e.printStackTrace() ;
            return 0;
        }finally{
            DBUtil.close(conn) ;
        }

    }

}
