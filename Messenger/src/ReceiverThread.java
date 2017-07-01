
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JTextArea;

public class ReceiverThread implements Runnable{
    
    private JTextArea outputArea;
    private BufferedReader in;
    
    public ReceiverThread ( BufferedReader _in, JTextArea outputarea ) {
        this.in = _in;
        this.outputArea = outputarea;
    }


    
    
    public void run() {
        String string;
       
        try {
            while( (string = in.readLine()) != null ) {
                this.outputArea.append('\n' + string);
                this.outputArea.moveCaretPosition( (this.outputArea.getText()).length() );
            }
        } catch (IOException e) {}
            
    }
    
}
