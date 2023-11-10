package TP00;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class ReservationTest {
     public static void main(String[] args) throws ParseException {
 List<Reservation> reservations = new ArrayList<>(); // Create an empty list to hold reservations
Scanner scanner = new Scanner(System.in);


SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");

System.out.print("Enter room number: ");
String roomNumber = scanner.nextLine();

System.out.print("Enter person name: ");
String personName = scanner.nextLine();

System.out.print("Enter start date/time (MM/dd/yyyy HH:mm): ");
Date startTime = dateFormat.parse(scanner.nextLine());

System.out.print("Enter end date/time (MM/dd/yyyy HH:mm): "); 
Date endTime = dateFormat.parse(scanner.nextLine());

System.out.print("Enter remarks (optional): ");
String remarks = scanner.nextLine();

Reservation reservation;

try {
  reservation = new Reservation(roomNumber, personName, startTime, endTime, remarks);
  System.out.println("Reservation created!");
} catch (Exception e) {
  System.out.println("Invalid reservation details: " + e.getMessage());
  return;
}

// Print reservation details
System.out.println(reservation.getRoomNumber());
System.out.println(reservation.getPersonName());
System.out.println(reservation.getStartTime());
System.out.println(reservation.getEndTime());
    if(!remarks.isEmpty()){
      System.out.println(reservation.getRemark()); 
    }
}
}
