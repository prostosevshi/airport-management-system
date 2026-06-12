package com.solvd.airportmanagement.dao.mybatisimpl;

import com.solvd.airportmanagement.dao.CardPaymentRepository;
import com.solvd.airportmanagement.entity.CardPayment;
import com.solvd.airportmanagement.mapper.CardPaymentMapper;
import com.solvd.airportmanagement.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CardPaymentRepositoryMyBatisImpl implements CardPaymentRepository {

    @Override
    public void create(CardPayment cardPayment) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            session.getMapper(CardPaymentMapper.class).insert(cardPayment);
        }
    }

    @Override
    public void update(CardPayment cardPayment) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            session.getMapper(CardPaymentMapper.class).update(cardPayment);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            session.getMapper(CardPaymentMapper.class).delete(id);
        }
    }

    @Override
    public CardPayment findById(Long id) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            return session.getMapper(CardPaymentMapper.class).findById(id);
        }
    }

    @Override
    public List<CardPayment> findAll() {
        try (SqlSession session = MyBatisUtil.openSession()) {
            return session.getMapper(CardPaymentMapper.class).findAll();
        }
    }
}