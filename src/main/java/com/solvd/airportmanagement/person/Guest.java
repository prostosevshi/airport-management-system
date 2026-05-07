package com.solvd.airportmanagement.person;

import com.solvd.airportmanagement.payment.Payment;

public class Guest extends Person{

    private String passportNumber;
    private Payment payment;

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
