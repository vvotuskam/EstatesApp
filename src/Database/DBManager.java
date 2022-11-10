package Database;

import Estates.*;
import User.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;

public class DBManager {
    private Connection connection;

    public static final String FLAT = "Flat";
    public static final String HOUSE = "House";
    public static final String AREA = "Area";
    public static final String BASE = "Base";
    public static final String BUILDING = "Building";
    public static final String OFFICE = "Office";
    public static final String PREMISE = "Premise";
    public static final String SHOP = "Shop";
    public static final String ROOM = "Room";

    public static final String[] estateTypes = {FLAT, HOUSE, BASE, AREA, BUILDING, OFFICE, PREMISE, SHOP, ROOM};

    public static final String url = "jdbc:postgresql://localhost:5432/EstateProject";
    public static final String user = "postgres";
    public static final String password = "webuser";

    public DBManager() {
        connect();
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Database");
        }
        catch (Exception e) {
            System.out.println("Didn't connected to Database");
            e.printStackTrace();
        }
    }

    public Integer getLastUserId() {
        Integer maxID = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT max(userid) from Users");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                maxID = resultSet.getInt(1);
            }
            statement.close();
        }
        catch (Exception e) {
            System.out.println("Statement mistake");
            e.printStackTrace();
        }
        return maxID;
    }
    public void addUser(UserManager userManager) {
        User user = userManager.getUser();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO Users (name, surname, password, email, phone, money) Values (?, ?, ?, ?, ?, ?)");
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPhone());
            statement.setInt(6, user.getMoney());

            statement.executeUpdate();
            statement.close();
            user.setId(getLastUserId());
        }
        catch (Exception e) {
            System.out.println("Statement mistake");
            e.printStackTrace();
        }
    }
    public void deleteUser(User user) {
        int userID = user.getId();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM Users WHERE userID = " + userID);

            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            System.out.println("Statement mistake");
            e.printStackTrace();
        }
    }
    public void editUser(UserManager userManager) {
        User user = userManager.getUser();
        int userID = user.getId();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE Users SET name = ?, surname = ?, password = ?, " +
                    "email = ?, phone = ?, money = ? WHERE userid = " + userID);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPhone());
            statement.setInt(6, user.getMoney());

            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            System.out.println("Statement mistake");
            e.printStackTrace();
        }
    }

    public void addEstate(UserManager userManager) {
        Estate estate = userManager.getEstate();
        if (estate instanceof Area)
            addEstate((Area) estate);
        else if (estate instanceof Base)
            addEstate((Base) estate);
        else if (estate instanceof Building)
            addEstate((Building) estate);
        else if (estate instanceof Flat)
            addEstate((Flat) estate);
        else if (estate instanceof House)
            addEstate((House) estate);
        else if (estate instanceof Office)
            addEstate((Office) estate);
        else if (estate instanceof Premise)
            addEstate((Premise) estate);
        else if (estate instanceof Room)
            addEstate((Room) estate);
        else if (estate instanceof Shop)
            addEstate((Shop) estate);
    }
    public void addEstate(Flat flat) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO Flat (location, price, area, year, inPledge, purpose, hotOffer, roomCount, " +
                    "houseType, floorNumber, kitchenArea, userID) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, flat.getLocation());
            statement.setInt(2, flat.getPrice());
            statement.setDouble(3, flat.getArea());
            statement.setInt(4, flat.getYear());
            statement.setBoolean(5, flat.isInPledge());
            statement.setString(6, flat.getPurpose());
            statement.setBoolean(7, flat.isHotOffer());
            statement.setInt(8, flat.getRoomCount());
            statement.setString(9, flat.getHouseType());
            statement.setInt(10, flat.getFloorNumber());
            statement.setDouble(11, flat.getKitchenArea());
            statement.setInt(12, flat.getOwnerID());

            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addEstate(House house) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO House (location, price, area, year, inPledge, purpose, hotOffer, " +
                    "roomCount, houseType, floorCount, kitchenArea, plotArea, userID) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, house.getLocation());
            statement.setInt(2, house.getPrice());
            statement.setDouble(3, house.getArea());
            statement.setInt(4, house.getYear());
            statement.setBoolean(5, house.isInPledge());
            statement.setString(6, house.getPurpose());
            statement.setBoolean(7, house.isHotOffer());
            statement.setInt(8, house.getRoomCount());
            statement.setString(9, house.getHouseType());
            statement.setInt(10, house.getFloorCount());
            statement.setDouble(11, house.getKitchenArea());
            statement.setDouble(12, house.getPlotArea());
            statement.setInt(13, house.getOwnerID());

            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addEstate(Area area) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO Area (location, price, area, year, inPledge, purpose, hotOffer, " +
                    "userID) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, area.getLocation());
            statement.setInt(2, area.getPrice());
            statement.setDouble(3, area.getArea());
            statement.setInt(4, area.getYear());
            statement.setBoolean(5, area.isInPledge());
            statement.setString(6, area.getPurpose());
            statement.setBoolean(7, area.isHotOffer());
            statement.setInt(8, area.getOwnerID());

            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addEstate(Base base) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO Base (location, price, area, year, inPledge, purpose, hotOffer, " +
                    "userID, baseType) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, base.getLocation());
            statement.setInt(2, base.getPrice());
            statement.setDouble(3, base.getArea());
            statement.setInt(4, base.getYear());
            statement.setBoolean(5, base.isInPledge());
            statement.setString(6, base.getPurpose());
            statement.setBoolean(7, base.isHotOffer());
            statement.setInt(8, base.getOwnerID());
            statement.setString(9, base.getBaseType());

            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addEstate(Building building) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO Area (location, price, area, year, inPledge, purpose, hotOffer, " +
                    "userID,houseType, floorCount) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, building.getLocation());
            statement.setInt(2, building.getPrice());
            statement.setDouble(3, building.getArea());
            statement.setInt(4, building.getYear());
            statement.setBoolean(5, building.isInPledge());
            statement.setString(6, building.getPurpose());
            statement.setBoolean(7, building.isHotOffer());
            statement.setInt(8, building.getOwnerID());
            statement.setString(9, building.getHouseType());
            statement.setInt(10, building.getFloorCount());

            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addEstate(Office office) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO Area (location, price, area, year, inPledge, purpose, hotOffer, " +
                    "userID, officeType, roomCount) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, office.getLocation());
            statement.setInt(2, office.getPrice());
            statement.setDouble(3, office.getArea());
            statement.setInt(4, office.getYear());
            statement.setBoolean(5, office.isInPledge());
            statement.setString(6, office.getPurpose());
            statement.setBoolean(7, office.isHotOffer());
            statement.setInt(8, office.getOwnerID());
            statement.setString(9, office.getOfficeType());
            statement.setInt(10, office.getRoomCount());

            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addEstate(Premise premise) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO Area (location, price, area, year, inPledge, purpose, hotOffer, " +
                    "userID) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, premise.getLocation());
            statement.setInt(2, premise.getPrice());
            statement.setDouble(3, premise.getArea());
            statement.setInt(4, premise.getYear());
            statement.setBoolean(5, premise.isInPledge());
            statement.setString(6, premise.getPurpose());
            statement.setBoolean(7, premise.isHotOffer());
            statement.setInt(8, premise.getOwnerID());

            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addEstate(Room room) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO Area (location, price, area, year, inPledge, purpose, hotOffer, " +
                    "userID, roomCount, floorNumber) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, room.getLocation());
            statement.setInt(2, room.getPrice());
            statement.setDouble(3, room.getArea());
            statement.setInt(4, room.getYear());
            statement.setBoolean(5, room.isInPledge());
            statement.setString(6, room.getPurpose());
            statement.setBoolean(7, room.isHotOffer());
            statement.setInt(8, room.getOwnerID());
            statement.setInt(9, room.getRoomCount());
            statement.setInt(10, room.getFloorNumber());

            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addEstate(Shop shop) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO Area (location, price, area, year, inPledge, purpose, hotOffer, " +
                    "userID, shopType, buildingType) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, shop.getLocation());
            statement.setInt(2, shop.getPrice());
            statement.setDouble(3, shop.getArea());
            statement.setInt(4, shop.getYear());
            statement.setBoolean(5, shop.isInPledge());
            statement.setString(6, shop.getPurpose());
            statement.setBoolean(7, shop.isHotOffer());
            statement.setInt(8, shop.getOwnerID());
            statement.setString(9, shop.getShopType());
            statement.setString(10, shop.getBuildingType());

            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteEstate(UserManager userManager) {
        Estate estate = userManager.getEstate();
        int estateID = estate.getEstateID();
        try {
            StringBuilder preStatement = new StringBuilder("DELETE FROM ");
            preStatement.append(getEstateType(estate));
            preStatement.append(" WHERE estateid = " + estateID);

            PreparedStatement statement = connection.prepareStatement(String.valueOf(preStatement));
            System.out.println(statement);
            statement.executeUpdate();

            statement = connection.prepareStatement(
                    "DELETE FROM Favourites WHERE estateid = ? AND estatetype = ?"
            );
            statement.setInt(1, estateID);
            statement.setString(2, getEstateType(estate));
            statement.executeUpdate();
            statement.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editEstate(UserManager userManager) {
        Estate estate = userManager.getEstate();
        if (estate instanceof Area)
            editEstate((Area) estate);
        else if (estate instanceof Base)
            editEstate((Base) estate);
        else if (estate instanceof Building)
            editEstate((Building) estate);
        else if (estate instanceof Flat)
            editEstate((Flat) estate);
        else if (estate instanceof House)
            editEstate((House) estate);
        else if (estate instanceof Office)
            editEstate((Office) estate);
        else if (estate instanceof Premise)
            editEstate((Premise) estate);
        else if (estate instanceof Room)
            editEstate((Room) estate);
        else if (estate instanceof Shop)
            editEstate((Shop) estate);
    }
    public void editEstate(Flat flat) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE Flat SET location = ?, price = ?, area = ?, year = ?, inPledge = ?," +
                    "purpose = ?, hotOffer = ?, roomCount = ?, houseType = ?, floorNumber = ?," +
                    "kitchenArea = ?, userId = ? WHERE estateID = ?");
            statement.setString(1, flat.getLocation());
            statement.setInt(2, flat.getPrice());
            statement.setDouble(3, flat.getArea());
            statement.setInt(4, flat.getYear());
            statement.setBoolean(5, flat.isInPledge());
            statement.setString(6, flat.getPurpose());
            statement.setBoolean(7, flat.isHotOffer());
            statement.setInt(8, flat.getRoomCount());
            statement.setString(9, flat.getHouseType());
            statement.setInt(10, flat.getFloorNumber());
            statement.setDouble(11, flat.getKitchenArea());
            statement.setInt(12, flat.getOwnerID());
            statement.setInt(13, flat.getEstateID());

            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void editEstate(House house) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE House SET location = ?, price = ?, area = ?, year = ?, inPledge = ?," +
                    "purpose = ?, hotOffer = ?, roomCount = ?, houseType = ?, floorCount = ?," +
                    "kitchenArea = ?, plotArea = ?, userId = ? WHERE estateID = ?");
            statement.setString(1, house.getLocation());
            statement.setInt(2, house.getPrice());
            statement.setDouble(3, house.getArea());
            statement.setInt(4, house.getYear());
            statement.setBoolean(5, house.isInPledge());
            statement.setString(6, house.getPurpose());
            statement.setBoolean(7, house.isHotOffer());
            statement.setInt(8, house.getRoomCount());
            statement.setString(9, house.getHouseType());
            statement.setInt(10, house.getFloorCount());
            statement.setDouble(11, house.getKitchenArea());
            statement.setDouble(12, house.getPlotArea());
            statement.setInt(13, house.getOwnerID());
            statement.setInt(13, house.getEstateID());

            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void editEstate(Area area) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE Area SET location = ?, price = ?, area = ?, year = ?, inPledge = ?," +
                    "purpose = ?, hotOffer = ?, userId = ? WHERE estateID = ?");
            statement.setString(1, area.getLocation());
            statement.setInt(2, area.getPrice());
            statement.setDouble(3, area.getArea());
            statement.setInt(4, area.getYear());
            statement.setBoolean(5, area.isInPledge());
            statement.setString(6, area.getPurpose());
            statement.setBoolean(7, area.isHotOffer());
            statement.setInt(8, area.getOwnerID());
            statement.setInt(9, area.getEstateID());

            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void editEstate(Base base) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE Base SET location = ?, price = ?, area = ?, year = ?, inPledge = ?," +
                    "purpose = ?, hotOffer = ?, userId = ?, baseType = ? WHERE estateID = ?");
            statement.setString(1, base.getLocation());
            statement.setInt(2, base.getPrice());
            statement.setDouble(3, base.getArea());
            statement.setInt(4, base.getYear());
            statement.setBoolean(5, base.isInPledge());
            statement.setString(6, base.getPurpose());
            statement.setBoolean(7, base.isHotOffer());
            statement.setInt(8, base.getOwnerID());
            statement.setString(9, base.getBaseType());
            statement.setInt(10, base.getEstateID());

            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void editEstate(Building building) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE Building SET location = ?, price = ?, area = ?, year = ?, inPledge = ?," +
                    "purpose = ?, hotOffer = ?, userId = ?, houseType = ?, floorCount = ? WHERE estateID = ?");
            statement.setString(1, building.getLocation());
            statement.setInt(2, building.getPrice());
            statement.setDouble(3, building.getArea());
            statement.setInt(4, building.getYear());
            statement.setBoolean(5, building.isInPledge());
            statement.setString(6, building.getPurpose());
            statement.setBoolean(7, building.isHotOffer());
            statement.setInt(8, building.getOwnerID());
            statement.setString(9, building.getHouseType());
            statement.setInt(10, building.getFloorCount());
            statement.setInt(11, building.getEstateID());

            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void editEstate(Office office) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE Office SET location = ?, price = ?, area = ?, year = ?, inPledge = ?," +
                    "purpose = ?, hotOffer = ?, userId = ?, officeType = ?, roomCount = ? WHERE estateID = ?");
            statement.setString(1, office.getLocation());
            statement.setInt(2, office.getPrice());
            statement.setDouble(3, office.getArea());
            statement.setInt(4, office.getYear());
            statement.setBoolean(5, office.isInPledge());
            statement.setString(6, office.getPurpose());
            statement.setBoolean(7, office.isHotOffer());
            statement.setInt(8, office.getOwnerID());
            statement.setString(9, office.getOfficeType());
            statement.setInt(10, office.getRoomCount());
            statement.setInt(11, office.getEstateID());

            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void editEstate(Premise premise) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE Premise SET location = ?, price = ?, area = ?, year = ?, inPledge = ?," +
                    "purpose = ?, hotOffer = ?, userId = ? WHERE estateID = ?");
            statement.setString(1, premise.getLocation());
            statement.setInt(2, premise.getPrice());
            statement.setDouble(3, premise.getArea());
            statement.setInt(4, premise.getYear());
            statement.setBoolean(5, premise.isInPledge());
            statement.setString(6, premise.getPurpose());
            statement.setBoolean(7, premise.isHotOffer());
            statement.setInt(8, premise.getOwnerID());
            statement.setInt(9, premise.getEstateID());

            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void editEstate(Room room) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE Room SET location = ?, price = ?, area = ?, year = ?, inPledge = ?," +
                    "purpose = ?, hotOffer = ?, userId = ?, roomCount = ?, floorNumber = ? WHERE estateID = ?");
            statement.setString(1, room.getLocation());
            statement.setInt(2, room.getPrice());
            statement.setDouble(3, room.getArea());
            statement.setInt(4, room.getYear());
            statement.setBoolean(5, room.isInPledge());
            statement.setString(6, room.getPurpose());
            statement.setBoolean(7, room.isHotOffer());
            statement.setInt(8, room.getOwnerID());
            statement.setInt(9, room.getRoomCount());
            statement.setInt(10, room.getFloorNumber());
            statement.setInt(11, room.getEstateID());

            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void editEstate(Shop shop) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE Shop SET location = ?, price = ?, area = ?, year = ?, inPledge = ?," +
                    "purpose = ?, hotOffer = ?, userId = ?, shopType = ?, buildingType = ? WHERE estateID = ?");
            statement.setString(1, shop.getLocation());
            statement.setInt(2, shop.getPrice());
            statement.setDouble(3, shop.getArea());
            statement.setInt(4, shop.getYear());
            statement.setBoolean(5, shop.isInPledge());
            statement.setString(6, shop.getPurpose());
            statement.setBoolean(7, shop.isHotOffer());
            statement.setInt(8, shop.getOwnerID());
            statement.setString(9, shop.getShopType());
            statement.setString(10, shop.getBuildingType());
            statement.setInt(11, shop.getEstateID());

            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Estate> viewUserEstates(UserManager userManager) {

        int userID = userManager.getUser().getId();

        ArrayList<Estate> userEstates = new ArrayList<>();
        try {
            for (String estateType : estateTypes) {
                PreparedStatement statement = connection.prepareStatement("" +
                        "SELECT * FROM " + estateType + " estate WHERE estate.userid = " + userID);
                ResultSet resultSet = statement.executeQuery();
                userEstates.addAll(getEstates(resultSet, estateType));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("user estates added");
        return userEstates;
    }

    private ArrayList<Estate> getEstates(ResultSet resultSet, String type) {
        ArrayList<Estate> estates = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int estateID = resultSet.getInt("estateid");
                String location = resultSet.getString("location");
                int price = resultSet.getInt("price");
                double area = resultSet.getDouble("area");
                int year = resultSet.getInt("year");
                boolean inPledge = resultSet.getBoolean("inpledge");
                String purpose = resultSet.getString("purpose");
                boolean hotOffer = resultSet.getBoolean("hotoffer");
                int userID = resultSet.getInt("userid");
                if (type.equals(FLAT)) {
                    int roomCount = resultSet.getInt("roomcount");
                    String houseType = resultSet.getString("housetype");
                    int floorNumber = resultSet.getInt("floornumber");
                    double kitchenArea = resultSet.getDouble("kitchenarea");
                    estates.add(new Flat(estateID, userID, location, price, area,
                            year, inPledge, purpose, hotOffer, roomCount, houseType, floorNumber, kitchenArea));
                }
                else if (type.equals(HOUSE)) {
                    int roomCount = resultSet.getInt("roomcount");
                    String houseType = resultSet.getString("housetype");
                    int floorCount = resultSet.getInt("floorcount");
                    double kitchenArea = resultSet.getDouble("kitchenarea");
                    double plotArea = resultSet.getDouble("plotarea");
                    estates.add(new House(estateID, userID, location, price, area,
                            year, inPledge, purpose, hotOffer, roomCount, houseType, floorCount, kitchenArea, plotArea));
                }
                else if (type.equals(BASE)) {
                    String baseType = resultSet.getString("basetype");
                    estates.add(new Base(estateID, userID, location, price, area,
                            year, inPledge, purpose, hotOffer, baseType));
                }
                else if (type.equals(BUILDING)) {
                    String houseType = resultSet.getString("housetype");
                    int floorCount = resultSet.getInt("floorcount");
                    estates.add(new Building(estateID, userID, location, price, area,
                            year, inPledge, purpose, hotOffer, houseType, floorCount));
                }
                else if (type.equals(OFFICE)) {
                    int roomCount = resultSet.getInt("roomcount");
                    String officeType = resultSet.getString("officetype");
                    estates.add(new Office(estateID, userID, location, price, area,
                            year, inPledge, purpose, hotOffer, roomCount, officeType));
                }
                else if (type.equals(ROOM)) {
                    int roomCount = resultSet.getInt("roomcount");
                    int floorNumber = resultSet.getInt("floornumber");
                    estates.add(new Room(estateID, userID, location, price, area,
                            year, inPledge, purpose, hotOffer, roomCount, floorNumber));
                }
                else if (type.equals(SHOP)) {
                    String shopType = resultSet.getString("shoptype");
                    String buildingType = resultSet.getString("buildingtype");
                    estates.add(new Shop(estateID, userID, location, price, area,
                            year, inPledge, purpose, hotOffer, shopType, buildingType));
                }
                else if (type.equals(AREA)) {
                    estates.add(new Area(estateID, userID, location, price, area,
                            year, inPledge, purpose, hotOffer));
                }
                else if (type.equals(PREMISE)) {
                    estates.add(new Premise(estateID, userID, location, price, area,
                            year, inPledge, purpose, hotOffer));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return estates;
    }

    public User canLogIn(UserManager userManager) {
        String password = userManager.getPassword();
        String email = userManager.getEmail();
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM Users WHERE email = ? and password = ?");
            statement.setString(1, password);
            statement.setString(2, email);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("userid");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String email1 = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String password1 = resultSet.getString("password");
                int money = resultSet.getInt("money");

                user = new User(id, name, surname, password1, email1, phone, money);
                break;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void addMoney(UserManager userManager) {
        int money = userManager.getMoney();
        int userMoney = userManager.getUser().getMoney();
        User user = userManager.getUser();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE Users SET money = ? WHERE userid = ?");
            statement.setInt(1, money + userMoney);
            statement.setInt(2, user.getId());
            statement.executeUpdate();
            statement.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Estate> viewEstates(UserManager userManager) {
        String filterType = userManager.getFilterType();
        String estateType = userManager.getEstateType();

        ArrayList<Estate> estates = new ArrayList<>();

        ResultSet resultSet;
        PreparedStatement statement;
        String preStatement = "SELECT * FROM ";

        try {
            if (estateType.equals("None")) {
                for (String estate : estateTypes) {
                    statement = connection.prepareStatement(preStatement + estate);
                    System.out.println(statement);
                    resultSet = statement.executeQuery();
                    estates.addAll(getEstates(resultSet, estate));
                }
            }
            else {
                statement = connection.prepareStatement(preStatement + estateType);
                resultSet = statement.executeQuery();
                estates.addAll(getEstates(resultSet, estateType));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (filterType.equals("None")) {
            sortByOffer(estates);
        }
        else if (filterType.equals("Price")) {
            sortByPrice(estates);
        }
        else if (filterType.equals("Location")) {
            sortByLocation(estates);
        }
        else if (filterType.equals("Year")) {
            sortByYear(estates);
        }
        else if (filterType.equals("Area")) {
            sortByArea(estates);
        }
        else if (filterType.equals("Purpose")) {
            sortByPurpose(estates);
        }
        return estates;
    }
    public void sortByLocation(ArrayList<Estate> estates) {
        Comparator locationComparator = new Comparator<Estate>() {
            @Override
            public int compare(Estate estate1, Estate estate2) {
                if (estate1.getOffer() < estate2.getOffer())
                    return 1;
                if (estate1.getOffer() == estate2.getOffer()) {
                    if (estate1.getLocation().compareToIgnoreCase(estate2.getLocation()) > 0)
                        return 1;
                    if (estate1.getLocation().compareToIgnoreCase(estate2.getLocation()) < 0)
                        return -1;
                    return 0;
                }
                return -1;
            }
        };
        estates.sort(locationComparator);
        System.out.println("Sorted by location");
    }
    public void sortByPrice(ArrayList<Estate> estates) {
        Comparator comparator = new Comparator<Estate>() {
            @Override
            public int compare(Estate estate1, Estate estate2) {
                if (estate1.getOffer() < estate2.getOffer())
                    return 1;
                if (estate1.getOffer() == estate2.getOffer()) {
                    if (estate1.getPrice() > estate2.getPrice())
                        return 1;
                    if (estate1.getPrice() < estate2.getPrice())
                        return -1;
                    return 0;
                }
                return -1;
            }
        };
        estates.sort(comparator);
    }
    public void sortByYear(ArrayList<Estate> estates) {
        Comparator comparator = new Comparator<Estate>() {
            @Override
            public int compare(Estate estate1, Estate estate2) {
                if (estate1.getOffer() < estate2.getOffer())
                    return 1;
                if (estate1.getOffer() == estate2.getOffer()) {
                    if (estate1.getYear() > estate2.getYear())
                        return -1;
                    if (estate1.getYear() < estate2.getYear())
                        return 1;
                    return 0;
                }
                return -1;
            }
        };
        estates.sort(comparator);
    }
    public void sortByArea(ArrayList<Estate> estates) {
        Comparator comparator = new Comparator<Estate>() {
            @Override
            public int compare(Estate estate1, Estate estate2) {
                if (estate1.getOffer() < estate2.getOffer())
                    return 1;
                if (estate1.getOffer() == estate2.getOffer()) {
                    if (estate1.getArea() > estate2.getArea())
                        return 1;
                    if (estate1.getArea() < estate2.getArea())
                        return -1;
                    return 0;
                }
                return -1;
            }
        };
        estates.sort(comparator);
    }
    public void sortByPurpose(ArrayList<Estate> estates) {
        Comparator comparator = new Comparator<Estate>() {
            @Override
            public int compare(Estate estate1, Estate estate2) {
                if (estate1.getOffer() < estate2.getOffer())
                    return 1;
                if (estate1.getOffer() == estate2.getOffer()) {
                    if (estate1.getPurpose().compareToIgnoreCase(estate2.getPurpose()) > 0)
                        return 1;
                    if (estate1.getPurpose().compareToIgnoreCase(estate2.getPurpose()) < 0)
                        return -1;
                    return 0;
                }
                return -1;
            }
        };
        estates.sort(comparator);
    }
    private static void sortByOffer(ArrayList<Estate> estates) {
        Comparator<Estate> comparator = new Comparator<>() {
            @Override
            public int compare(Estate estate1, Estate estate2) {
                if (estate1.getOffer() < estate2.getOffer())
                    return 1;
                return -1;
            }
        };
        estates.sort(comparator);
    }

    public void addToFavourites(UserManager userManager) {
        if (isFavourite(userManager))
            return;

        Estate estate = userManager.getEstate();
        int userID = userManager.getUser().getId();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO Favourites (userid, estateid, estatetype) VALUES " +
                    "(?, ?, ?)"
            );
            statement.setInt(1, userID);
            statement.setInt(2, estate.getEstateID());
            statement.setString(3, getEstateType(estate));
            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isFavourite(UserManager userManager) {
        boolean isFavourites = false;

        Estate estate = userManager.getEstate();
        User user = userManager.getUser();

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT count(*) FROM Favourites " +
                            "WHERE userid = ? AND estateid = ? AND estatetype = ?"
            );
            statement.setInt(1, user.getId());
            statement.setInt(2, estate.getEstateID());
            statement.setString(3, getEstateType(estate));
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getInt("count") > 0) {
                    isFavourites = true;
                    break;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return isFavourites;
    }

    public ArrayList<Estate> viewFavourites(UserManager userManager) {
        ArrayList<Estate> favourites = new ArrayList<>();

        User user = userManager.getUser();

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT estateid, estatetype FROM Favourites " +
                            "WHERE userid = ?"
            );
            statement.setInt(1, user.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int estateID = resultSet.getInt("estateid");
                String estateType = resultSet.getString("estatetype");
                favourites.add(getEstate(estateID, estateType));
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

        return favourites;
    }

    public Estate getEstate(int estateID, String estateType) {
        Estate estate = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM " + estateType + " WHERE estateid = ?"
            );
            statement.setInt(1, estateID);
            ResultSet resultSet = statement.executeQuery();
            System.out.println(statement);
            estate = getEstates(resultSet, estateType).get(0);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return estate;
    }

    public String getEstateType(Estate estate) {
        String str = null;
        if (estate instanceof Area)
            str = "Area";
        else if (estate instanceof Base)
            str = "Base";
        else if (estate instanceof Building)
            str = "Building";
        else if (estate instanceof Flat)
            str = "Flat";
        else if (estate instanceof House)
            str = "House";
        else if (estate instanceof Office)
            str = "Office";
        else if (estate instanceof Premise)
            str = "Premise";
        else if (estate instanceof Room)
            str = "Room";
        else if (estate instanceof Shop)
            str = "Shop";
        return str;
    }

    public void deleteFavourite(UserManager userManager) {
        Estate estate = userManager.getEstate();
        User user = userManager.getUser();

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM Favourites WHERE userid = ? " +
                            "AND estateid = ? AND estatetype = ?"
            );
            statement.setInt(1, user.getId());
            statement.setInt(2, estate.getEstateID());
            statement.setString(3, getEstateType(estate));
            statement.executeUpdate();
            statement.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
