package Estates;

public class Shop extends Estate {
    private String shopType;
    private String buildingType;

    public Shop() {
    }

    public Shop(Integer ownerID, Integer estateID, String location, int price, double area, int year, boolean inPledge, String purpose, boolean hotOffer, String shopType, String buildingType) {
        super(ownerID, estateID, location, price, area, year, inPledge, purpose, hotOffer);
        this.shopType = shopType;
        this.buildingType = buildingType;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nShop Type = " + shopType +
                ", Building Type = " + buildingType;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }
}
