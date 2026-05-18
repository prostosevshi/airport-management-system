package com.solvd.airportmanagement.dao;

import com.solvd.airportmanagement.entity.Booking;

import java.util.List;

public interface BookingRepository {

    void create(Booking booking);

    void update(Booking booking);

    void delete(Long id);

    Booking findById(Long id);

    List<Booking> findAll();
}
