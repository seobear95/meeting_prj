package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MeetingUI extends JFrame {

    private JFrame currentOpenFrame = null;  // 현재 열려있는 서브 창

    public MeetingUI() {
        setTitle("회의 정보 관리");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));

        JButton insertBtn = new JButton("회의 추가");
        JButton viewBtn = new JButton("회의 목록 보기");
        JButton deleteBtn = new JButton("회의 삭제");
        JButton updateBtn = new JButton("회의 수정");
        JButton noteBtn = new JButton("회의록 작성");  // ✅ 추가 버튼
        JButton noteManageBtn = new JButton("회의록 관리");

        // ➕ 사용자 관련 버튼
        JButton manageUserBtn = new JButton("사용자 관리");

        // 📝 회의록 관련 버튼
        JButton viewNoteBtn = new JButton("회의록 목록 보기");

        panel.add(insertBtn);
        panel.add(viewBtn);
        panel.add(deleteBtn);
        panel.add(updateBtn);
        panel.add(noteBtn);

        panel.add(manageUserBtn);   // 추가
        panel.add(viewNoteBtn);     // 추가

        panel.add(noteManageBtn);

        add(panel);
        setVisible(true);


        //회의 추가 버튼 클릭 시 MeetingInsertUI 열기
        insertBtn.addActionListener(e -> new MeetingInsertUI());
        //회의 삭제 버튼 클릭시
        deleteBtn.addActionListener(e -> new MeetingDeleteUI());
        //회의 수정 버튼 클릭 시 MeetingUpdateUi 열기
        updateBtn.addActionListener(e -> new MeetingUpdateUI());
        //회의록 목록 보기 클릭시
        viewBtn.addActionListener(e -> {
            closeCurrentFrame();
            currentOpenFrame = new MeetingListUI();

        });

        noteManageBtn.addActionListener(e -> {
            new NoteManagementUI();
        });

        // 회의록 작성 버튼 클릭 시 NoteUI 열기
        noteBtn.addActionListener(e -> new NoteAddUI());

        manageUserBtn.addActionListener(e -> new UserManagementUI());   // 사용자 관리 창
        viewNoteBtn.addActionListener(e -> new NoteListUI());           // 회의록 보기 창

    }

    // 🔒 이전 창 닫기 함수
    private void closeCurrentFrame() {
        if (currentOpenFrame != null) {
            currentOpenFrame.dispose();
            currentOpenFrame = null;
        }
    }


}
