package by.javatr.service.valid;

import by.javatr.dao.PersistentException;
import by.javatr.dao.UserDao;
import by.javatr.dao.mysql.DaoSql;
import by.javatr.dao.mysql.DaoException;
import by.javatr.dao.mysql.FactoryDaoSql;
import by.javatr.entity.User;

public class UserServiceValidation {

    public Boolean ifUserExists (User user) {
        Boolean ifUserExists = false;
        User userValid = null;
        UserDao userDao = null;
        try {
            userDao = FactoryDaoSql.getInstance().get(DaoSql.UserDao);
            userValid = userDao.read(user.getLogin(), user.getPassword());
        } catch (PersistentException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        if (userValid != null) {
            ifUserExists = true;
        }
        return ifUserExists;
    }


    public Boolean ifUserLoginExists (String login) {
        Boolean ifUserExists = false;
        User userValid = null;
        UserDao userDao = null;
        try {
            userDao = FactoryDaoSql.getInstance().get(DaoSql.UserDao);
            userValid = userDao.read(login);
        } catch (PersistentException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        if (userValid != null) {
            ifUserExists = true;
        }
        return ifUserExists;
    }
}