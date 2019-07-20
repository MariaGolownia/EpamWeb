package by.javatr.dao.mysql;
import by.javatr.dao.BicycleDao;
import by.javatr.dao.PersistentException;
import by.javatr.entity.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import by.javatr.entity.en_um.BicycleType;
import org.apache.logging.log4j.LogManager;

public class BicycleDaoSql extends BaseDaoSql implements BicycleDao {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();
    private static final String SQL_BICYCLE_INSERT =
            "INSERT INTO `bicycle` (`bicycle_model`, `bicycle_type`, `bicycle_productionYear`, `bicycle_producer`, " +
                    "`bicycle_currentLocation_id`, `bicycle_price_id`, `bicycle_ifNotBooked`, `bicycle_ifFree`,`bicycle_photo`)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_BICYCLE_BY_ID_SELECT =
            "SELECT `bicycle_model`, `bicycle_type`, `bicycle_productionYear`, `bicycle_producer`," +
                    " `bicycle_currentLocation_id`, `bicycle_price_id`, `bicycle_ifNotBooked`, `bicycle_ifFree`, `bicycle_photo`" +
                    " FROM `bicycle` WHERE `bicycle_id` = ?";
    private static final String SQL_BICYCLE_BY_CURRENT_LOCATION =
            "SELECT `bicycle_id`,`bicycle_model`, `bicycle_type`, `bicycle_productionYear`, `bicycle_producer`," +
                    "`bicycle_price_id`, `bicycle_ifNotBooked`, `bicycle_ifFree`, `bicycle_photo`" +
                    " FROM `bicycle` WHERE `bicycle_currentLocation_id` = ?";
    private static final String SQL_BICYCLE_UPDATE =
            "UPDATE `bicycle` SET `bicycle_model`= ?, `bicycle_type`= ?, `bicycle_productionYear`= ?," +
                    " `bicycle_producer`= ?, `bicycle_currentLocation_id`= ?, `bicycle_price_id`= ?," +
                    " `bicycle_ifNotBooked`= ?, `bicycle_ifFree`= ?, `bicycle_photo`= ? WHERE `bicycle_id` = ?";
    private static final String SQL_BICYCLE_DELETE = "DELETE FROM `bicycle` WHERE `bicycle_id` = ?";

    protected BicycleDaoSql() {
        super();
    }

    public BicycleDaoSql(Connection connection) {
        super(connection);
    }

    @Override
    public List<Bicycle> readByCurrentLocation(Location location) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
//            ConnectionSQL connectionSQL = new ConnectionSQL();
//            connection = connectionSQL.getConnectionToDB();
            statement = connection.prepareStatement(SQL_BICYCLE_BY_CURRENT_LOCATION);
            statement.setInt(1, location.getId());
            resultSet = statement.executeQuery();
            List<Bicycle> bicycles = new ArrayList<>();
            while(resultSet.next()) {
                Bicycle bicycle = new Bicycle();
                Integer bicycleID = resultSet.getInt("bicycle_id");
                bicycle.setId(bicycleID);
                bicycle.setModel(resultSet.getString("bicycle_model"));
                BicycleType bicycleType = BicycleType.getBicycleType(resultSet.getString("bicycle_type"));
                bicycle.setBicycleType(bicycleType);
                bicycle.setProductionYear(resultSet.getShort("bicycle_productionYear"));
                bicycle.setProducer(resultSet.getString("bicycle_producer"));
                bicycle.setCurrentLocation(location);
                bicycle.setPhoto(resultSet.getBlob("bicycle_photo"));
                Price price = new Price();
                PriceDaoSql priceDao = new PriceDaoSql();
                price = priceDao.read(resultSet.getInt("bicycle_price_id"), connection);
                bicycle.setPrice(price);
                bicycle.setIfNotBooked(resultSet.getBoolean("bicycle_ifNotBooked"));
                bicycle.setIfFree(resultSet.getBoolean("bicycle_ifFree"));
                bicycles.add(bicycle);
            }
            return bicycles;
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
//                connection.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }


