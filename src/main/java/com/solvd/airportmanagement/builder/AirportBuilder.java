package com.solvd.airportmanagement.builder;

import com.solvd.airportmanagement.entity.Airport;
import com.solvd.airportmanagement.entity.Employee;

import java.util.List;

public class AirportBuilder {

    private Airport airport = new Airport();

    public AirportBuilder name(String name) {
        airport.setAirportName(name);
        return this;
    }

    public AirportBuilder location(String location) {
        airport.setAirportLocation(location);
        return this;
    }

    public AirportBuilder employees(List<Employee> employees) {
        airport.setEmployees(employees);
        return this;
    }

    public Airport build() {
        return airport;
    }
}