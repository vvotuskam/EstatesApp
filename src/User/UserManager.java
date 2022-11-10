package User;

import Estates.Estate;

import java.io.Serializable;
import java.util.ArrayList;

public class UserManager implements Serializable {
    private User user;
    private Estate estate;
    private ArrayList<Estate> estates;
    private int operationType;
    private int money;
    private String password;
    private String email;
    private boolean hotOffer;
    private int canEnter;
    private String filterType;
    private String estateType;

    public String getFilterType() {
        return filterType;
    }

    public String getEstateType() {
        return estateType;
    }

    public static final int LOG_IN = 0;

    public static final int ADD_USER = 10;
    //public static final int DELETE_USER = 11;
    public static final int EDIT_USER = 12;

    public static final int ADD_ESTATE = 20;
    public static final int DELETE_ESTATE = 21;
    public static final int EDIT_ESTATE = 22;
    public static final int VIEW_USER_ESTATES = 23;

    public static final int ADD_FAVOURITE = 30;
    public static final int DELETE_FAVOURITE = 31;
    public static final int VIEW_USER_FAVOURITES = 32;

    public static final int ADD_MONEY = 40;
    public static final int BUY_HOT_OFFER = 41;

    public static final int VIEW_ESTATES = 50;


    /**
    REQUEST MANAGERS
     */
    //LOG IN
    public UserManager(int operationType, String password, String email) {
        this.operationType = operationType;
        this.password = password;
        this.email = email;
    }

    //ADD-EDIT USER
    //VIEW-USER-ESTATES
    //VIEW-USER-FAVOURITES
    //BUY HOT OFFER
    public UserManager(int operationType, User user) {
        this.user = user;
        this.operationType = operationType;
    }

    //ADD-DELETE-EDIT ESTATE
    //ADD-DELETE FAVOURITES
    public UserManager(int operationType, User user, Estate estate) {
        this.user = user;
        this.estate = estate;
        this.operationType = operationType;
    }

    //ADD MONEY
    public UserManager(int operationType, User user, int money) {
        this.user = user;
        this.money = money;
        this.operationType = operationType;
    }

    //VIEW_ESTATE
    public UserManager(int operationType, User user, String filterType, String estateType) {
        this.user = user;
        this.operationType = operationType;
        this.filterType = filterType;
        this.estateType = estateType;
    }

    /**
    ANSWER MANAGERS
     */
    public UserManager(User user) {
        this.user = user;
    }
    public UserManager(Estate estate) {
        this.estate = estate;
    }
    public UserManager(boolean hotOffer) {
        this.hotOffer = hotOffer;
    }

    public UserManager(int canEnter) {
        //1 - can enter
        //-1 - not
        this.canEnter = canEnter;
    }
    public UserManager(ArrayList<Estate> estates) {
        this.estates = estates;
    }

    /**
     GETTERS AND SETTERS
     */
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }

    public ArrayList<Estate> getEstates() {
        return estates;
    }

    public void setEstates(ArrayList<Estate> estates) {
        this.estates = estates;
    }

    public int getOperationType() {
        return operationType;
    }

    public void setOperationType(int operationType) {
        this.operationType = operationType;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getHotOffer() {
        return hotOffer;
    }

    public void setHotOffer(Boolean hotOffer) {
        this.hotOffer = hotOffer;
    }
}