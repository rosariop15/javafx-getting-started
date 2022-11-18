package org.openjfx;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javafx.fxml.FXML;

public class PrimaryController {
    @FXML
    MyGrid myGrid = new MyGrid();


/*
    @FXML
    private void initialize() {
        ChartUpdater server = new ChartUpdater(myChart);
        server.setDaemon(true);
        server.start();
    }*/

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void addClientData() throws IOException {
        try {
            Socket s = new Socket("192.168.35.47", 6666);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("0.85");
            dout.flush();
            dout.close();
            s.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
/*
    @FXML
    private void setIPAdress() throws IOException {

    }*/
    }

