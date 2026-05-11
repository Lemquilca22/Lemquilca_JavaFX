package org.example.memory_javafx.Model;

public class Carta {
    private int id;
    private boolean emparejada;

    public Carta(int id) {
        this.id = id;
        this.emparejada = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEmparejada() {
        return emparejada;
    }

    public void setEmparejada(boolean emparejada) {
        this.emparejada = emparejada;
    }
}
