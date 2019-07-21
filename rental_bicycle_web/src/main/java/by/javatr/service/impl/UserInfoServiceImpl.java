package by.javatr.service.impl;

import by.javatr.dao.PersistentException;
import by.javatr.dao.UserInfoDao;
import by.javatr.dao.mysql.DaoException;
import by.javatr.dao.mysql.DaoSql;
import by.javatr.dao.mysql.FactoryDaoSql;
import by.javatr.entity.User;
import by.javatr.entity.UserInfo;
import by.javatr.service.Service;
import by.javatr.service.ServiceException;
import by.javatr.service.UserInfoService;

import java.sql.SQLException;
import java.util.List;

public class UserInfoServiceImpl  extends Service implements UserInfoService {
    @Override
    public List<User> findAll() throws PersistentException {
        return null;
    }

    @Override
    public User findByIdentity(Integer identity) throws PersistentException {
        return null;
    }

    @Override
    public void save(UserInfo userInfo) throws ServiceException {
        UserInfoDao dao = null;
        try {
            dao = FactoryDaoSql.getInstance().get(DaoSql.UserInfoDao);
                dao.create(userInfo);
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (PersistentException e) {
        e.printStackTrace();
    }
    }

    @Override
    public void update(UserInfo userInfo, UserInfo userInfoUpdate) throws PersistentException {

    }

    @Override
    public void delete(Integer identity) throws PersistentException {

    }
}
