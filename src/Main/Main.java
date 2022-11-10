package Main;


import Estates.Estate;
import GUI.*;
import Server.Server;
import User.UserManager;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import Server.*;

public class Main {
    public static void connect(UserManager userManager) {
        try {
            Socket socket = new Socket("127.0.0.1", 4500);

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            int operationType = userManager.getOperationType();

            if (operationType == UserManager.LOG_IN) {
                outputStream.writeObject(userManager);
                UserManager fromServer = (UserManager) inputStream.readObject();
                FrameLogIn.user = fromServer.getUser();
            }
            else if (operationType == UserManager.ADD_USER) {
                outputStream.writeObject(userManager);
            }
            else if (operationType == UserManager.ADD_ESTATE) {
                outputStream.writeObject(userManager);
            }
            else if (operationType == UserManager.EDIT_USER) {
                outputStream.writeObject(userManager);
            }
            else if (operationType == UserManager.EDIT_ESTATE) {
                outputStream.writeObject(userManager);
            }
            else if (operationType == UserManager.DELETE_ESTATE) {
                outputStream.writeObject(userManager);
            }
            else if (operationType == UserManager.ADD_MONEY) {
                outputStream.writeObject(userManager);
            }
            else if (operationType == UserManager.ADD_FAVOURITE) {
                outputStream.writeObject(userManager);
            }
            else if (operationType == UserManager.VIEW_USER_ESTATES) {
                outputStream.writeObject(userManager);
                UserManager fromServer = (UserManager) inputStream.readObject();
                FrameUserMyViewEstates.userEstates = fromServer.getEstates();
                FrameUserEditEstate.userEstates = fromServer.getEstates();
            }
            else if (operationType == UserManager.VIEW_USER_FAVOURITES) {
                outputStream.writeObject(userManager);
                UserManager fromServer = (UserManager) inputStream.readObject();
                FrameUserViewFavourites.favourites = fromServer.getEstates();
            }
            else if (operationType == UserManager.DELETE_FAVOURITE) {
                outputStream.writeObject(userManager);
            }
            else if (operationType == UserManager.VIEW_ESTATES) {
                outputStream.writeObject(userManager);
                UserManager fromServer = (UserManager) inputStream.readObject();
                FrameUserViewEstates.estates = fromServer.getEstates();
            }
            outputStream.close();
            inputStream.close();
            socket.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void replaceEstates(ArrayList<Estate> original, ArrayList<Estate> newOne) {
        if (original == null || newOne == null || original.size() == 0)
            return;
        else {
            for (int i = 0; i < original.size(); i++) {
                original.remove(i);
            }
            original.addAll(newOne);
        }
    }
    public static FrameMain frameMain;
    public static void main(String[] args) {
        frameMain = new FrameMain();
    }
}
