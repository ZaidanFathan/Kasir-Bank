package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServicesOperation implements Services{
    private Connection connection;
    @Override
    public void setor(int rekeningId, int jumlahSetoran) {
        String query = "UPDATE rekening SET saldo = saldo + ? WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, jumlahSetoran);
            stmt.setInt(2, rekeningId);
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void tarikTunai(int rekeningId) {

    }

    @Override
    public void createNasabah(Nasabah nasabah, Rekening rekening) {

    }
}
