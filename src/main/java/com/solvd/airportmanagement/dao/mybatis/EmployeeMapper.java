package com.solvd.airportmanagement.dao.mybatis;

import com.solvd.airportmanagement.entity.Employee;
import java.util.List;

public interface EmployeeMapper {

    void insert(Employee employee);

    void update(Employee employee);

    void delete(Long id);

    Employee findById(Long id);

    List<Employee> findAll();

    List<Employee> findByAirportId(Long airportId);
}