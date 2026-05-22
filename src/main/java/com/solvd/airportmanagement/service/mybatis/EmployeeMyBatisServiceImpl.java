package com.solvd.airportmanagement.service.mybatis;

import com.solvd.airportmanagement.entity.Employee;
import com.solvd.airportmanagement.dao.mybatis.EmployeeMapper;
import com.solvd.airportmanagement.service.EmployeeService;
import com.solvd.airportmanagement.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmployeeMyBatisServiceImpl implements EmployeeService {

    @Override
    public void createEmployee(Employee employee) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            EmployeeMapper mapper =
                    session.getMapper(EmployeeMapper.class);

            mapper.insert(employee);
        }
    }

    @Override
    public void updateEmployee(Employee employee) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            EmployeeMapper mapper =
                    session.getMapper(EmployeeMapper.class);

            mapper.update(employee);
        }
    }

    @Override
    public void deleteEmployee(Long id) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            EmployeeMapper mapper =
                    session.getMapper(EmployeeMapper.class);

            mapper.delete(id);
        }
    }

    @Override
    public Employee getEmployeeById(Long id) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            EmployeeMapper mapper =
                    session.getMapper(EmployeeMapper.class);

            return mapper.findById(id);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {

        try (SqlSession session = MyBatisUtil.openSession()) {

            EmployeeMapper mapper =
                    session.getMapper(EmployeeMapper.class);

            return mapper.findAll();
        }
    }
}