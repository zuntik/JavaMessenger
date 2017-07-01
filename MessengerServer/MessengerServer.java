import java.net.*;
import java.io.*;
import java.util.*;

public class MessengerServer {





    public static void main(String[] args) {

        int portNumber = 1234;


        try ( ServerSocket server = new ServerSocket(portNumber) ) {

            StringObject theString = new StringObject();
            Socket client;
            BufferedReader in;
            PrintWriter out;

            while ( true ) {
                client = server.accept();
                out = new PrintWriter(client.getOutputStream(), true); // is what leaves
                in = new BufferedReader( new InputStreamReader(client.getInputStream())); // is what enteres
                (new Thread( new ClientNode( in, out, theString ) ) ).start();
            }


        }


        catch( IOException e ) {
            System.out.println("Problem when trying to listen to port: "+ portNumber );
            System.exit(0);
        }







    }
}
