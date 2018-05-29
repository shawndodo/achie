package achieve.dao;

import achieve.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class StatisticsDaoImpl implements StatisticsDao {

    public List<HashMap> findBasicInfo() {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT teacher_achie.teacherId as teacherId, user.realName as userName,  " +
                    "sum(case when teacher_achie.label = 'research' then 1 else 0 end) as research_count, " +
                    "sum(case when teacher_achie.label = 'teach' then 1 else 0 end) as teach_count, " +
                    "sum(case when teacher_achie.achieType = 'JoinAcademicConference' then 1 else 0 end) as join_academic_conference_count, " +
                    "sum(case when teacher_achie.achieType = 'Paper' then 1 else 0 end) as paper_count, " +
                    "sum(case when teacher_achie.achieType = 'Patent' then 1 else 0 end) as patent_count, " +
                    "sum(case when teacher_achie.achieType = 'ResearchAward' then 1 else 0 end) as research_award_count, " +
                    "sum(case when teacher_achie.achieType = 'ResearchProject' then 1 else 0 end) as research_project_count, " +
                    "sum(case when teacher_achie.achieType = 'SoftwareCopyright' then 1 else 0 end) as software_copyright_count, " +
                    "sum(case when teacher_achie.achieType = 'StudentProject' then 1 else 0 end) as student_project_count, " +
                    "sum(case when teacher_achie.achieType = 'TeachAward' then 1 else 0 end) as teach_award_count, " +
                    "sum(case when teacher_achie.achieType = 'TeachPaper' then 1 else 0 end) as teach_paper_count, " +
                    "sum(case when teacher_achie.achieType = 'TeachReformResearchProject' then 1 else 0 end) as teach_reform_research_project_count, " +
                    "sum(case when teacher_achie.achieType = 'Writing' then 1 else 0 end) as writing_count " +
                    "FROM teacher_achie " +
                    "LEFT OUTER JOIN teacher ON teacher_achie.teacherId = teacher.id " +
                    "LEFT OUTER JOIN user ON teacher.userId = user.id " +
                    "GROUP BY teacher_achie.`teacherId`, user.realName ";
            Statement state = conn.createStatement() ;
            ResultSet rs = state.executeQuery(sql) ;
            List<HashMap> list = new ArrayList<HashMap>() ;
            while(rs.next()){
                HashMap map = new HashMap() ;
                map.put("teacherId", rs.getInt("teacherId"));
                map.put("userName", rs.getString("userName"));
                map.put("researchCount", rs.getInt("research_count"));
                map.put("joinAcademicConferenceCount", rs.getInt("join_academic_conference_count"));
                map.put("paperCount", rs.getInt("paper_count"));
                map.put("patentCount", rs.getInt("patent_count"));
                map.put("researchAwardCount", rs.getInt("research_award_count"));
                map.put("researchProjectCount", rs.getInt("research_project_count"));
                map.put("softwareCopyrightCount", rs.getInt("software_copyright_count"));
                map.put("studentProjectCount", rs.getInt("student_project_count"));
                map.put("teachAwardCount", rs.getInt("teach_award_count"));
                map.put("teachPaperCount", rs.getInt("teach_paper_count"));
                map.put("teachReformResearchProjectCount", rs.getInt("teach_reform_research_project_count"));
                map.put("writingCount", rs.getInt("writing_count"));
                list.add(map) ;
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

}
