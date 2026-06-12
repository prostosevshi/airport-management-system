package com.solvd.airportmanagement.factory;

import com.solvd.airportmanagement.dao.AirportRepository;
import com.solvd.airportmanagement.dao.EmployeeRepository;
import com.solvd.airportmanagement.dao.mybatisimpl.AirportRepositoryMyBatisImpl;
import com.solvd.airportmanagement.dao.mybatisimpl.EmployeeRepositoryMyBatisImpl;

public class MyBatisDaoFactory implements DaoFactory {

    @Override
    public AirportRepository createAirportRepository() {
        return new AirportRepositoryMyBatisImpl();
    }

    @Override
    public EmployeeRepository createEmployeeRepository() {
        return new EmployeeRepositoryMyBatisImpl();
    }
}
