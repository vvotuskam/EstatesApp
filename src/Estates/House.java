package Estates;

public class House extends Estate {
    private int roomCount;
    private String houseType;
    private int floorCount;
    private double kitchenArea;
    private double plotArea;

    public House() {
    }

    public House(Integer ownerID, Integer estateID, String location, int price, double area, int year, boolean inPledge,
                 String purpose, boolean hotOffer, int roomCount, String houseType,
                 int floorCount, double kitchenArea, double plotArea) {
        super(ownerID, estateID, location, price, area, year, inPledge, purpose, hotOffer);
        this.roomCount = roomCount;
        this.houseType = houseType;
        this.floorCount = floorCount;
        this.kitchenArea = kitchenArea;
        this.plotArea = plotArea;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nRoom Count = " + roomCount +
                "\n" + houseType +
                "\nFloor Count = " + floorCount +
                "\nKitchen Area = " + kitchenArea +
                ", Plot Area = " + plotArea;
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

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public double getKitchenArea() {
        return kitchenArea;
    }

    public void setKitchenArea(double kitchenArea) {
        this.kitchenArea = kitchenArea;
    }

    public double getPlotArea() {
        return plotArea;
    }

    public void setPlotArea(double plotArea) {
        this.plotArea = plotArea;
    }
}
