package com.solvd.airportmanagement.service.impl;

import com.solvd.airportmanagement.dao.CardPaymentRepository;
import com.solvd.airportmanagement.entity.CardPayment;
import com.solvd.airportmanagement.service.CardPaymentService;

import java.util.List;

public class CardPaymentServiceImpl implements CardPaymentService {

    private final CardPaymentRepository repository;

    public CardPaymentServiceImpl(CardPaymentRepository repository) {
        this.repository = repository;
    }

    public void createPayment(CardPayment cardPayment) {
        repository.create(cardPayment);
    }

    public void updatePayment(CardPayment cardPayment) {
        repository.update(cardPayment);
    }

    public void deletePayment(Long id) {
        repository.delete(id);
    }

    public CardPayment getPaymentById(Long id) {
        return repository.findById(id);
    }

    public List<CardPayment> getAllPayments() {
        return repository.findAll();
    }
}