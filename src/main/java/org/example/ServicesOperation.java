package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
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
    public void createNasabah(Rekening rekening, String jenis) {

    }
}
