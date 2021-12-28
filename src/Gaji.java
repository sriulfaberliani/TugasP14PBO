import java.util.InputMismatchException;
import java.util.Scanner;
import com.mysql.cj.protocol.Resultset;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class Gaji implements PTABC  {
    static Connection con;
	String url = "jdbc:mysql://localhost:3306/db_gaji";
    public int noPegawai;
    public String namaPegawai;
    public String email;
    public int jabatan;
    public String jabatann;
    public int gajiPokok;
    public int jmlHariMasuk;
    public int potongan;
    public int totalGaji;

    Scanner input = new Scanner(System.in);

    @Override
    public void show() throws SQLException {
        System.out.println("TAMPILAN INFO GAJI");
						
		String sql ="SELECT * FROM karyawan";
		con = DriverManager.getConnection(url,"root","");
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next()){
            System.out.print("\nNama Pegawai\t\t : ");
            System.out.print(result.getString("nama"));
			System.out.print("\nNomor Pegawai\t\t : ");
            System.out.print(result.getInt("no_pegawai"));
            System.out.print("\nEmail Pegawai\t\t : ");
            System.out.print(result.getString("email"));
            System.out.print("\nJabatan\t\t\t : ");
            System.out.print(result.getString("jabatan"));
            System.out.print("\nJumlah Hari Kerja\t : ");
            System.out.print(result.getInt("jumlah_hari_kerja"));
            System.out.print("\nGaji Pokok\t\t : ");
            System.out.print(result.getInt("gaji_pokok"));
            System.out.print("\nPotongan\t\t : ");
            System.out.print(result.getInt("potongan_gaji"));
            System.out.print("\nTotal gaji\t\t : ");
            System.out.print(result.getInt("total_gaji"));
            System.out.print("\n");
		}
	}

    @Override
    public void insert() throws SQLException {
        System.out.println("Input Data Karyawan");
		
    	try {
        // Nama Pegawai
        System.out.print("Nama Pegawai \t\t : ");
        this.namaPegawai = input.next();

        // No Pegawai
        System.out.print("No Pegawai \t\t : ");
        this.noPegawai = input.nextInt();

        // Email Pegawai
        System.out.print("Email Pegawai \t\t : ");
        this.email = input.next();

        // Pilih Jabatan
        System.out.println("==List Jabatan== \n 1 = Direktur Utama \n 2 = Direktur Keuangan \n 3 = Manajer Pemasaran \n 4 = Bagian Produksi \n 5 = Cleaning Service");
        
        int fail = 0;
        do{
            try{
                System.out.println("Inputkan Jabatan Anda : ");
                this.jabatan = input.nextInt();
                input.nextLine();
                if(this.jabatan<1 || this.jabatan>5)
                {
                System.out.println("Inputan harus angka 1-5");
                }
            } catch (Exception e){
                fail += 1;
                if (fail > 2) {
                    System.out.println("Mohon Inputkan Angka dari 1 hingga 5!!");
                    } else {
                    System.out.println("Mohon Inputkan inputan berupa angka!");
                    }
                    input.nextLine();
                    }
                    } while (this.jabatan < 1 || this.jabatan > 5);
                    if(this.jabatan == 1){
                        jabatann = "Direktur Utama";
                    }
                    else if(this.jabatan == 2){
                        jabatann = "Direktur Keuangan";
                    }
                    else if(jabatan == 3){
                        jabatann = "Manajer Pemasaran";
                    }
                    else if(jabatan == 4){
                        jabatann = "Bagian Produksi";
                    }
                    else if(jabatan == 5){
                        jabatann = "Cleaning Service";
                    }
            
        
        // Gaji Pokok
        switch(jabatann){
            case "Direktur Utama" : 
            gajiPokok = 12000000;
            break;
            case "Direktur Keuangan" :
            gajiPokok = 10000000;
            break;
            case "Manajer Pemasaran" :
            gajiPokok = 8000000;
            break;
            case "Bagian Produksi" :
            gajiPokok = 5000000;
            break;
            case "Cleaning Service" :
            gajiPokok = 3000000;
            break;
        }


        // Jumlah hari masuk
        this.jmlHariMasuk = jmlHariMasuk;
        
        
        do{
            try{
                System.out.println("Inputkan Jumlah Hari Kerja anda : ");
                this.jmlHariMasuk = input.nextInt();
                if(this.jmlHariMasuk<1 || this.jmlHariMasuk>30)
            {
            System.out.println("Inputan harus berupa angka 1-30");
            }
            } catch (Exception e ){
                fail +=1;
                if(fail > 2){
                    System.out.println("Mohon Input Angka 1-30!");
                } else {
                    System.out.println("Input harus berupa Angka!");
                } input.nextLine();
            }
        } while (this.jmlHariMasuk <1 || this.jmlHariMasuk >30);

        //Potongan
        potongan = (30-jmlHariMasuk)*100000;

        //Total gaji
        totalGaji = gajiPokok - potongan;

        String sql = "INSERT INTO karyawan (nama,no_pegawai,email,  jabatan, jumlah_hari_kerja, gaji_pokok, potongan_gaji, total_gaji) VALUES ('"+namaPegawai+"','"+noPegawai+"','"+email+"','"+jabatann+"','"+jmlHariMasuk+"','"+gajiPokok+"','"+potongan+"','"+totalGaji+"')";
        con = DriverManager.getConnection(url,"root","");
        Statement statement = con.createStatement();
        statement.execute(sql);
        System.out.println("DATA BERHASIL DIINPUT!");
    }
    catch (SQLException e) {
        System.err.println("DATA GAGAL DIINPUT");
    } 
    catch (InputMismatchException e) {
        System.err.println("Inputan harus berupa angka");
       }
    }

    @Override
    public void update() throws SQLException{
        System.out.println("Update Data Pegawai");
        try {
            show();
            System.out.print("\nMasukkan Nomor Pegawai yang akan di ubah : ");
            Integer noPegawai = Integer.parseInt(input.nextLine());
            
            String sql = "SELECT * FROM karyawan WHERE no_pegawai = " +noPegawai;
            con = DriverManager.getConnection(url,"root","");
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            if(result.next()){
                
                System.out.print("Nama baru ["+result.getString("nama")+"]\t: ");
                String namaPegawai = input.nextLine();
                   
                sql = "UPDATE karyawan SET nama='"+namaPegawai+"' WHERE no_pegawai='"+noPegawai+"'";
                //System.out.println(sql);

                if(statement.executeUpdate(sql) > 0){
                    System.out.println("Berhasil memperbaharui data pegawai ("+noPegawai+")");
                }
            }
            statement.close();        
        } 
		catch (SQLException e) {
        	System.err.println("Terjadi kesalahan dalam mengedit data");
            System.err.println(e.getMessage());
        }
	}
    

    @Override
    public void delete() {
		System.out.println("Hapus Data Pegawai");
		
		try{
	        show();
            System.out.print("\nInput No Pegawai : ");
            String keyword = input.nextLine();
	        
	        String sql = "DELETE FROM karyawan WHERE no_pegawai LIKE '%"+keyword+"%'";
	        con = DriverManager.getConnection(url,"root","");
	        Statement statement = con.createStatement();
	        //ResultSet result = statement.executeQuery(sql);
	        
	        if(statement.executeUpdate(sql) > 0){
	            System.out.println("Data Pegawai Sudah Dihapus (Pegawai "+noPegawai+")");
	        }
	   }
		catch(SQLException e){
	        System.out.println("Penghapusan Data Gagal");
	    }
        catch(Exception e){
            System.out.println("Input data yang benar!");
        }
	}

    @Override
    public void search() throws SQLException {
		System.out.println("Cari Data Karyawan");
				
		System.out.print("Masukkan Nama Pegawai yang ingin dilihat : ");    
		String keyword = input.nextLine();
		
		String sql = "SELECT * FROM karyawan WHERE nama LIKE '%"+keyword+"%'";
		con = DriverManager.getConnection(url,"root","");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql); 
                
        while(result.next()){
        	System.out.print("\nNomor pegawai\t  : ");
            System.out.print(result.getInt("no_pegawai"));
            System.out.print("\nNama pegawai\t  : ");
            System.out.print(result.getString("nama"));
            System.out.print("\nEmail pegawai\t  : ");
            System.out.print(result.getString("email"));
            System.out.print("\nJabatan\t\t  : ");
            System.out.print(result.getString("jabatan"));
            System.out.print("\nGaji Pokok\t  : ");
            System.out.print(result.getInt("gaji_pokok"));
            System.out.print("\nJumlah hari masuk : ");
            System.out.print(result.getInt("jumlah_hari_kerja"));
            System.out.print("\nPotongan gaji\t  : ");
            System.out.print(result.getInt("potongan_gaji"));
            System.out.print("\nTotal gaji\t  : ");
            System.out.print(result.getInt("total_gaji"));
            System.out.print("\n");
        }
    }
}


