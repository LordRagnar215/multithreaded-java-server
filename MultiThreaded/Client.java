import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public Runnable getRunnable() {
        return () -> {
            int port = 8010;
            try {
                InetAddress address = InetAddress.getByName("localhost");

                try (Socket socket = new Socket(address, port);
                     PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
                     BufferedReader fromSocket = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {

                    toSocket.println("Hello from Client " + socket.getLocalSocketAddress());

                    String line = fromSocket.readLine();
                    System.out.println("Response from Server: " + line);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        };
    }

    public static void main(String[] args) {

        Client client = new Client();

        for (int i = 0; i < 100; i++) {
            new Thread(client.getRunnable()).start();

       try {
                Thread.sleep(1);  // prevents Connection Refused errors
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
