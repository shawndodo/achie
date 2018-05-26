package achieve.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    private static String driverName = "com.mysql.jdbc.Driver" ;
    private static String url = "jdbc:mysql://45.76.103.254:3306/achie_0417?characterEncoding=utf8&useSSL=false" ;
    private static String username = "root" ;
    private static String password = "dodocat1994" ;

//    建立连接
    public static Connection getConnection()throws Exception{
        try {
            Class.forName(driverName) ;
            Connection conn = DriverManager.getConnection(
                    url,
                    username,
                    password) ;
            return conn ;
        } catch (Exception e) {
            System.out.println("连接数据库失败") ;
            throw e ;
        }

    }

//    关闭数据库
    public static void close(Connection conn){
        if(conn != null){
            try {
                conn.close() ;
            } catch (Exception e) {
                e.printStackTrace() ;
            }
        }
    }

//    回滚
    public static void rollback(Connection conn){
        if(conn != null){
            try {
                conn.rollback() ;
            } catch (Exception e) {
                e.printStackTrace() ;
            }
        }
    }



}
