package GUI;

import User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrameUser extends Container {
    public static Integer userID = null;
    public static User user;
    public FrameUser() {

        setSize(500, 500);
        setLayout(null);

        JLabel userMenuLabel = new JLabel("USER MENU");
        userMenuLabel.setBounds(190, 0, 500, 75);
        userMenuLabel.setFont(new Font("Georgia", Font.BOLD, 20));
        add(userMenuLabel);

        JButton accountInfo = new JButton("VIEW ACCOUNT INFO");
        accountInfo.setBounds(50, 75, 400, 50);
        add(accountInfo);
        accountInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain.frameUser.setVisible(false);
                FrameMain.frameUserInfo.setVisible(true);
            }
        });

        JButton editAccount = new JButton("EDIT ACCOUNT");
        editAccount.setBounds(50, 130, 400, 50);
        add(editAccount);
        editAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain.frameUser.setVisible(false);
                FrameMain.frameUserEditAccount.setVisible(true);
            }
        });

        JButton addMoney = new JButton("ADD MONEY");
        addMoney.setBounds(50, 185, 400, 50);
        add(addMoney);
        addMoney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain.frameUser.setVisible(false);
                FrameMain.frameUserAddMoney.setVisible(true);
            }
        });

        JButton viewEstates = new JButton("VIEW ESTATES");
        viewEstates.setBounds(50, 240, 200, 50);
        add(viewEstates);
        viewEstates.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain.frameUser.setVisible(false);
                FrameMain.frameUserViewEstates.setVisible(true);
            }
        });

        JButton viewMyEstates = new JButton("VIEW MY ESTATES");
        viewMyEstates.setBounds(250, 240, 200, 50);
        add(viewMyEstates);
        viewMyEstates.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain.frameUser.setVisible(false);
                FrameMain.frameUserMyViewEstates.setVisible(true);
            }
        });

        JButton addEstate = new JButton("ADD ESTATE");
        addEstate.setBounds(50, 295, 200, 50);
        add(addEstate);
        addEstate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain.frameUser.setVisible(false);
                FrameMain.frameUserAddEstate.setVisible(true);
            }
        });

        JButton editEstate = new JButton("EDIT ESTATE");
        editEstate.setBounds(250, 295, 200, 50);
        add(editEstate);
        editEstate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain.frameUser.setVisible(false);
                FrameMain.frameUserEditEstate.setVisible(true);
            }
        });

        JButton viewFavourite = new JButton("VIEW FAVOURITES");
        viewFavourite.setBounds(50, 350, 400, 50);
        add(viewFavourite);
        viewFavourite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain.frameUser.setVisible(false);
                FrameMain.frameUserViewFavourites.setVisible(true);
            }
        });

        JButton exit = new JButton("EXIT");
        exit.setBounds(50, 405, 400, 50);
        add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain.frameUser.setVisible(false);
                FrameMain.frameDefault.setVisible(true  );
            }
        });
    }
}
