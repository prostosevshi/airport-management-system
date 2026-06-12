package com.solvd.airportmanagement.dao.mybatisimpl;

import com.solvd.airportmanagement.dao.ReportRepository;
import com.solvd.airportmanagement.entity.Airport;
import com.solvd.airportmanagement.mapper.AirportMapper;
import com.solvd.airportmanagement.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class ReportRepositoryMyBatisImpl implements ReportRepository {

    @Override
    public Airport getFullAirportReport(Long airportId) {

        try (SqlSession session = MyBatisUtil.openSession()) {

            AirportMapper mapper =
                    session.getMapper(AirportMapper.class);

            return mapper.findById(airportId);
        }
    }
}