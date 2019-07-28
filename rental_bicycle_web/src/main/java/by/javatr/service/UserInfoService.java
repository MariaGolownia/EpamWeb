package by.javatr.service;

import by.javatr.dao.PersistentException;
import by.javatr.entity.User;
import by.javatr.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    List<User> findAll() throws PersistentException;

    UserInfo findByIdNumberPassport(String idPassport) throws PersistentException;

    UserInfo findByIdentity(Integer identity) throws PersistentException;

    void save(UserInfo userInfo) throws PersistentException, ServiceException;

    void update(UserInfo userInfo, UserInfo userInfoUpdate) throws PersistentException;

    void delete(Integer identity) throws PersistentException;

}
