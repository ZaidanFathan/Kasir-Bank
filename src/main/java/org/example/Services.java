package org.example;

public interface Services {
    void setor(int rekeningId, int jumlahSetoran);
    void tarikTunai(int rekeningId);
    void createNasabah(Nasabah nasabah, Rekening rekening);
}
