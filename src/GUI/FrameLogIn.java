package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Main.*;
import User.*;

public class FrameLogIn  extends Container {
    public static User user;
    public FrameLogIn() {
        setSize(500, 500);
        setLayout(null);

        JLabel logIn = new JLabel("LOG IN");
        logIn.setBounds(210, 50, 500, 100);
        logIn.setFont(new Font("Georgia", Font.BOLD, 20));
        add(logIn);

        JLabel emailLabel = new JLabel("EMAIL:");
        emailLabel.setBounds(50, 150, 200, 50);
        add(emailLabel);

        JTextField emailText = new JTextField();
        emailText.setBounds(250, 150, 200, 50);
        add(emailText);

        JLabel passwordLabel = new JLabel("PASSWORD:");
        passwordLabel.setBounds(50, 210, 200, 50);
        add(passwordLabel);

        JTextField passwordText = new JTextField();
        passwordText.setBounds(250, 210, 200, 50);
        add(passwordText);

        JButton signInButton = new JButton("LOG IN");
        signInButton.setBounds(50, 270, 200, 50);
        add(signInButton);

        JButton cancelButton = new JButton("CANCEL");
        cancelButton.setBounds(250, 270, 200, 50);
        add(cancelButton);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailText.getText();
                String password = passwordText.getText();

                UserManager userManager = new UserManager(UserManager.LOG_IN, email, password);
                Main.connect(userManager);

                if (user != null) {
                    FrameUser.userID = user.getId();
                    FrameUser.user = user;
                    emailText.setText("");
                    passwordText.setText("");
                    FrameMain.frameLogIn.setVisible(false);
                    FrameMain.frameUser.setVisible(true);

                }
                else {
                    JOptionPane.showMessageDialog(null, "WRONG EMAIL OR PASSWORD", "ERROR",JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain.frameLogIn.setVisible(false);
                FrameMain.frameDefault.setVisible(true);
            }
        });
    }
}
