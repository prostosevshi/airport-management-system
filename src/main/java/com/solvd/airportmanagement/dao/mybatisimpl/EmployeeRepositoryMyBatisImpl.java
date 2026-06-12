package com.solvd.airportmanagement.dao.mybatisimpl;

import com.solvd.airportmanagement.dao.EmployeeRepository;
import com.solvd.airportmanagement.entity.Employee;
import com.solvd.airportmanagement.mapper.EmployeeMapper;
import com.solvd.airportmanagement.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmployeeRepositoryMyBatisImpl implements EmployeeRepository {

    @Override
    public void create(Employee employee) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            session.getMapper(EmployeeMapper.class).insert(employee);
        }
    }

    @Override
    public void update(Employee employee) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            session.getMapper(EmployeeMapper.class).update(employee);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            session.getMapper(EmployeeMapper.class).delete(id);
        }
    }

    @Override
    public Employee findById(Long id) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            return session.getMapper(EmployeeMapper.class).findById(id);
        }
    }

    @Override
    public List<Employee> findAll() {
        try (SqlSession session = MyBatisUtil.openSession()) {
            return session.getMapper(EmployeeMapper.class).findAll();
        }
    }
}