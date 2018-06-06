package achieve.dao;

import achieve.pojo.ResearchProject;
import achieve.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResearchProjectDaoImpl implements ResearchProjectDao {

    public List<ResearchProject> findAll(Integer teacherId, String querySql) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM research_project " +
                    "LEFT JOIN teacher_achie ON research_project.id = teacher_achie.achieId " +
                    "WHERE teacher_achie.achieType = 'ResearchProject' AND teacher_achie.teacherId = " + teacherId.toString() + querySql;
            Statement state = conn.createStatement() ;
            ResultSet rs = state.executeQuery(sql) ;
            List<ResearchProject> list = new ArrayList<ResearchProject>() ;
            while(rs.next()){
                ResearchProject researchProject = new ResearchProject() ;
                researchProject.setId(rs.getInt("id")) ;
                researchProject.setLeader(rs.getString("leader")) ;
                researchProject.setName(rs.getString("name")) ;
                researchProject.setProjectType(rs.getString("projectType")) ;
                researchProject.setApprovalNumber(rs.getString("approvalNumber")) ;
                researchProject.setResearchCategory(rs.getString("researchCategory")) ;
                researchProject.setApprovalFund(rs.getInt("approvalFund")) ;
                researchProject.setCurrentYearInMoney(rs.getInt("currentYearInMoney")) ;
                researchProject.setCurrentYearOutMoney(rs.getInt("currentYearOutMoney")) ;
                researchProject.setSubjectCategory(rs.getString("subjectCategory")) ;
                researchProject.setOrganizationForm(rs.getString("organizationForm")) ;
                researchProject.setServeNationalEconomyIndustry(rs.getString("serveNationalEconomyIndustry")) ;
                researchProject.setProjectGoal(rs.getString("projectGoal")) ;
                researchProject.setProjectStatus(rs.getString("projectStatus")) ;
                researchProject.setRemark(rs.getString("remark")) ;
                researchProject.setCreatedAt(rs.getTimestamp("createdAt"));
                researchProject.setUpdatedAt(rs.getTimestamp("updatedAt"));
                list.add(researchProject) ;
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

    public Integer addResearchProject(ResearchProject researchProject) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "INSERT INTO research_project " +
                    "(leader , name , projectType , approvalNumber, researchCategory, approvalFund , currentYearInMoney, currentYearOutMoney, subjectCategory, organizationForm, serveNationalEconomyIndustry, projectGoal, projectStatus, remark, createdAt, updatedAt) " +
                    "VALUES " +
                    "(? , ? , ? , ? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, researchProject.getLeader()) ;
            ps.setString(2, researchProject.getName()) ;
            ps.setString(3, researchProject.getProjectType()) ;
            ps.setString(4, researchProject.getApprovalNumber()) ;
            ps.setString(5, researchProject.getResearchCategory()) ;
            ps.setInt(6, researchProject.getApprovalFund());
            ps.setInt(7, researchProject.getCurrentYearInMoney()) ;
            ps.setInt(8, researchProject.getCurrentYearOutMoney()) ;
            ps.setString(9, researchProject.getSubjectCategory()) ;
            ps.setString(10, researchProject.getOrganizationForm()) ;
            ps.setString(11, researchProject.getServeNationalEconomyIndustry()) ;
            ps.setString(12, researchProject.getProjectGoal()) ;
            ps.setString(13, researchProject.getProjectStatus()) ;
            ps.setString(14, researchProject.getRemark()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(15, timeStamp);
            ps.setTimestamp(16, timeStamp);

            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("新建成功") ;
            }
            ResultSet rs = ps.getGeneratedKeys();
            int researchProjectId = 0;
            if(rs.next())
            {
                researchProjectId = rs.getInt(1);
            }
            ps.close() ;
            return researchProjectId ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null;
        }finally{
            DBUtil.close(conn) ;
        }
    }

    public ResearchProject findById(Integer id) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM research_project " +
                    "WHERE id = ? "	;
            PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setInt(1, id) ;
            ResearchProject researchProject = null ;
            ResultSet rs = ps.executeQuery() ;
            while(rs.next()){
                researchProject = new ResearchProject() ;
                researchProject.setId(rs.getInt("id")) ;
                researchProject.setLeader(rs.getString("leader")) ;
                researchProject.setName(rs.getString("name")) ;
                researchProject.setProjectType(rs.getString("projectType")) ;
                researchProject.setApprovalNumber(rs.getString("approvalNumber")) ;
                researchProject.setResearchCategory(rs.getString("researchCategory")) ;
                researchProject.setApprovalFund(rs.getInt("approvalFund")) ;
                researchProject.setCurrentYearInMoney(rs.getInt("currentYearInMoney")) ;
                researchProject.setCurrentYearOutMoney(rs.getInt("currentYearOutMoney")) ;
                researchProject.setSubjectCategory(rs.getString("subjectCategory")) ;
                researchProject.setOrganizationForm(rs.getString("organizationForm")) ;
                researchProject.setServeNationalEconomyIndustry(rs.getString("serveNationalEconomyIndustry")) ;
                researchProject.setProjectGoal(rs.getString("projectGoal")) ;
                researchProject.setProjectStatus(rs.getString("projectStatus")) ;
                researchProject.setRemark(rs.getString("remark")) ;
                researchProject.setCreatedAt(rs.getTimestamp("createdAt"));
                researchProject.setUpdatedAt(rs.getTimestamp("updatedAt"));
            }
            rs.close() ;
            ps.close() ;
            return researchProject ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null ;
        }finally{
            DBUtil.close(conn) ;
        }

    }

    public int editResearchProject(ResearchProject researchProject) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "UPDATE research_project " +
                    "SET leader = ?, " +
                    "name = ?, " +
                    "projectType = ?, " +
                    "approvalNumber = ?, " +
                    "researchCategory = ?, " +
                    "approvalFund = ?, " +
                    "currentYearInMoney = ?, " +
                    "currentYearOutMoney = ?, " +
                    "subjectCategory = ?, " +
                    "organizationForm = ?, " +
                    "serveNationalEconomyIndustry = ?, " +
                    "projectGoal = ?, " +
                    "projectStatus = ?, " +
                    "remark = ?, " +
                    "updatedAt = ?" +
                    "WHERE id = ? " ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, researchProject.getLeader()) ;
            ps.setString(2, researchProject.getName()) ;
            ps.setString(3, researchProject.getProjectType()) ;
            ps.setString(4, researchProject.getApprovalNumber()) ;
            ps.setString(5, researchProject.getResearchCategory()) ;
            ps.setInt(6, researchProject.getApprovalFund());
            ps.setInt(7, researchProject.getCurrentYearInMoney()) ;
            ps.setInt(8, researchProject.getCurrentYearOutMoney()) ;
            ps.setString(9, researchProject.getSubjectCategory()) ;
            ps.setString(10, researchProject.getOrganizationForm()) ;
            ps.setString(11, researchProject.getServeNationalEconomyIndustry()) ;
            ps.setString(12, researchProject.getProjectGoal()) ;
            ps.setString(13, researchProject.getProjectStatus()) ;
            ps.setString(14, researchProject.getRemark()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(15, timeStamp);
            ps.setInt(16, researchProject.getId()) ;
            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("更新成功") ;
            }
            ResultSet rs = ps.getGeneratedKeys();
            int researchProjectId = 0;
            if(rs.next())
            {
                researchProjectId = rs.getInt(1);
            }
            ps.close() ;
            return researchProjectId ;
        } catch (Exception e) {
            System.out.println("出错原因" + e);
            e.printStackTrace() ;
            return 0;
        }finally{
            DBUtil.close(conn) ;
        }

    }

}
