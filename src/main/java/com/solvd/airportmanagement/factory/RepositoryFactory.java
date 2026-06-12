package com.solvd.airportmanagement.factory;

import com.solvd.airportmanagement.dao.AirportRepository;
import com.solvd.airportmanagement.dao.EmployeeRepository;
import com.solvd.airportmanagement.dao.jdbcimpl.AirportRepositoryImpl;
import com.solvd.airportmanagement.dao.jdbcimpl.EmployeeRepositoryImpl;

public class RepositoryFactory {

    public static AirportRepository createAirportRepository() {
        return new AirportRepositoryImpl();
    }

    public static EmployeeRepository createEmployeeRepository() {
        return new EmployeeRepositoryImpl();
    }
}