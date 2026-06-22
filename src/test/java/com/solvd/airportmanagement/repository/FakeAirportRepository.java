package com.solvd.airportmanagement.repository;

import com.solvd.airportmanagement.dao.AirportRepository;
import com.solvd.airportmanagement.entity.Airport;

import java.util.*;

public class FakeAirportRepository implements AirportRepository {

    private final Map<Long, Airport> storage = new HashMap<>();
    private long idSeq = 1;

    @Override
    public void create(Airport airport) {
        airport.setId(idSeq++);
        storage.put(airport.getId(), airport);
    }

    @Override
    public void update(Airport airport) {
        storage.put(airport.getId(), airport);
    }

    @Override
    public void delete(Long id) {
        storage.remove(id);
    }

    @Override
    public Airport findById(Long id) {
        return storage.get(id);
    }

    @Override
    public List<Airport> findAll() {
        return new ArrayList<>(storage.values());
    }
}