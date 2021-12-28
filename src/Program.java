import java.util.Scanner;
import java.sql.*;
import java.util.InputMismatchException;
import com.mysql.cj.protocol.Resultset;
import java.io.BufferedReader;
import java.io.FileReader;

public class Program {
    static Connection con;

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner (System.in);
    	String inputanPengguna;
    	boolean isLanjutkan = true;
        String url = "jdbc:mysql://localhost:3306/db_gaji";
        try {
            TerimaGaji trmgj = new TerimaGaji();
           
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection(url,"root","");
            System.out.println("\nKONEKSI KE DATABASE SUDAH BERHASIL");
            while (isLanjutkan) {
                //replace kalimat
                String sapa="oi";
                String ubahkalimat = sapa.replace("oi", "\nSelamat pagi :)\n");
                System.out.println(ubahkalimat);

                //input password(equal)
                System.out.println("Masukkan Password : ");
                String password1 = input.nextLine();
                password1 = password1;
                String password2="abcmantap"; 
                System.out.println("\nPassword " +password1.equals(password2));

                 if(password1.equals(password2)){
                    trmgj.tampilWaktu();
                    System.out.println("===PROGRAM GAJI KARYAWAN PT ABC===");
                    System.out.println("Pilihan Menu");
                    System.out.println("1. Lihat Data Pegawai");
                    System.out.println("2. Tambah Data Pegawai");
                    System.out.println("3. Ubah Data Pegawai");
                    System.out.println("4. Hapus Data Pegawai");
                    System.out.println("5. Cari Data Pegawai");
                    
                    System.out.print("\nSILAHKAN PILIH MENU (1-5): ");
                    inputanPengguna = input.next();
                    
                    switch (inputanPengguna) {
                    case "1":
                        trmgj.show();
                        break;
                    case "2":
                        trmgj.insert();
                        break;
                    case "3":
                        trmgj.update();
                        break;
                    case "4":
                        trmgj.delete();
                        break;
                    case "5":
                        trmgj.search();
                        break;
                    default:
                        System.err.println("\nMOHON INPUT DENGAN BENAR!(1-5)");
                    }
                    
                    System.out.print("\nMasih Ingin Menggunakan Program? [y/t] ");
                    inputanPengguna = input.next();
                    isLanjutkan = inputanPengguna.equalsIgnoreCase("y");
        
                }
            }System.out.println("PROGRAM SELESAI");
        }
        
        catch(ClassNotFoundException ex) {
            System.err.println("DRIVER ERROR");
            System.exit(0);
        }

        catch (Exception e) {
            System.err.println("KONEKSI KE DATABASE GAGAL" +e.getMessage());
        }
        finally{
            System.out.println("\nPROGRAM SELESAI\n");
 
        }
        
    }
}