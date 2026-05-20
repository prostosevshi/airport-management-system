package com.solvd.airportmanagement.service;

import com.solvd.airportmanagement.entity.Employee;

import java.util.List;

public interface EmployeeService {

    void createEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(Long id);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();
}