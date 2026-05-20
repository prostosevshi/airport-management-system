package com.solvd.airportmanagement.service;

import com.solvd.airportmanagement.entity.Airport;

import java.util.List;

public interface AirportService {

    void createAirport(Airport airport);

    List<Airport> getAll();
}