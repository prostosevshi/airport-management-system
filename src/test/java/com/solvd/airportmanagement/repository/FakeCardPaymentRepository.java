package com.solvd.airportmanagement.repository;

import com.solvd.airportmanagement.dao.CardPaymentRepository;
import com.solvd.airportmanagement.entity.CardPayment;

import java.util.*;

public class FakeCardPaymentRepository implements CardPaymentRepository {

    private final Map<Long, CardPayment> storage = new HashMap<>();
    private long idSeq = 1;

    @Override
    public void create(CardPayment payment) {
        payment.setId(idSeq++);
        storage.put(payment.getId(), payment);
    }

    @Override
    public void update(CardPayment payment) {
        storage.put(payment.getId(), payment);
    }

    @Override
    public void delete(Long id) {
        storage.remove(id);
    }

    @Override
    public CardPayment findById(Long id) {
        return storage.get(id);
    }

    @Override
    public List<CardPayment> findAll() {
        return new ArrayList<>(storage.values());
    }
}