package org.example.memory_javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import org.example.memory_javafx.Model.Carta;
import org.example.memory_javafx.Model.Tablero;

public class HelloController {
    @FXML
    private GridPane gridTablero;
    private Tablero tablero;
    private Button primerBotonSeleccionado;
    private Carta primeraCartaSeleccionada;
    private boolean bloqueado = false;

    @FXML
    public void initialize(){
        tablero = new Tablero();
        tablero.generarCartas();
        tablero.barajar();

        dibujarTablero();
    }

    private void dibujarTablero(){
        for (int i = 0; i < 16; i++) {
            Button boton = new Button("?");
            boton.setPrefSize(80,100);

            int indice = i;

            boton.setOnAction(e -> manejarClick(boton, indice));

            gridTablero.add(boton, i%4,1/4);
        }
    }
}
