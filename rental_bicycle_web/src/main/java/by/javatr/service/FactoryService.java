package by.javatr.service;
import by.javatr.dao.PersistentException;
import by.javatr.dao.mysql.*;
import by.javatr.service.impl.*;
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

    public <Type extends Service> Type  get (DaoSql entityDao) {
        switch (entityDao) {
            case BicycleDao:
                return (Type) new BicycleServiceImpl();
            case CompanyDao:
            case LocationDao:
                    return (Type) new LocationServiceImpl();
            case PaymentDao:
                break;
            case PriceDao:
             break;
            case RentDao:
                break;
            case UserDao:
                return (Type) new UserServiceImpl();
            case UserInfoDao:
                return (Type) new UserInfoServiceImpl();
            case VirtualCardDao:
                return (Type) new VirtualCardServiceImpl();
            default:
                try {
                    throw new ServiceException("Check the existence of the desired entity! " + entityDao);
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
        }
                return null;
    }
}
