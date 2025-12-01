package MAIN;

import javax.swing.*;

public class MySwingApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("입력 예제");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //창 닫으면 전체 종료
        // JFrame.DISPOSE_ON_CLOSE
        // 이 창만 닫고 다른 창은 유지
        // JFrame.HIDE_ON_CLOSE
        // 닫는 대신 숨기기만 함.
        JPanel panel = new JPanel();
        JLabel label = new JLabel("이름:");
        JTextField textField = new JTextField(15);
        JButton button = new JButton("출력");

        // 버튼 클릭 시 이벤트
        button.addActionListener(e -> {
            String name = textField.getText();
            JOptionPane.showMessageDialog(frame, "안녕하세요, " + name + "님!");
        });

        panel.add(label);
        panel.add(textField);
        panel.add(button);
        frame.add(panel);
        frame.setVisible(true);
    }
}
