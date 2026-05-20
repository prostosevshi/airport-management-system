package com.solvd.airportmanagement.service.impl;

import com.solvd.airportmanagement.dao.GuestRepository;
import com.solvd.airportmanagement.entity.Guest;
import com.solvd.airportmanagement.service.GuestService;

import java.util.List;

public class GuestServiceImpl implements GuestService {

    private final GuestRepository repository;

    public GuestServiceImpl(GuestRepository repository) {
        this.repository = repository;
    }

    public void createGuest(Guest guest) {
        repository.create(guest);
    }

    public void updateGuest(Guest guest) {
        repository.update(guest);
    }

    public void deleteGuest(Long id) {
        repository.delete(id);
    }

    public Guest getGuestById(Long id) {
        return repository.findById(id);
    }

    public List<Guest> getAllGuests() {
        return repository.findAll();
    }
}