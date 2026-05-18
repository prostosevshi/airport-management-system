package com.solvd.airportmanagement.dao;

import com.solvd.airportmanagement.entity.Airport;

import java.util.List;

public interface AirportRepository {

    void create(Airport airport);

    void update(Airport airport);

    void delete(Long id);

    Airport findById(Long id);

    List<Airport> findAll();
}
