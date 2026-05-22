package com.solvd.airportmanagement.service.mybatis;

import com.solvd.airportmanagement.entity.Guest;
import com.solvd.airportmanagement.dao.mybatis.GuestMapper;
import com.solvd.airportmanagement.service.GuestService;
import com.solvd.airportmanagement.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GuestMyBatisServiceImpl implements GuestService {

    @Override
    public void createGuest(Guest guest) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            GuestMapper mapper =
                    session.getMapper(GuestMapper.class);

            mapper.insert(guest);
        }
    }

    @Override
    public void updateGuest(Guest guest) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            GuestMapper mapper =
                    session.getMapper(GuestMapper.class);

            mapper.update(guest);
        }
    }

    @Override
    public void deleteGuest(Long id) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            GuestMapper mapper =
                    session.getMapper(GuestMapper.class);

            mapper.delete(id);
        }
    }

    @Override
    public Guest getGuestById(Long id) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            GuestMapper mapper =
                    session.getMapper(GuestMapper.class);

            return mapper.findById(id);
        }
    }

    @Override
    public List<Guest> getAllGuests() {

        try (SqlSession session = MyBatisUtil.openSession()) {

            GuestMapper mapper =
                    session.getMapper(GuestMapper.class);

            return mapper.findAll();
        }
    }
}