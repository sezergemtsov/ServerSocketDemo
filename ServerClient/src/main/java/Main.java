import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 80;

        try (Socket clientSocket = new Socket(host, port)) {

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println("access/request to connect");

            while (true) {

                String serverResp = in.readLine();
                System.out.println(serverResp);
                String[] tags = serverResp.split("/");

                switch (tags[0]) {
                    case "1":
                        out.println("name/Sasha");
                        System.out.println("name/Sasha");
                        break;
                    case "2":
                        out.println("resp yes/request to connect");
                        System.out.println("resp yes/request to connect");
                        break;
                    case "3":
                        System.out.println("Сессия завершена");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
