package by.javatr.dao;
import by.javatr.entity.User;
import by.javatr.entity.UserInfo;
import java.util.List;

public interface UserInfoDao extends Dao<UserInfo> {

    UserInfo readByUser(User search) throws PersistentException;

    List<UserInfo> readByCountry(String search) throws PersistentException;
}
