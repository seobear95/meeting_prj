package UI;
import javax.swing.*;
import java.awt.*;

public class MeetingUI extends JFrame {

    public MeetingUI() {
        setTitle("회의 정보 관리");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 1));

        JButton insertBtn = new JButton("회의 추가");
        JButton viewBtn = new JButton("회의 목록 보기");
        JButton deleteBtn = new JButton("회의 삭제");
        JButton updateBtn = new JButton("회의 수정");
        JButton noteBtn = new JButton("회의록 작성");  // ✅ 추가 버튼

        panel.add(insertBtn);
        panel.add(viewBtn);
        panel.add(deleteBtn);
        panel.add(updateBtn);
        panel.add(noteBtn);

        add(panel);
        setVisible(true);

        // ✅ 회의록 작성 버튼 클릭 시 NoteUI 열기
        noteBtn.addActionListener(e -> new NoteUI());
    }


}
