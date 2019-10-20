package by.javatr.service;
import by.javatr.entity.PersistentException;
import by.javatr.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService  {

    List<User> findAll() throws ServiceException;

    User findByIdentity(Integer identity) throws ServiceException;

    User findByLogin(String login) throws ServiceException;

    User findByLoginAndPassword(String login, String password) throws ServiceException;

    Integer save(User user) throws ServiceException;

    void update(User user, User userUpdate) throws ServiceException;

    void delete(Integer identity) throws ServiceException;

    String getHashCodePassword (String passwordStr);

}