    @Override
    public Integer create(Bicycle bicycle) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer idOfLocation = null;
        try {
            statement = connection.prepareStatement(SQL_BICYCLE_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, bicycle.getModel());
            statement.setString(2, bicycle.getBicycleType().getName());
            statement.setShort(3, bicycle.getProductionYear());
            statement.setString(4, bicycle.getProducer());
            // locationID
            Location location = new Location();
            LocationDaoSql locationDao = new LocationDaoSql(connection);
            Integer locationID = bicycle.getCurrentLocation().getId();
            if (locationID != null) {
                location = locationDao.read(locationID, connection);
                statement.setInt(5, location.getId());
            }
            else {
                statement.setInt(5, 1);
            }
            // priceID
            Price price = new Price();
            PriceDaoSql priceDao = new PriceDaoSql(connection);
            Integer priceID = bicycle.getPrice().getId();
            if (priceID != null) {
                price = priceDao.read(priceID, connection);
                statement.setInt(6, price.getId());
            }
            else {
                statement.setInt(6, 1);
            }
            statement.setInt(7, bicycle.getIfNotBookedInt());
            statement.setInt(8, bicycle.getIfFreeInt());
            statement.setInt(9, bicycle.getIfFreeInt());
            if (bicycle.getPhoto().length() > 3) {
                statement.setBlob(9, bicycle.getPhoto());
            }
            else {
                Bicycle bicycleD = new Bicycle();
                BicycleDaoSql bicycleDao = new BicycleDaoSql(connection);
                bicycleD = bicycleDao.read(1);
                statement.setBlob(8, bicycleD.getPhoto());
            }
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                idOfLocation = resultSet.getInt(1);
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
        return idOfLocation;
    }

    @Override
    public Bicycle read(Integer id) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_BICYCLE_BY_ID_SELECT);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Bicycle bicycle = new Bicycle();
            if(resultSet.next()) {
                bicycle = new Bicycle();
                bicycle.setId(id);
                bicycle.setModel(resultSet.getString("bicycle_model"));
                BicycleType bicycleType = BicycleType.getBicycleType(resultSet.getString("bicycle_type"));
                bicycle.setBicycleType(bicycleType);
                bicycle.setProductionYear(resultSet.getShort("bicycle_productionYear"));
                bicycle.setProducer(resultSet.getString("bicycle_producer"));
                Location location = new Location();
                LocationDaoSql locationDao = new LocationDaoSql(connection);
                location = locationDao.read(resultSet.getInt("bicycle_currentLocation_id"), connection);
                bicycle.setCurrentLocation(location);
                bicycle.setPhoto(resultSet.getBlob("bicycle_photo"));
                Price price = new Price();
                PriceDaoSql priceDao = new PriceDaoSql(connection);
                price = priceDao.read(resultSet.getInt("bicycle_price_id"), connection);
                bicycle.setPrice(price);
                bicycle.setIfNotBooked(resultSet.getBoolean("bicycle_ifNotBooked"));
                bicycle.setIfFree(resultSet.getBoolean("bicycle_ifFree"));
            }
            return bicycle;
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
    public void update(Bicycle bicycle) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer idOfLocation = null;
        try {
            statement = connection.prepareStatement(SQL_BICYCLE_UPDATE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, bicycle.getModel());
            statement.setString(2, bicycle.getBicycleType().getName());
            statement.setShort(3, bicycle.getProductionYear());
            statement.setString(4, bicycle.getProducer());
            Location location = new Location();
            LocationDaoSql locationDao = new LocationDaoSql(connection);
            location = locationDao.read(bicycle.getCurrentLocation().getId(),connection);
            statement.setInt(5, location.getId());
            Price price = new Price();
            PriceDaoSql priceDao = new PriceDaoSql(connection);
            price = priceDao.read(bicycle.getPrice().getId(), connection);
            statement.setInt(6, price.getId());
            statement.setInt(7, bicycle.getIfNotBookedInt());
            statement.setInt(8, bicycle.getIfFreeInt());
            Integer companyNumber = location.getCompany().getAccountNumberOfPayer();
            statement.setBlob(9, bicycle.getPhoto());
            statement.setInt(10, bicycle.getId());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
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
    public void delete(Integer id) throws PersistentException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_BICYCLE_DELETE);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }
}
