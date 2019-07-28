package by.javatr.service.impl;
import by.javatr.dao.PersistentException;
import by.javatr.dao.UserDao;
import by.javatr.dao.mysql.DaoException;
import by.javatr.dao.mysql.DaoSql;
import by.javatr.dao.mysql.FactoryDaoSql;
import by.javatr.entity.User;
import by.javatr.service.Service;
import by.javatr.service.ServiceException;
import by.javatr.service.UserService;
import by.javatr.service.valid.UserServiceValidation;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl extends Service implements UserService {
    @Override
    public List<User> findAll() {
        UserDao dao = null;
        List<User> users = new ArrayList<>();
        try {
            try {
                dao = FactoryDaoSql.getInstance().get(DaoSql.UserDao);
                try {
                    users = dao.read();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (PersistentException e) {
                e.printStackTrace();
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findByIdentity(Integer id) {
        UserDao dao = null;
        User user = null;
        try {
            try {
                dao = FactoryDaoSql.getInstance().get(DaoSql.UserDao);
                try {
                    user = dao.read(id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (PersistentException e) {
                e.printStackTrace();
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public User findByLogin(String login) {
        UserDao dao = null;
        User user = null;
        try {
            try {
                dao = FactoryDaoSql.getInstance().get(DaoSql.UserDao);
                try {
                    user = dao.read(login);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (PersistentException e) {
                e.printStackTrace();
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        UserDao dao = null;
        User user = null;
        try {
            try {
                dao = FactoryDaoSql.getInstance().get(DaoSql.UserDao);
                try {
                    user = dao.read(login, password);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (PersistentException e) {
                e.printStackTrace();
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Integer save(User user) throws ServiceException {
        UserDao dao = null;
        Integer id = null;
        try {
            try {
                dao = FactoryDaoSql.getInstance().get(DaoSql.UserDao);
                if (user.getPassword() != null || user.getLogin() != null) {
                    UserServiceValidation userServiceValidation = new UserServiceValidation();
                    if (!userServiceValidation.ifUserLoginExists(user.getLogin())) {
                        try {
                            id = dao.create(user);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        throw new ServiceException("A user with this login already exists! Please think of another login!");
                    }
                } else {
                        throw new ServiceException("You must enter a username and password to save the user!");
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return  id;
    }

    @Override
    public void update(User user, User userUpdate) throws SQLException {
        UserDao dao = null;
        UserServiceValidation userServiceValidation = new UserServiceValidation();
        if (userServiceValidation.ifUserExists(user)) {
            UserDao userDao = null;
            try {
                userDao.update(userUpdate);
                userDao = FactoryDaoSql.getInstance().get(DaoSql.UserDao);
            } catch (PersistentException e) {
                e.printStackTrace();
            }
             catch (DaoException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void delete(Integer id) throws PersistentException {
        UserDao userDao = null;
        try {
            userDao = FactoryDaoSql.getInstance().get(DaoSql.UserDao);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        userDao.delete(id);
    }
}
