package org.eventsmanager;

import org.eventsmanager.exceptions.InvalidDateException;
import org.eventsmanager.exceptions.InvalidTimeException;
import org.eventsmanager.exceptions.InvalidPriceException;


import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

public class Concert extends Event{

    private LocalTime time;
    private BigDecimal price;

    public Concert(String title, LocalDate date, int total_seats, LocalTime time, BigDecimal price) throws InvalidDateException, InvalidPriceException {
        super(title, date, total_seats);
        this.time = validateTime(time);
        this.price = validatePrice(price);
    }

    //Getter
    public LocalTime getTime() {
        return time;
    }

    public BigDecimal getPrice() {
        return price;
    }


    //Setter
    public void setTime(LocalTime time) throws InvalidTimeException{
        this.time = validateTime(time);
    }

    public void setPrice(BigDecimal price) throws InvalidPriceException{
        this.price = validatePrice(price);
    }


    //validate
    private LocalTime validateTime(LocalTime time) throws InvalidTimeException {
        if (time == null) {
            throw new InvalidTimeException("Time cannot be null");
        }
        return time;
    }

    private BigDecimal validatePrice(BigDecimal price) throws InvalidPriceException {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPriceException("Price cannot be null or less than or equal to zero");
        }
        return price;
    }

    //Formatting
    @Override
    public String toString() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.ITALY);
        return "Concert{" +
                "title='" + getTitle() + '\'' +
                ", date=" + getDate() +
                ", time=" + time +
                ", " + printSeats() +
                ", price=" + currencyFormat.format(price) +
                '}';
    }
}
