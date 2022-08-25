import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        System.out.println("server started");
        int port = 80;
        String name = null;


        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println("New connection accepted");

            while (true) {

                String clientResponse = in.readLine();
                System.out.println(clientResponse);
                String[] tags = clientResponse.split("/");

                switch (tags[0]) {
                    case "access":
                        out.println("1/ Hi, please enter your name");
                        break;
                    case "name":
                        out.println("2/ Are you child?");
                        name = tags[1];
                        break;
                    case "resp yes":
                        out.println(String.format("3/ Hi %s welcome to kids area! Lets play!", name));
                        break;
                    case "resp no":
                        out.println(String.format("3/ Hi %s welcome to adult area", name));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
