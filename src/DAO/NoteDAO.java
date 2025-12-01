package DAO;

import DB.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteDAO {

    // 1. 회의록 추가
    public static void insertNote( int meetingId, String content, int createdBy) {

        Connection con = null;
        String sql = "INSERT INTO notes(meeting_id, content, created_by) VALUES (?, ?, ?)";
        try {
            con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, meetingId);
            pst.setString(2, content);
            pst.setInt(3, createdBy);
            pst.executeUpdate();
            System.out.println("회의록 등록 완료!");
        } catch (SQLException e) {
            System.out.println("회의록 등록 오류: " + e.getMessage());
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 2. 회의록 조회
    public static void listNotesByMeeting(Connection con, int meetingId) {
        String sql = "SELECT * FROM notes WHERE meeting_id = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, meetingId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println("📝 회의록 ID: " + rs.getInt("id"));
                System.out.println("내용: " + rs.getString("content"));
                System.out.println("작성자 ID: " + rs.getInt("created_by"));
                System.out.println("작성일: " + rs.getTimestamp("created_at"));
                System.out.println("====================================");
            }
        } catch (SQLException e) {
            System.out.println("조회 중 오류 발생: " + e.getMessage());
        }
    }

    // 3. 회의록 수정
    public static void updateNote(Connection con, int noteId, String newContent) {
        String sql = "UPDATE notes SET content = ? WHERE id = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, newContent);
            pst.setInt(2, noteId);
            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("회의록 수정 완료!");
            } else {
                System.out.println("해당 ID의 회의록이 없습니다.");
            }
        } catch (SQLException e) {
            System.out.println("수정 중 오류: " + e.getMessage());
        }
    }

    // 4. 회의록 삭제
    public static void deleteNote(Connection con, int noteId) {
        String sql = "DELETE FROM notes WHERE id = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, noteId);
            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("회의록 삭제 완료!");
            } else {
                System.out.println("해당 ID의 회의록이 없습니다.");
            }
        } catch (SQLException e) {
            System.out.println("삭제 중 오류: " + e.getMessage());
        }
    }

    public static List<String> getAllNotes() {
        String sql = "SELECT * FROM notes";
        List<String> result = new ArrayList<>();
        Connection con = null;

        try {
            con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int meeting_id = rs.getInt("meeting_id"); // 오타 수정
                String content = rs.getString("content");
                int created_by = rs.getInt("created_by");
                String created_at = rs.getTimestamp("created_at").toString();

                String row = String.format("[%d] 회의ID: %d | 작성자: %d | 내용: %s | 날짜: %s",
                        id, meeting_id, created_by, content, created_at);

                result.add(row);
            }

        } catch (SQLException e) {
            throw new RuntimeException("회의록 조회 실패: " + e.getMessage(), e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                throw new RuntimeException("연결 종료 실패: " + e.getMessage(), e);
            }
        }

        return result;
    }

}
