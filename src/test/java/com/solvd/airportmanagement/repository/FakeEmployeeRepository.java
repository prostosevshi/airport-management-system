package com.solvd.airportmanagement.repository;

import com.solvd.airportmanagement.dao.EmployeeRepository;
import com.solvd.airportmanagement.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class FakeEmployeeRepository implements EmployeeRepository {

    private final List<Employee> employees = new ArrayList<>();

    @Override
    public void create(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void update(Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(employee.getId())) {
                employees.set(i, employee);
                return;
            }
        }
    }

    @Override
    public void delete(Long id) {
        employees.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public Employee findById(Long id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employees);
    }
}