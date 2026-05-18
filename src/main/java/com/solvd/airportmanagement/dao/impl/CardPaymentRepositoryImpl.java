package com.solvd.airportmanagement.dao.impl;

import com.solvd.airportmanagement.dao.CardPaymentRepository;
import com.solvd.airportmanagement.entity.CardPayment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardPaymentRepositoryImpl implements CardPaymentRepository {

    private final Connection connection;

    public CardPaymentRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(CardPayment cardPayment) {
        String sql = "INSERT INTO card_payments (card_number, payment_number, payment_amount, payment_date) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, cardPayment.getCardNumber());
            ps.setInt(2, cardPayment.getPaymentNumber());
            ps.setInt(3, cardPayment.getPaymentAmount());
            ps.setDate(4, Date.valueOf(cardPayment.getPaymentDate()));

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(CardPayment cardPayment) {
        String sql = "UPDATE card_payments SET card_number=?, payment_number=?, payment_amount=?, payment_date=? WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, cardPayment.getCardNumber());
            ps.setInt(2, cardPayment.getPaymentNumber());
            ps.setInt(3, cardPayment.getPaymentAmount());
            ps.setDate(4, Date.valueOf(cardPayment.getPaymentDate()));
            ps.setLong(5, cardPayment.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM card_payments WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CardPayment findById(Long id) {
        String sql = "SELECT * FROM card_payments WHERE id=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                CardPayment cp = new CardPayment();
                cp.setId(rs.getLong("id"));
                cp.setCardNumber(rs.getInt("card_number"));
                cp.setPaymentNumber(rs.getInt("payment_number"));
                cp.setPaymentAmount(rs.getInt("payment_amount"));
                cp.setPaymentDate(rs.getDate("payment_date").toLocalDate());

                return cp;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public List<CardPayment> findAll() {
        String sql = "SELECT * FROM card_payments";

        List<CardPayment> list = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CardPayment cp = new CardPayment();

                cp.setId(rs.getLong("id"));
                cp.setCardNumber(rs.getInt("card_number"));
                cp.setPaymentNumber(rs.getInt("payment_number"));
                cp.setPaymentAmount(rs.getInt("payment_amount"));
                cp.setPaymentDate(rs.getDate("payment_date").toLocalDate());

                list.add(cp);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}