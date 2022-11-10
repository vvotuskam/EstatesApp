package Estates;

import java.awt.event.ActionListener;
import java.io.Serializable;

public abstract class Estate implements Serializable {
    protected Integer estateID;
    protected Integer ownerID;
    protected StringBuilder location;
    protected int price;
    protected double area;
    protected int year;
    protected boolean inPledge;
    protected StringBuilder purpose;
    protected boolean hotOffer;

    public Estate(Integer estateID, Integer ownerID, String location, int price, double area,
                  int year, boolean inPledge, String purpose, boolean hotOffer) {
        this.estateID = estateID;
        this.ownerID = ownerID;
        this.location = new StringBuilder(location);
        this.price = price;
        this.area = area;
        this.year = year;
        this.inPledge = inPledge;
        this.purpose = new StringBuilder(purpose);
        this.hotOffer = hotOffer;
    }

    public Estate() {
    }

    public String estateInfoShort() {
        String s = location + ", " + price;
        if (hotOffer)
            s += "🔥";
        return s;
    }

    @Override
    public String toString() {
        String basicFeatures = location + "";
        if (hotOffer)
            basicFeatures += "🔥";
        basicFeatures += "\n" + price + "\nTotal Area = " + area + "\n"
                + year + " year\n";
        if (!inPledge)
            basicFeatures += "Not ";
        basicFeatures += "In Pledge\n" + purpose;
        return basicFeatures;
    }

    public Integer getEstateID() {
        return estateID;
    }

    public void setEstateID(Integer estateID) {
        this.estateID = estateID;
    }

    public Integer getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Integer ownerID) {
        this.ownerID = ownerID;
    }

    public String getLocation() {
        return String.valueOf(location);
    }

    public void setLocation(String location) {
        this.location.replace(0, this.location.length(), location);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isInPledge() {
        return inPledge;
    }

    public void setInPledge(boolean inPledge) {
        this.inPledge = inPledge;
    }

    public String getPurpose() {
        return String.valueOf(purpose);
    }

    public void setPurpose(String purpose) {
        this.purpose.replace(0, this.purpose.length(), purpose);
    }

    public boolean isHotOffer() {
        return hotOffer;
    }

    public void setHotOffer(boolean hotOffer) {
        this.hotOffer = hotOffer;
    }

    public int getOffer() {
        if (hotOffer)
            return 1;
        return -1;
    }
}
