package org.example.helloworldtest;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloWorldTest {

    @FXML
    private Button btnEnviar;

    @FXML
    private Label helloText;

    @FXML
    public void mostrarTexto(){
        helloText.setText("¡Hola Mundo!");
        System.out.println("Boton presionado");
    }
}