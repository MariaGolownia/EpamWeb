package by.javatr.service;
import by.javatr.dao.Dao;
import by.javatr.dao.PersistentException;
import by.javatr.dao.mysql.*;
import org.apache.logging.log4j.LogManager;

final public class FactoryService {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();

    private static FactoryService instance;

    private FactoryService() {
    }

    public static FactoryService getInstance(){
        if (instance == null) {
            synchronized (FactoryService.class) {
                instance  = new FactoryService();
            }
        }
        return instance;
    }

    public  <Type extends Dao<?>> Type get (DaoSql entityDao) {
        switch (entityDao) {
            case BicycleDao:
                try {
                    return (Type)FactoryDaoSql.getInstance().get(DaoSql.BicycleDao);
                } catch (PersistentException e) {
                    e.printStackTrace();
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            case CompanyDao:
                try {
                    return (Type)FactoryDaoSql.getInstance().get(DaoSql.CompanyDao);
                } catch (PersistentException e) {
                    e.printStackTrace();
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            case LocationDao:
                try {
                    return (Type)FactoryDaoSql.getInstance().get(DaoSql.LocationDao);
                } catch (PersistentException e) {
                    e.printStackTrace();
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            case PriceDao:
                try {
                    return (Type)FactoryDaoSql.getInstance().get(DaoSql.PriceDao);
                } catch (PersistentException e) {

                } catch (DaoException e) {
                    e.printStackTrace();
                    e.printStackTrace();
                }
            case RentDao:
                try {
                    return (Type)FactoryDaoSql.getInstance().get(DaoSql.RentDao);
                } catch (PersistentException e) {
                    e.printStackTrace();
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            case UserDao:
                try {
                    return (Type)FactoryDaoSql.getInstance().get(DaoSql.UserDao);
                } catch (PersistentException e) {
                    e.printStackTrace();
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            case UserInfoDao:
                try {
                    return (Type)FactoryDaoSql.getInstance().get(DaoSql.UserInfoDao);
                } catch (PersistentException e) {
                    e.printStackTrace();
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            case VirtualCardDao:
                try {
                    return (Type)FactoryDaoSql.getInstance().get(DaoSql.VirtualCardDao);
                } catch (PersistentException e) {
                    e.printStackTrace();
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            default:
                try {
                    throw new DaoException("Check the existence of the desired entity! " + entityDao);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
        }
                return null;
    }
}
