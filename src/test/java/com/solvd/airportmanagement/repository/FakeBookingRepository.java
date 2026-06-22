package com.solvd.airportmanagement.repository;

import com.solvd.airportmanagement.dao.BookingRepository;
import com.solvd.airportmanagement.entity.Booking;

import java.util.*;

public class FakeBookingRepository implements BookingRepository {

    private final Map<Long, Booking> storage = new HashMap<>();
    private long idSeq = 1;

    @Override
    public void create(Booking booking) {
        booking.setId(idSeq++);
        storage.put(booking.getId(), booking);
    }

    @Override
    public void update(Booking booking) {
        storage.put(booking.getId(), booking);
    }

    @Override
    public void delete(Long id) {
        storage.remove(id);
    }

    @Override
    public Booking findById(Long id) {
        return storage.get(id);
    }

    @Override
    public List<Booking> findAll() {
        return new ArrayList<>(storage.values());
    }
}