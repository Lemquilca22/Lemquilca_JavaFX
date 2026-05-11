package org.example.memory_javafx;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import org.example.memory_javafx.Model.Carta;
import org.example.memory_javafx.Model.Tablero;

public class HelloController {
    @FXML
    private GridPane gridTablero;
    private Tablero tablero;
    private Button primerBotonSeleccionado;
    private Carta primeraCartaSeleccionada;
    private boolean bloqueado = false;
    private int parejasEncontradas = 0;

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

            gridTablero.add(boton, i % 4,i / 4);
        }
    }

    private void manejarClick(Button botonActual, int indice){
        Carta cartaActual = tablero.getCarta(indice);

        if (bloqueado || cartaActual.isEmparejada() || botonActual == primerBotonSeleccionado){
            return;
        }

        botonActual.setText(String.valueOf(cartaActual.getId()));

        if (primeraCartaSeleccionada == null ){
            primeraCartaSeleccionada = cartaActual;
            primerBotonSeleccionado = botonActual;
        } else {
            if (cartaActual.getId() == primeraCartaSeleccionada.getId()){
                cartaActual.setEmparejada(true);
                primeraCartaSeleccionada.setEmparejada(true);
                parejasEncontradas++;
                limpiarSeleccion();

                if (parejasEncontradas == 8 ){
                    finalizarJuego();
                }
            } else {
                bloqueado=true;
                PauseTransition pausa = new PauseTransition(Duration.seconds(1));
                pausa.setOnFinished(e -> {
                    botonActual.setText("?");
                    primerBotonSeleccionado.setText("?");
                    limpiarSeleccion();
                    bloqueado=false;
                });
                pausa.play();
            }
        }
    }
    private void limpiarSeleccion(){
        primeraCartaSeleccionada = null;
        primerBotonSeleccionado = null;
    }
    private void finalizarJuego() {
        javafx.scene.control.Alert alerta = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alerta.setTitle("¡Juego Terminado!");
        alerta.setHeaderText(null);
        alerta.setContentText("¡Felicidades! Has encontrado todas las parejas.");
        alerta.showAndWait();
    }
}
