package by.javatr.dao.mysql;
import by.javatr.entity.PersistentException;
import by.javatr.dao.OrderDao;
import by.javatr.entity.Order;
import org.apache.logging.log4j.LogManager;
import java.sql.*;
import java.time.LocalDateTime;

public class OrderDaoSql extends BaseDaoSql implements OrderDao {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();
    private static final String SQL_RENT_UPDATE_FINISH_TIME =
            "UPDATE `rent` " +
                    "SET `rent_finish_time` = ? WHERE `rent_id` = ?";
    private static final String SQL_RENT_INSERT =
            "INSERT INTO `rent` " +
                    "(`rent_user_id`, `rent_start_time`) VALUES (?, ?)";
    private static final String SQL_RENT_BIC_INSERT =
            "INSERT INTO `rent_bic` " +
                    "(`rent_bic_id`, `rent_bic_user_id`, `rent_bic_bicycle_id`) VALUES (?, ?, ?)";
    private static final String SQL_SELECT_RENT_BY_ID =
            "SELECT `rent_user_id`, `rent_start_time`, `rent_finish_time`,`rent_finishLocation_id`, " +
                    "`rent_startLocation_id`, `rent_payment_id` FROM `rent` WHERE `rent_id` = ?";
    private static final String SQL_SELECT_START_RENT_BY_ID =
            "SELECT `rent_user_id`, `rent_start_time`" +
                    " FROM `rent` WHERE `rent_id` = ?";
//    private static final String SQL_SELECT_ALL_RENT_BY_BICYCLE_ID =
//            "SELECT `rent_id`, `rent_user_id`, `rent_start_time`, `rent_finish_time`, `rent_finishLocation_id` " +
//                    "FROM `rent` WHERE `rent_bicycle_id` = ?";
    private static final String SQL_SELECT_ALL_RENT_BY_USER_ID =
            "SELECT `rent_id`, `rent_bicycle_id`, `rent_start_time`, `rent_finish_time`, `rent_finishLocation_id` " +
                    "FROM `rent` WHERE `rent_user_id` = ?";
    private static final String SQL_SELECT_ALL_RENT_IN_PROCESS =
            "SELECT `rent_id`, `rent_user_id`, `rent_bicycle_id`, `rent_start_time`, `rent_finishLocation_id` " +
                    "FROM `rent` WHERE rent_finish_time = null";
    private static final String SQL_SELECT_ALL_RENT =
            "SELECT `rent_id`, `rent_user_id`, `rent_bicycle_id`, `rent_start_time`, `rent_finish_time`, " +
                    "`rent_finishLocation_id`, `rent_payment_id` FROM `rent` ORDER BY `rent_user_id`";
    private static final String SQL_RENT_UPDATE =
            "UPDATE `rent` SET `rent_user_id`= ?, `rent_bicycle_id`= ?, `rent_start_time`= ?," +
                    " `rent_finishLocation_id`= ? WHERE `rent_id` = ?";
    private static final String SQL_RENT_DELETE = "DELETE FROM `rent` WHERE `rent_id` = ?";
    private static final String SQL_SELECT_LAST_ORDER =
            "SELECT MAX(`rent_id`) AS RENT_LAST_ORDER FROM `rent`";
    public OrderDaoSql(Connection connection) {
        this.connection = connection;
    }

