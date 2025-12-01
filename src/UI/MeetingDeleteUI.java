package UI;

import DAO.MeetingDAO;
import DB.DBUtil;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class MeetingDeleteUI extends JFrame {

    public MeetingDeleteUI() {
        setTitle("🗑 회의 삭제");               // 창 제목
        setSize(250, 150);                    // 창 크기 (너비 x 높이)
        setLocationRelativeTo(null);         // 화면 가운데 정렬
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 창 닫으면 메모리에서 제거만 (프로그램 전체 종료는 안 함)

        // 🔷 입력 필드와 버튼을 배치할 패널
        JPanel panel = new JPanel(new GridLayout(2, 2));

        JTextField idField = new JTextField();         // 회의 ID 입력 칸
        JButton deleteBtn = new JButton("삭제");       // 삭제 버튼

        // 🔷 레이아웃 구성
        panel.add(new JLabel("삭제할 회의 ID:")); // 텍스트 라벨
        panel.add(idField);                       // 입력창
        panel.add(new JLabel());                  // 빈 공간
        panel.add(deleteBtn);                     // 삭제 버튼

        add(panel);  // 패널을 창에 붙이기
        setVisible(true);  // 창 보이게

        // ✅ 버튼 클릭 시 실행할 동작 (이벤트 핸들링)
        deleteBtn.addActionListener(e -> {
            try (Connection conn = DBUtil.getConnection()) {
                int id = Integer.parseInt(idField.getText());  // 사용자가 입력한 ID
                MeetingDAO.deleteMeeting(id);            // DB에서 삭제 시도
                JOptionPane.showMessageDialog(this, "삭제 완료!");  // 알림창
                dispose(); // 창 닫기
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "삭제 오류: " + ex.getMessage()); // 예외 메시지 표시
            }
        });
    }
}
