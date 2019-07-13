package by.javatr.dao.mysql;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import by.javatr.dao.PersistentException;
import by.javatr.dao.UserDao;
import by.javatr.dao.pool.ConnectionSQL;
import by.javatr.dao.valid.SQLValidation;
import by.javatr.dao.valid.ValidationException;
import by.javatr.entity.Role;
import by.javatr.entity.User;
import by.javatr.entity.UserStatus;
import org.apache.logging.log4j.LogManager;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();
    //private static final String SERVER_NAME = "localhost";
    //private static final String MY_DATA_BASE = "rental_bicycle_web";

    private static final String SQL_USER_INSERT = "INSERT INTO `user` (`user_login`, `user_password`, `user_role`, `user_status`) VALUES (?, ?, ?, ?)";
    private static final String SQL_SELECT_USER_BY_ID = "SELECT `user_login`, `user_password`, `user_role`, `user_status` FROM `user` WHERE `user_id` = ?";
    private static final String SQL_ALL_USERS_SELECT = "SELECT `user_id`, `user_login`, `user_password`, `user_role`, `user_status` FROM `user` ORDER BY `user_login`";
    private static final String SQL_ID_ROLE_STATUS_USER_SELECT = "SELECT `user_id`, `user_role`, `user_status` FROM `user` WHERE `user_login` = ? AND `user_password` = ?";
    private static final String SQL_USER_UPDATE = "UPDATE `user` SET `user_login` = ?, `user_password` = ?, `user_role` = ?, `user_status` = ? WHERE `user_id` = ?";
    private static final String SQL_USER_DELETE = "DELETE FROM `user` WHERE `user_id` = ?";

    @Override
    public Integer create(User user) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer idOfUser = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            SQLValidation SQLValidation = new SQLValidation();
            if (!SQLValidation.validateIfIdenticalLoginInDB(user.getLogin(), connection)) {
                statement = connection.prepareStatement(SQL_USER_INSERT, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, user.getLogin());
                statement.setString(2, user.getPassword());
                statement.setInt(3, user.getRole().getId());
                statement.setInt(4, user.getUserStatus().getId());
                statement.executeUpdate();
                resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    idOfUser = resultSet.getInt(1);
                } else {
                    logger.error("There is no autoincremented index after trying to add record into table `users`");
                    throw new PersistentException();
                }
            }
            else {
                try {
                    throw new ValidationException("A user with this login already exists!");
                } catch (ValidationException e) {
                    logger.debug("ValidationException: A user with this login already exists");
                }
            }
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
                connection.close();
            } catch(SQLException | NullPointerException e) {}
        }
        return idOfUser;
    }


    @Override
    public User read(String login, String password) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            statement = connection.prepareStatement(SQL_ID_ROLE_STATUS_USER_SELECT);
            statement.setString(1, login);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            User user = null;
            if(resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setLogin(login);
                user.setPassword(password);
                user.setRole(Role.getById(resultSet.getInt("user_role")));
                user.setUserStatus(UserStatus.getById(resultSet.getInt("user_status")));
            }
            return user;
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
                connection.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public List<User> read() throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            statement = connection.prepareStatement(SQL_ALL_USERS_SELECT);
            resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();
            User user = null;
            while(resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setLogin(resultSet.getString("user_login"));
                user.setPassword(resultSet.getString("user_password"));
                user.setRole(Role.getById(resultSet.getInt("user_role")));
                user.setUserStatus(UserStatus.getById(resultSet.getInt("user_status")));
                users.add(user);
            }
            return users;
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
                connection.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public User read(Integer id) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            statement = connection.prepareStatement(SQL_SELECT_USER_BY_ID);
            statement.setInt(1, id);
                    resultSet = statement.executeQuery();
            User user = null;
            if(resultSet.next()) {
                user = new User();
                user.setId(id);
                user.setLogin(resultSet.getString("user_login"));
                user.setPassword(resultSet.getString("user_password"));
                user.setRole(Role.getById(resultSet.getInt("user_role")));
                user.setUserStatus(UserStatus.getById(resultSet.getInt("user_status")));
            }
            return user;
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
                connection.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public void update(User user) throws PersistentException {
        PreparedStatement statement = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            statement = connection.prepareStatement(SQL_USER_UPDATE);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole().getId());
            statement.setInt(4, user.getUserStatus().getId());
            statement.setInt(5, user.getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

//    @Override
    public void delete(Integer id) throws PersistentException {
        PreparedStatement statement = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            statement = connection.prepareStatement(SQL_USER_DELETE);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }


}
