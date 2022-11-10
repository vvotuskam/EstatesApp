package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import User.UserManager;

public class FrameUserInfo extends Container {

    public FrameUserInfo() {
        setSize(500, 500);
        setLayout(null);

        JLabel userInfoLabel = new JLabel("USER INFO");
        userInfoLabel.setFont(new Font("Georgia", Font.BOLD, 20));
        userInfoLabel.setBounds(190, 0, 500, 75);
        add(userInfoLabel);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(50, 75, 400, 200);
        textArea.setEnabled(false);
        add(textArea);

        JButton showButton = new JButton("SHOW");
        showButton.setBounds(50, 300, 200, 50);
        add(showButton);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(250, 300, 200, 50);
        add(backButton);

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = FrameUser.user.toString();
                textArea.setText(str);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                FrameMain.frameUserInfo.setVisible(false);
                FrameMain.frameUser.setVisible(true);
            }
        });
    }
}
