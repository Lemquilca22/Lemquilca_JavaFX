package org.example.helloworld;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label HelloWolrdText;

    @FXML
    protected void onHelloButtonClick() {
        HelloWolrdText.setText("Hello World!");
    }
}
