package by.javatr.service;
import by.javatr.dao.PersistentException;
import by.javatr.entity.User;
import java.util.List;

public interface UserService extends Service {

    List<User> findAll() throws PersistentException;

    User findByIdentity(Integer identity) throws PersistentException;

    User findByLoginAndPassword(String login, String password) throws PersistentException;

    void save(User user) throws PersistentException;

    void delete(Integer identity) throws PersistentException;

}
