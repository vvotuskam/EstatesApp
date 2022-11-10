package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import Estates.Estate;
import Main.Main;
import User.UserManager;

public class FrameUserViewFavourites extends Container {
    public static ArrayList<Estate> favourites = new ArrayList<>();
    public FrameUserViewFavourites() {
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("FAVOURITES");
        label.setFont(new Font("Georgia", Font.BOLD, 20));
        label.setBounds(190, 0, 500, 75);
        add(label);

        JComboBox favouriteBox = new JComboBox();
        favouriteBox.setBounds(50, 100, 400, 50);
        add(favouriteBox);

        JTextArea favouriteInfoArea = new JTextArea();
        favouriteInfoArea.setBounds(50, 150, 400, 250);
        favouriteInfoArea.setEnabled(false);
        add(favouriteInfoArea);

        JButton showFavouriteButton = new JButton("SHOW");
        showFavouriteButton.setBounds(50, 400, 133, 50);
        add(showFavouriteButton);

        JButton deleteFavouriteButton = new JButton("DELETE");
        deleteFavouriteButton.setBounds(183, 400, 134, 50);
        add(deleteFavouriteButton);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(317, 400, 133, 50);
        add(backButton);

        showFavouriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    favouriteBox.removeAllItems();
                    UserManager userManager = new UserManager(UserManager.VIEW_USER_FAVOURITES, FrameUser.user);
                    Main.connect(userManager);
                    addItems(favouriteBox, favourites);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        favouriteBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (favourites.size() != 0){
                        String s = (String) favouriteBox.getSelectedItem();
                        if (s != null) {
                            String idStr = s.split(" ")[0].substring(0, s.split(" ")[0].length() - 1);
                            int estateId = Integer.parseInt(idStr) - 1;
                            favouriteInfoArea.setText(favourites.get(estateId).toString());
                        }
                    }
                }
                catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain.frameUserViewFavourites.setVisible(false);
                FrameMain.frameUser.setVisible(true);
                favouriteBox.removeAllItems();
                favouriteInfoArea.setText("");
            }
        });

        deleteFavouriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (favourites.size() != 0){
                        String s = (String) favouriteBox.getSelectedItem();
                        if (s != null) {
                            String idStr = s.split(" ")[0].substring(0, s.split(" ")[0].length() - 1);
                            int positionID = Integer.parseInt(idStr) - 1;
                            UserManager userManager1 = new UserManager(UserManager.DELETE_FAVOURITE, FrameUser.user, favourites.get(positionID));
                            Main.connect(userManager1);
                            JOptionPane.showMessageDialog(null, "Deleted", "Success", JOptionPane.PLAIN_MESSAGE);
                            favouriteInfoArea.setText("");
                            favouriteBox.removeAllItems();
                        }
                    }
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
    }
    private void addItems(JComboBox box, ArrayList<Estate> estates) {
        int id = 1;
        for (Estate estate : estates) {
            box.addItem(id++ + ") " + estate.estateInfoShort());
        }
    }
}
