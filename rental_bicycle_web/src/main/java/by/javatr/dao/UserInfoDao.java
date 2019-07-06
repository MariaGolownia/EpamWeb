package by.javatr.dao;

import by.javatr.entity.UserInfo;

import java.util.List;

public interface UserInfoDao extends Dao<UserInfo> {

    List<UserInfo> readBySurname(String search) throws PersistentException;

    List<UserInfo> readByCountry(String search) throws PersistentException;
}
