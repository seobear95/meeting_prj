package DAO;

import DB.DBUtil;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class MembersDAO {

    // ------------------------------------
    // 1) 초기사용자 20명 추가 (Batch Insert)
    // ------------------------------------
    public static void insertDummyMembers() {
        Connection con = null;
        String sql = "INSERT INTO members(name, department, email) VALUES (?, ?, ?)";
        List<String> names = Arrays.asList(
                "김민준", "이서연", "박지훈", "최지우", "정우진",
                "한서준", "유나", "임채영", "배성우", "서윤아",
                "조현우", "강예린", "문성호", "오지후", "신유리",
                "황지민", "윤다은", "장민호", "구하린", "백승호"
        );

        try {
            con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            for (int i = 0; i < names.size(); i++) {

                pst.setString(1, names.get(i));
                pst.setString(2, "컴퓨터소프트웨어학과");
                pst.setString(3, "student" + (i + 1) + "@school.ac.kr");

                pst.addBatch(); // 일괄 등록
            }

            pst.executeBatch();
            System.out.println("✅ 초기 사용자 20명 등록 완료!");

        } catch (SQLException e) {
            System.out.println("❌ 초기 사용자 등록 오류: " + e.getMessage());
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    // ------------------------------------
    // 2) 사용자 추가
    // ------------------------------------
    public static void insertMember(Connection con, String name, String dept, String email) {
        String sql = "INSERT INTO members(name, department, email) VALUES (?, ?, ?)";

        try (PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, name);
            pst.setString(2, dept);
            pst.setString(3, email);

            pst.executeUpdate();
            System.out.println("✅ 사용자 추가 완료!");

        } catch (SQLException e) {
            System.out.println("❌ 사용자 추가 오류: " + e.getMessage());
        }
    }


    // ------------------------------------
    // 3) 사용자 수정 (name, dept, email)
    // ------------------------------------
    public static void updateMember(Connection con, int id, String name, String dept, String email) {
        String sql = "UPDATE members SET name=?, department=?, email=? WHERE id=?";

        try (PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, name);
            pst.setString(2, dept);
            pst.setString(3, email);
            pst.setInt(4, id);

            int result = pst.executeUpdate();

            if (result > 0)
                System.out.println("✏ 사용자 수정 완료!");
            else
                System.out.println("❗ 해당 ID 사용자를 찾을 수 없습니다.");

        } catch (SQLException e) {
            System.out.println("❌ 사용자 수정 오류: " + e.getMessage());
        }
    }


    // ------------------------------------
    // 4) 사용자 삭제
    // ------------------------------------
    public static void deleteMember(Connection con, int id) {

        String sql = "DELETE FROM members WHERE id=?";

        try (PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            int result = pst.executeUpdate();

            if (result > 0)
                System.out.println("🗑 사용자 삭제 완료!");
            else
                System.out.println("❗ 삭제 실패: 해당 사용자 없음");

        } catch (SQLException e) {
            System.out.println("❌ 삭제 오류: " + e.getMessage());
        }
    }


    // ------------------------------------
    // 5) 전체 사용자 목록 출력
    // ------------------------------------
    public static void listAllMembers(Connection con) {

    }

    public static void viewAllMembers() {
    }
}
