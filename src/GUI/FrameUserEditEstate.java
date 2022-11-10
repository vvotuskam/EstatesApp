package GUI;

import Estates.Estate;
import Estates.Flat;
import Main.Main;
import User.UserManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrameUserEditEstate extends Container {

    public static final int LOCATION = 0;
    public static final int PRICE = 1;
    public static final int AREA = 2;
    public static final int YEAR = 3;
    public static final int IN_PLEDGE = 4;
    public static final int PURPOSE = 5;
    public static ArrayList<Estate> userEstates;
    UserManager userManager;
    private ArrayList<JComponent> components = new ArrayList<>();

    public FrameUserEditEstate() {
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("EDIT");
        label.setFont(new Font("Georgia", Font.BOLD, 20));
        label.setBounds(190, 0, 500, 75);
        add(label);

        JComboBox myEstatesBox = new JComboBox();
        myEstatesBox.setBounds(125, 100, 325, 25);
        add(myEstatesBox);

        JButton showButton = new JButton("SHOW");
        showButton.setBounds(50, 100, 75, 25);
        add(showButton);

        //1
        JLabel locationLabel = new JLabel("Location");
        locationLabel.setBounds(50, 150, 200, 30);
        add(locationLabel);

        JTextField locationField = new JTextField();
        locationField.setBounds(250, 150, 200, 30);
        add(locationField);
        components.add(locationField);

        //2
        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(50, 180, 200, 30);
        add(priceLabel);

        JTextField priceField = new JTextField();
        priceField.setBounds(250, 180, 200, 30);
        add(priceField);
        components.add(priceField);

        //3
        JLabel areaLabel = new JLabel("Area");
        areaLabel.setBounds(50, 210, 200, 30);
        add(areaLabel);

        JTextField areaField = new JTextField();
        areaField.setBounds(250, 210, 200, 30);
        add(areaField);
        components.add(areaField);

        //4
        JLabel yearLabel = new JLabel("Year");
        yearLabel.setBounds(50, 240, 200, 30);
        add(yearLabel);

        JTextField yearField = new JTextField();
        yearField.setBounds(250, 240, 200, 30);
        add(yearField);
        components.add(yearField);

        //5
        JLabel inPledgeLabel = new JLabel("In pledge");
        inPledgeLabel.setBounds(50, 270, 200, 30);
        add(inPledgeLabel);

        String[] inPledges = {"Not in pledge", "In pledge"};
        JComboBox inPledgeBox = new JComboBox<>(inPledges);
        inPledgeBox.setBounds(250, 270, 200, 30);
        add(inPledgeBox);
        components.add(inPledgeBox);

        //6
        JLabel purposeLabel = new JLabel("Purpose");
        purposeLabel.setBounds(50, 300, 200, 30);
        add(purposeLabel);

        String[] purpose = {"For Sale", "For Rent"};
        JComboBox purposeBox = new JComboBox<>(purpose);
        purposeBox.setBounds(250, 300, 200, 30);
        add(purposeBox);
        components.add(purposeBox);

        JButton editButton = new JButton("EDIT");
        editButton.setBounds(50, 400, 200, 50);
        add(editButton);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(240, 400, 200, 50);
        add(backButton);backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain.frameUser.setVisible(true);
                FrameMain.frameUserEditEstate.setVisible(false);
            }
        });

        myEstatesBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (userEstates.size() != 0){
                        String s = (String) myEstatesBox.getSelectedItem();
                        if (s != null) {
                            String idStr = s.split(" ")[0].substring(0, s.split(" ")[0].length() - 1);

                            int positionID = Integer.parseInt(idStr) - 1;

                            locationField.setText(userEstates.get(positionID).getLocation());
                            areaField.setText(String.valueOf(userEstates.get(positionID).getArea()));
                            yearField.setText(String.valueOf(userEstates.get(positionID).getYear()));
                            priceField.setText(String.valueOf(userEstates.get(positionID).getPrice()));
                            String purpose = userEstates.get(positionID).getPurpose();
                            if (purpose.equals("For Sale"))
                                purposeBox.setSelectedIndex(0);
                            else
                                purposeBox.setSelectedIndex(1);
                            boolean inPledge = userEstates.get(positionID).isInPledge();
                            if (inPledge)
                                inPledgeBox.setSelectedIndex(1);
                            else
                                inPledgeBox.setSelectedIndex(0);
                        }
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userManager = new UserManager(UserManager.VIEW_USER_ESTATES, FrameUser.user);
                Main.connect(userManager);
                myEstatesBox.removeAllItems();
                if (userEstates.size() == 0)
                    JOptionPane.showMessageDialog(null,
                            "You have no estates", "Error", JOptionPane.PLAIN_MESSAGE);
                else
                    addItems(myEstatesBox, userEstates);
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String location = locationField.getText();
                    int price = Integer.parseInt(priceField.getText());
                    int year = Integer.parseInt(yearField.getText());
                    double area = Double.parseDouble(areaField.getText());
                    boolean inPledge;
                    if (inPledgeBox.getSelectedItem().equals(inPledges[0]))
                        inPledge = false;
                    else
                        inPledge = true;
                    String purpose = (String) purposeBox.getSelectedItem();
                    if (userEstates.size() != 0){
                        String s = (String) myEstatesBox.getSelectedItem();
                        String idStr = s.split(" ")[0].substring(0, s.split(" ")[0].length() - 1);
                        int positionID = Integer.parseInt(idStr) - 1;

                        userEstates.get(positionID).setLocation(location);
                        userEstates.get(positionID).setArea(area);
                        userEstates.get(positionID).setPrice(price);
                        userEstates.get(positionID).setInPledge(inPledge);
                        userEstates.get(positionID).setYear(year);
                        userEstates.get(positionID).setPurpose(purpose);

                        System.out.println(userEstates.get(positionID).toString());

                        userManager = new UserManager(UserManager.EDIT_ESTATE, FrameUser.user, userEstates.get(positionID));
                        Main.connect(userManager);
                        myEstatesBox.removeAllItems();
                        clearComponents(components);
                    }
                }
                catch (Exception exception) {
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
    private void clearComponents(ArrayList<JComponent> components) {
        for (JComponent component : components) {
            if (component instanceof JTextField)
                ((JTextField) component).setText("");
            if (component instanceof JComboBox<?>)
                ((JComboBox<?>) component).setSelectedIndex(0);
        }
    }

}
