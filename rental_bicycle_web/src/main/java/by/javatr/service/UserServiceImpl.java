package by.javatr.service;
import by.javatr.dao.PersistentException;
import by.javatr.dao.UserDao;
import by.javatr.dao.mysql.DaoSql;
import by.javatr.entity.User;
import by.javatr.service.valid.UserServiceValidation;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl  implements UserService {
    @Override
    public List<User> findAll() throws PersistentException {
        UserDao dao = null;
        List<User> users = new ArrayList<>();
        dao = FactoryService.getInstance().get(DaoSql.UserDao);
        users = dao.read();
        return users;
    }

    @Override
    public User findByIdentity(Integer id) throws PersistentException {
        UserDao dao = null;
        User user = null;
        dao = FactoryService.getInstance().get(DaoSql.UserDao);
        user = dao.read(id);
        return user;
    }

    @Override
    public User findByLoginAndPassword(String login, String password) throws PersistentException {
        UserDao dao = null;
        User user = null;
        dao = FactoryService.getInstance().get(DaoSql.UserDao);
        user = dao.read(login, password);
        return user;
    }

    @Override
    public void save(User user) {
        UserDao dao = null;
        try {
            dao = FactoryService.getInstance().get(DaoSql.UserDao);
            if (user.getPassword() != null || user.getLogin() != null) {
                UserServiceValidation userServiceValidation = new UserServiceValidation();
                if (!userServiceValidation.ifUserLoginExists(user.getLogin())) {
                    dao.create(user);
                }
                else {
                    throw new ServiceException("A user with this login already exists! Please think of another login!");
                }
            } else {
                try {
                    throw new ServiceException("You must enter a username and password to save the user!");
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user, User userUpdate) throws PersistentException {
        UserDao dao = null;
        UserServiceValidation userServiceValidation = new UserServiceValidation();
        if (userServiceValidation.ifUserExists(user)) {
            UserDao userDao = FactoryService.getInstance().get(DaoSql.UserDao);
            userDao.update(userUpdate);
        }
    }

    @Override
    public void delete(Integer id) throws PersistentException {
        UserDao userDao = FactoryService.getInstance().get(DaoSql.UserDao);
        userDao.delete(id);
    }
}
