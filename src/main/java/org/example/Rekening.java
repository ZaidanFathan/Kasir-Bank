package org.example;

public abstract class Rekening {
    private int id;

    public Rekening(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public abstract double hitungBunga();
}
