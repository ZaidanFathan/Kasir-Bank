package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class databaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3308/bank_system";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Koneksi Berhasil");
        }catch(SQLException e) {
            System.out.println("Koneksi Gagal: " + e.getMessage());
        }finally {
            if (connection != null) {
                try{
                    connection.close();
                    System.out.println("Koneksi ditutup");
                }catch (SQLException e){
                    System.out.println("Gagal menutup koneksi: " + e.getMessage());
                }
            }
        }
    }
}
