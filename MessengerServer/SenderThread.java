import java.net.*;
import java.io.*;
import java.util.*;

public class SenderThread implements Runnable {

    private StringObject commontheString;
    private PrintWriter out;

    public SenderThread ( StringObject _commontheString, PrintWriter _out ) {
        this.commontheString = _commontheString;
        this.out = _out;
    }

    public void run() {

        String newString;

        while ( true ) {
            try {
                newString = commontheString.getString();
            } catch ( InterruptedException e ) {return;}


            out.println(newString);
        }

    }

}
