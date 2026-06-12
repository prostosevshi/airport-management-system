package com.solvd.airportmanagement.dao.jdbcimpl;

import com.solvd.airportmanagement.dao.ReportRepository;
import com.solvd.airportmanagement.entity.*;
import com.solvd.airportmanagement.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;

public class ReportRepositoryImpl implements ReportRepository {

    private final ConnectionPool connectionPool =
            ConnectionPool.getInstance();

    @Override
    public Airport getFullAirportReport(Long airportId) {

        Connection connection = connectionPool.getConnection();

        try {

            // =========================
            // 1. AIRPORT
            // =========================
            Airport airport = new Airport();

            String airportSql = "SELECT * FROM airports WHERE id=?";

            try (PreparedStatement ps = connection.prepareStatement(airportSql)) {

                ps.setLong(1, airportId);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    airport.setId(rs.getLong("id"));
                    airport.setAirportName(rs.getString("airport_name"));
                    airport.setAirportLocation(rs.getString("airport_location"));
                }
            }

            airport.setPlanes(new ArrayList<>());
            airport.setEmployees(new ArrayList<>());
            airport.setBookings(new ArrayList<>());

            // =========================
            // 2. PLANES
            // =========================
            String planeSql = "SELECT * FROM planes WHERE airport_id=?";

            try (PreparedStatement ps = connection.prepareStatement(planeSql)) {

                ps.setLong(1, airportId);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Plane plane = new Plane();

                    plane.setId(rs.getLong("id"));
                    plane.setModel(rs.getString("model"));
                    plane.setNumberOfEngines(rs.getInt("number_of_engines"));
                    plane.setNumberOfSeats(rs.getInt("number_of_seats"));

                    airport.getPlanes().add(plane);
                }
            }

            // =========================
            // 3. EMPLOYEES
            // =========================
            String empSql = "SELECT * FROM employees WHERE airport_id=?";

            try (PreparedStatement ps = connection.prepareStatement(empSql)) {

                ps.setLong(1, airportId);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Employee emp = new Employee();

                    emp.setId(rs.getLong("id"));
                    emp.setName(rs.getString("name"));
                    emp.setAge(rs.getInt("age"));
                    emp.setSalary(rs.getInt("salary"));

                    airport.getEmployees().add(emp);
                }
            }

            // =========================
            // 4. BOOKINGS + JOIN
            // =========================
            String bookingSql =
                    "SELECT b.id as booking_id, b.booking_number, b.booking_date, " +
                            "g.id as guest_id, g.name as guest_name, " +
                            "cp.id as payment_id, cp.payment_amount, cp.payment_date " +
                            "FROM bookings b " +
                            "JOIN guests g ON b.guest_id = g.id " +
                            "JOIN card_payments cp ON cp.booking_id = b.id " +
                            "WHERE b.airport_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(bookingSql)) {

                ps.setLong(1, airportId);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    Guest guest = new Guest();
                    guest.setId(rs.getLong("guest_id"));
                    guest.setName(rs.getString("guest_name"));

                    CardPayment payment = new CardPayment();
                    payment.setId(rs.getLong("payment_id"));
                    payment.setPaymentAmount(rs.getInt("payment_amount"));
                    payment.setPaymentDate(rs.getDate("payment_date").toLocalDate());

                    Booking booking = new Booking();
                    booking.setId(rs.getLong("booking_id"));
                    booking.setBookingNumber(rs.getInt("booking_number"));
                    booking.setBookingDate(rs.getDate("booking_date").toLocalDate());

                    booking.setGuest(guest);
                    booking.setPayment(payment);

                    airport.getBookings().add(booking);
                }
            }

            return airport;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}