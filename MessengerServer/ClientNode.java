import java.net.*;
import java.io.*;
import java.util.*;

public class ClientNode implements Runnable {

    private StringObject commontheString;
    private PrintWriter out;
    private BufferedReader in;

    public ClientNode(BufferedReader _in, PrintWriter _out, StringObject _commontheString) {
        this.commontheString = _commontheString;
        this.in = _in;
        this.out = _out;
    }

    public void run() {

            Thread sender = new Thread ( new SenderThread( commontheString, this.out ) );
            Thread receiver = new Thread ( new ReceiverThread( commontheString, this.in ) );
            sender.start();
            receiver.start();
            try { receiver.join(); } catch ( InterruptedException e ) {}
            sender.interrupt();

    }

}
