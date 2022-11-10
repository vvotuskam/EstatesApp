package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Main.*;
import User.*;


public class FrameUserAddMoney extends Container {

    public FrameUserAddMoney() {
        setSize(500, 500);
        setLayout(null);

        JLabel userInfoLabel = new JLabel("ADD MONEY");
        userInfoLabel.setFont(new Font("Georgia", Font.BOLD, 20));
        userInfoLabel.setBounds(190, 0, 500, 75);
        add(userInfoLabel);

        JTextField currentBalanceField = new JTextField();
        currentBalanceField.setBounds(50, 100, 200, 50);
        currentBalanceField.setEnabled(false);
        add(currentBalanceField);

        JButton viewBalanceButton = new JButton("VIEW BALANCE");
        viewBalanceButton.setBounds(250, 100, 200, 50);
        viewBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String money = String.valueOf(FrameUser.user.getMoney());
                currentBalanceField.setText("  " + money + " TENGE");
            }
        });
        add(viewBalanceButton);

        JTextField addMoneyField = new JTextField();
        addMoneyField.setBounds(50, 180, 200, 50);
        add(addMoneyField);

        JButton addMoneyButton = new JButton("ADD MONEY");
        addMoneyButton.setBounds(250, 180, 200, 50);
        addMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String moneyString = addMoneyField.getText();
                int money = 0;
                boolean notNumber = false;

                try {
                    money = Integer.parseInt(moneyString);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(null, "NOT NUMBER", "ERROR",JOptionPane.PLAIN_MESSAGE);
                    notNumber = true;
                }

                if (!notNumber && money < 100) {
                    JOptionPane.showMessageDialog(null, "INSERT AT LEAST 100 TENGE", "ERROR",JOptionPane.PLAIN_MESSAGE);
                }

                else {
                    UserManager userManager = new UserManager(UserManager.ADD_MONEY, FrameUser.user, money);
                    Main.connect(userManager);
                    FrameUser.user.setMoney(FrameUser.user.getMoney() + money);
                }
                addMoneyField.setText("");
            }
        });
        add(addMoneyButton);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(50, 300, 400, 50);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain.frameUserAddMoney.setVisible(false);
                FrameMain.frameUser.setVisible(true);
            }
        });
    }
}
