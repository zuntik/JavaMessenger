
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

public class Messenger {
    
    
        
    public static void main(String args[]) {
        
        String hostName, userName;
        int portNumber = 1234;

        hostName = (String)JOptionPane.showInputDialog( null, "Specify the HostName:",
                    "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, "localhost");
        userName = (String)JOptionPane.showInputDialog( null, "Specify your user name:",
                    "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, "example");
        if (hostName == null || hostName.length() == 0 || userName == null || userName.length() == 0 )
            System.exit(0);
        
        
        
        
        try(
            Socket mserver = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(mserver.getOutputStream(), true);
            BufferedReader in = new BufferedReader( new InputStreamReader(mserver.getInputStream()));
        ){

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {  new GUI(userName, in, out).setVisible(true);  }
            });            
            
            mserver.setKeepAlive(true);
            
            try {Thread.sleep(1200000);} catch (InterruptedException e) {}
            
        } catch ( UnknownHostException e )  {
            
        } catch( IOException e ) {
            
        } 
            
        
        

        
        
        
    }


}
