package com.solvd.airportmanagement.decorator;

import com.solvd.airportmanagement.entity.Employee;
import com.solvd.airportmanagement.service.EmployeeService;

import java.util.List;

public class LoggingEmployeeServiceDecorator implements EmployeeService {

    private final EmployeeService service;

    public LoggingEmployeeServiceDecorator(EmployeeService service) {
        this.service = service;
    }

    @Override
    public void createEmployee(Employee employee) {
        System.out.println("Creating employee...");
        service.createEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(Long id) {

    }

    @Override
    public Employee getEmployeeById(Long id) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return List.of();
    }
}
