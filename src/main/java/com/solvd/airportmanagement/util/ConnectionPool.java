package com.solvd.airportmanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {

    private static volatile ConnectionPool instance;

    private static final int POOL_SIZE = 5;

    private final BlockingQueue<Connection> pool;

    private static final String URL =
            Config.getProperty("db.url");

    private static final String USERNAME =
            Config.getProperty("db.username");

    private static final String PASSWORD =
            Config.getProperty("db.password");

    private static final String DRIVER =
            Config.getProperty("db.driver");

    private ConnectionPool() {

        pool = new ArrayBlockingQueue<>(POOL_SIZE);

        try {

            Class.forName(DRIVER);

            for (int i = 0; i < POOL_SIZE; i++) {

                Connection connection =
                        DriverManager.getConnection(
                                URL,
                                USERNAME,
                                PASSWORD
                        );

                pool.put(connection);
            }

        } catch (ClassNotFoundException |
                 SQLException |
                 InterruptedException e) {

            throw new RuntimeException(e);
        }
    }

    public static ConnectionPool getInstance() {

        if (instance == null) {

            synchronized (ConnectionPool.class) {

                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }

        return instance;
    }

    public Connection getConnection() {

        try {

            return pool.take();

        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
    }

    public void releaseConnection(Connection connection) {

        try {

            pool.put(connection);

        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
    }
}