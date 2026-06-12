package com.solvd.airportmanagement;

import com.solvd.airportmanagement.decorator.LoggingEmployeeServiceDecorator;
import com.solvd.airportmanagement.facade.AirportFacade;
import com.solvd.airportmanagement.factory.DaoFactory;
import com.solvd.airportmanagement.factory.JdbcDaoFactory;
import com.solvd.airportmanagement.listener.AirportCreatedEvent;
import com.solvd.airportmanagement.listener.AirportListener;
import com.solvd.airportmanagement.listener.LoggingAirportListener;
import com.solvd.airportmanagement.service.EmployeeService;
import com.solvd.airportmanagement.service.impl.AirportServiceImpl;
import com.solvd.airportmanagement.service.impl.EmployeeServiceImpl;
import com.solvd.airportmanagement.entity.Airport;
import com.solvd.airportmanagement.builder.AirportBuilder;
import com.solvd.airportmanagement.strategy.JdbcReportStrategy;
import com.solvd.airportmanagement.strategy.MyBatisReportStrategy;
import com.solvd.airportmanagement.strategy.ReportContext;

public class Main {
    public static void main(String[] args) {

        DaoFactory factory = new JdbcDaoFactory();

        EmployeeService employeeService =
                new LoggingEmployeeServiceDecorator(
                        new EmployeeServiceImpl(factory.createEmployeeRepository())
                );

        AirportFacade facade =
                new AirportFacade(
                        new AirportServiceImpl(factory.createAirportRepository(), employeeService),
                        employeeService
                );


        Airport airport = new AirportBuilder()
                .name("Tbilisi Airport")
                .location("Georgia")
                .build();

        facade.createAirportFull(airport);

        ReportContext context = new ReportContext();
        context.setStrategy(new JdbcReportStrategy());
        context.generate();

        context.setStrategy(new MyBatisReportStrategy());
        context.generate();

        AirportListener listener = new LoggingAirportListener();
        listener.onAirportCreated(new AirportCreatedEvent(airport));

        System.out.println("Airport created.");
    }
}