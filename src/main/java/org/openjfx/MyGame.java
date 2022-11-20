package org.openjfx;
import javafx.fxml.FXML;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MyGame extends MyGrid {
    @FXML
    MyGame myGame = new MyGame();

    @FXML
    private void initialize() {
        GridUpdater server = new GridUpdater(myGame);
        server.setDaemon(true);
        server.start();
    }
    @FXML
    public void sendIP() throws IOException {
        try {
            Socket s = new Socket("10.10.24.163", 6666);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(String.valueOf(Math.random()));
            dout.flush();
            dout.close();
            s.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
