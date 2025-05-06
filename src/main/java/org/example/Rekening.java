package org.example;

public class Rekening {
    private int id;
    private String jenis;
    private int saldo;

    public Rekening(int id, String jenis, int saldo){
        this.id = id;
        this.jenis = jenis;
        this.saldo = saldo;
    }

    public String getJenis() {return jenis;}
    public int getSaldo() {return saldo;}

}
