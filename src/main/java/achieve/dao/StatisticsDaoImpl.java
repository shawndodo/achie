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
                    "sum(case when teacher_achie.label = 'teach' then 1 else 0 end) as teach_count " +
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
                map.put("teachCount", rs.getInt("teach_count"));
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
