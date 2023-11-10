package TP00;

// TP00.5. Va 
// Create a java program that can: 
// 1. List all reservations. 
// 2. Add new reservation. Reservation date and time must be expressed as a future time. 
// 3. Cancel/remove reservation. A Reservation can be canceled/removed if and only if it is not yet started. 
// 4. Update reservation if it is not yet started. 
// 5. Swap room between 2 reservations of the same date and time reservations 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ReservationManage {
    private List<Reservation> reservations;

    public ReservationManage() {
        this.reservations = new ArrayList<>();
    }

    public void listReservations() {
        for (Reservation reservation : reservations) {
            System.out.println(
                    reservation.getRoomNumber() + " " + reservation.getPersonName() + " " + reservation.getRemark());
        }
    }

    public void addReservation(Reservation reservation) {
        if (reservation.getStartTime().after(new Date())) {
            reservations.add(reservation);
            System.out.println("Reservation added successfully.");
        } else {
            System.out.println("Reservation date must be in the future.");
        }
    }

    public void removeReservation(Reservation reservation) {
        if (reservation.getStartTime().after(new Date())) {
            reservations.remove(reservation);
            System.out.println("Reservation removed successfully.");
        } else {
            System.out.println("Cannot remove a reservation that has already started.");
        }
    }

    public void updateReservation(Reservation oldReservation, Reservation newReservation) {
        if (oldReservation.getStartTime().after(new Date())) {
            if (newReservation.getStartTime().after(new Date())) {
                reservations.remove(oldReservation);
                reservations.add(newReservation);
                System.out.println("Reservation updated successfully.");
            } else {
                System.out.println("New reservation date must be in the future.");
            }
        } else {
            System.out.println("Cannot update a reservation that has already started.");
        }
    }

    public void swapRooms(Reservation reservation1, Reservation reservation2) {
        if (reservation1.getStartTime().equals(reservation2.getStartTime()) &&
                reservation1.getEndTime().equals(reservation2.getEndTime())) {
            String temporaryRoom = reservation2.getRoomNumber();
            reservation2.setRoomNumber(reservation1.getRoomNumber());
            reservation1.setRoomNumber(temporaryRoom);
            System.out.println("Rooms swapped successfully.");
        } else {
            System.out.println("Reservations must have the same date and time for room swapping.");
        }
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        ReservationManage manage = new ReservationManage();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu List:");
            System.out.println("1. List all reservations");
            System.out.println("2. Add new reservation");
            System.out.println("3. Cancel/remove reservation");
            System.out.println("4. Update reservation");
            System.out.println("5. Swap room between two reservations");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    manage.listReservations();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Enter room number:");
                    String roomNumber = scanner.nextLine();
                    System.out.println("Enter your name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter starting date and time (yyyy-MM-dd HH:mm):");
                    String startingDate = scanner.nextLine();
                    System.out.println("Enter ending date and time (yyyy-MM-dd HH:mm):");
                    String endingDate = scanner.nextLine();
                    System.out.println("Remarks:");
                    String remark = scanner.nextLine();

                    try {
                        Reservation newReservation = new Reservation(roomNumber, name, dateFormat.parse(startingDate),
                                dateFormat.parse(endingDate), remark);
                        manage.addReservation(newReservation);
                        System.out.println("Reservation added successfully.");
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Reservation not added.");
                    }
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Enter room number to cancel/remove the reservation:");
                    String roomNumberToRemove = scanner.nextLine();

                    Reservation reservationToRemove = null;
                    for (Reservation reservation : manage.reservations) {
                        if (reservation.getRoomNumber().equals(roomNumberToRemove)) {
                            reservationToRemove = reservation;
                            break;
                        }
                    }

                    if (reservationToRemove != null) {
                        manage.removeReservation(reservationToRemove);
                    } else {
                        System.out.println("Reservation not found or cannot be removed.");
                    }
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Enter room number of the reservation to update:");
                    String roomNumberToUpdate = scanner.nextLine();
                    System.out.println("Enter the name associated with the reservation:");
                    String nameToUpdate = scanner.nextLine();
                    System.out.println("Enter the new room number:");
                    String newRoomNumber = scanner.nextLine();
                    System.out.println("Enter the new name:");
                    String newName = scanner.nextLine();
                    System.out.println("Enter the new starting date and time (yyyy-MM-dd HH:mm):");
                    String newStartingDate = scanner.nextLine();
                    System.out.println("Enter the new ending date and time (yyyy-MM-dd HH:mm):");
                    String newEndingDate = scanner.nextLine();
                    System.out.println("Enter the new remarks:");
                    String newRemark = scanner.nextLine();

                    Reservation reservationToUpdate = null;
                    for (Reservation reservation : manage.reservations) {
                        if (reservation.getRoomNumber().equals(roomNumberToUpdate) &&
                                reservation.getPersonName().equals(nameToUpdate)) {
                            reservationToUpdate = reservation;
                            break;
                        }
                    }

                    if (reservationToUpdate != null) {
                        try {
                            Reservation updatedReservation = new Reservation(newRoomNumber, newName,
                                    dateFormat.parse(newStartingDate), dateFormat.parse(newEndingDate), newRemark);
                            manage.updateReservation(reservationToUpdate, updatedReservation);
                        } catch (ParseException e) {
                            System.out.println("Invalid date format. Reservation not updated.");
                        }
                    } else {
                        System.out.println("Reservation not found or cannot be updated.");
                    }
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("Enter the room number of the first reservation to swap:");
                    String roomNumber1 = scanner.nextLine();
                    System.out.println("Enter the room number of the second reservation to swap:");
                    String roomNumber2 = scanner.nextLine();

                    Reservation reservationNext1 = null;
                    Reservation reservationNext2 = null;

                    for (Reservation reservation : manage.reservations) {
                        if (reservation.getRoomNumber().equals(roomNumber1)) {
                            reservationNext1 = reservation;
                        } else if (reservation.getRoomNumber().equals(roomNumber2)) {
                            reservationNext2 = reservation;
                        }

                        if (reservationNext1 != null && reservationNext2 != null) {
                            break;
                        }
                    }

                    if (reservationNext1 != null && reservationNext2 != null) {
                        manage.swapRooms(reservationNext1, reservationNext2);
                    } else {
                        System.out.println("One or both of the reservations were not found.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
