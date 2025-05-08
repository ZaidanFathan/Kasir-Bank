package org.example;
import java.sql.SQLException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try{
            ServicesOperation servicesOperation = new ServicesOperation();
            Scanner scanner = new Scanner(System.in);

            while(true) {
                System.out.println("\n Menu:");
                System.out.println("1. Setor tunai:");
                System.out.println("2. Tarik Tunai");
                System.out.println("3. Daftar");
                System.out.println("4. Hitung bunga");
                System.out.println("5. Exit:");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                String rekeningId;
                String amount;
                switch (choice){
                    case 1:
                        System.out.print("Masukkan nomor rekening : ");
                        rekeningId = scanner.next();
                        System.out.print("Masukkan jumlah uang yang ingin disetorkan : ");
                        amount = scanner.next();
                        servicesOperation.setor(Integer.parseInt(rekeningId),Integer.parseInt(amount));
                        break;
                    case 2:
                        System.out.print("Masukkan nomor rekening : ");
                        rekeningId = scanner.next();
                        System.out.print("Masukkan jumlah  yang ingin anda tarik : ");
                        amount = scanner.next();
                        servicesOperation.tarikTunai(Integer.parseInt(rekeningId),Integer.parseInt(amount));
                        break;
                    case 5:
                        System.out.print("Exiting...");
                        System.exit(0);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}