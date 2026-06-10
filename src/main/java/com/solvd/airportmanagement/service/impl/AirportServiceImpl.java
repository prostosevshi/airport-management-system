package com.solvd.airportmanagement.service.impl;

import com.solvd.airportmanagement.dao.AirportRepository;
import com.solvd.airportmanagement.dao.EmployeeRepository;
import com.solvd.airportmanagement.entity.Airport;
import com.solvd.airportmanagement.entity.Employee;
import com.solvd.airportmanagement.service.AirportService;

import java.util.List;

public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;
    private final EmployeeRepository employeeRepository;

    public AirportServiceImpl(AirportRepository airportRepository,
                              EmployeeRepository employeeRepository) {
        this.airportRepository = airportRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void createAirport(Airport airport) {
        airportRepository.create(airport);
    }

    @Override
    public List<Airport> getAll() {
        return airportRepository.findAll();
    }

    public void createAirportWithEmployees(Airport airport) {

        airportRepository.create(airport);

        if (airport.getEmployees() != null) {
            for (Employee employee : airport.getEmployees()) {
                employeeRepository.create(employee);
            }
        }
    }
}