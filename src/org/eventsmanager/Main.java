package org.eventsmanager;

import java.time.LocalDate;
import org.eventsmanager.exceptions.InvalidDateException;

public class Main {
    public static void main(String[] args) {

        try {

            Event event = new Event("Concert", LocalDate.of(2024, 12, 25), 100);


            System.out.println("Event created: " + event);


            event.book(10);
            System.out.println("Reserved 10 seats.");
            System.out.println("Event status after booking 10 seats: " + event);


            event.book(90);
            System.out.println("Reserved 90 seats.");
            System.out.println("Event status after booking 90 seats: " + event);


            event.cancelBooking(5);
            System.out.println("Canceled 5 seats.");
            System.out.println("Event status after cancelling 5 seats: " + event);

            //Genero un' eccezione
            event.cancelBooking(100);

        } catch (InvalidDateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }


    }
}
