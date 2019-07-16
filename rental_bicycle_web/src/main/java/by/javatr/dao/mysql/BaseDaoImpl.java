package by.javatr.dao.mysql;
import by.javatr.dao.pool.ConnectionSQL;
import java.sql.Connection;

public class BaseDaoImpl {
    protected Connection connection;

    public BaseDaoImpl (Connection connection) {
        this.connection = connection;
    }

    protected BaseDaoImpl () {
    }
}
