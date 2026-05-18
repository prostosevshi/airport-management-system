package com.solvd.airportmanagement.dao.impl;

import com.solvd.airportmanagement.dao.GuestRepository;
import com.solvd.airportmanagement.entity.Guest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestRepositoryImpl implements GuestRepository {

    private final Connection connection;

    public GuestRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Guest guest) {
        String sql = "INSERT INTO guests (name, age, passport_number) VALUES (?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, guest.getName());
            ps.setInt(2, guest.getAge());
            ps.setInt(3, Integer.parseInt(guest.getPassportNumber()));

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Guest guest) {
        String sql = "UPDATE guests SET name=?, age=?, passport_number=? WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, guest.getName());
            ps.setInt(2, guest.getAge());
            ps.setInt(3, Integer.parseInt(guest.getPassportNumber()));
            ps.setLong(4, guest.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM guests WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Guest findById(Long id) {
        String sql = "SELECT * FROM guests WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Guest guest = new Guest();

                guest.setId(rs.getLong("id"));
                guest.setName(rs.getString("name"));
                guest.setAge(rs.getInt("age"));
                guest.setPassportNumber(String.valueOf(rs.getInt("passport_number")));

                return guest;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public List<Guest> findAll() {
        String sql = "SELECT * FROM guests";

        List<Guest> list = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Guest guest = new Guest();

                guest.setId(rs.getLong("id"));
                guest.setName(rs.getString("name"));
                guest.setAge(rs.getInt("age"));
                guest.setPassportNumber(String.valueOf(rs.getInt("passport_number")));

                list.add(guest);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}