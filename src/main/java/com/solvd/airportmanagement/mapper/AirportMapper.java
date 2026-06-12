package com.solvd.airportmanagement.mapper;

import com.solvd.airportmanagement.entity.Airport;
import java.util.List;

public interface AirportMapper {

    void insert(Airport airport);

    void update(Airport airport);

    void delete(Long id);

    Airport findById(Long id);

    List<Airport> findAll();
}