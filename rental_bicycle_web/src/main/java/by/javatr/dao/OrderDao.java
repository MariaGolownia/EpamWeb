package by.javatr.dao;
import by.javatr.dao.mysql.BaseDaoSql;
import by.javatr.entity.Bicycle;
import by.javatr.entity.Order;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

public interface OrderDao extends Dao<Order> {

    //List<Order> readByUserId(Integer search) throws SQLException;

    //Order readByBicycle(Bicycle search) throws SQLException;

    //List<Order> readInProcess(Boolean search) throws SQLException;

    Integer getLastId () throws SQLException;

    Integer create(Order order) throws SQLException;

    Order readStartOrder(Integer idOrder) throws SQLException;

    Order read(Integer identity) throws SQLException;

    String selectFinishTime (Integer identity) throws SQLException;

}
