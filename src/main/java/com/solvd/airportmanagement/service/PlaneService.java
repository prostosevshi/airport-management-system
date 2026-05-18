package com.solvd.airportmanagement.service;

import com.solvd.airportmanagement.dao.PlaneRepository;
import com.solvd.airportmanagement.entity.Plane;

import java.util.List;

public class PlaneService {

    private final PlaneRepository repository;

    public PlaneService(PlaneRepository repository) {
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