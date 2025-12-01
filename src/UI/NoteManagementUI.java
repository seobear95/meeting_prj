package UI;

import javax.swing.*;
import java.awt.*;

public class NoteManagementUI extends JFrame {

    public NoteManagementUI() {
        setTitle("📋 회의록 관리");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));

        JButton addBtn = new JButton("회의록 작성");
        JButton listBtn = new JButton("회의록 목록 보기");
        JButton updateBtn = new JButton("회의록 수정");
        JButton deleteBtn = new JButton("회의록 삭제");

        panel.add(addBtn);
        panel.add(listBtn);
        panel.add(updateBtn);
        panel.add(deleteBtn);

        add(panel);
        setVisible(true);

        // 버튼 이벤트 핸들링
        addBtn.addActionListener(e -> new NoteAddUI());
        listBtn.addActionListener(e -> new NoteListUI());
        //updateBtn.addActionListener(e -> new NoteUpdateUI());
       // deleteBtn.addActionListener(e -> new NoteDeleteUI());
    }
}
