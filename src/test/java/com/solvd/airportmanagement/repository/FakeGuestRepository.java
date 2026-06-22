package com.solvd.airportmanagement.repository;

import com.solvd.airportmanagement.dao.GuestRepository;
import com.solvd.airportmanagement.entity.Guest;

import java.util.*;

public class FakeGuestRepository implements GuestRepository {

    private final Map<Long, Guest> storage = new HashMap<>();
    private long idSeq = 1;

    @Override
    public void create(Guest guest) {
        guest.setId(idSeq++);
        storage.put(guest.getId(), guest);
    }

    @Override
    public void update(Guest guest) {
        storage.put(guest.getId(), guest);
    }

    @Override
    public void delete(Long id) {
        storage.remove(id);
    }

    @Override
    public Guest findById(Long id) {
        return storage.get(id);
    }

    @Override
    public List<Guest> findAll() {
        return new ArrayList<>(storage.values());
    }
}