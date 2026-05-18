package com.solvd.airportmanagement.service;

import com.solvd.airportmanagement.dao.AirportRepository;
import com.solvd.airportmanagement.entity.Airport;

import java.util.List;

public class AirportService {

    private final AirportRepository repository;

    public AirportService(AirportRepository repository) {
        this.repository = repository;
    }

    public void createAirport(Airport airport) {
        repository.create(airport);
    }

    public List<Airport> getAll() {
        return repository.findAll();
    }
}
