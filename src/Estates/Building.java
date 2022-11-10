package Estates;

public class Building extends Estate {
    private String houseType;
    private int floorCount;

    public Building() {
    }

    public Building(Integer ownerID, Integer estateID, String location, int price, double area,
                    int year, boolean inPledge, String purpose,
                    boolean hotOffer, String houseType, int floorCount) {
        super(ownerID, estateID, location, price, area, year, inPledge, purpose, hotOffer);
        this.houseType = houseType;
        this.floorCount = floorCount;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", " + houseType +
                ", Floor count = " + floorCount;
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
}
