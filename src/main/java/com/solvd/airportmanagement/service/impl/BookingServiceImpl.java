package com.solvd.airportmanagement.service.impl;

import com.solvd.airportmanagement.dao.BookingRepository;
import com.solvd.airportmanagement.entity.Booking;
import com.solvd.airportmanagement.service.BookingService;

import java.util.List;

public class BookingServiceImpl implements BookingService {

    private final BookingRepository repository;

    public BookingServiceImpl(BookingRepository repository) {
        this.repository = repository;
    }

    public void createBooking(Booking booking) {
        repository.create(booking);
    }

    public void updateBooking(Booking booking) {
        repository.update(booking);
    }

    public void deleteBooking(Long id) {
        repository.delete(id);
    }

    public Booking getBookingById(Long id) {
        return repository.findById(id);
    }

    public List<Booking> getAllBookings() {
        return repository.findAll();
    }
}