package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import User.*;
import Main.*;

public class FrameSignUp extends Container {
    public FrameSignUp() {
        setSize(500, 500);
        setLayout(null);

        JLabel signUp = new JLabel("SIGN UP");
        signUp.setBounds(210, 0, 500, 100);
        signUp.setFont(new Font("Georgia", Font.BOLD, 20));
        add(signUp);

        JLabel nameLabel = new JLabel("NAME:");
        nameLabel.setBounds(50, 100, 200, 50);
        add(nameLabel);

        JTextField nameText = new JTextField();
        nameText.setBounds(250, 100, 200, 50);
        add(nameText);

        JLabel surnameLabel = new JLabel("SURNAME:");
        surnameLabel.setBounds(50, 150, 200, 50);
        add(surnameLabel);

        JTextField surnameText = new JTextField();
        surnameText.setBounds(250, 150, 200, 50);
        add(surnameText);

        JLabel emailLabel = new JLabel("EMAIL:");
        emailLabel.setBounds(50, 200, 200, 50);
        add(emailLabel);

        JTextField emailText = new JTextField();
        emailText.setBounds(250, 200, 200, 50);
        add(emailText);

        JLabel passwordLabel = new JLabel("PASSWORD:");
        passwordLabel.setBounds(50, 250, 200, 50);
        add(passwordLabel);

        JTextField passwordText = new JTextField();
        passwordText.setBounds(250, 250, 200, 50);
        add(passwordText);

        JLabel phoneLabel = new JLabel("PHONE:");
        phoneLabel.setBounds(50, 300, 200, 50);
        add(phoneLabel);

        JTextField phoneText = new JTextField();
        phoneText.setBounds(250, 300, 200, 50);
        add(phoneText);

        JButton signInButton = new JButton("SIGN UP");
        signInButton.setBounds(50, 350, 200, 50);
        add(signInButton);

        JButton cancelButton = new JButton("CANCEL");
        cancelButton.setBounds(250, 350, 200, 50);
        add(cancelButton);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                String surname = surnameText.getText();
                String email = emailText.getText();
                String password = passwordText.getText();
                String phone = phoneText.getText();

                if (name.isEmpty() || surname.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "EMPTY FIELD", "ERROR",JOptionPane.PLAIN_MESSAGE);
                }

                else if (!User.suitablePassword(password)) {
                    JOptionPane.showMessageDialog(null, "WRONG PASSWORD", "ERROR",JOptionPane.PLAIN_MESSAGE);
                }

                else if (!User.suitablePhone(phone)) {
                    JOptionPane.showMessageDialog(null, "WRONG PHONE NUMBER", "ERROR",JOptionPane.PLAIN_MESSAGE);
                }

                else {
                    User newUser = new User(null, name, surname, password, email, phone, 0);
                    Main.connect(new UserManager(UserManager.ADD_USER, newUser));
                    FrameMain.frameSignUp.setVisible(false);
                    FrameMain.frameDefault.setVisible(true);
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain.frameSignUp.setVisible(false);
                FrameMain.frameDefault.setVisible(true);
            }
        });
    }
}
