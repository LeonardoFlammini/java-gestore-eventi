package org.eventsmanager;

import java.time.LocalDate;
import java.util.Scanner;

import org.eventsmanager.exceptions.InvalidDateException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            Event event = new Event("Concert", LocalDate.of(2024, 12, 25), 100);

            int num_of_seats = 0;

            System.out.println("1 - book\n2 - cancel\n3 - seats info");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    System.out.println("How many seats to book?");
                    num_of_seats = Integer.parseInt(scanner.nextLine());
                    event.book(num_of_seats);
                    break;
                case"2":
                    System.out.println("How many seats to cancel?");
                    num_of_seats = Integer.parseInt(scanner.nextLine());
                    event.cancelBooking(num_of_seats);
                    break;
                case "3":
                    event.printSeats();
                    break;
                default:
                    break;
            }




        } catch (InvalidDateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }


    }
}
