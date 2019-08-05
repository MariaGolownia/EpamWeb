package by.javatr.service;

import by.javatr.entity.Bicycle;
import by.javatr.entity.Order;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {

    Integer getLastOrderId();

    Integer createOrder(Order order);

    Order readStartOrder(Integer orderId);

    Integer createOrder(Integer idUser, List<Integer> idBicycles);

    Integer createOrder(String idPasswordUser, List<Integer> bicycles) throws SQLException;

    Order read(Integer identity);

    String setFinishTime (Integer idOrder);
}
