package com.solvd.airportmanagement.dao.mybatis;

import java.util.List;
import java.util.Map;

public interface ReportMapper {

    List<Map<String, Object>> getFullAirportReport();
}