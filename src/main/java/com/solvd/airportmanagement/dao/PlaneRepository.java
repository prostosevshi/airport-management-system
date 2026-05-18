package com.solvd.airportmanagement.dao;

import com.solvd.airportmanagement.entity.Plane;

import java.util.List;

public interface PlaneRepository {

    void create(Plane plane);

    void update(Plane plane);

    void delete(Long id);

    Plane findById(Long id);

    List<Plane> findAll();
}
