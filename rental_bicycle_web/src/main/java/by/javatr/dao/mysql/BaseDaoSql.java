package by.javatr.dao.mysql;
import by.javatr.dao.pool.ConnectionSQL;
import java.sql.Connection;

public class BaseDaoSql {
    protected Connection connection;

    public BaseDaoSql(Connection connection) {
        this.connection = connection;
    }

    protected BaseDaoSql() {
    }
}
