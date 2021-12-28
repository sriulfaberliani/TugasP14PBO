import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 

public class TerimaGaji extends Gaji {
    

    public void tampilWaktu(){
        LocalDateTime waktu = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy || HH:mm:ss");   
        String formattedDate = waktu.format(myFormatObj);
        System.out.println("\n---------------------------");
        System.out.println("Waktu : " + formattedDate);
        System.out.println("---------------------------");
    }

}
