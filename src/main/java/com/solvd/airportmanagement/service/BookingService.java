package com.solvd.airportmanagement.service;

import com.solvd.airportmanagement.entity.Booking;

import java.util.List;

public interface BookingService {

    void createBooking(Booking booking);

    void updateBooking(Booking booking);

    void deleteBooking(Long id);

    Booking getBookingById(Long id);

    List<Booking> getAllBookings();
}