    protected OrderDaoSql() {
        super();
    }

//    @Override
//    public List<Order> readByUserId(Integer userId) throws PersistentException {
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        try {
//            statement = connection.prepareStatement(SQL_SELECT_ALL_RENT_BY_USER_ID);
//            statement.setInt(1, userId);
//            resultSet = statement.executeQuery();
//            List<Order> rentList = new ArrayList<>();
//            if(resultSet.next()) {
//                Order rent =  new Order();
//                rent.setId(resultSet.getInt("rent_id"));
//                Integer bicycleId = resultSet.getInt("rent_bicycle_id");
//                BicycleDaoSql bicycleDao = new BicycleDaoSql(connection);
//                Bicycle bicycle = new Bicycle();
//                bicycle = bicycleDao.read(bicycleId);
//                rent.setBicycle(bicycle);
//                UserDaoSql userDao = new UserDaoSql(connection);
//                User user = userDao.read(userId);
//                rent.setUser(user);
//                rent.setStartTime(resultSet.getTimestamp("rent_start_time").toLocalDateTime());
//                Timestamp timestampFinish = resultSet.getTimestamp("rent_finish_time");
//                if (timestampFinish != null) {
//                    LocalDateTime localDateTimeFinish = timestampFinish.toLocalDateTime();
//                    rent.setFinishTime(localDateTimeFinish);
//                }
//                else {
//                    rent.setFinishTime(null);
//                }
//                LocationDaoSql locationDao = new LocationDaoSql(connection);
//                Location locationFinish = locationDao.read(resultSet.getInt("rent_finishLocation_id"), connection);
//                rent.setFinishLocation(locationFinish);
//                rentList.add(rent);
//            }
//            return rentList;
//        } catch(SQLException e) {
//            throw new PersistentException(e);
//        } finally {
//            try {
//                resultSet.close();
//            } catch(SQLException | NullPointerException e) {}
//            try {
//                statement.close();
//            } catch(SQLException | NullPointerException e) {}
//        }
//    }

//    @Override
//    public Order readByBicycle(Bicycle bicycle) throws PersistentException {
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        try {
//            statement = connection.prepareStatement(SQL_SELECT_ALL_RENT_BY_BICYCLE_ID);
//            statement.setInt(1, bicycle.getId());
//            resultSet = statement.executeQuery();
//            Order rent =  new Order();
//            if(resultSet.next()) {
//                rent =  new Order();
//                rent.setId(resultSet.getInt("rent_id"));
//                rent.setBicycle(bicycle);
//                Integer userId = resultSet.getInt("rent_user_id");
//                UserDaoSql userDao = new UserDaoSql(connection);
//                User user = userDao.read(userId);
//                rent.setUser(user);
//                rent.setStartTime(resultSet.getTimestamp("rent_start_time").toLocalDateTime());
//                Timestamp timestampFinish = resultSet.getTimestamp("rent_finish_time");
//                if (timestampFinish != null) {
//                    LocalDateTime localDateTimeFinish = timestampFinish.toLocalDateTime();
//                    rent.setFinishTime(localDateTimeFinish);
//                }
//                else {
//                    rent.setFinishTime(null);
//                }
//                LocationDaoSql locationDao = new LocationDaoSql(connection);
//                Location locationFinish = locationDao.read(resultSet.getInt("rent_finishLocation_id"), connection);
//                rent.setFinishLocation(locationFinish);
//            }
//            return rent;
//        } catch(SQLException e) {
//            throw new PersistentException(e);
//        } finally {
//            try {
//                resultSet.close();
//            } catch(SQLException | NullPointerException e) {}
//            try {
//                statement.close();
//            } catch(SQLException | NullPointerException e) {}
//        }
//    }

//    @Override
//    public List<Order> readInProcess(Boolean search) throws PersistentException {
//        return null;
//    }

    @Override
    public Integer getLastId() throws SQLException {
       Integer lastOrderId = 0;
       PreparedStatement statement = null;
       ResultSet resultSet = null;
       statement = connection.prepareStatement(SQL_SELECT_LAST_ORDER);
        resultSet =  statement.executeQuery();
        if (resultSet.next())
       lastOrderId = resultSet.getInt("RENT_LAST_ORDER");
       return lastOrderId;
    }


    @Override
    public Integer create(Order order) throws SQLException {
        PreparedStatement statement = null;
        statement = connection.prepareStatement(SQL_RENT_INSERT, Statement.RETURN_GENERATED_KEYS);
        PreparedStatement statementAdditional = null;

        ResultSet resultSet = null;
        Integer idOfOrder = null;
        Integer userId = order.getUserId();
        statement.setInt(1, Integer.valueOf(userId));
        LocalDateTime localDateTimeStart = order.getStartTime();
        statement.setTimestamp(2, Timestamp.valueOf(localDateTimeStart));
        statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            idOfOrder = resultSet.getInt(1);
        } else {
            logger.error("There is no autoincremented index after trying to add record into table `users`");
        }
        for (int i = 0; i < order.getBicyclesId().size(); i++) {
            statementAdditional = null;
            statementAdditional = connection.prepareStatement(SQL_RENT_BIC_INSERT);
            statementAdditional.setInt(1, idOfOrder);
            statementAdditional.setInt(2, userId);
            statementAdditional.setInt(3, order.getBicyclesId().get(i));
            statementAdditional.executeUpdate();
        }
        try {
            resultSet.close();
        } catch (SQLException | NullPointerException e) {
        }
        try {
            statement.close();
        } catch (SQLException | NullPointerException e) {
        }

        return idOfOrder;
    }
    //SQL_SELECT_START_RENT_BY_ID

    @Override
    public Order readStartOrder(Integer idOrder) throws SQLException {
        Integer orderId;
        LocalDateTime localDateTimeStart;
        Order order = new Order();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        statement = connection.prepareStatement(SQL_SELECT_START_RENT_BY_ID);
        statement.setInt(1, idOrder);
        resultSet =  statement.executeQuery();
        if (resultSet.next()) {
            orderId = resultSet.getInt("rent_user_id");
            localDateTimeStart = (resultSet.getTimestamp("rent_start_time")).toLocalDateTime();
            order.setId(idOrder);
            order.setStartTime(localDateTimeStart);
            order.setUserId(orderId);
        }

        try {
            resultSet.close();
        } catch(SQLException | NullPointerException e) {}
        try {
            statement.close();
        } catch(SQLException | NullPointerException e) {}

        return order;

    }

    @Override
    public Order read(Integer identity) throws SQLException {
    return null;
    }

    @Override
    public String selectFinishTime(Integer idOrder) throws SQLException {
        Integer orderId;
        LocalDateTime localDateTimeFinish = LocalDateTime.now();
        String localDateTimeFinishStr = localDateTimeFinish.toString();
        Order order = new Order();
        PreparedStatement statement = null;
        statement = connection.prepareStatement(SQL_RENT_UPDATE_FINISH_TIME);
        statement.setTimestamp(1, Timestamp.valueOf(localDateTimeFinish));
        statement.setInt(2, idOrder);
        statement.execute();
        try {
            statement.close();
        } catch(SQLException | NullPointerException e) {}
        return localDateTimeFinishStr;
    }


    @Override
    public void update(Order entity) throws SQLException {

    }


    @Override
    public void delete(Integer identity) throws SQLException {

    }
}
