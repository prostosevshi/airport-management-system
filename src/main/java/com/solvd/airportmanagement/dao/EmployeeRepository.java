package com.solvd.airportmanagement.dao;

import com.solvd.airportmanagement.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    void create(Employee employee);

    void update(Employee employee);

    void delete(Long id);

    Employee findById(Long id);

    List<Employee> findAll();
}
