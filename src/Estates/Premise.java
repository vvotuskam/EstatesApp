package Estates;

public class Premise extends Estate {
    public Premise() {
    }

    public Premise(Integer ownerID, Integer estateID, String location, int price, double area, int year, boolean inPledge, String purpose, boolean hotOffer) {
        super(ownerID, estateID, location, price, area, year, inPledge, purpose, hotOffer);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
