package by.javatr.service;

import by.javatr.entity.PersistentException;
import by.javatr.entity.User;
import by.javatr.entity.UserInfo;

import java.sql.SQLException;
import java.util.List;

public interface UserInfoService {

    List<User> findAll() throws PersistentException;

    UserInfo findByIdNumberPassport(String idPassport) throws ServiceException;

    UserInfo findByIdentity(Integer identity) throws ServiceException;

    void save(UserInfo userInfo) throws PersistentException, ServiceException;

    void update(UserInfo userInfoUpdate) throws ServiceException;

    void delete(Integer identity) throws ServiceException;

}
