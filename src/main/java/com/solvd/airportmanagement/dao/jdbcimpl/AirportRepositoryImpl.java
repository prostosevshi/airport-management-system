package com.solvd.airportmanagement.dao.jdbcimpl;

import com.solvd.airportmanagement.dao.AirportRepository;
import com.solvd.airportmanagement.entity.Airport;
import com.solvd.airportmanagement.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirportRepositoryImpl implements AirportRepository {

    private final ConnectionPool connectionPool =
            ConnectionPool.getInstance();

    @Override
    public void create(Airport airport) {

        Connection connection =
                connectionPool.getConnection();

        try {

            String sql =
                    "INSERT INTO airports (airport_name, airport_location) VALUES (?, ?)";

            PreparedStatement ps =
                    connection.prepareStatement(sql);

            ps.setString(1, airport.getAirportName());
            ps.setString(2, airport.getAirportLocation());

            ps.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(Airport airport) {

        Connection connection =
                connectionPool.getConnection();

        try {

            String sql =
                    "UPDATE airports SET airport_name=?, airport_location=? WHERE id=?";

            PreparedStatement ps =
                    connection.prepareStatement(sql);

            ps.setString(1, airport.getAirportName());
            ps.setString(2, airport.getAirportLocation());
            ps.setLong(3, airport.getId());

            ps.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Long id) {

        Connection connection =
                connectionPool.getConnection();

        try {

            String sql =
                    "DELETE FROM airports WHERE id=?";

            PreparedStatement ps =
                    connection.prepareStatement(sql);

            ps.setLong(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public Airport findById(Long id) {

        Connection connection =
                connectionPool.getConnection();

        try {

            String sql =
                    "SELECT * FROM airports WHERE id=?";

            PreparedStatement ps =
                    connection.prepareStatement(sql);

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Airport airport = new Airport();

                airport.setId(rs.getLong("id"));
                airport.setAirportName(rs.getString("airport_name"));
                airport.setAirportLocation(rs.getString("airport_location"));

                return airport;
            }

            return null;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<Airport> findAll() {

        Connection connection =
                connectionPool.getConnection();

        try {

            String sql = "SELECT * FROM airports";

            PreparedStatement ps =
                    connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Airport> list = new ArrayList<>();

            while (rs.next()) {

                Airport airport = new Airport();

                airport.setId(rs.getLong("id"));
                airport.setAirportName(rs.getString("airport_name"));
                airport.setAirportLocation(rs.getString("airport_location"));

                list.add(airport);
            }

            return list;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }
}