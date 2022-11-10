package Estates;

public class Room extends Estate {
    private int roomCount;
    private int floorNumber;

    public Room() {
    }

    public Room(Integer ownerID, Integer estateID, String location, int price, double area, int year, boolean inPledge, String purpose, boolean hotOffer, int roomCount, int floorNumber) {
        super(ownerID, estateID, location, price, area, year, inPledge, purpose, hotOffer);
        this.roomCount = roomCount;
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nRoom Count = " + roomCount +
                ", Floor Number = " + floorNumber;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
