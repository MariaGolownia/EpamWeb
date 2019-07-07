package by.javatr.dao.pool;

import by.javatr.dao.PersistentException;

import java.sql.Connection;

public class ConnectionSQL {
    private static final String SERVER_NAME = "localhost";
    private static final String MY_DATA_BASE = "rental_bicycle_web";
    private static final String URL = "jdbc:mysql://" + SERVER_NAME + "/" + MY_DATA_BASE;
    private static final String USER_SQL_NAME = "root";
    private static final String USER_SQL_PASSWORD = "admin";

    public Connection createConnectionToDB () {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection=null;
        try {
            connectionPool.init("java.sql.Driver",
                    URL, USER_SQL_NAME, USER_SQL_PASSWORD,
                    1,5, 10000);
            connection = connectionPool.getConnection();
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
