package com.solvd.airportmanagement.facade;

import com.solvd.airportmanagement.entity.Airport;
import com.solvd.airportmanagement.entity.Employee;
import com.solvd.airportmanagement.service.AirportService;
import com.solvd.airportmanagement.service.EmployeeService;

public class AirportFacade {

    private final AirportService airportService;
    private final EmployeeService employeeService;

    public AirportFacade(AirportService airportService,
                         EmployeeService employeeService) {
        this.airportService = airportService;
        this.employeeService = employeeService;
    }

    public void createAirportFull(Airport airport) {

        airportService.createAirport(airport);

        if (airport.getEmployees() != null) {
            for (Employee e : airport.getEmployees()) {
                employeeService.createEmployee(e);
            }
        }
    }
}
