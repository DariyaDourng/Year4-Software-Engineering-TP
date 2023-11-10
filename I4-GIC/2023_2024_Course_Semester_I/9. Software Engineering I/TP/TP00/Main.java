package  TP00;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Main {
    public static void main(String[] args) throws ParseException{
        SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd H:mm");
        Reservation rev=new Reservation("Moniroth", "J704", 
            df.parse("2023-10-17 7:00"),
            df.parse("2023-10-17 11:05"), "Projector and key");
    }
}