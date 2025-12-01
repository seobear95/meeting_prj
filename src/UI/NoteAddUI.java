package UI;
import DAO.NoteDAO;
import DB.DBUtil;
import javax.swing.*;
import java.awt.*;

public class NoteAddUI  extends JFrame {

    public NoteAddUI() {
        setTitle("📝 회의록 작성");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // 창만 닫힘

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        JTextField meetingIdField = new JTextField();
        JTextField memberIdField = new JTextField();
        JTextArea contentArea = new JTextArea(5, 20);
        JButton submitBtn = new JButton("등록");

        panel.add(new JLabel("회의 ID:"));
        panel.add(meetingIdField);
        panel.add(new JLabel("작성자 ID:"));
        panel.add(memberIdField);
        panel.add(new JLabel("내용:"));
        panel.add(new JScrollPane(contentArea));
        panel.add(new JLabel());
        panel.add(submitBtn);

        add(panel);
        setVisible(true);

        // 실제 등록 기능
        submitBtn.addActionListener(e -> {
            try {
                int meetingId = Integer.parseInt(meetingIdField.getText());
                int memberId = Integer.parseInt(memberIdField.getText());
                String content = contentArea.getText();

                NoteDAO.insertNote(meetingId,content,memberId);

                JOptionPane.showMessageDialog(this, "회의록 등록 완료!");
                dispose(); // 창 닫기
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "오류: " + ex.getMessage());
            }
        });
    }
}