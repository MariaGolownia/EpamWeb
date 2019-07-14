package by.javatr.dao;
import by.javatr.entity.User;
import java.util.List;

public interface UserDao extends Dao<User> {

    User read(String login, String password) throws PersistentException;

    List<User> read() throws PersistentException;
}
