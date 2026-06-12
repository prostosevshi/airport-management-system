package com.solvd.airportmanagement.listener;

public class LoggingAirportListener implements AirportListener {

    @Override
    public void onAirportCreated(AirportCreatedEvent event) {
        System.out.println("Airport created: " +
                event.getAirport().getAirportName());
    }
}
