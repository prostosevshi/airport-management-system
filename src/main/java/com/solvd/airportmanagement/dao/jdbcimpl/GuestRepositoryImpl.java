package com.solvd.airportmanagement.dao.jdbcimpl;

import com.solvd.airportmanagement.dao.GuestRepository;
import com.solvd.airportmanagement.entity.Guest;
import com.solvd.airportmanagement.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestRepositoryImpl implements GuestRepository {

    private final ConnectionPool connectionPool =
            ConnectionPool.getInstance();

    @Override
    public void create(Guest guest) {

        Connection connection = connectionPool.getConnection();

        String sql = "INSERT INTO guests (name, age, passport_number) VALUES (?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, guest.getName());
            ps.setInt(2, guest.getAge());
            ps.setInt(3, Integer.parseInt(guest.getPassportNumber()));

            ps.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(Guest guest) {

        Connection connection = connectionPool.getConnection();

        String sql = "UPDATE guests SET name=?, age=?, passport_number=? WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, guest.getName());
            ps.setInt(2, guest.getAge());
            ps.setInt(3, Integer.parseInt(guest.getPassportNumber()));
            ps.setLong(4, guest.getId());

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

        String sql = "DELETE FROM guests WHERE id=?";

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
    public Guest findById(Long id) {

        Connection connection = connectionPool.getConnection();

        String sql = "SELECT * FROM guests WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Guest guest = new Guest();

                guest.setId(rs.getLong("id"));
                guest.setName(rs.getString("name"));
                guest.setAge(rs.getInt("age"));
                guest.setPassportNumber(
                        String.valueOf(rs.getInt("passport_number"))
                );

                return guest;
            }

            return null;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<Guest> findAll() {

        Connection connection = connectionPool.getConnection();

        String sql = "SELECT * FROM guests";

        List<Guest> list = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Guest guest = new Guest();

                guest.setId(rs.getLong("id"));
                guest.setName(rs.getString("name"));
                guest.setAge(rs.getInt("age"));
                guest.setPassportNumber(
                        String.valueOf(rs.getInt("passport_number"))
                );

                list.add(guest);
            }

            return list;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }
}