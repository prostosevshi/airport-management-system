package com.solvd.airportmanagement.buiseness;

import java.time.LocalDate;

public class Booking {

    private int bookingNumber;
    private LocalDate bookingDate;

    public void bookTicket() {
        System.out.println("Ticket is booked");
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
}
