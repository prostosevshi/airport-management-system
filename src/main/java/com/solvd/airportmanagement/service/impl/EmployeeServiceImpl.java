package com.solvd.airportmanagement.service.impl;

import com.solvd.airportmanagement.dao.EmployeeRepository;
import com.solvd.airportmanagement.entity.Employee;
import com.solvd.airportmanagement.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void createEmployee(Employee employee) {
        repository.create(employee);
    }

    public void updateEmployee(Employee employee) {
        repository.update(employee);
    }

    public void deleteEmployee(Long id) {
        repository.delete(id);
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }
}