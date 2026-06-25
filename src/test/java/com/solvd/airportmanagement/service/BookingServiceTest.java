package com.solvd.airportmanagement.service;

import com.solvd.airportmanagement.entity.Booking;
import com.solvd.airportmanagement.entity.CardPayment;
import com.solvd.airportmanagement.repository.FakeBookingRepository;
import com.solvd.airportmanagement.repository.FakeCardPaymentRepository;
import com.solvd.airportmanagement.service.impl.BookingServiceImpl;
import com.solvd.airportmanagement.service.impl.CardPaymentServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookingServiceTest {

    private BookingServiceImpl service;

    @BeforeMethod
    public void setUp() {
        service = new BookingServiceImpl(
                new FakeBookingRepository(),
                new CardPaymentServiceImpl(new FakeCardPaymentRepository())
        );
    }

    @Test
    public void shouldCreateBooking() {
        Booking b = new Booking();
        b.setId(1L);

        service.createBooking(b);

        Assert.assertNotNull(
                service.getBookingById(1L),
                "Booking should be found after creation"
        );
    }

    @Test
    public void shouldUpdateBooking() {
        Booking b = new Booking();
        b.setId(1L);
        b.setBookingNumber(100);

        service.createBooking(b);

        b.setBookingNumber(200);
        service.updateBooking(b);

        Assert.assertEquals(
                service.getBookingById(1L).getBookingNumber(),
                200,
                "Booking number should be updated"
        );
    }

    @Test
    public void shouldDeleteBooking() {
        Booking b = new Booking();
        b.setId(1L);

        service.createBooking(b);
        service.deleteBooking(1L);

        Assert.assertNull(
                service.getBookingById(1L),
                "Booking should be deleted"
        );
    }

    @Test
    public void shouldReturnAllBookings() {
        Booking b1 = new Booking();
        b1.setId(1L);

        Booking b2 = new Booking();
        b2.setId(2L);

        service.createBooking(b1);
        service.createBooking(b2);

        Assert.assertEquals(
                service.getAllBookings().size(),
                2,
                "Service should return 2 bookings"
        );
    }

    @Test
    public void shouldCreateBookingWithPayment() {
        Booking b = new Booking();
        b.setId(1L);

        CardPayment p = new CardPayment();

        service.createBookingWithPayment(b, p);

        Assert.assertNotNull(
                b.getId(),
                "Booking should be created together with payment"
        );
    }
}