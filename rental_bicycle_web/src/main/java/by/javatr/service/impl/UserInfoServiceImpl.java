package by.javatr.service.impl;

import by.javatr.dao.UserDao;
import by.javatr.entity.PersistentException;
import by.javatr.dao.UserInfoDao;
import by.javatr.dao.mysql.DaoException;
import by.javatr.dao.mysql.DaoSql;
import by.javatr.dao.mysql.FactoryDaoSql;
import by.javatr.entity.User;
import by.javatr.entity.UserInfo;
import by.javatr.service.Service;
import by.javatr.service.ServiceException;
import by.javatr.service.UserInfoService;
import by.javatr.service.valid.UserServiceValidation;

import java.sql.SQLException;
import java.util.List;

public class UserInfoServiceImpl  extends Service implements UserInfoService {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public UserInfo findByIdNumberPassport(String idPassport) throws ServiceException {
        UserInfo userInfo = new UserInfo();
        try {
            UserInfoDao dao = FactoryDaoSql.getInstance().get(DaoSql.UserInfoDao);
            userInfo = dao.readByPassportId(idPassport);
        } catch (DaoException e) {
            e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return userInfo;
    }

    @Override
    public UserInfo findByIdentity(Integer identity) throws ServiceException{
        UserInfo userInfo = new UserInfo();
        try {
            UserInfoDao dao = FactoryDaoSql.getInstance().get(DaoSql.UserInfoDao);
            userInfo = dao.read(identity);
        } catch (DaoException e) {
            e.printStackTrace();
        }
         catch (SQLException e) {
        e.printStackTrace();
    }
        return userInfo;
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
    }

    @Override
    public void update(UserInfo userInfoUpdate) throws ServiceException{
        UserInfoDao userInfoDao = null;
            try {
                userInfoDao = FactoryDaoSql.getInstance().get(DaoSql.UserInfoDao);
                userInfoDao.update(userInfoUpdate);
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
            catch (DaoException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void delete(Integer identity) throws ServiceException {

    }
}
