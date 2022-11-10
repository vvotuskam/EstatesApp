package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import User.*;
import Main.*;

public class FrameUserEditAccount extends Container {

    //private final DBManager dbManager = new DBManager();

    private final int NAME = 0;
    private final int SURNAME = 1;
    private final int EMAIL = 2;
    private final int PHONE = 3;
    private final int PASSWORD = 4;

    public FrameUserEditAccount() {
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("EDIT");
        label.setFont(new Font("Georgia", Font.BOLD, 20));
        label.setBounds(190, 0, 500, 75);
        add(label);

        String[] characteristics = {"Name", "Surname", "Email", "Phone", "Password"};
        JComboBox changeBox = new JComboBox(characteristics);
        changeBox.setBounds(250, 150, 200, 50);
        add(changeBox);

        JTextField changeField = new JTextField();
        changeField.setBounds(50, 150, 200, 50);
        add(changeField);

        JButton changeButton = new JButton("CHANGE");
        changeButton.setBounds(50, 200, 200, 50);
        add(changeButton);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(250, 200, 200, 50);
        add(backButton);

        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selected = (String) changeBox.getSelectedItem();
                String newCharacteristics = changeField.getText();
                boolean operationCompleted = false;

                if (selected.equals(characteristics[0]) && checkField(newCharacteristics, NAME)) {
                    FrameUser.user.setName(newCharacteristics);
                    operationCompleted = true;
                }
                else if (selected.equals(characteristics[1]) && checkField(newCharacteristics, SURNAME)) {
                    FrameUser.user.setSurname(newCharacteristics);
                    operationCompleted = true;
                }
                else if (selected.equals(characteristics[2]) && checkField(newCharacteristics, EMAIL)) {
                    FrameUser.user.setEmail(newCharacteristics);
                    operationCompleted = true;
                }
                else if (selected.equals(characteristics[3]) && checkField(newCharacteristics, PHONE)) {
                    FrameUser.user.setPhone(newCharacteristics);
                    operationCompleted = true;
                }
                else if (selected.equals(characteristics[4]) && checkField(newCharacteristics, PASSWORD)) {
                    FrameUser.user.setPassword(newCharacteristics);
                    operationCompleted = true;
                }

                if (operationCompleted){
                    UserManager userManager = new UserManager(UserManager.EDIT_USER, FrameUser.user);
                    Main.connect(userManager);
                    successMessage();
                    changeField.setText("");
                    changeBox.setSelectedIndex(0);
                }
                else
                    errorMessage();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain.frameUser.setVisible(true);
                FrameMain.frameUserEditAccount.setVisible(false);
            }
        });
    }
    private boolean checkField(String str, int field) {
        boolean isOk = true;
        if (field == 0 || field == 1) {
            for (int i = 0; i < str.length(); i++) {
                boolean lowerCase = (str.charAt(i) >= 'a' && str.charAt(i) <= 'z');
                boolean upperCase = (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z');
                if (!lowerCase && !upperCase) {
                    return false;
                }
            }
            return true;
        }
        if (field == 2)
            return true;
        if (field == 3) {
            return User.suitablePhone(str);
        }
        if (field == 4) {
            return User.suitablePassword(str);
        }
        return false;
    }

    private void successMessage() {
        JOptionPane.showMessageDialog(null, "Success", "Success", JOptionPane.PLAIN_MESSAGE);
    }
    private void errorMessage() {
        JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.PLAIN_MESSAGE);
    }
}
