package MAIN;

import DAO.MeetingDAO;
import DB.DBUtil;
import java.sql.*;

public class MainTest {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            System.out.println("DB 연결 성공!!");
        } catch (SQLException e) {
            System.out.println("DB 연결 실패!: " + e.getMessage());
        }
        //System.out.println(" CRUD 작업 가능 - insert test");
        //MeetingDAO.insertMeeting(conn, "캡스톤회의01 ", "2025-10-24", "혁신관 304");
        //MeetingDAO.insertMeeting(conn, "최종회의", "2025-12-24", "혁신관 306");


      //  System.out.println(" CRUD 작업 가능 - delete test");
      //  MeetingDAO.deleteMeeting(conn,9);
      //  MeetingDAO.deleteMeeting(conn,8);

       //  MeetingDAO.updateMeeting(conn,"수정제목변경","2025-12-01","304", 1);
        MeetingDAO.selectAllMeeting(conn);


    }
}
