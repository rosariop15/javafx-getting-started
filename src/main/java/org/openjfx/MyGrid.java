package org.openjfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MyGrid extends VBox {
    @FXML
    GridPane myGridPane = new GridPane();

    @FXML
    TextField ipAddress = new TextField();

    @FXML
    Button btnIP = new Button();

    public MyGrid() {
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
                int IPaddress = Integer.parseInt(ipAddress.getText());
            }
        });
    }

    @FXML
    public void initialize() throws Exception {

        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");
        Button button5 = new Button("Button 5");
        Button button6 = new Button("Button 6");
        Button button7 = new Button("Button 7");
        Button button8 = new Button("Button 8");
        Button button9 = new Button("Button 9");


        myGridPane.add(button1, 0, 0, 1, 1);
        myGridPane.add(button2, 1, 0, 1, 1);
        myGridPane.add(button3, 2, 0, 1, 1);
        myGridPane.add(button4, 0, 1, 1, 1);
        myGridPane.add(button5, 1, 1, 1, 1);
        myGridPane.add(button6, 2, 1, 1, 1);
        myGridPane.add(button7, 0, 2, 1, 1);
        myGridPane.add(button8, 1, 2, 1, 1);
        myGridPane.add(button9, 2, 2, 1, 1);


        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Accepted");
            }
        });


    }

}


