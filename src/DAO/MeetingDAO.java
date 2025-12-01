package DAO;
import java.sql.*;
import java.time.LocalDate;

public class MeetingDAO {
    // insert meetings 회의 정보를 추가
    public static void insertMeeting(Connection con, String t,
                                      String d, String l){
        String sql = "INSERT INTO meetings(title,date,location) " +
                     "VALUES(?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            pst.setDate(2, Date.valueOf(d));
            pst.setString(3, l);
            pst.executeUpdate();
            System.out.println("회의록 정보 추가 성공!!");
        } catch (SQLException e) {
            System.out.println("회의록 등록중 예외 발생 : " +  e.getMessage());
        }
    }

    // 삭제
    public static void deleteMeeting(Connection con, int meeting_id){
        String sql = "DELETE FROM meetings WHERE id = ?";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, meeting_id);
            int rows = pst.executeUpdate();  // 1 or 0
            if(rows > 0){
                System.out.println("회의 정보 삭제 성공: " +  meeting_id+ " 삭제 완료");
            }else{
                System.out.println("회의 정보 삭제 불가: "+ meeting_id + " 정보 없음.");
            }

        } catch (SQLException e) {
            System.out.println("회의 정보 삭제 중에 SQL예외 발생: "+ e.getMessage());
        }
    }

    // 수정
    public static void updateMeeting(Connection con, String title, String date,
                                      String location, int meeting_id)
    {
        String sql = "UPDATE meetings SET title = ?, date = ?, location = ? " +
                     "WHERE id = ?";

        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, title);
            pst.setDate(2, Date.valueOf(date));
            pst.setString(3, location);
            pst.setInt(4, meeting_id);
            int rows = pst.executeUpdate();
            if(rows > 0){
                System.out.println("회의 정보 수정 성공: " + meeting_id +" 수정 완료");
            }else{
                System.out.println("회의 정보 수정 실패: " + meeting_id +" 정보 없음");
            }

        }catch(Exception e){

            System.out.println("회의 정보 수정 예외 발생: " + e.getMessage());
        }

    }


    // 조회
    public static void selectMeeting(Connection con, int meeting_id)
    {
        String sql = "SELECT * FROM meetings WHERE id = ?";
        try{
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setInt(1, meeting_id);
           ResultSet rs = pst.executeQuery();
           if(rs.next()){
               int id = rs.getInt("id");
               String title = rs.getString("title");
               String date = rs.getString("date");
               String location = rs.getString("location");
               System.out.println(id + " | " + title + " | " + date + " | " + location);
           }
        }catch(SQLException e){
            System.out.println( meeting_id + " 회의 정보 조회 중 예외밝생: " +e.getMessage());
        }

    }

    public static void selectAllMeeting(Connection con)
    {
        String sql = "SELECT * FROM meetings";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            System.out.println("회의록 테이블 출력 조회 시작");
            System.out.println("id"+"\t |" +"title" +"\t |" +"date" +"\t |" +"location");
            while(rs.next()){  // 커서를 한줄씩 내려오는 것, 한 행씩 rs 가 받아온다
                int id = rs.getInt("id");
                String title = rs.getString("title");
                Date date = rs.getDate("date");
                String location = rs.getString("location");

                System.out.println(id+"\t | "+title+"\t | "+date+"\t | "+location);

            }
            System.out.println("회의록 테이블 출력 조회 완료!!");

        }catch(SQLException e){
            System.out.println("회의록 목록 조회 중 예외 발생: "+ e.getMessage());
        }

    }

}
