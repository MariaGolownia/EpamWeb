package by.javatr.dao;
import by.javatr.entity.PersistentException;
import by.javatr.entity.User;
import by.javatr.entity.UserInfo;

import java.sql.SQLException;
import java.util.List;

public interface UserInfoDao extends Dao<UserInfo> {

    UserInfo readByUser(User search) throws SQLException;

    List<UserInfo> readByCountry(String search) throws SQLException;

    UserInfo readByPassportId(String search) throws SQLException;
}
