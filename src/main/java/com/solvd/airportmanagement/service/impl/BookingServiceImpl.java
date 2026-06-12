package com.solvd.airportmanagement.service.impl;

import com.solvd.airportmanagement.dao.BookingRepository;
import com.solvd.airportmanagement.entity.Booking;
import com.solvd.airportmanagement.entity.CardPayment;
import com.solvd.airportmanagement.service.BookingService;
import com.solvd.airportmanagement.service.CardPaymentService;

import java.util.List;

public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final CardPaymentService cardPaymentService;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              CardPaymentService cardPaymentService) {
        this.bookingRepository = bookingRepository;
        this.cardPaymentService = cardPaymentService;
    }

    @Override
    public void createBooking(Booking booking) {
        bookingRepository.create(booking);
    }

    @Override
    public void updateBooking(Booking booking) {
        bookingRepository.update(booking);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.delete(id);
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public void createBookingWithPayment(Booking booking, CardPayment payment) {

        bookingRepository.create(booking);

        payment.setBookingId(booking.getId());

        cardPaymentService.createPayment(payment);
    }
}