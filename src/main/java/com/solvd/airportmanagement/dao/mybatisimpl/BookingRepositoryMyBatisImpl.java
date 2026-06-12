package com.solvd.airportmanagement.dao.mybatisimpl;

import com.solvd.airportmanagement.dao.BookingRepository;
import com.solvd.airportmanagement.entity.Booking;
import com.solvd.airportmanagement.mapper.BookingMapper;
import com.solvd.airportmanagement.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookingRepositoryMyBatisImpl implements BookingRepository {

    @Override
    public void create(Booking booking) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            session.getMapper(BookingMapper.class).insert(booking);
        }
    }

    @Override
    public void update(Booking booking) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            session.getMapper(BookingMapper.class).update(booking);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            session.getMapper(BookingMapper.class).delete(id);
        }
    }

    @Override
    public Booking findById(Long id) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            return session.getMapper(BookingMapper.class).findById(id);
        }
    }

    @Override
    public List<Booking> findAll() {
        try (SqlSession session = MyBatisUtil.openSession()) {
            return session.getMapper(BookingMapper.class).findAll();
        }
    }
}