package Estates;

public class Base extends Estate {
    private String baseType;

    public Base() {
    }

    public Base(Integer ownerID, Integer estateID, String location, int price, double area, int year, boolean inPledge, String purpose, boolean hotOffer, String baseType) {
        super(ownerID, estateID, location, price, area, year, inPledge, purpose, hotOffer);
        this.baseType = baseType;
    }
    public String toString() {
        return super.toString() + ", " + baseType;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }
}
