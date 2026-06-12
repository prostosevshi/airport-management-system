package com.solvd.airportmanagement.factory;

import com.solvd.airportmanagement.dao.AirportRepository;
import com.solvd.airportmanagement.dao.EmployeeRepository;
import com.solvd.airportmanagement.dao.jdbcimpl.AirportRepositoryImpl;
import com.solvd.airportmanagement.dao.jdbcimpl.EmployeeRepositoryImpl;

public class JdbcDaoFactory implements DaoFactory {

    @Override
    public AirportRepository createAirportRepository() {
        return new AirportRepositoryImpl();
    }

    @Override
    public EmployeeRepository createEmployeeRepository() {
        return new EmployeeRepositoryImpl();
    }
}
