package com.solvd.airportmanagement.mapper;

import java.util.List;
import java.util.Map;

public interface ReportMapper {

    List<Map<String, Object>> getFullAirportReport();
}