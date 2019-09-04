import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

public class DictionaryClient {
    public String sendRequest(String requestType,String requestContent,String ip,int port){
        String output="";
        String content="";
        if(requestType.equals("query")){
            content="query"+" "+requestContent+"\n";
        }else if(requestType.equals("add")){
            content="add"+" "+requestContent+"\n";
        }else{
//            remove words from dictionary
            content="remove"+" "+requestContent+"\n";
        }
        output = send(content,ip,port);
        return output;
    }
    public String send(String content,String ip,int port){
        String output="";
        try {
            Socket socket = new Socket(ip, port);
            // Get the input/output streams for reading/writing data from/to the socket
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
            bufferedWriter.write(content);
            bufferedWriter.flush();
            System.out.println("Request sent:"+content);
            output=bufferedReader.readLine();
            System.out.println("Response Received:"+output);
            output = output.trim();
            bufferedWriter.close();

        } catch (IOException e) {
            output = "Failed: "+ e;
        }
        return output;
    }
}