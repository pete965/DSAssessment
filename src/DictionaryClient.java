import java.io.*;
import java.net.Socket;

public class DictionaryClient {
    public String sendRequest(String requestType,String requestContent,String ip,int port){
        String output="";
        String content="";
        if(requestType.equals("query")){
            content="query"+" "+requestContent;
        }else if(requestType.equals("add")){
            content="add"+" "+requestContent;
        }else{
//            remove words from dictionary
            content="remove"+" "+requestContent;
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
            System.out.println("Request sent");
            output=bufferedReader.readLine();
        } catch (IOException e) {
            // TODO: 2019/9/2 handle exception and display it;Exceptions consists multiple kinds
            e.printStackTrace();
        }
        return output;
    }
}