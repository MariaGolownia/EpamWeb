package by.javatr.dao.mysql;
import by.javatr.dao.BicycleDao;
import by.javatr.dao.PersistentException;
import by.javatr.dao.valid.SQLValidation;
import by.javatr.entity.*;
import java.util.List;
import java.sql.*;
import by.javatr.dao.pool.ConnectionSQL;
import by.javatr.entity.en_um.BicycleType;
import org.apache.logging.log4j.LogManager;

public class BicycleDaoImpl extends BaseDaoImpl implements BicycleDao {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();
    private static final String SQL_BICYCLE_INSERT =
            "INSERT INTO `bicycle` (`bicycle_model`, `bicycle_type`, `bicycle_productionYear`, `bicycle_producer`, " +
                    "`bicycle_currentLocation_id`, `bicycle_price_id`, `bicycle_ifNotBooked`, `bicycle_ifFree`,`bicycle_photo`)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,)";
    private static final String SQL_BICYCLE_BY_ID_SELECT =
            "SELECT `bicycle_model`, `bicycle_type`, `bicycle_productionYear`, `bicycle_producer`," +
                    " `bicycle_currentLocation_id`, `bicycle_price_id`, `bicycle_ifNotBooked`, `bicycle_ifFree`, `bicycle_photo`" +
                    " FROM `bicycle` WHERE `bicycle_id` = ?";


    @Override
    public List<Bicycle> readByModel(String search) throws PersistentException {
        return null;
    }

    @Override
    public List<Bicycle> readByType(Bicycle search) throws PersistentException {
        return null;
    }

    @Override
    public List<Bicycle> readByProductionYear(Integer search) throws PersistentException {
        return null;
    }

    @Override
    public List<Bicycle> readByProducer(String search) throws PersistentException {
        return null;
    }

    @Override
    public List<Bicycle> readCurrentLocation(Location search) throws PersistentException {
        return null;
    }

    @Override
    public List<Bicycle> readCurrentLocation(Price search) throws PersistentException {
        return null;
    }
    
    @Override
    public Integer create(Bicycle bicycle) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer idOfLocation = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            SQLValidation sqlValidation = new SQLValidation();
            statement = connection.prepareStatement(SQL_BICYCLE_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, bicycle.getModel());
            statement.setString(2, bicycle.getBicycleType().getName());
            statement.setShort(3, bicycle.getProductionYear());
            statement.setString(4, bicycle.getProducer());
            // locationID
            Location location = new Location();
            LocationDaoImpl locationDao = new LocationDaoImpl();
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
            PriceDaoImpl priceDao = new PriceDaoImpl();
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
            if (!bicycle.getPhoto().equals(null)) {
                statement.setBlob(8, bicycle.getPhoto());
            }
            else {
                Bicycle bicycleD = new Bicycle();
                BicycleDaoImpl bicycleDao = new BicycleDaoImpl();
                bicycleD = bicycleDao.read(1);
                statement.setBlob(1, bicycleD.getPhoto());
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
                connection.close();
            } catch(SQLException | NullPointerException e) {}
        }
        return idOfLocation;
    }


    @Override
    public Bicycle read(Integer id) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            statement = connection.prepareStatement(SQL_BICYCLE_BY_ID_SELECT);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Bicycle bicycle = null;
            if(resultSet.next()) {
                bicycle = new Bicycle();
                bicycle.setId(id);
                bicycle.setModel(resultSet.getString("bicycle_model"));
                BicycleType bicycleType = BicycleType.getBicycleType(resultSet.getString("bicycle_type"));
                bicycle.setBicycleType(bicycleType);
                bicycle.setProductionYear(resultSet.getShort("bicycle_productionYear"));
                bicycle.setProducer(resultSet.getString("bicycle_producer"));
                Location location = new Location();
                LocationDaoImpl locationDao = new LocationDaoImpl();
                location = locationDao.read(resultSet.getInt("bicycle_currentLocation_id"), connection);
                bicycle.setCurrentLocation(location);
                bicycle.setPhoto(resultSet.getBlob("bicycle_photo"));
                Price price = new Price();
                PriceDaoImpl priceDao = new PriceDaoImpl();
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
                connection.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public void update(Bicycle entity) throws PersistentException {

    }

    @Override
    public void delete(Integer identity) throws PersistentException {

    }
}
