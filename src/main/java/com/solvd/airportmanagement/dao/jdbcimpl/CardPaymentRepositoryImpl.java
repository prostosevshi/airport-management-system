package com.solvd.airportmanagement.dao.jdbcimpl;

import com.solvd.airportmanagement.dao.CardPaymentRepository;
import com.solvd.airportmanagement.entity.CardPayment;
import com.solvd.airportmanagement.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardPaymentRepositoryImpl implements CardPaymentRepository {

    private final ConnectionPool connectionPool =
            ConnectionPool.getInstance();

    @Override
    public void create(CardPayment cardPayment) {

        Connection connection = connectionPool.getConnection();

        String sql = "INSERT INTO card_payments (card_number, payment_number, payment_amount, payment_date) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, cardPayment.getCardNumber());
            ps.setInt(2, cardPayment.getPaymentNumber());
            ps.setInt(3, cardPayment.getPaymentAmount());
            ps.setDate(4, Date.valueOf(cardPayment.getPaymentDate()));

            ps.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(CardPayment cardPayment) {

        Connection connection = connectionPool.getConnection();

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

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Long id) {

        Connection connection = connectionPool.getConnection();

        String sql = "DELETE FROM card_payments WHERE id=?";

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
    public CardPayment findById(Long id) {

        Connection connection = connectionPool.getConnection();

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

            return null;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<CardPayment> findAll() {

        Connection connection = connectionPool.getConnection();

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

            return list;

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            connectionPool.releaseConnection(connection);
        }
    }
}