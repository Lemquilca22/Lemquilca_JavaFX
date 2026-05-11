package org.example.memory_javafx.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Tablero {
    private ArrayList<Carta> cartas;

    public Tablero() {
        this.cartas = new ArrayList<>();
    }

    public void generarCartas(){ // Para llenar el tablero en cada partida
            for (int i = 1; i <= 8; i++) {
                cartas.add(new Carta(i));
                cartas.add(new Carta(i));
            }
    }
    public void barajar(){
        Collections.shuffle(cartas);
    }
    public Carta getCarta(int indice){
        if (indice>=0 && indice < cartas.size()){
            return cartas.get(indice);
        }
        return null;
    }
}
