package com.solvd.airportmanagement.service;

import com.solvd.airportmanagement.entity.CardPayment;

import java.util.List;

public interface CardPaymentService {

    void createPayment(CardPayment cardPayment);

    void updatePayment(CardPayment cardPayment);

    void deletePayment(Long id);

    CardPayment getPaymentById(Long id);

    List<CardPayment> getAllPayments();
}