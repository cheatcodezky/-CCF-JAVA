import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Created by 95112 on 2/21/2018.
 */
public class GreetingServer extends Thread {
    private ServerSocket serverSocket;
    public GreetingServer(int port) throws IOException{
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void run(){
        while (true){
            try{
                System.out.println("waiting the connecting from client, port : "+ serverSocket.getLocalPort());
                Socket server = serverSocket.accept();
                System.out.println("remote mainframe location :"+ server.getRemoteSocketAddress());
                DataInputStream dataInputStream = new DataInputStream(server.getInputStream());
                System.out.println(dataInputStream.readUTF());
                DataOutputStream dataOutputStream = new DataOutputStream(server.getOutputStream());
                dataOutputStream.writeUTF("Thanks for your connecting:"+server.getLocalSocketAddress()+"\n Goodbye");
                server.close();
            }catch (SocketTimeoutException e){
                System.out.println("Socket timed out");
                break;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args)
    {
        int port = Integer.parseInt(args[0]);
        try{
            Thread t = new GreetingServer(port);
            t.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
