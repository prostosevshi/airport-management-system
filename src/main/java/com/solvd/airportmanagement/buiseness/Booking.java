package com.solvd.airportmanagement.buiseness;

import com.solvd.airportmanagement.payment.CardPayment;
import com.solvd.airportmanagement.person.Guest;

import java.time.LocalDate;

public class Booking {

    private Long id;
    private int bookingNumber;
    private LocalDate bookingDate;
    private Guest guest;
    private CardPayment payment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public CardPayment getPayment() {
        return payment;
    }

    public void setPayment(CardPayment payment) {
        this.payment = payment;
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
