package Estates;

public class Flat extends Estate {
    private int roomCount;
    private String houseType; //(кирпичный, панельный, монолитный, прочее)
    private int floorNumber; //(2nd)
    private double kitchenArea;

    public Flat(Integer estateID, Integer ownerID, String location, int price, double area, int year,
                boolean inPledge, String purpose, boolean hotOffer, int roomCount,
                String houseType, int floorNumber, double kitchenArea) {
        super(estateID, ownerID, location, price, area, year, inPledge, purpose, hotOffer);
        this.roomCount = roomCount;
        this.houseType = houseType;
        this.floorNumber = floorNumber;
        this.kitchenArea = kitchenArea;
    }

    public Flat() {

    }

    @Override
    public String toString() {
        return super.toString() +
                "\nRoom Count = " + roomCount +
                "\n" + houseType +
                "\nFloor Number = " + floorNumber +
                ", Kitchen Area = " + kitchenArea;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public double getKitchenArea() {
        return kitchenArea;
    }

    public void setKitchenArea(double kitchenArea) {
        this.kitchenArea = kitchenArea;
    }
}
