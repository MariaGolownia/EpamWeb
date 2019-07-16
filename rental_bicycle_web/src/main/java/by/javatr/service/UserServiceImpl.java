package by.javatr.service;

import by.javatr.dao.PersistentException;
import by.javatr.entity.User;

import java.util.List;

public class UserServiceImpl  implements UserService {
    @Override
    public List<User> findAll() throws PersistentException {
        return null;
    }

    @Override
    public User findByIdentity(Integer identity) throws PersistentException {
        return null;
    }

    @Override
    public User findByLoginAndPassword(String login, String password) throws PersistentException {
        return null;
    }

    @Override
    public void save(User user) throws PersistentException {

    }

    @Override
    public void delete(Integer identity) throws PersistentException {

    }
}
