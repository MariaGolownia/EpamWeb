package by.javatr.dao.mysql;
import by.javatr.dao.Dao;
import by.javatr.dao.PersistentException;
import by.javatr.dao.pool.ConnectionSQL;
import org.apache.logging.log4j.LogManager;
import java.sql.Connection;

final public class DAOSqlFactory {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();
    private static final DAOSqlFactory factory = new DAOSqlFactory();
    private Connection connection;

    public static DAOSqlFactory getInstance(){
        return factory;
    }

    private DAOSqlFactory(){
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


    public Dao get (DaoImpl entityDao) throws  PersistentException, DaoException  {
        switch (entityDao) {
            case BicycleDaoImpl:
                return new BicycleDaoImpl(connection);
            case CompanyDaoImpl:
                return new CompanyDaoImpl(connection);
            case LocationDaoImpl:
                return new LocationDaoImpl(connection);
            case PriceDaoImpl:
                return new PriceDaoImpl(connection);
            case RentDaoImpl:
                return new RentDaoImpl(connection);
            case UserDaoImpl:
                return new UserDaoImpl(connection);
            case UserInfoDaoImpl:
                return new UserInfoDaoImpl(connection);
            case VirtualCardDaoImpl:
                return new VirtualCardDaoImpl(connection);
            default:
                throw new DaoException("Check the existence of the desired entity! " + entityDao);
        }
    }
}
