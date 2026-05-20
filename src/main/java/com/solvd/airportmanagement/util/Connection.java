package com.solvd.airportmanagement.util;

public class Connection {

    private final int id;

    public Connection(int id) {
        this.id = id;
    }

    public void execute() {
        System.out.println("Using connection " + id);
    }

    public int getId() {
        return id;
    }
}
