package com.solvd.airportmanagement.service;

import com.solvd.airportmanagement.dao.BookingRepository;
import com.solvd.airportmanagement.entity.Booking;

import java.util.List;

public class BookingService {

    private final BookingRepository repository;

    public BookingService(BookingRepository repository) {
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