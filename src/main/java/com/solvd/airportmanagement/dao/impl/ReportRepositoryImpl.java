package com.solvd.airportmanagement.dao.impl;

import com.solvd.airportmanagement.dao.ReportRepository;

import java.sql.*;
import java.util.*;

public class ReportRepositoryImpl implements ReportRepository {

    private final Connection connection;

    public ReportRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Map<String, Object>> getFullAirportReport() {

        String sql =
                "SELECT " +
                        "a.airport_name, " +
                        "a.airport_location, " +
                        "p.model AS plane_model, " +
                        "e.name AS employee_name, " +
                        "g.name AS guest_name, " +
                        "b.booking_number, " +
                        "cp.payment_amount, " +
                        "cp.payment_date " +
                        "FROM airports a " +
                        "JOIN planes p ON a.id = p.airport_id " +
                        "JOIN employees e ON a.id = e.airport_id " +
                        "JOIN guests g ON p.id = g.plane_id " +
                        "JOIN bookings b ON g.id = b.guest_id " +
                        "JOIN card_payments cp ON b.id = cp.booking_id";

        List<Map<String, Object>> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();

                row.put("airport_name", rs.getString("airport_name"));
                row.put("airport_location", rs.getString("airport_location"));
                row.put("plane_model", rs.getString("plane_model"));
                row.put("employee_name", rs.getString("employee_name"));
                row.put("guest_name", rs.getString("guest_name"));
                row.put("booking_number", rs.getInt("booking_number"));
                row.put("payment_amount", rs.getInt("payment_amount"));
                row.put("payment_date", rs.getDate("payment_date"));

                result.add(row);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}