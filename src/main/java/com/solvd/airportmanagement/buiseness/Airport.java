package com.solvd.airportmanagement.buiseness;

import com.solvd.airportmanagement.person.Employee;
import com.solvd.airportmanagement.plane.Plane;

import java.util.ArrayList;
import java.util.List;

public class Airport {

    private long id;
    private String airportName;
    private String airportLocation;

    private List<Plane> planes = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportLocation() {
        return airportLocation;
    }

    public void setAirportLocation(String airportLocation) {
        this.airportLocation = airportLocation;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
