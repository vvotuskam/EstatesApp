package Estates;

public class Office extends Estate {
    private int roomCount;
    private String officeType;

    public Office() {
    }

    public Office(Integer ownerID, Integer estateID, String location, int price, double area, int year, boolean inPledge, String purpose, boolean hotOffer, int roomCount, String officeType) {
        super(ownerID, estateID, location, price, area, year, inPledge, purpose, hotOffer);
        this.roomCount = roomCount;
        this.officeType = officeType;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nRoom Count = " + roomCount +
                ", Office Type = " + officeType;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public String getOfficeType() {
        return officeType;
    }

    public void setOfficeType(String officeType) {
        this.officeType = officeType;
    }
}
