package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameDefault extends Container {
    public FrameDefault() {
        setSize(500, 500);
        setLayout(null);

        JLabel helloLabel = new JLabel("HELLO, USER");
        helloLabel.setFont(new Font("Georgia", Font.BOLD, 20));
        helloLabel.setBounds(180, 0, 500, 100);
        add(helloLabel);

        JButton signInButton = new JButton("SIGN UP");
        signInButton.setBounds(50, 100, 400, 50);
        add(signInButton);

        JButton logInButton = new JButton("LOG IN");
        logInButton.setBounds(50, 170, 400, 50);
        add(logInButton);

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(50, 240, 400, 50);
        add(exitButton);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain.frameSignUp.setVisible(true);
                FrameMain.frameDefault.setVisible(false);
            }
        });

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain.frameLogIn.setVisible(true);
                FrameMain.frameDefault.setVisible(false);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
