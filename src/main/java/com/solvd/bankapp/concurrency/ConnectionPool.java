package com.solvd.bankapp.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ConnectionPool {

    private volatile static ConnectionPool connectionPool;
    private List<Connection> connections = new ArrayList<>();

    private ConnectionPool(){
        IntStream.range(1, 6).forEach(i -> {
            Connection connection = new Connection();
            connection.setName("Connection " + i);
            connections.add(connection);
        });
    }

    public synchronized static ConnectionPool getInstance(){
        if (connectionPool == null){
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }

    public synchronized Connection getConnection() throws InterruptedException {

        if (connections.isEmpty()){
            return null;
        }
        Connection connection = connections.get(0);
        connections.remove(connection);
        return connection;
    }

    public synchronized void releaseConnection(Connection connection){
        connections.add(connection);
    }
}
