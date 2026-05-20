package com.solvd.airportmanagement.service;

import com.solvd.airportmanagement.entity.Plane;

import java.util.List;

public interface PlaneService {

    void createPlane(Plane plane);

    void updatePlane(Plane plane);

    void deletePlane(Long id);

    Plane getPlaneById(Long id);

    List<Plane> getAllPlanes();
}