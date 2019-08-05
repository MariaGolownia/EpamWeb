package by.javatr.service;
import by.javatr.entity.PersistentException;
import by.javatr.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService  {

    List<User> findAll() throws PersistentException;

    User findByIdentity(Integer identity) throws PersistentException;

    User findByLogin(String login);

    User findByLoginAndPassword(String login, String password) throws PersistentException;

    Integer save(User user) throws PersistentException, ServiceException;

    void update(User user, User userUpdate) throws PersistentException, SQLException;

    void delete(Integer identity) throws PersistentException, SQLException;

}
