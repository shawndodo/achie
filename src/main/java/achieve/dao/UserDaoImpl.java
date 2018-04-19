package achieve.dao;

import achieve.pojo.User;
import achieve.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {

    public User findByUserName(String userName){
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM user " +
                    "WHERE userName = ? "	;
            PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setString(1,userName) ;
            User user = null ;
            ResultSet rs = ps.executeQuery() ;
            while(rs.next()){
                user = new User() ;
                user.setId(rs.getInt("Id")) ;
                user.setUserName(rs.getString("userName"));
                user.setRealName(rs.getString("realName"));
                user.setPassword(rs.getString("password")) ;
                user.setAge(rs.getString("age"));
                user.setJob(rs.getString("job"));
                user.setPosition(rs.getString("position"));
                user.setStartWorkingTime(rs.getDate("startWorkingTime"));
                user.setRemark(rs.getString("remark"));
                user.setStatus(rs.getString("status"));
            }
            rs.close() ;
            ps.close() ;
            return user ;
        } catch (Exception e) {
            e.printStackTrace() ;
            return null ;
        }finally{
            DBUtil.close(conn) ;
        }
    }

}
