import java.net.*;
import java.io.*;
import java.util.*;

public class StringObject {

    private String theString;

    public synchronized void addString(String string) {
        this.theString = string;
        notifyAll();
    }

    public synchronized String getString() throws InterruptedException {
        wait();
        return this.theString;
    }

}
