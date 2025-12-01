package DB;
import java.sql.*;
public class DBUtil {
     //DB와 연결되었을 때 그 세션 연결 정보를 가진 객체
     private static String url = "jdbc:mariadb://localhost:3310/meeting_db";
     private static String user = "root";
     private static String password = "1111";
     private static Connection conn =  null;

     public static Connection getConnection() throws SQLException {
         try {
             if( conn == null){
                 conn = DriverManager.getConnection(url, user,password);
             }

         } catch (SQLException e) {
             throw new SQLException(e);
         }
         return conn;
     }
}
