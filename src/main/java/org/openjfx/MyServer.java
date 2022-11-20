package org.openjfx;

import java.net.*;
import java.io.*;


public class MyServer extends Thread {

    //private PrimaryController primaryController;
    //public MyServer(PrimaryController primaryController) {
     //   this.primaryController = primaryController;
    //}
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept(); //establishes connection
            DataInputStream dis = new DataInputStream(s.getInputStream());

            String str = (String) dis.readUTF();
            System.out.println("message= " + str);

            Thread updater = new Thread(new Runnable() {
                @Override
                public void run() {
                    //primaryController.updateUI(Integer.valueOf(str));
                }
            });

            ss.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
