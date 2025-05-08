package org.example;

public class Giro extends Rekening{
    private String jenis;
    private int saldo;

    public Giro(int id, String jenis, int saldo){
        super(id);
        this.jenis = jenis;
        this.saldo = saldo;
    }

    public String getJenis() {return jenis;}
    public int getSaldo() {return saldo;}

    @Override
    public double hitungBunga() {
        return this.saldo * 0.5;
    }
}
