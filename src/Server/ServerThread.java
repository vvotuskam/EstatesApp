package Server;

import Database.DBManager;
import User.*;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownServiceException;

public class ServerThread extends Thread {
    private Socket socket;
    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DBManager dbManager = new DBManager();

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            UserManager userManager;

            while ((userManager = (UserManager)inputStream.readObject()) != null) {

                int operationType = userManager.getOperationType();

                if (operationType == UserManager.ADD_USER) {
                    dbManager.addUser(userManager);
                }
                else if (operationType == UserManager.EDIT_USER) {
                    dbManager.editUser(userManager);
                }
                else if (operationType == UserManager.ADD_ESTATE) {
                    dbManager.addEstate(userManager);
                }
                else if (operationType == UserManager.DELETE_ESTATE) {
                    dbManager.deleteEstate(userManager);
                    System.out.println("ESTATE DELETED");
                }
                else if (operationType == UserManager.EDIT_ESTATE) {
                    System.out.println("EDITING");
                    dbManager.editEstate(userManager);
                    System.out.println("EDITED");
                }
                else if (operationType == UserManager.ADD_FAVOURITE) {
                    dbManager.addToFavourites(userManager);
                }
                else if (operationType == UserManager.ADD_MONEY) {
                    dbManager.addMoney(userManager);
                }
                else if (operationType == UserManager.VIEW_USER_ESTATES) {
                    UserManager fromServer = new UserManager(dbManager.viewUserEstates(userManager));
                    outputStream.writeObject(fromServer);
                }
                else if (operationType == UserManager.VIEW_USER_FAVOURITES) {
                    UserManager fromServer = new UserManager(dbManager.viewFavourites(userManager));
                    outputStream.writeObject(fromServer);
                }
                else if (operationType == UserManager.LOG_IN) {
                    User user = dbManager.canLogIn(userManager);
                    UserManager fromServer = new UserManager(user);
                    outputStream.writeObject(fromServer);
                }
                else if (operationType == UserManager.VIEW_ESTATES) {
                    UserManager fromServer = new UserManager(dbManager.viewEstates(userManager));
                    outputStream.writeObject(fromServer);
                }
                else if (operationType == UserManager.DELETE_FAVOURITE) {
                    dbManager.deleteFavourite(userManager);
                }
            }

        }
        catch (Exception e) {
            if (!(e instanceof EOFException))
                e.printStackTrace();
        }
    }
}
