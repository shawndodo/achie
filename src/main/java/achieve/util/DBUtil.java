package achieve.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    // 数据库驱动
    private static String driverName = "com.mysql.jdbc.Driver" ;
    // 数据库地址和名称以及编码方式
    private static String url = "jdbc:mysql://45.76.103.254:3306/achie_0417?characterEncoding=utf8&useSSL=false" ;
    // 数据库账户
    private static String username = "root" ;
    // 数据库密码
    private static String password = "dodocat1994" ;

//    开始做操作前建立连接
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

//    操作完后关闭数据库
    public static void close(Connection conn){
        if(conn != null){
            try {
                conn.close() ;
            } catch (Exception e) {
                e.printStackTrace() ;
            }
        }
    }

//    有错误要回滚
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
