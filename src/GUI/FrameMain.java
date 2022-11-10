package GUI;

import javax.swing.*;

public class FrameMain extends JFrame {
    public static FrameDefault frameDefault;
    public static FrameSignUp frameSignUp;
    public static FrameLogIn frameLogIn;
    public static FrameUser frameUser;

    public static FrameUserInfo frameUserInfo;
    public static FrameUserAddMoney frameUserAddMoney;
    public static FrameUserMyViewEstates frameUserMyViewEstates;
    public static FrameUserViewEstates frameUserViewEstates;
    public static FrameUserAddEstate frameUserAddEstate;
    public static FrameUserViewFavourites frameUserViewFavourites;
    public static FrameUserEditAccount frameUserEditAccount;
    public static FrameUserEditEstate frameUserEditEstate;


    public FrameMain() {
        setSize(500, 500);
        setTitle("Apartments - Sale and Rent");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);

        frameDefault = new FrameDefault();
        frameDefault.setVisible(true);
        frameDefault.setLocation(0, 0);
        add(frameDefault);

        frameSignUp = new FrameSignUp();
        frameSignUp.setLocation(0, 0);
        frameSignUp.setVisible(false);
        add(frameSignUp);

        frameLogIn = new FrameLogIn();
        frameLogIn.setLocation(0, 0);
        frameLogIn.setVisible(false);
        add(frameLogIn);

        frameUser = new FrameUser();
        frameUser.setLocation(0, 0);
        frameUser.setVisible(false);
        add(frameUser);

        frameUserEditAccount = new FrameUserEditAccount();
        frameUserEditAccount.setLocation(0, 0);
        frameUserEditAccount.setVisible(false);
        add(frameUserEditAccount);

        frameUserAddEstate = new FrameUserAddEstate();
        frameUserAddEstate.setLocation(0, 0);
        frameUserAddEstate.setVisible(false);
        add(frameUserAddEstate);

        frameUserMyViewEstates = new FrameUserMyViewEstates();
        frameUserMyViewEstates.setLocation(0, 0);
        frameUserMyViewEstates.setVisible(false);
        add(frameUserMyViewEstates);

        frameUserInfo = new FrameUserInfo();
        frameUserInfo.setLocation(0, 0);
        frameUserInfo.setVisible(false);
        add(frameUserInfo);

        frameUserViewEstates = new FrameUserViewEstates();
        frameUserViewEstates.setLocation(0, 0);
        frameUserViewEstates.setVisible(false);
        add(frameUserViewEstates);

        frameUserAddMoney = new FrameUserAddMoney();
        frameUserAddMoney.setLocation(0, 0);
        frameUserAddMoney.setVisible(false);
        add(frameUserAddMoney);

        frameUserViewFavourites = new FrameUserViewFavourites();
        frameUserViewFavourites.setLocation(0, 0);
        frameUserViewFavourites.setVisible(false);
        add(frameUserViewFavourites);

        frameUserEditEstate = new FrameUserEditEstate();
        frameUserEditEstate.setLocation(0, 0);
        frameUserEditEstate.setVisible(false);
        add(frameUserEditEstate);


    }
}
