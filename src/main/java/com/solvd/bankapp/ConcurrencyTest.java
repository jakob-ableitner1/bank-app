package com.solvd.bankapp;

import com.solvd.bankapp.concurrency.Connection;
import com.solvd.bankapp.concurrency.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConcurrencyTest {

    private static final Logger LOGGER = LogManager.getLogger(ConcurrencyTest.class);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i<7; i++){
            new Thread(() ->{
                ConnectionPool connectionPool = ConnectionPool.getInstance();
                int timer = 0;
                try{
                    Connection connection = connectionPool.getConnection();
                    while(connection == null && timer < 60000){
                        connection = connectionPool.getConnection();
                        Thread.sleep(3000);
                        timer+=3000;
                    }
                    if (connection != null){
                        LOGGER.info(connection.getName());
                        connectionPool.releaseConnection(connection);
                    } else {
                        throw new RuntimeException();
                    }
                } catch(InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
