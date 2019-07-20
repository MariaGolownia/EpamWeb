package by.javatr.dao.mysql;
import by.javatr.dao.Dao;
import by.javatr.dao.PersistentException;
import by.javatr.dao.pool.ConnectionSQL;
import org.apache.logging.log4j.LogManager;
import java.sql.Connection;
import java.sql.SQLException;

final public class FactoryDaoSql {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();
    private static final FactoryDaoSql instance = new FactoryDaoSql();
    private Connection connection;

    public static FactoryDaoSql getInstance(){
        return instance;
    }

    private FactoryDaoSql(){
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            if (connection == null) {
                throw new DaoException ("Initialization of connection pool failed!");
            }
        } catch (DaoException e) {
            logger.error(e.getMessage(), e);
        }
    }


    public <Type extends Dao<?>> Type get (DaoSql entityDao) throws  PersistentException, DaoException  {
        switch (entityDao) {
            case BicycleDao:
                return (Type) new BicycleDaoSql(connection);
            case CompanyDao:
                return (Type)new CompanyDaoSql(connection);
            case LocationDao:
                return (Type)new LocationDaoSql(connection);
            case PriceDao:
                return (Type)new PriceDaoSql(connection);
            case RentDao:
                return (Type)new RentDaoSql(connection);
            case UserDao:
                return (Type)new UserDaoSql(connection);
            case UserInfoDao:
                return (Type)new UserInfoDaoSql(connection);
            case VirtualCardDao:
                return (Type)new VirtualCardDaoSql(connection);
            default:
                throw new DaoException("Check the existence of the desired entity! " + entityDao);
        }
    }

    public void closeConnection () {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
