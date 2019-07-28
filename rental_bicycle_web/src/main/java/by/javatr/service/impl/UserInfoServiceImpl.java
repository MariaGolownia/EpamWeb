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
    public List<User> findAll() {
        return null;
    }

    @Override
    public UserInfo findByIdNumberPassport(String idPassport) {
        UserInfo userInfo = new UserInfo();
        try {
            UserInfoDao dao = FactoryDaoSql.getInstance().get(DaoSql.UserInfoDao);
            userInfo = dao.readByPassportId(idPassport);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    @Override
    public UserInfo findByIdentity(Integer identity) {
        UserInfo userInfo = new UserInfo();
        try {
            UserInfoDao dao = FactoryDaoSql.getInstance().get(DaoSql.UserInfoDao);
            userInfo = dao.read(identity);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        catch (PersistentException e) {
            e.printStackTrace();
        }
         catch (SQLException e) {
        e.printStackTrace();
    }
        return userInfo;
    }

    @Override
    public void save(UserInfo userInfo) {
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
    public void update(UserInfo userInfo, UserInfo userInfoUpdate){

    }

    @Override
    public void delete(Integer identity) throws PersistentException {

    }
}
