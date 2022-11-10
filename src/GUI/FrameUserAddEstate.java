package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Estates.*;
import Main.Main;
import User.UserManager;

public class FrameUserAddEstate extends Container {
    private boolean hotOffer = false;

    private ArrayList<JLabel> labels = new ArrayList<>();
    private ArrayList<JTextField> textFields = new ArrayList<>();
    private ArrayList<JComboBox> comboBoxes = new ArrayList<>();

    private ArrayList<JComponent> mainComponents = new ArrayList<>();

    public FrameUserAddEstate() {
        setSize(500, 500);
        setLayout(null);


        JLabel addEstateLabel = new JLabel("ADD ESTATE");
        addEstateLabel.setFont(new Font("Georgia", Font.BOLD, 20));
        addEstateLabel.setBounds(190, 0, 500, 75);
        add(addEstateLabel);

        JLabel typeLabel = new JLabel("TYPE:");
        typeLabel.setBounds(50, 75, 200, 20);
        add(typeLabel);

        String[] type = {"Flat", "House", "Area", "Room", "Office", "Premise", "Building", "Shop", "Base"};
        JComboBox typeBox = new JComboBox(type);
        typeBox.setBounds(250, 75, 200, 20);
        add(typeBox);

        JButton selectType = new JButton("SELECT");
        selectType.setBounds(150, 95, 200, 20);
        add(selectType);

        JLabel locationLabel = new JLabel("LOCATION:");
        locationLabel.setBounds(50, 115, 200, 20);
        add(locationLabel);
        mainComponents.add(locationLabel);

        JTextField locationField = new JTextField();
        locationField.setBounds(250, 115, 200, 20);
        add(locationField);
        mainComponents.add(locationField);

        JLabel priceLabel = new JLabel("PRICE:");
        priceLabel.setBounds(50, 135, 200, 20);
        add(priceLabel);
        mainComponents.add(priceLabel);

        JTextField priceField = new JTextField();
        priceField.setBounds(250, 135, 200, 20);
        add(priceField);
        mainComponents.add(priceField);


        JLabel areaLabel = new JLabel("AREA:");
        areaLabel.setBounds(50, 155, 200, 20);
        add(areaLabel);
        mainComponents.add(areaLabel);

        JTextField areaField = new JTextField();
        areaField.setBounds(250, 155, 200, 20);
        add(areaField);
        mainComponents.add(areaField);


        JLabel yearLabel = new JLabel("YEAR:");
        yearLabel.setBounds(50, 175, 200, 20);
        add(yearLabel);
        mainComponents.add(yearLabel);

        JTextField yearField = new JTextField();
        yearField.setBounds(250, 175, 200, 20);
        add(yearField);
        mainComponents.add(yearField);


        JLabel pledgeLabel = new JLabel("PLEDGE:");
        pledgeLabel.setBounds(50, 195, 200, 20);
        add(pledgeLabel);
        mainComponents.add(pledgeLabel);

        String[] pledge = {"In pledge", "Not in pledge"};
        JComboBox pledgeBox = new JComboBox(pledge);
        pledgeBox.setBounds(250, 195, 200, 20);
        add(pledgeBox);
        mainComponents.add(pledgeBox);


        JLabel purposeLabel = new JLabel("PURPOSE:");
        purposeLabel.setBounds(50, 215, 200, 20);
        add(purposeLabel);
        mainComponents.add(purposeLabel);

        String[] purpose = {"For Sale", "For Rent"};
        JComboBox purposeBox = new JComboBox(purpose);
        purposeBox.setBounds(250, 215, 200, 20);
        add(purposeBox);
        mainComponents.add(purposeBox);


        JLabel offerLabel = new JLabel("HOT OFFER?");
        offerLabel.setBounds(50, 235, 200, 20);
        add(offerLabel);
        mainComponents.add(offerLabel);

        JButton offerButton = new JButton("BUY");
        offerButton.setBounds(250, 235, 200, 20);
        add(offerButton);
        mainComponents.add(offerButton);
        offerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (FrameUser.user.getMoney() > 200 && !hotOffer)
                    hotOffer = true;
                else if (hotOffer)
                    JOptionPane.showMessageDialog(null, "It is already hot offer", "ERROR",JOptionPane.PLAIN_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "Not enough money", "ERROR",JOptionPane.PLAIN_MESSAGE);
            }
        });

        ///////////////////////////////////////////////////////

        //1
        JLabel roomCountLabel = new JLabel("ROOM COUNT:");
        roomCountLabel.setBounds(50, 255, 200, 20);
        add(roomCountLabel);
        roomCountLabel.setVisible(false);

        JTextField roomCountField = new JTextField();
        roomCountField.setBounds(250, 255, 200, 20);
        add(roomCountField);
        roomCountField.setVisible(false);

        //2
        JLabel houseTypeLabel = new JLabel("HOUSE TYPE:");
        houseTypeLabel.setBounds(50, 275, 200, 20);
        add(houseTypeLabel);
        houseTypeLabel.setVisible(false);

        String[] houseType = {"Brick", "Panel", "Monolithic"};
        JComboBox houseTypeBox = new JComboBox(houseType);
        houseTypeBox.setBounds(250, 275, 200, 20);
        add(houseTypeBox);
        houseTypeBox.setVisible(false);

        //3
        JLabel kitchenAreaLabel = new JLabel("KITCHEN AREA:");
        kitchenAreaLabel.setBounds(50, 295, 200, 20);
        add(kitchenAreaLabel);
        kitchenAreaLabel.setVisible(false);

        JTextField kitchenAreaField = new JTextField();
        kitchenAreaField.setBounds(250, 295, 200, 20);
        add(kitchenAreaField);
        kitchenAreaField.setVisible(false);

        //4
        JLabel floorNumberLabel = new JLabel("FLOOR NUMBER:");
        floorNumberLabel.setBounds(50, 315, 200, 20);
        add(floorNumberLabel);
        floorNumberLabel.setVisible(false);

        JTextField floorNumberField = new JTextField();
        floorNumberField.setBounds(250, 315, 200, 20);
        add(floorNumberField);
        floorNumberField.setVisible(false);

        //4
        JLabel plotAreaLabel = new JLabel("PLOT AREA:");
        plotAreaLabel.setBounds(50, 315, 200, 20);
        add(plotAreaLabel);
        plotAreaLabel.setVisible(false);

        JTextField plotAreaField = new JTextField();
        plotAreaField.setBounds(250, 315, 200, 20);
        add(plotAreaField);
        plotAreaField.setVisible(false);

        //5
        JLabel floorCountLabel = new JLabel("FLOOR COUNT:");
        floorCountLabel.setBounds(50, 335, 200, 20);
        add(floorCountLabel);
        floorCountLabel.setVisible(false);

        JTextField floorCountField = new JTextField();
        floorCountField.setBounds(250, 335, 200, 20);
        add(floorCountField);
        floorCountField.setVisible(false);

        //2
        JLabel officeTypeLabel = new JLabel("OFFICE TYPE:");
        officeTypeLabel.setBounds(50, 275, 200, 20);
        add(officeTypeLabel);
        officeTypeLabel.setVisible(false);

        String[] officeType = {"Business Center", "Administrative building", "Living house"};
        JComboBox officeTypeBox = new JComboBox(officeType);
        officeTypeBox.setBounds(250, 275, 200, 20);
        add(officeTypeBox);
        officeTypeBox.setVisible(false);

        //1
        JLabel shopTypeLabel = new JLabel("SHOP TYPE:");
        shopTypeLabel.setBounds(50, 255, 200, 20);
        add(shopTypeLabel);
        shopTypeLabel.setVisible(false);

        String[] shopType = {"Shop", "Boutique", "Container", "Kiosk"};
        JComboBox shopTypeBox = new JComboBox(shopType);
        shopTypeBox.setBounds(250, 255, 200, 20);
        add(shopTypeBox);
        shopTypeBox.setVisible(false);

        //2
        JLabel shopBuildingLabel = new JLabel("BUILDING TYPE:");
        shopBuildingLabel.setBounds(50, 275, 200, 20);
        add(shopBuildingLabel);
        shopBuildingLabel.setVisible(false);

        String[] shopBuilding = {"In building", "Separate building"};
        JComboBox shopBuildingBox = new JComboBox(shopBuilding);
        shopBuildingBox.setBounds(250, 275, 200, 20);
        add(shopBuildingBox);
        shopBuildingBox.setVisible(false);

        //1
        JLabel baseTypeLabel = new JLabel("BASE TYPE:");
        baseTypeLabel.setBounds(50, 255, 200, 20);
        add(baseTypeLabel);
        baseTypeLabel.setVisible(false);

        String[] baseType = {"IndustrialBase", "Warehouse", "Factory"};
        JComboBox baseTypeBox = new JComboBox(baseType);
        baseTypeBox.setBounds(250, 255, 200, 20);
        add(baseTypeBox);
        baseTypeBox.setVisible(false);

        labels.add(roomCountLabel);
        labels.add(houseTypeLabel);
        labels.add(floorNumberLabel);
        labels.add(kitchenAreaLabel);
        labels.add(plotAreaLabel);
        labels.add(floorCountLabel);
        labels.add(officeTypeLabel);
        labels.add(shopBuildingLabel);
        labels.add(shopTypeLabel);
        labels.add(baseTypeLabel);

        textFields.add(roomCountField);
        textFields.add(floorNumberField);
        textFields.add(kitchenAreaField);
        textFields.add(plotAreaField);
        textFields.add(floorCountField);

        comboBoxes.add(houseTypeBox);
        comboBoxes.add(officeTypeBox);
        comboBoxes.add(shopBuildingBox);
        comboBoxes.add(shopTypeBox);
        comboBoxes.add(baseTypeBox);


        selectType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideComponents();
                setVisibleMainComponents(true);
                String selectedType = (String) typeBox.getSelectedItem();
                if (selectedType.equals("Flat")) {
                    roomCountField.setVisible(true);
                    roomCountLabel.setVisible(true);
                    houseTypeLabel.setVisible(true);
                    houseTypeBox.setVisible(true);
                    floorNumberField.setVisible(true);
                    floorNumberLabel.setVisible(true);
                    kitchenAreaLabel.setVisible(true);
                    kitchenAreaField.setVisible(true);
                }
                else if (selectedType.equals("House")) {
                    roomCountField.setVisible(true);
                    roomCountLabel.setVisible(true);
                    houseTypeLabel.setVisible(true);
                    houseTypeBox.setVisible(true);
                    plotAreaField.setVisible(true);
                    plotAreaLabel.setVisible(true);
                    kitchenAreaLabel.setVisible(true);
                    kitchenAreaField.setVisible(true);
                    floorCountField.setVisible(true);
                    floorCountLabel.setVisible(true);
                }
                else if (selectedType.equals("Room")) {
                    roomCountField.setVisible(true);
                    roomCountLabel.setVisible(true);
                    floorNumberField.setVisible(true);
                    floorNumberLabel.setVisible(true);
                }
                else if (selectedType.equals("Office")) {
                    roomCountField.setVisible(true);
                    roomCountLabel.setVisible(true);
                    officeTypeLabel.setVisible(true);
                    officeTypeBox.setVisible(true);
                }
                else if (selectedType.equals("Building")) {
                    houseTypeBox.setVisible(true);
                    houseTypeLabel.setVisible(true);
                    floorCountField.setVisible(true);
                    floorCountLabel.setVisible(true);
                }
                else if (selectedType.equals("Shop")) {
                    shopBuildingBox.setVisible(true);
                    shopBuildingLabel.setVisible(true);
                    shopTypeBox.setVisible(true);
                    shopTypeLabel.setVisible(true);
                }
                else if (selectedType.equals("Base")) {
                    baseTypeBox.setVisible(true);
                    baseTypeLabel.setVisible(true);
                }
            }
        });

        JButton addEstate = new JButton("ADD");
        addEstate.setBounds(50, 360, 200, 30);
        add(addEstate);
        addEstate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Estate estate = null;

                String location = "";
                int price = 0;
                double area = 0;
                int year = 0;
                boolean inPledge = false;
                String purpose;

                boolean numbersOk = true;

                if (!locationField.getText().isEmpty())
                    location = locationField.getText();
                else
                    error();

                try {
                    price = Integer.parseInt(priceField.getText());
                    area = Double.parseDouble(areaField.getText());
                    year = Integer.parseInt(yearField.getText());
                }catch (Exception exception) {
                    exception.printStackTrace();
                    error();
                    numbersOk = false;
                }

                if(!(price > 0 && area > 0 && year > 0))
                    numbersOk = false;

                if (pledgeBox.getSelectedItem().equals("In pledge"))
                    inPledge = true;

                purpose = (String) purposeBox.getSelectedItem();

                if (numbersOk) {
                    if (typeBox.getSelectedItem().equals("Flat")) {
                        int roomCount;
                        String houseType;
                        int floorNumber;
                        double kitchenArea;
                        boolean isOk = true;
                        try {
                            roomCount = Integer.parseInt(roomCountField.getText());
                            floorNumber = Integer.parseInt(floorNumberField.getText());
                            kitchenArea = Double.parseDouble(kitchenAreaField.getText());
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                            error();
                            isOk = false;
                            roomCount = 0;
                            floorNumber = 0;
                            kitchenArea = 0;
                        }

                        if (!(roomCount > 0 && floorNumber > 0 && kitchenArea > 0))
                            isOk = false;

                        if (isOk) {
                            houseType = (String) houseTypeBox.getSelectedItem();
                            estate = new Flat(null, FrameUser.userID, location, price, area,
                                    year, inPledge, purpose, hotOffer, roomCount, houseType, floorNumber, kitchenArea);
                        }
                    }
                    else if (typeBox.getSelectedItem().equals("House")) {
                        int roomCount;
                        String houseType;
                        double plotArea;
                        double kitchenArea;
                        int floorCount;
                        boolean isOk = true;
                        try {
                            roomCount = Integer.parseInt(roomCountField.getText());
                            plotArea = Double.parseDouble(floorNumberField.getText());
                            kitchenArea = Double.parseDouble(kitchenAreaField.getText());
                            floorCount = Integer.parseInt(floorCountField.getText());
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                            error();
                            isOk = false;
                            roomCount = 0;
                            plotArea = 0;
                            kitchenArea = 0;
                            floorCount = 0;
                        }

                        if (!(roomCount > 0 && plotArea > 0 && kitchenArea > 0 && floorCount > 0))
                            isOk = false;

                        if (isOk) {
                            houseType = (String) houseTypeBox.getSelectedItem();
                            estate = new House(null, FrameUser.userID, location, price, area,
                                    year, inPledge, purpose, hotOffer, roomCount, houseType, floorCount, plotArea, kitchenArea);
                        }
                    }
                    else if (typeBox.getSelectedItem().equals("Room")) {
                        int roomCount;
                        int floorNumber;
                        boolean isOk = true;
                        try {
                            roomCount = Integer.parseInt(roomCountField.getText());
                            floorNumber = Integer.parseInt(floorNumberField.getText());
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                            error();
                            isOk = false;
                            roomCount = 0;
                            floorNumber = 0;
                        }

                        if (!(roomCount > 0 && floorNumber > 0))
                            isOk = false;

                        if (isOk) {
                            estate = new Room(null, FrameUser.userID, location, price, area,
                                    year, inPledge, purpose, hotOffer, roomCount, floorNumber);
                        }
                    }
                    else if (typeBox.getSelectedItem().equals("Office")) {
                        int roomCount;
                        String officeType = (String) officeTypeBox.getSelectedItem();
                        boolean isOk = true;
                        try {
                            roomCount = Integer.parseInt(roomCountField.getText());
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                            error();
                            isOk = false;
                            roomCount = 0;
                        }

                        if (!(roomCount > 0))
                            isOk = false;

                        if (isOk) {
                            estate = new Office(null, FrameUser.userID, location, price, area,
                                    year, inPledge, purpose, hotOffer, roomCount, officeType);
                        }
                    }
                    else if (typeBox.getSelectedItem().equals("Building")) {
                        String houseType = (String) houseTypeBox.getSelectedItem();
                        int floorCount;
                        boolean isOk = true;
                        try {
                            floorCount = Integer.parseInt(floorCountField.getText());
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                            error();
                            isOk = false;
                            floorCount = 0;
                        }

                        if (!(floorCount > 0))
                            isOk = false;

                        if (isOk) {
                            estate = new Building(null, FrameUser.userID, location, price, area,
                                    year, inPledge, purpose, hotOffer, houseType, floorCount);
                        }
                    }
                    else if (typeBox.getSelectedItem().equals("Shop")) {
                        String shopType = (String) shopTypeBox.getSelectedItem();
                        String shopBuilding = (String) shopBuildingBox.getSelectedItem();
                        estate = new Shop(null, FrameUser.userID, location, price, area,
                                year, inPledge, purpose, hotOffer, shopType, shopBuilding);
                    }
                    else if (typeBox.getSelectedItem().equals("Base")) {
                        String baseType = (String) baseTypeBox.getSelectedItem();
                        estate = new Base(null, FrameUser.userID, location, price, area,
                                year, inPledge, purpose, hotOffer, baseType);
                    }
                    else if (typeBox.getSelectedItem().equals("Area")) {
                        estate = new Area(null, FrameUser.userID, location, price, area,
                                year, inPledge, purpose, hotOffer);
                    }
                    else if (typeBox.getSelectedItem().equals("Premise")) {
                        estate = new Premise(null, FrameUser.userID, location, price, area,
                                year, inPledge, purpose, hotOffer);
                    }
                }

                UserManager userManager = new UserManager(UserManager.ADD_ESTATE, FrameUser.user, estate);
                Main.connect(userManager);


                JOptionPane.showMessageDialog(null, "Apartment was added", "Success",JOptionPane.PLAIN_MESSAGE);
                hotOffer = false;
                clearComponents();
                hideComponents();
                setVisibleMainComponents(false);
            }
        });

        JButton backButton = new JButton("BACK");
        backButton.setBounds(250, 360, 200, 30);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameMain.frameUserAddEstate.setVisible(false);
                FrameMain.frameUser.setVisible(true);
            }
        });

        setVisibleMainComponents(false);

    }
    private void error() {
        JOptionPane.showMessageDialog(null, "Something wrong...", "ERROR",JOptionPane.PLAIN_MESSAGE);
    }
    private void clearComponents() {
        for (JTextField textField : textFields) {
            textField.setText("");
        }
        for (JComponent component : mainComponents) {
            if (component instanceof JTextField)
                ((JTextField) component).setText("");
            if (component instanceof JComboBox)
                ((JComboBox<?>) component).setSelectedIndex(0);
        }
    }
    private void hideComponents() {
        for (JLabel label : labels) {
            label.setVisible(false);
        }
        for (JTextField textField : textFields) {
            textField.setVisible(false);
        }
        for (JComboBox comboBox : comboBoxes) {
            comboBox.setVisible(false);
        }
    }
    private void setVisibleMainComponents(boolean flag) {
        for (JComponent component : mainComponents) {
            component.setVisible(flag);
        }
    }
}
