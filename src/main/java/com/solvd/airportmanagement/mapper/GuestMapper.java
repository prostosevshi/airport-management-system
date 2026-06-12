package com.solvd.airportmanagement.mapper;

import com.solvd.airportmanagement.entity.Guest;
import java.util.List;

public interface GuestMapper {

    void insert(Guest guest);

    void update(Guest guest);

    void delete(Long id);

    Guest findById(Long id);

    List<Guest> findAll();

    List<Guest> findByPlaneId(Long planeId);
}