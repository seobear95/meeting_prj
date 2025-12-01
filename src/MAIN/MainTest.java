package MAIN;

import DAO.MeetingDAO;
import DB.DBUtil;
import UI.MeetingUI;

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


       // System.out.println(" CRUD 작업 가능 - delete test");
      //  MeetingDAO.deleteMeeting(conn,1);
      //  MeetingDAO.deleteMeeting(conn,2);

      //  MeetingDAO.selectAllMeeting(conn);
      //  MeetingDAO.updateMeeting(conn,"수정제목변경","2025-12-01","304", 4);
      //  MeetingDAO.selectMeeting(conn,4);
      //  MeetingDAO.selectAllMeeting(conn);

       // 회의 첫 시작에서 일정논의
       // MeetingDAO.insertMeeting(conn, "일정논의 회의","2025-12-1","306");
       // 예산관련 논의
       // MeetingDAO.insertMeeting(conn, "예산관련 논의", "2025-12-1", "304");

       // 전체 어떤 회의가 있었는지 확인필요
      // MeetingDAO.selectAllMeeting(conn);

       // 예산관련 내용이 수정 필요해
      // MeetingDAO.updateMeeting(conn,"예산관련수정","2025-12-2", "305",17);

        //일정논의 회의는 삭제 필요해.
      // MeetingDAO.deleteMeeting(conn,16);

        //최종 결과
       // MeetingDAO.selectAllMeeting(conn);

        new MeetingUI();



    }
}
