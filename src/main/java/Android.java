import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Android {
        public static void main(String[] args) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d");
            LocalDateTime now = LocalDateTime.now().plusDays(7);
            String baslangicTarihi = dtf.format(now);
            String baslangicTarihPath = "//android.widget.TextView[@text="+baslangicTarihi+"]";


            System.out.println(baslangicTarihPath);
        }
}
