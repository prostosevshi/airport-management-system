package com.solvd.airportmanagement.payment;

public class CardPayment extends Payment {

    private int cardNumber;

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
}
