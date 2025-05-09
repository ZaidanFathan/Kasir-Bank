package org.example;

import java.sql.*;
import java.time.LocalDateTime;

public class ServicesOperation implements Services{
    private Connection connection;

    public ServicesOperation() throws SQLException{
        connection = databaseConnection.getConnection();
    }

    @Override
    public void setor(int rekeningId, int jumlahSetoran) {
        String query = "UPDATE rekening SET saldo = saldo + ? WHERE id = ?";
        String query2 = "INSERT INTO transaksi (rekening_id, tipe, jumlah, tanggal) VALUES (?,?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(query);
        PreparedStatement transactionCreated = connection.prepareStatement(query2)){
            stmt.setInt(1, jumlahSetoran);
            stmt.setInt(2, rekeningId);
            stmt.executeUpdate();

            transactionCreated.setInt(1, rekeningId);
            transactionCreated.setString(2, "setor");
            transactionCreated.setInt(3, jumlahSetoran);
            transactionCreated.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            transactionCreated.executeUpdate();
            System.out.print("Saldo berhasil disetor");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void tarikTunai(int rekeningId, int jumlahTarikTunai) {
        String query = "UPDATE rekening SET saldo = saldo - ? WHERE id = ?";
        String query2 = "INSERT INTO transaksi (rekening_id, tipe, jumlah, tanggal) VALUES (?,?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(query);
            PreparedStatement transactionCreated = connection.prepareStatement(query2)){
            stmt.setInt(1, jumlahTarikTunai);
            stmt.setInt(2, rekeningId);
            stmt.executeUpdate();

            transactionCreated.setInt(1, rekeningId);
            transactionCreated.setString(2, "tarik tunai");
            transactionCreated.setInt(3, jumlahTarikTunai);
            transactionCreated.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            transactionCreated.executeUpdate();

            System.out.print("Penarikan tunai berhasil");
        }catch (SQLException E) {
            E.printStackTrace();
        }
    }

    @Override
    public void createNasabah(int jenisRekening, String nama) {
        String query = "INSERT INTO rekening (jenis, saldo) VALUES (?,?)";
        String query2 = "INSERT INTO nasabah (nama, rekening_id) VALUES (?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement stmt2 = connection.prepareStatement(query2)) {

            if (jenisRekening == 1) {
                stmt.setString(1,"Giro");
            }else{
                stmt.setString(1,"Tabungan");
            }

            stmt.setInt(2,0);
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()){
                if (generatedKeys.next()){
                    int rekeningId = generatedKeys.getInt(1);
                    stmt2.setString(1, nama);
                    stmt2.setInt(2,rekeningId);
                    stmt2.executeUpdate();
                    System.out.println("Akun berhasil dibuat");
                }else{
                    System.out.println("Gagal mendapatkan ID rekening");
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
