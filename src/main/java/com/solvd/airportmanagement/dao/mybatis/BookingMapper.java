package com.solvd.airportmanagement.dao.mybatis;

import com.solvd.airportmanagement.entity.Booking;
import java.util.List;

public interface BookingMapper {

    void insert(Booking booking);

    void update(Booking booking);

    void delete(Long id);

    Booking findById(Long id);

    List<Booking> findAll();

    List<Booking> findByGuestId(Long guestId);

    List<Booking> findByAirportId(Long airportId);
}