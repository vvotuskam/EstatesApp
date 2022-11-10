package Server;

import java.net.ServerSocket;
import java.net.Socket;
import Main.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4500);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("User Connected");

                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
