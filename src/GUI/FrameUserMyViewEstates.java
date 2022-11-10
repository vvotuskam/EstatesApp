package GUI;

import Estates.*;
import User.*;
import Main.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrameUserMyViewEstates extends Container {

    public static ArrayList<Estate> userEstates;
    public String[] userEstatesInfo;
    UserManager userManager;
    public FrameUserMyViewEstates() {

        setSize(500, 500);
        setVisible(true);
        setLayout(null);

        JLabel label = new JLabel("MY ESTATES");
        label.setFont(new Font("Georgia", Font.BOLD, 20));
        label.setBounds(190, 0, 500, 75);
        add(label);

        JComboBox myEstatesBox = new JComboBox();
        myEstatesBox.setBounds(50, 100, 400, 50);
        add(myEstatesBox);

        JTextArea myEstateInfoArea = new JTextArea();
        myEstateInfoArea.setBounds(50, 150, 400, 200);
        myEstateInfoArea.setEnabled(false);
        add(myEstateInfoArea);

        JButton showMyEstateButton = new JButton("SHOW");
        showMyEstateButton.setBounds(50, 400, 133, 50);
        add(showMyEstateButton);

        JButton deleteButton = new JButton("DELETE");
        deleteButton.setBounds(183, 400, 134, 50);
        add(deleteButton);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(317, 400, 133, 50);
        add(backButton);


        myEstatesBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (userEstates.size() != 0) {
                        String s = (String) myEstatesBox.getSelectedItem();
                        String idStr = s.split(" ")[0].substring(0, s.split(" ")[0].length() - 1);
                        int estateId = Integer.parseInt(idStr) - 1;
                        myEstateInfoArea.setText(userEstates.get(estateId).toString());
                    }
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        showMyEstateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userManager = new UserManager(UserManager.VIEW_USER_ESTATES, FrameUser.user);
                Main.connect(userManager);
                myEstatesBox.removeAllItems();
                if (userEstates.size() == 0)
                    JOptionPane.showMessageDialog(null, "You have no estates", "Error", JOptionPane.PLAIN_MESSAGE);
                else
                    addItems(myEstatesBox, userEstates);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (userEstates.size() != 0){
                        String s = (String) myEstatesBox.getSelectedItem();
                        String idStr = s.split(" ")[0].substring(0, s.split(" ")[0].length() - 1);
                        int positionID = Integer.parseInt(idStr) - 1;
                        UserManager userManager1 = new UserManager(UserManager.DELETE_ESTATE, FrameUser.user, userEstates.get(positionID));
                        Main.connect(userManager1);
                        JOptionPane.showMessageDialog(null, "Deleted", "Success", JOptionPane.PLAIN_MESSAGE);
                        myEstateInfoArea.setText("");
                        myEstatesBox.removeAllItems();
                    }
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain.frameUserMyViewEstates.setVisible(false);
                FrameMain.frameUser.setVisible(true);
            }
        });
    }
    private void addItems(JComboBox box, ArrayList<Estate> estates) {
        int id = 1;
        for (Estate estate : estates) {
            if (estate == null)
                continue;
            box.addItem(id++ + ") " + estate.estateInfoShort());
        }
    }

    private Estate getUserEstate(ArrayList<Estate> estates, int estateID) {
        Estate estate = null;
        for (Estate estate1 : estates) {
            if (estate1.getEstateID() == estateID){
                estate = estate1;
                break;
            }
        }
        return estate;
    }
}
