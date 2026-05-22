package com.solvd.airportmanagement.service.mybatis;

import com.solvd.airportmanagement.entity.CardPayment;
import com.solvd.airportmanagement.dao.mybatis.CardPaymentMapper;
import com.solvd.airportmanagement.service.CardPaymentService;
import com.solvd.airportmanagement.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CardPaymentMyBatisServiceImpl implements CardPaymentService {

    @Override
    public void createPayment(CardPayment cardPayment) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            CardPaymentMapper mapper =
                    session.getMapper(CardPaymentMapper.class);

            mapper.insert(cardPayment);
        }
    }

    @Override
    public void updatePayment(CardPayment cardPayment) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            CardPaymentMapper mapper =
                    session.getMapper(CardPaymentMapper.class);

            mapper.update(cardPayment);
        }
    }

    @Override
    public void deletePayment(Long id) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            CardPaymentMapper mapper =
                    session.getMapper(CardPaymentMapper.class);

            mapper.delete(id);
        }
    }

    @Override
    public CardPayment getPaymentById(Long id) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            CardPaymentMapper mapper =
                    session.getMapper(CardPaymentMapper.class);

            return mapper.findById(id);
        }
    }

    @Override
    public List<CardPayment> getAllPayments() {

        try (SqlSession session = MyBatisUtil.openSession()) {

            CardPaymentMapper mapper =
                    session.getMapper(CardPaymentMapper.class);

            return mapper.findAll();
        }
    }
}