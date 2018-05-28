package achieve.dao;

import achieve.pojo.User;
import achieve.util.DBUtil;

import java.sql.*;
import java.util.Date;

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

    public User findById(Integer id) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "SELECT * FROM user " +
                    "WHERE id = ? "	;
            PreparedStatement ps = conn.prepareStatement(sql) ;
            ps.setInt(1, id) ;
            User user = null ;
            ResultSet rs = ps.executeQuery() ;
            while(rs.next()){
                user = new User() ;
                user.setId(rs.getInt("id")) ;
                user.setUserName(rs.getString("userName")) ;
                user.setRealName(rs.getString("realName")) ;
                user.setAge(rs.getString("age")) ;
                user.setPassword(rs.getString("password")) ;
                user.setJob(rs.getString("job")) ;
                user.setPosition(rs.getString("position")) ;
                user.setStartWorkingTime(rs.getDate("startWorkingTime")) ;
                user.setRemark(rs.getString("remark")) ;
                user.setStatus(rs.getString("status")) ;
                user.setCreatedAt(rs.getTimestamp("createdAt"));
                user.setUpdatedAt(rs.getTimestamp("updatedAt"));
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

    public int editUser(User user) {
        Connection conn = null ;
        try {
            conn = DBUtil.getConnection() ;
            String sql = "UPDATE user " +
                    "SET userName = ?, " +
                    "realName = ?, " +
                    "age = ?, " +
                    "password = ?, " +
                    "job = ?, " +
                    "position = ?, " +
                    "startWorkingTime = ?, " +
                    "remark = ?, " +
                    "status = ?, " +
                    "updatedAt = ?" +
                    "WHERE id = ? " ;
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
            ps.setString(1, user.getUserName()) ;
            ps.setString(2, user.getRealName()) ;
            ps.setString(3, user.getAge()) ;
            ps.setString(4, user.getPassword()) ;
            ps.setString(5, user.getJob()) ;
            ps.setString(6, user.getPosition()) ;
            if (user.getStartWorkingTime() != null){
                ps.setDate(7, new java.sql.Date(user.getStartWorkingTime().getTime()));
            }else{
                ps.setDate(7, null);
            }
            ps.setString(8, user.getRemark()) ;
            ps.setString(9, user.getStatus()) ;
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            ps.setTimestamp(10, timeStamp);
            ps.setInt(11, user.getId()) ;
            int n = ps.executeUpdate() ;
            if(n > 0){
                System.out.println("更新成功") ;
            }
            ResultSet rs = ps.getGeneratedKeys();
            int userId = 0;
            if(rs.next())
            {
                userId = rs.getInt(1);
            }
            ps.close() ;
            return userId ;
        } catch (Exception e) {
            System.out.println("出错原因" + e);
            e.printStackTrace() ;
            return 0;
        }finally{
            DBUtil.close(conn) ;
        }

    }
    

}
