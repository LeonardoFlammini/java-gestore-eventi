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
            String choice = "";

            while (!choice.equals("4")) {
                System.out.println("1 - book\n2 - cancel\n3 - seats info\n4 - quit");
                choice = scanner.nextLine();
                switch (choice){
                    case "1":
                        System.out.println("How many seats to book?");
                        num_of_seats = Integer.parseInt(scanner.nextLine());
                        event.book(num_of_seats);
                        System.out.println(event.printSeats());
                        break;
                    case"2":
                        System.out.println("How many seats to cancel?");
                        num_of_seats = Integer.parseInt(scanner.nextLine());
                        event.cancelBooking(num_of_seats);
                        System.out.println(event.printSeats());
                        break;
                    case "3":
                        System.out.println(event.printSeats());
                        break;
                    case "4":
                        System.out.println("Quitting");
                    default:
                        break;
                }
            }


        } catch (InvalidDateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
        finally {
            scanner.close();
        }




    }
}
