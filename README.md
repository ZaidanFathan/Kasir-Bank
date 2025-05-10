# UTS Pemrograman Berorientasi Obyek 2
<ul>
  <li>Mata Kuliah: Pemrograman Berorientasi Obyek 2</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Profil
<ul>
  <li>Nama: Muhammad Zaidan Fathan Abdullah</li>
  <li>NIM: 23552012014</li>
  <li>Studi Kasus: Kasir Bank</li>
</ul>

## Judul Studi Kasus
<p>Kasir Bank</p>

## Penjelasan Studi Kasus
<p>Proyek Kasir Bank adalah sebuah aplikasi yang digunakan untuk membantu proses transaksi keuangan di sebuah bank secara efisien. Aplikasi ini bertindak sebagai sistem kasir yang melayani kebutuhan transaksi nasabah seperti penyetoran uang, penarikan, pembuatan akun, dan melihat bunga.</p>

## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance
<p>
  public class Tabungan extends Rekening{
    @Override
    public String hitungBunga() {
        return "Bunga sebesar 20%";
    }
}
</p>

### 2. Encapsulation
<p>
  private Connection connection;
</p>

### 3. Polymorphism
<p>
  public interface Services {
    void setor(int rekeningId, int jumlahSetoran);
    void tarikTunai(int rekeningId, int jumlahTarikTunai);
    void createNasabah(int jenisTabungan, String nama);
}

  public abstract String hitungBunga();
</p>

### 4. Abstract
<p>
  public abstract class Rekening {
  private int id;
  public abstract String hitungBunga();
}
</p>

## Demo Proyek
<ul>
  <li>Github: <a href="https://github.com/ZaidanFathan/Kasir-Bank/">Github</a></li>
  <li>Youtube: <a href="https://www.youtube.com/watch?v=bmrN65T-frI">Youtube</a></li>
</ul>
