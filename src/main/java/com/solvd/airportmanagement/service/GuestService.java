package com.solvd.airportmanagement.service;

import com.solvd.airportmanagement.entity.Guest;

import java.util.List;

public interface GuestService {

    void createGuest(Guest guest);

    void updateGuest(Guest guest);

    void deleteGuest(Long id);

    Guest getGuestById(Long id);

    List<Guest> getAllGuests();
}