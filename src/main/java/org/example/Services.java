package org.example;

public interface Services {
    void setor(int rekeningId, int jumlahSetoran);
    void tarikTunai(int rekeningId, int jumlahTarikTunai);
    void createNasabah(Rekening rekening, String jenis);
}
