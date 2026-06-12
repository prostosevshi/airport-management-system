package com.solvd.airportmanagement.listener;

import com.solvd.airportmanagement.entity.Airport;

public class AirportCreatedEvent {
    private Airport airport;

    public AirportCreatedEvent(Airport airport) {
        this.airport = airport;
    }

    public Airport getAirport() {
        return airport;
    }
}
