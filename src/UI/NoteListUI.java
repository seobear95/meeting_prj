package UI;

import DAO.NoteDAO;
import DB.DBUtil;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.util.List;

public class NoteListUI extends JFrame {

    public NoteListUI() {
        setTitle("📄 회의록 목록");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        try {
            List<String> notes = NoteDAO.getAllNotes();
            for (String note : notes) {
                textArea.append(note + "\n");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "불러오기 오류: " + e.getMessage());
        }

        setVisible(true);
    }
}
