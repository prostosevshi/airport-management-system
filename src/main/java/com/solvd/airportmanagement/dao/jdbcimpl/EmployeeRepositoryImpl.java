package com.solvd.airportmanagement.dao.jdbcimpl;

import com.solvd.airportmanagement.dao.EmployeeRepository;
import com.solvd.airportmanagement.entity.Employee;
import com.solvd.airportmanagement.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final ConnectionPool connectionPool =
            ConnectionPool.getInstance();

    @Override
    public void create(Employee employee) {

        Connection connection = connectionPool.getConnection();

        String sql = "INSERT INTO employees (name, age, salary) VALUES (?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, employee.getName());
            ps.setInt(2, employee.getAge());
            ps.setInt(3, employee.getSalary());

            ps.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(Employee employee) {

        Connection connection = connectionPool.getConnection();

        String sql = "UPDATE employees SET name=?, age=?, salary=? WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, employee.getName());
            ps.setInt(2, employee.getAge());
            ps.setInt(3, employee.getSalary());
            ps.setLong(4, employee.getId());

            ps.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Long id) {

        Connection connection = connectionPool.getConnection();

        String sql = "DELETE FROM employees WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public Employee findById(Long id) {

        Connection connection = connectionPool.getConnection();

        String sql = "SELECT * FROM employees WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Employee emp = new Employee();

                emp.setId(rs.getLong("id"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getInt("age"));
                emp.setSalary(rs.getInt("salary"));

                return emp;
            }

            return null;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<Employee> findAll() {

        Connection connection = connectionPool.getConnection();

        String sql = "SELECT * FROM employees";

        List<Employee> list = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Employee emp = new Employee();

                emp.setId(rs.getLong("id"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getInt("age"));
                emp.setSalary(rs.getInt("salary"));

                list.add(emp);
            }

            return list;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }
}