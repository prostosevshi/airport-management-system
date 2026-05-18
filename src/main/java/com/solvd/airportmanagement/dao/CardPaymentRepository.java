package com.solvd.airportmanagement.dao;

import com.solvd.airportmanagement.entity.CardPayment;

import java.util.List;

public interface CardPaymentRepository {

    void create(CardPayment cardPayment);

    void update(CardPayment cardPayment);

    void delete(Long id);

    CardPayment findById(Long id);

    List<CardPayment> findAll();
}
