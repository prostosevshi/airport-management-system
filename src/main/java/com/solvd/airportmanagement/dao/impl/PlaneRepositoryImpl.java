package com.solvd.airportmanagement.dao.impl;

import com.solvd.airportmanagement.dao.PlaneRepository;
import com.solvd.airportmanagement.entity.Plane;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaneRepositoryImpl implements PlaneRepository {

    private final Connection connection;

    public PlaneRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Plane plane) {
        String sql = "INSERT INTO planes (model, number_of_engines, number_of_seats) VALUES (?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, plane.getModel());
            ps.setInt(2, plane.getNumberOfEngines());
            ps.setInt(3, plane.getNumberOfSeats());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Plane plane) {
        String sql = "UPDATE planes SET model=?, number_of_engines=?, number_of_seats=? WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, plane.getModel());
            ps.setInt(2, plane.getNumberOfEngines());
            ps.setInt(3, plane.getNumberOfSeats());
            ps.setLong(4, plane.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM planes WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Plane findById(Long id) {
        String sql = "SELECT * FROM planes WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Plane plane = new Plane();

                plane.setId(rs.getLong("id"));
                plane.setModel(rs.getString("model"));
                plane.setNumberOfEngines(rs.getInt("number_of_engines"));
                plane.setNumberOfSeats(rs.getInt("number_of_seats"));

                return plane;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public List<Plane> findAll() {
        String sql = "SELECT * FROM planes";

        List<Plane> list = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Plane plane = new Plane();

                plane.setId(rs.getLong("id"));
                plane.setModel(rs.getString("model"));
                plane.setNumberOfEngines(rs.getInt("number_of_engines"));
                plane.setNumberOfSeats(rs.getInt("number_of_seats"));

                list.add(plane);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}