package com.solvd.airportmanagement.factory;

import com.solvd.airportmanagement.dao.AirportRepository;
import com.solvd.airportmanagement.dao.EmployeeRepository;

public interface DaoFactory {

    AirportRepository createAirportRepository();
    EmployeeRepository createEmployeeRepository();
}
