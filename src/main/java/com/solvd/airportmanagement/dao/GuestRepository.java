package com.solvd.airportmanagement.dao;

import com.solvd.airportmanagement.entity.Guest;

import java.util.List;

public interface GuestRepository {

    void create(Guest guest);

    void update(Guest guest);

    void delete(Long id);

    Guest findById(Long id);

    List<Guest> findAll();
}
