package com.solvd.airportmanagement.service.impl;

import com.solvd.airportmanagement.dao.PlaneRepository;
import com.solvd.airportmanagement.entity.Plane;
import com.solvd.airportmanagement.service.PlaneService;

import java.util.List;

public class PlaneServiceImpl implements PlaneService {

    private final PlaneRepository repository;

    public PlaneServiceImpl(PlaneRepository repository) {
        this.repository = repository;
    }

    public void createPlane(Plane plane) {
        repository.create(plane);
    }

    public void updatePlane(Plane plane) {
        repository.update(plane);
    }

    public void deletePlane(Long id) {
        repository.delete(id);
    }

    public Plane getPlaneById(Long id) {
        return repository.findById(id);
    }

    public List<Plane> getAllPlanes() {
        return repository.findAll();
    }
}