package com.solvd.airportmanagement.payment;

public class CashPayment extends Payment {

    private int changeAmount;

    public int getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(int changeAmount) {
        this.changeAmount = changeAmount;
    }
}
