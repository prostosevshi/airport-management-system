package com.solvd.airportmanagement.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {

    private static volatile ConnectionPool instance;

    private final BlockingQueue<Connection> pool;

    private ConnectionPool(int size) {
        pool = new ArrayBlockingQueue<>(size);

        for (int i = 0; i < size; i++) {
            pool.add(new Connection(i));
        }
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool(5);
                }
            }
        }
        return instance;
    }

    public Connection getConnection() throws InterruptedException {
        return pool.take();
    }

    public void releaseConnection(Connection connection) {
        pool.offer(connection);
    }
}
