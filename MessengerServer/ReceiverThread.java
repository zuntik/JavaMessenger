import java.net.*;
import java.io.*;
import java.util.*;

public class ReceiverThread implements Runnable {

    private StringObject commontheString;
    private BufferedReader in;

    public ReceiverThread( StringObject _commontheString, BufferedReader _in ) {
        this.commontheString = _commontheString;
        this.in = _in;
    }

    public void run() {

        String newLine;

        try {
            while( (newLine = this.in.readLine()) != null ) {
                commontheString.addString(newLine);
            }
        } catch ( IOException e ) {commontheString.addString("A user became offline");}

    }

}
