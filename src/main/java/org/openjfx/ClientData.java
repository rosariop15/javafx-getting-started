package org.openjfx;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ClientData extends VBox {
    public ClientData() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("client_data.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

}
