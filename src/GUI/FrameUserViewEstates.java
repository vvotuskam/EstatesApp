package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Estates.*;
import User.UserManager;
import Main.*;

public class FrameUserViewEstates extends Container {

    public final static int NO_FILTER = 0;
    public final static int TYPE_FILTER = 1;
    public final static int PRICE_FILTER = 2;
    public final static int LOCATION_FILTER = 3;
    public final static int AREA_FILTER = 4;
    public final static int YEAR_FILTER = 5;
    public final static int PURPOSE_FILTER = 6;

    public final static String[] filters = {"None", "Price", "Location", "Area", "Year", "Purpose"};
    public final static String[] estatesTypes = {"None", "Flat", "House", "Area", "Room", "Office", "Building", "Shop", "Premise", "Base"};

    private ArrayList<JComponent> components = new ArrayList<>();
    public static ArrayList<Estate> estates;

    public FrameUserViewEstates() {
        setSize(500, 500);
        setLayout(null);
        System.out.println("WORKS");
        JLabel label = new JLabel("VIEW ESTATES");
        label.setFont(new Font("Georgia", Font.BOLD, 20));
        label.setBounds(190, 0, 500, 75);
        add(label);

        JLabel selectFilterLabel = new JLabel("SELECT FILTER");
        selectFilterLabel.setBounds(50, 100, 200, 30);
        add(selectFilterLabel);

        JComboBox filterBox = new JComboBox(filters);
        filterBox.setBounds(250, 100, 200, 30);
        add(filterBox);

        JLabel estateTypeLabel = new JLabel("SELECT TYPE");
        estateTypeLabel.setBounds(50, 135, 200, 30);
        add(estateTypeLabel);

        JComboBox typeBox = new JComboBox(estatesTypes);
        typeBox.setBounds(250, 135, 200, 30);
        add(typeBox);
        components.add(typeBox);

        JComboBox estateList = new JComboBox();
        estateList.setBounds(50, 170, 400, 50);
        estateList.setVisible(false);
        add(estateList);
        components.add(estateList);

        JTextArea estateInfoArea = new JTextArea();
        estateInfoArea.setBounds(50, 230, 400, 160);
        estateInfoArea.setVisible(false);
        estateInfoArea.setEditable(false);
        add(estateInfoArea);
        components.add(estateInfoArea);

        JButton showButton = new JButton("SHOW");
        showButton.setBounds(50, 400, 133, 50);
        add(showButton);

        JButton addToFavourites = new JButton("FAVOURITE");
        addToFavourites.setBounds(183, 400, 134, 50);
        add(addToFavourites);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(317, 400, 133, 50);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                filterBox.setSelectedIndex(0);
                typeBox.setSelectedIndex(0);

                estateInfoArea.setVisible(false);
                estateList.setVisible(false);

                FrameMain.frameUserViewEstates.setVisible(false);
                FrameMain.frameUser.setVisible(true);
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserManager userManager;
                try {
                    String filterType = (String) filterBox.getSelectedItem();
                    String estateType = (String) typeBox.getSelectedItem();

                    userManager = new UserManager(UserManager.VIEW_ESTATES, FrameUser.user, filterType, estateType);
                    Main.connect(userManager);

                    estateList.removeAllItems();
                    estateInfoArea.setText("");
                    addItems(estateList, estates);
                    estateList.setVisible(true);
                    estateInfoArea.setVisible(true);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        estateList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (estates.size() != 0){
                        String s = (String) estateList.getSelectedItem();
                        if (s != null) {
                            String idStr = s.split(" ")[0].substring(0, s.split(" ")[0].length() - 1);
                            int estateId = Integer.parseInt(idStr) - 1;
                            estateInfoArea.setText(estates.get(estateId).toString());
                        }
                    }
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });

        addToFavourites.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!estateInfoArea.isVisible() || !estateList.isVisible())
                    return;
                try {
                    if (estates.size() != 0){
                        String s = (String) estateList.getSelectedItem();
                        if (s != null) {
                            String idStr = s.split(" ")[0].substring(0, s.split(" ")[0].length() - 1);
                            int estateId = Integer.parseInt(idStr) - 1;
                            UserManager userManager = new UserManager(UserManager.ADD_FAVOURITE, FrameUser.user,
                                    estates.get(estateId));
                            Main.connect(userManager);
                        }
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
    private void setVisibleComponents(boolean flag) {
        for (JComponent component : components) {
            component.setVisible(flag);
        }
    }
    private void clearComponents() {
        for (JComponent component : components) {
            if (component instanceof JComboBox)
                ((JComboBox<?>) component).setSelectedIndex(0);
            if (component instanceof JTextArea)
                component.removeAll();
        }
    }
    private void addItems(JComboBox box, ArrayList<Estate> estates) {
        int id = 1;
        for (Estate estate : estates) {
            box.addItem(id++ + ") " + estate.estateInfoShort());
        }
    }
}
