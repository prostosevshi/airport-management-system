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
        service.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        service.deleteEmployee(id);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return service.getEmployeeById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }
}
