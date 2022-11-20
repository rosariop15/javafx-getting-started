package org.openjfx;
import javafx.fxml.FXML;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MyGame extends MyGrid {
    public int winner = -5;

    public int player = 1;
    public int[][] advance = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};


    public void won() {
        String win;
        int i;
        int j;
        for(i = 0; i < 3; ++i) {
            win = "True";

            for(j = 0; j < 3; ++j) {
                if (this.advance[i][j] != this.player) {
                    win = "false";
                    break;
                }
            }

            if (win == "True") {
                this.winner = this.player;
            }
        }

        for(i = 0; i < 3; ++i) {
            win = "True";

            for(j = 0; j < 3; ++j) {
                if (this.advance[j][i] != this.player) {
                    win = "false";
                    break;
                }
            }

            if (win == "True") {
                this.winner = this.player;
            }
        }

        for(i = 0; i < 3; ++i) {
            win = "True";
            if (this.advance[i][i] != this.player) {
                win = "false";
                break;
            }

            if (win == "True") {
                this.winner = this.player;
            }
        }

        for(i = 0; i < 3; ++i) {
            win = "True";
            if (this.advance[2 - i][2 - i] != this.player) {
                win = "false";
                break;
            }

            if (win == "True") {
                this.winner = this.player;
            }
        }

    }

    public void isnull() {
        String win = "tie";

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                if (this.advance[i][j] == 0) {
                    win = "false";
                    break;
                }
            }
        }

        if (win == "tie") {
            this.winner = 0;
        }

    }

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
