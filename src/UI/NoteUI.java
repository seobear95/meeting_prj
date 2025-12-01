package UI;

import javax.swing.*;
import java.awt.*;

public class NoteUI  extends JFrame {

    public NoteUI() {
        setTitle("회의록 작성");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // 닫아도 프로그램 종료되지 않음

        JPanel panel = new JPanel(new GridLayout(4, 2));
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
        panel.add(submitBtn);

        add(panel);
        setVisible(true);

        // 등록 버튼 기능 (예시용, DB 연동은 이후 추가 가능)
        submitBtn.addActionListener(e -> {
            String mid = meetingIdField.getText();
            String cid = memberIdField.getText();
            String content = contentArea.getText();
            JOptionPane.showMessageDialog(this,
                    "회의 ID: " + mid + "\n작성자: " + cid + "\n내용: " + content,
                    "등록됨", JOptionPane.INFORMATION_MESSAGE);
        });
    }
}