package com.solvd.airportmanagement.mapper;

import com.solvd.airportmanagement.entity.CardPayment;
import java.util.List;

public interface CardPaymentMapper {

    void insert(CardPayment cardPayment);

    void update(CardPayment cardPayment);

    void delete(Long id);

    CardPayment findById(Long id);

    List<CardPayment> findAll();

    List<CardPayment> findByBookingId(Long bookingId);
}