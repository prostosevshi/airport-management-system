package com.solvd.airportmanagement.mapper;

import com.solvd.airportmanagement.entity.Plane;
import java.util.List;

public interface PlaneMapper {

    void insert(Plane plane);

    void update(Plane plane);

    void delete(Long id);

    Plane findById(Long id);

    List<Plane> findAll();

    List<Plane> findByAirportId(Long airportId);
}