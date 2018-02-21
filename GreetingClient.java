import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by 95112 on 2/21/2018.
 */
public class GreetingClient {
    public static void main(String[] args)
    {
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);
        try{
            System.out.println("conneting the mainframe:"+serverName +",port:"+port);
            Socket client = new Socket(serverName,port);
            System.out.println("remote mainframe location:"+client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF("hello from 192"+client.getLocalAddress());
            InputStream inputStream = client.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            System.out.println("Server response:"+dataInputStream.readUTF());
            client.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
