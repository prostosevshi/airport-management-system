package com.solvd.airportmanagement.service;

import com.solvd.airportmanagement.entity.Airport;
import com.solvd.airportmanagement.entity.Employee;
import com.solvd.airportmanagement.repository.FakeAirportRepository;
import com.solvd.airportmanagement.repository.FakeEmployeeRepository;
import com.solvd.airportmanagement.service.impl.AirportServiceImpl;
import com.solvd.airportmanagement.service.impl.EmployeeServiceImpl;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class AirportServiceTest {

    private AirportServiceImpl service;

    @BeforeMethod
    public void setUp() {

        service = new AirportServiceImpl(
                new FakeAirportRepository(),
                new EmployeeServiceImpl(new FakeEmployeeRepository())
        );
    }

    @Test
    public void shouldCreateAirport() {

        Airport airport = new Airport();
        airport.setAirportName("Tbilisi");
        airport.setAirportLocation("Georgia");

        service.createAirport(airport);

        Assert.assertNotNull(airport.getId());
    }

    @Test
    public void shouldReturnAllAirports() {

        Airport a1 = new Airport();
        a1.setAirportName("A1");

        Airport a2 = new Airport();
        a2.setAirportName("A2");

        service.createAirport(a1);
        service.createAirport(a2);

        Assert.assertEquals(service.getAll().size(), 2);
    }

    @Test
    public void shouldCreateAirportWithEmployees() {

        Employee e1 = new Employee();
        e1.setName("John");

        Employee e2 = new Employee();
        e2.setName("Mike");

        Airport airport = new Airport();
        airport.setAirportName("Tbilisi Airport");
        airport.setEmployees(List.of(e1, e2));

        service.createAirportWithEmployees(airport);

        Assert.assertNotNull(airport.getId());

        Assert.assertEquals(
                e1.getAirportId(),
                airport.getId()
        );
    }

    @Test
    public void shouldHandleNullEmployees() {

        Airport airport = new Airport();
        airport.setAirportName("Test");

        service.createAirportWithEmployees(airport);

        Assert.assertNotNull(airport.getId());
    }

    @Test
    public void shouldUpdateAirport() {

        Airport airport = new Airport();
        airport.setAirportName("Old");

        service.createAirport(airport);

        airport.setAirportName("New");

        service.createAirport(airport);

        Airport result = service.getAll().get(0);

        Assert.assertEquals(result.getAirportName(), "New");
    }
}