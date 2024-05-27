package org.eventsmanager;

import java.time.LocalDate;
import org.eventsmanager.exceptions.InvalidDateException;

public class Event {
    private String title;
    private LocalDate date;
    private int available_seats, reserved_seats;

    public Event(String title, LocalDate date, int available_seats) throws InvalidDateException{
        this.title = title;
        this.date = validateDate(date);
        this.available_seats = validateSeats(available_seats);
        reserved_seats = 0;
    }

    //Getter
    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAvailable_seats() {
        return available_seats;
    }

    public int getReserved_seats() {
        return reserved_seats;
    }

    //Setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) {
        this.date = validateDate(date);
    }

    //methods
    public void book(int num_of_seats) throws IllegalArgumentException{
        validateDate(this.date);
        validateSeats(num_of_seats);
        if(this.reserved_seats + num_of_seats > this.available_seats){
            throw new IllegalArgumentException("Max available seats: " + (this.available_seats - this.reserved_seats));
        }
        this.reserved_seats += num_of_seats;
    }

    public void cancelBooking(int num_of_seats) throws IllegalArgumentException{
        validateSeats(num_of_seats);
        validateDate(this.date);
        if(this.reserved_seats - num_of_seats < 0){
            throw new IllegalArgumentException("Invalid number of seats to cancel. Number of reserved seats: " + this.reserved_seats);
        }
        this.reserved_seats -= num_of_seats;
    }


    //Validations
    private int validateSeats(int seats) throws NumberFormatException{
        if (seats < 0){
            throw new NumberFormatException("Number of seats must be positive");
        }
        return seats;
    }

    private LocalDate validateDate(LocalDate date) throws InvalidDateException {
        if (date == null || date.isBefore(LocalDate.now())) {
            throw new InvalidDateException("Invalid date: " + date);
        }
        return date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", available_seats=" + available_seats +
                ", reserved_seats=" + reserved_seats +
                '}';
    }
}
