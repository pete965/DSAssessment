import javax.net.ServerSocketFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DictionaryServer {
    public static int port = 0;
    public static String dic = "";
    public static int numberOfUser = 0;
    public static int numberOfWorks = 10;
    public static void main(String[] args) {
        port = Integer.parseInt(args[0]);
        dic = args[1];
//        Returns a copy of the environment's default socket factory.
        ServerSocketFactory factory = ServerSocketFactory.getDefault();
        Executor executor = Executors.newFixedThreadPool(numberOfWorks);
        try{
//            Returns an unbound server socket. The socket is configured with the socket options (such as accept timeout) given to this factory.
            ServerSocket server = factory.createServerSocket(port);
            while(true){
//                Listens for a connection to be made to this socket and accepts it.
                Socket clientSocket = server.accept();
                numberOfUser++;
                // TODO: 2019/8/30 Start a new thread for a connection
//                executor.execute(new Task());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
