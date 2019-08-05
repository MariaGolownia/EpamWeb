package by.javatr.service.impl;
import by.javatr.dao.OrderDao;
import by.javatr.dao.UserInfoDao;
import by.javatr.dao.mysql.*;
import by.javatr.entity.Order;
import by.javatr.entity.User;
import by.javatr.entity.UserInfo;
import by.javatr.service.OrderService;
import by.javatr.service.Service;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class OrderServiceImpl extends Service implements OrderService {
    @Override
    public Integer getLastOrderId() {
        Integer numberLastId = 0;
        OrderDao dao = null;
        try {
            dao = FactoryDaoSql.getInstance().get(DaoSql.OrderDao);
            numberLastId = dao.getLastId();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (DaoException e) {
            e.printStackTrace();
        }
        return numberLastId;
    }

    @Override
    public Integer createOrder(Order order) {
        Integer orderId = 0;
        OrderDao dao = null;
        try {
            dao = FactoryDaoSql.getInstance().get(DaoSql.OrderDao);
            LocalDateTime localDateTimeStart = LocalDateTime.now();
            order.setStartTime(localDateTimeStart);
            orderId = dao.create(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (DaoException e) {
            e.printStackTrace();
        }
        return orderId;

    }

    @Override
    public Order readStartOrder(Integer orderId) {
        OrderDao dao = null;
        Order order = new Order();
        try {
            dao = FactoryDaoSql.getInstance().get(DaoSql.OrderDao);
            order = dao.readStartOrder(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public Integer createOrder(Integer idUser, List<Integer> idBicycles) {
        Integer orderId = 0;
        Order order = new Order();
        User user = new User();
        try {
            UserDaoSql userDaoSql =  FactoryDaoSql.getInstance().get(DaoSql.UserDao);
            user = userDaoSql.read(idUser);
            order.setUserId(idUser);
            order.setBicyclesId(idBicycles);
            LocalDateTime localDateTimeStart = LocalDateTime.now();
            order.setStartTime(localDateTimeStart);
            orderId = createOrder(order);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return orderId;
    }

    @Override
    public Integer createOrder(String idPasswordUser, List<Integer> idBicycles) {
        Integer orderId = 0;
        Order order = new Order();
        UserInfo userInfo = new UserInfo();
        User user = new User();
        try {
            UserInfoDao userInfoDaoSql =  FactoryDaoSql.getInstance().get(DaoSql.UserInfoDao);
            userInfo = userInfoDaoSql.readByPassportId(idPasswordUser);
            order.setUserId(userInfo.getId());
            order.setBicyclesId(idBicycles);
            LocalDateTime localDateTimeStart = LocalDateTime.now();
            order.setStartTime(localDateTimeStart);
            orderId = createOrder(order);
        } catch (DaoException e) {
            e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return orderId;
    }

    @Override
    public Order read(Integer identity) {
        return null;
    }

    @Override
    public String setFinishTime(Integer idOrder) {
        String finishTimeStr = "";
        try {
            OrderDaoSql orderDaoSql =  FactoryDaoSql.getInstance().get(DaoSql.OrderDao);
            finishTimeStr = orderDaoSql.selectFinishTime(idOrder);
        } catch (DaoException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return finishTimeStr;
    }
}
