import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServeRequest implements Runnable {
    Socket clientSocket = null;
    DictionaryManager dictionaryManager = null;
    public ServeRequest(Socket clientSocket,DictionaryManager dictionaryManager){
        this.clientSocket=clientSocket;
        this.dictionaryManager = dictionaryManager;
    }
    @Override
    public void run() {
        try{
            String response = "";
            // Input stream
            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            // Output Stream
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
            String[] request = input.readUTF().split(" ");
            if (request[0].equals("add")){
                response = dictionaryManager.add(request[1],request[2]);
            }else if (request[0].equals(("query"))){
                response = dictionaryManager.query(request[1]);
            }else{
                response = dictionaryManager.remove(request[1]);
            }
            output.writeUTF(response);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}