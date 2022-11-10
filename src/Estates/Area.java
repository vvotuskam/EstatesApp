package Estates;

public class Area extends Estate {
    public Area(Integer estateID, Integer ownerID, String location, int price, double area, int year,
                boolean inPledge, String purpose, boolean hotOffer) {
        super(estateID, ownerID, location, price, area, year, inPledge, purpose, hotOffer);
    }

    public Area() {
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
