package by.javatr.dao.mysql;
import by.javatr.dao.BicycleDao;
import by.javatr.dao.PersistentException;
import by.javatr.entity.*;
import java.time.Year;
import java.util.List;
import java.sql.*;
import by.javatr.dao.pool.ConnectionSQL;

public class BicycleDaoImpl extends BaseDaoImpl implements BicycleDao {
    private static final String SQL_BICYCLE_INSERT =
            "INSERT INTO `bicycle` (`bicycle_model`, `bicycle_type`, `bicycle_productionYear`, `bicycle_producer`, " +
                    "`bicycle_currentLocation_id`, `bicycle_photo`, `bicycle_price_id`, `bicycle_ifNotBooked`, `bicycle_ifFree`)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,)";
    private static final String SQL_BICYCLE_BY_ID_SELECT =
            "SELECT `bicycle_model`, `bicycle_type`, `bicycle_productionYear`, `bicycle_producer`," +
                    " `bicycle_currentLocation_id`, `bicycle_photo`, `bicycle_price_id`, `bicycle_ifNotBooked`, `bicycle_ifFree`" +
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
    public List<Bicycle> readByProductionYear(Year search) throws PersistentException {
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
    public Integer create(Bicycle entity) throws PersistentException {
        return null;
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
