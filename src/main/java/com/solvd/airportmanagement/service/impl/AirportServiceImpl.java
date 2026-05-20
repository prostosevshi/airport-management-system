package com.solvd.airportmanagement.service.impl;

import com.solvd.airportmanagement.dao.AirportRepository;
import com.solvd.airportmanagement.entity.Airport;
import com.solvd.airportmanagement.service.AirportService;

import java.util.List;

public class AirportServiceImpl implements AirportService {

    private final AirportRepository repository;

    public AirportServiceImpl(AirportRepository repository) {
        this.repository = repository;
    }

    public void createAirport(Airport airport) {
        repository.create(airport);
    }

    public List<Airport> getAll() {
        return repository.findAll();
    }
}
