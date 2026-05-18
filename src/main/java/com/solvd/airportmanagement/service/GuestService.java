package com.solvd.airportmanagement.service;

import com.solvd.airportmanagement.dao.GuestRepository;
import com.solvd.airportmanagement.entity.Guest;

import java.util.List;

public class GuestService {

    private final GuestRepository repository;

    public GuestService(GuestRepository repository) {
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