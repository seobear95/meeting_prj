package UI;

import DAO.MembersDAO;
import DB.DBUtil;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class UserManagementUI extends JFrame {

    public UserManagementUI() {
        setTitle("👤 사용자 관리");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));

        JButton viewBtn = new JButton("사용자 목록 보기");
        JButton addBtn = new JButton("사용자 추가");
        JButton updateBtn = new JButton("사용자 수정");
        JButton deleteBtn = new JButton("사용자 삭제");

        panel.add(viewBtn);
        panel.add(addBtn);
        panel.add(updateBtn);
        panel.add(deleteBtn);

        add(panel);
        setVisible(true);

        viewBtn.addActionListener(e -> MembersDAO.viewAllMembers());
        addBtn.addActionListener(e -> {
            try (Connection conn = DBUtil.getConnection()) {
                String name = JOptionPane.showInputDialog("이름 입력:");
                String dept = JOptionPane.showInputDialog("학과 입력:");
                String email = JOptionPane.showInputDialog("이메일 입력:");
                MembersDAO.insertMember(conn, name, dept, email);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "추가 오류: " + ex.getMessage());
            }
        });

        updateBtn.addActionListener(e -> {
            try (Connection conn = DBUtil.getConnection()) {
                int id = Integer.parseInt(JOptionPane.showInputDialog("수정할 ID 입력:"));
                String name = JOptionPane.showInputDialog("새 이름:");
                String dept = JOptionPane.showInputDialog("새 학과:");
                String email = JOptionPane.showInputDialog("새 이메일:");
                MembersDAO.updateMember(conn, id, name, dept, email);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "수정 오류: " + ex.getMessage());
            }
        });

        deleteBtn.addActionListener(e -> {
            try (Connection conn = DBUtil.getConnection()) {
                int id = Integer.parseInt(JOptionPane.showInputDialog("삭제할 ID 입력:"));
                MembersDAO.deleteMember(conn, id);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "삭제 오류: " + ex.getMessage());
            }
        });
    }
}
