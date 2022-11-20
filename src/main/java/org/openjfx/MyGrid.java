package org.openjfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;


public class MyGrid implements Initializable {
    @FXML
    GridPane myGridPane = new GridPane();

    @FXML
    TextField ipAddress = new TextField();

    @FXML
    Button btnReset = new Button();

    @FXML
    Button btnIP = new Button();

    @FXML
    Button button1 = new Button();
    @FXML
    Button button2 = new Button();
    @FXML
    Button button3 = new Button();
    @FXML
    Button button4 = new Button();
    @FXML
    Button button5 = new Button();
    @FXML
    Button button6 = new Button();
    @FXML
    Button button7 = new Button();
    @FXML
    Button button8 = new Button();
    @FXML
    Button button9 = new Button();

    @FXML
    private Text winnerText;

    @FXML
    private Text loserText;

    private int playerTurn = 0;

    ArrayList<Button> buttons;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        myGridPane.add(button1, 0, 0, 1, 1);
        myGridPane.add(button2, 1, 0, 1, 1);
        myGridPane.add(button3, 2, 0, 1, 1);
        myGridPane.add(button4, 0, 1, 1, 1);
        myGridPane.add(button5, 1, 1, 1, 1);
        myGridPane.add(button6, 2, 1, 1, 1);
        myGridPane.add(button7, 0, 2, 1, 1);
        myGridPane.add(button8, 1, 2, 1, 1);
        myGridPane.add(button9, 2, 2, 1, 1);

        buttons = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));

        buttons.forEach(button -> {
            setupButton(button);
            button.setFocusTraversable(false);
        });
    }

    /*public MyGrid() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("my_grid.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        btnIP.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(ipAddress.getText());
                //String IPaddress = ipAddress.getText();
                try {
                    Socket s = new Socket(ipAddress.getText(), 6666);
                    DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                    dout.writeUTF(ipAddress.getText());
                    dout.flush();
                    dout.close();
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }*/

    public void setPlayerSymbol(Button button) {
        if (playerTurn % 2 == 0) {
            button.setText("X");
            button.setStyle("-fx-text-fill: red; -fx-font-size: 2em; ");

            playerTurn = 1;
        } else {
            button.setText("O");
            button.setStyle("-fx-font-size: 2em; ");
            playerTurn = 0;
        }
    }

    public void checkIfGameIsOver() {
        checkSuccess("X", button1, button2, button3);
        checkSuccess("X", button4, button5, button6);
        checkSuccess("X", button7, button8, button9);
        checkSuccess("X", button3, button5, button7);
        checkSuccess("X", button1, button4, button7);
        checkSuccess("X", button2, button5, button8);
        checkSuccess("X", button3, button6, button9);
        checkSuccess("X", button1, button5, button9);
        checkSuccess("X", button3, button5, button7);
        checkSuccess("O", button1, button2, button3);
        checkSuccess("O", button4, button5, button6);
        checkSuccess("O", button7, button8, button9);
        checkSuccess("O", button3, button5, button7);
        checkSuccess("O", button1, button4, button7);
        checkSuccess("O", button2, button5, button8);
        checkSuccess("O", button3, button6, button9);
        checkSuccess("O", button1, button5, button9);
        checkSuccess("O", button3, button5, button7);
    }

    private void checkSuccess(String PlayerSymbol, Button b1, Button b2, Button b3) {
        if (b1.getText().equals(PlayerSymbol) && b2.getText().equals(PlayerSymbol) && b3.getText().equals(PlayerSymbol)) {
            winnerText.setText("You won!");
            //loserText.setText("You lost !");
        }
    }

    @FXML
    void resetGame(ActionEvent event) {
        buttons.forEach(this::resetButton);
        ipAddress.setText(" ");
        winnerText.setText("Tic-Tac-Toe");
    }

    public void resetButton(Button button) {
        button.setDisable(false);
        button.setText("");
    }

    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setPlayerSymbol(button);
            button.setDisable(true);
            checkIfGameIsOver();
        });
    }

    public void sendIP(ActionEvent actionEvent) {
        btnIP.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(ipAddress.getText());
                //String IPaddress = ipAddress.getText();
                try {
                    Socket s = new Socket(ipAddress.getText(), 6666);
                    DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                    dout.writeUTF(ipAddress.getText());
                    dout.flush();
                    dout.close();
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**public void add(String) {
        buttons.getText().add((value));
    }**/
}


