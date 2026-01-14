import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {

    public Consumer<Socket> getConsumer() {
        return (clientSocket) -> {
            try (PrintWriter toClient =
                     new PrintWriter(clientSocket.getOutputStream(), true)) {

                toClient.println("Hello from the server");
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    public static void main(String[] args) {
        int port = 8010;
        Server server = new Server();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                final Socket socketForThread = serverSocket.accept();
                new Thread(() -> server.getConsumer().accept(socketForThread)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
