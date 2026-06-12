package com.solvd.airportmanagement;

import com.solvd.airportmanagement.dao.AirportRepository;
import com.solvd.airportmanagement.dao.EmployeeRepository;
import com.solvd.airportmanagement.dao.jdbcimpl.AirportRepositoryImpl;
import com.solvd.airportmanagement.dao.jdbcimpl.EmployeeRepositoryImpl;
import com.solvd.airportmanagement.service.EmployeeService;
import com.solvd.airportmanagement.service.impl.AirportServiceImpl;
import com.solvd.airportmanagement.service.impl.EmployeeServiceImpl;
import com.solvd.airportmanagement.entity.Airport;
import com.solvd.airportmanagement.entity.Employee;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AirportRepository airportRepository = new AirportRepositoryImpl();
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

        EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository);

        AirportServiceImpl airportService =
                new AirportServiceImpl(
                        airportRepository,
                        employeeService
                );

        // Create data
        Airport airport = new Airport();
        airport.setAirportName("Tbilisi International");
        airport.setAirportLocation("Georgia");

        Employee emp1 = new Employee();
        emp1.setName("John");
        emp1.setAge(30);
        emp1.setSalary(1000);

        Employee emp2 = new Employee();
        emp2.setName("Mike");
        emp2.setAge(40);
        emp2.setSalary(1500);

        airport.setEmployees(List.of(emp1, emp2));

        airportService.createAirportWithEmployees(airport);

        System.out.println("Airport and employees created.");
    }
}