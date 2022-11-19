package org.openjfx;


import java.io.DataOutputStream;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("IPaddress", 6666);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("0.85");
            dout.flush();
            dout.close();
            s.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}


