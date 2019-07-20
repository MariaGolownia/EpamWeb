package by.javatr.dao.mysql;
import by.javatr.dao.PersistentException;
import by.javatr.dao.RentDao;
import by.javatr.entity.Bicycle;
import by.javatr.entity.Location;
import by.javatr.entity.Rent;
import by.javatr.entity.User;
import org.apache.logging.log4j.LogManager;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RentDaoSql extends BaseDaoSql implements RentDao {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();
    private static final String SQL_RENT_INSERT =
            "INSERT INTO `rent` " +
                    "(`rent_user_id`, `rent_bicycle_id`, `rent_start_time`) VALUES (?, ?, ?)";
    private static final String SQL_SELECT_RENT_BY_ID =
            "SELECT `rent_user_id`, `rent_bicycle_id`, `rent_start_time`, `rent_finish_time`, `rent_finishLocation_id`, " +
                    "`rent_payment_id` FROM `rent` WHERE `rent_id` = ?";
    private static final String SQL_SELECT_ALL_RENT_BY_BICYCLE_ID =
            "SELECT `rent_id`, `rent_user_id`, `rent_start_time`, `rent_finish_time`, `rent_finishLocation_id` " +
                    "FROM `rent` WHERE `rent_bicycle_id` = ?";
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

    public RentDaoSql(Connection connection) {
        this.connection = connection;
    }

    protected RentDaoSql() {
        super();
    }

    @Override
    public List<Rent> readByUserId(Integer userId) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_RENT_BY_USER_ID);
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            List<Rent> rentList = new ArrayList<>();
            if(resultSet.next()) {
                Rent rent =  new Rent();
                rent.setId(resultSet.getInt("rent_id"));
                Integer bicycleId = resultSet.getInt("rent_bicycle_id");
                BicycleDaoSql bicycleDao = new BicycleDaoSql(connection);
                Bicycle bicycle = new Bicycle();
                bicycle = bicycleDao.read(bicycleId);
                rent.setBicycle(bicycle);
                UserDaoSql userDao = new UserDaoSql(connection);
                User user = userDao.read(userId);
                rent.setUser(user);
                rent.setStartTime(resultSet.getTimestamp("rent_start_time").toLocalDateTime());
                Timestamp timestampFinish = resultSet.getTimestamp("rent_finish_time");
                if (timestampFinish != null) {
                    LocalDateTime localDateTimeFinish = timestampFinish.toLocalDateTime();
                    rent.setFinishTime(localDateTimeFinish);
                }
                else {
                    rent.setFinishTime(null);
                }
                LocationDaoSql locationDao = new LocationDaoSql(connection);
                Location locationFinish = locationDao.read(resultSet.getInt("rent_finishLocation_id"), connection);
                rent.setFinishLocation(locationFinish);
                rentList.add(rent);
            }
            return rentList;
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public Rent readByBicycle(Bicycle bicycle) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL_RENT_BY_BICYCLE_ID);
            statement.setInt(1, bicycle.getId());
            resultSet = statement.executeQuery();
            Rent rent =  new Rent();
            if(resultSet.next()) {
                rent =  new Rent();
                rent.setId(resultSet.getInt("rent_id"));
                rent.setBicycle(bicycle);
                Integer userId = resultSet.getInt("rent_user_id");
                UserDaoSql userDao = new UserDaoSql(connection);
                User user = userDao.read(userId);
                rent.setUser(user);
                rent.setStartTime(resultSet.getTimestamp("rent_start_time").toLocalDateTime());
                Timestamp timestampFinish = resultSet.getTimestamp("rent_finish_time");
                if (timestampFinish != null) {
                    LocalDateTime localDateTimeFinish = timestampFinish.toLocalDateTime();
                    rent.setFinishTime(localDateTimeFinish);
                }
                else {
                    rent.setFinishTime(null);
                }
                LocationDaoSql locationDao = new LocationDaoSql(connection);
                Location locationFinish = locationDao.read(resultSet.getInt("rent_finishLocation_id"), connection);
                rent.setFinishLocation(locationFinish);
            }
            return rent;
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public List<Rent> readInProcess(Boolean search) throws PersistentException {
        return null;
    }

    @Override
    public Integer create(Rent rent) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer idOfPrice = null;
        try {
            statement = connection.prepareStatement(SQL_RENT_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, Integer.valueOf(rent.getUser().getId()));
            statement.setInt(2, Integer.valueOf(rent.getBicycle().getId()));
            LocalDateTime localDateTimeStart = rent.getStartTime();
            statement.setTimestamp(3, Timestamp.valueOf(localDateTimeStart));
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                idOfPrice = resultSet.getInt(1);
            } else {
                logger.error("There is no autoincremented index after trying to add record into table `users`");
                throw new PersistentException();
            }

        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
        return idOfPrice;
    }

    @Override
    public Rent read(Integer identity) throws PersistentException {
        return null;
    }

    @Override
    public void update(Rent entity) throws PersistentException {

    }

    @Override
    public void delete(Integer identity) throws PersistentException {

    }
}
