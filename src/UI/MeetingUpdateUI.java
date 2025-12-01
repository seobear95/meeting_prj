package UI;

import DAO.MeetingDAO;
import DB.DBUtil;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class MeetingUpdateUI extends JFrame {

    public MeetingUpdateUI() {
        setTitle("✏ 회의 수정");
        setSize(300, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField idField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField dateField = new JTextField();  // 형식: YYYY-MM-DD
        JTextField locationField = new JTextField();

        JButton updateBtn = new JButton("수정");

        // 컴포넌트 추가
        panel.add(new JLabel("수정할 회의 ID:"));
        panel.add(idField);

        panel.add(new JLabel("새 제목:"));
        panel.add(titleField);

        panel.add(new JLabel("새 날짜 (yyyy-mm-dd):"));
        panel.add(dateField);

        panel.add(new JLabel("새 장소:"));
        panel.add(locationField);

        panel.add(new JLabel());  // 빈 공간
        panel.add(updateBtn);

        add(panel);
        setVisible(true);

        // ✅ 이벤트 핸들링
        updateBtn.addActionListener(e -> {
            try (Connection conn = DBUtil.getConnection()) {
                int id = Integer.parseInt(idField.getText());
                String title = titleField.getText();
                String date = dateField.getText();
                String location = locationField.getText();

                MeetingDAO.updateMeeting(conn,title,date,location,id);
                JOptionPane.showMessageDialog(this, "수정 완료!");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "수정 중 오류 발생: " + ex.getMessage());
            }
        });
    }
}