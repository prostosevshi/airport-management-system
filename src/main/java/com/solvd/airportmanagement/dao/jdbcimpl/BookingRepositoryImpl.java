package com.solvd.airportmanagement.dao.jdbcimpl;

import com.solvd.airportmanagement.dao.BookingRepository;
import com.solvd.airportmanagement.entity.Booking;
import com.solvd.airportmanagement.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingRepositoryImpl implements BookingRepository {

    private final ConnectionPool connectionPool =
            ConnectionPool.getInstance();

    @Override
    public void create(Booking booking) {

        Connection connection = connectionPool.getConnection();

        String sql = "INSERT INTO bookings (booking_number, booking_date) VALUES (?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, booking.getBookingNumber());
            ps.setDate(2, Date.valueOf(booking.getBookingDate()));

            ps.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(Booking booking) {

        Connection connection = connectionPool.getConnection();

        String sql = "UPDATE bookings SET booking_number=?, booking_date=? WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, booking.getBookingNumber());
            ps.setDate(2, Date.valueOf(booking.getBookingDate()));
            ps.setLong(3, booking.getId());

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

        String sql = "DELETE FROM bookings WHERE id=?";

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
    public Booking findById(Long id) {

        Connection connection = connectionPool.getConnection();

        String sql = "SELECT * FROM bookings WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Booking booking = new Booking();

                booking.setId(rs.getLong("id"));
                booking.setBookingNumber(rs.getInt("booking_number"));
                booking.setBookingDate(rs.getDate("booking_date").toLocalDate());

                return booking;
            }

            return null;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<Booking> findAll() {

        Connection connection = connectionPool.getConnection();

        String sql = "SELECT * FROM bookings";

        List<Booking> list = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Booking booking = new Booking();

                booking.setId(rs.getLong("id"));
                booking.setBookingNumber(rs.getInt("booking_number"));
                booking.setBookingDate(rs.getDate("booking_date").toLocalDate());

                list.add(booking);
            }

            return list;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }
}