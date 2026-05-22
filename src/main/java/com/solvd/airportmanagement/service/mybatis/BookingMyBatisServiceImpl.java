package com.solvd.airportmanagement.service.mybatis;

import com.solvd.airportmanagement.entity.Booking;
import com.solvd.airportmanagement.dao.mybatis.BookingMapper;
import com.solvd.airportmanagement.service.BookingService;
import com.solvd.airportmanagement.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookingMyBatisServiceImpl implements BookingService {

    @Override
    public void createBooking(Booking booking) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            BookingMapper mapper =
                    session.getMapper(BookingMapper.class);

            mapper.insert(booking);
        }
    }

    @Override
    public void updateBooking(Booking booking) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            BookingMapper mapper =
                    session.getMapper(BookingMapper.class);

            mapper.update(booking);
        }
    }

    @Override
    public void deleteBooking(Long id) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            BookingMapper mapper =
                    session.getMapper(BookingMapper.class);

            mapper.delete(id);
        }
    }

    @Override
    public Booking getBookingById(Long id) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            BookingMapper mapper =
                    session.getMapper(BookingMapper.class);

            return mapper.findById(id);
        }
    }

    @Override
    public List<Booking> getAllBookings() {

        try (SqlSession session = MyBatisUtil.openSession()) {

            BookingMapper mapper =
                    session.getMapper(BookingMapper.class);

            return mapper.findAll();
        }
    }
}