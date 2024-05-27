package org.eventsmanager;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import org.eventsmanager.exceptions.InvalidDateException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            Event event = new Event("Race", LocalDate.of(2024, 12, 25), 100);
            Concert concert = new Concert("Green day",LocalDate.of(2024, 7,23), 1000, LocalTime.of(18,30), BigDecimal.valueOf(21));

            int num_of_seats = 0;
            String choice = "";

            while (!choice.equals("4")) {
                System.out.println("1 - book\n2 - cancel\n3 - info\n4 - quit");
                choice = scanner.nextLine();
                switch (choice){
                    case "1":
                        System.out.println("How many seats to book?");
                        num_of_seats = Integer.parseInt(scanner.nextLine());
                        concert.book(num_of_seats);
                        System.out.println(concert.printSeats());
                        break;
                    case"2":
                        System.out.println("How many seats to cancel?");
                        num_of_seats = Integer.parseInt(scanner.nextLine());
                        concert.cancelBooking(num_of_seats);
                        System.out.println(concert.printSeats());
                        break;
                    case "3":
                        System.out.println(concert.toString());
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
