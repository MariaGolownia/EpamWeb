package by.javatr.dao.mysql;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import by.javatr.dao.PersistentException;
import by.javatr.dao.UserDao;
import by.javatr.dao.pool.ConnectionPool;
import by.javatr.dao.pool.ConnectionSQL;
import by.javatr.entity.Role;
import by.javatr.entity.User;
import org.apache.log4j.Logger;

public class UserDaoImpl implements UserDao {
    private static final String SERVER_NAME = "localhost";
    private static final String MY_DATA_BASE = "rental_bicycle_web";
    private static final String URL = "jdbc:mysql://" + SERVER_NAME + "/" + MY_DATA_BASE;
    private static final String USER_SQL_NAME = "root";
    private static final String USER_SQL_PASSWORD = "admin";

    private static final String SQL_USER_INSERT = "INSERT INTO `user` (`user_login`, `user_password`, `user_role`) VALUES (?, ?, ?)";
    private static final String SQL_USER_SELECT = "SELECT `user_login`, `user_password`, `user_role` FROM `user` WHERE `user_id` = ?";
    private static final String SQL_ALL_USERS_SELECT = "SELECT `user_id`, `user_login`, `user_password`, `user_role` FROM `user` ORDER BY `user_login`";
    private static final String SQL_ID_ROLE_USER_SELECT = "SELECT `user_id`, `user_role` FROM `user` WHERE `user_login` = ? AND `user_password` = ?";
    private static final String SQL_USER_UPDATE = "UPDATE `user` SET `user_login` = ?, `user_password` = ?, `user_role` = ? WHERE `user_id` = ?";
    private static final String SQL_USER_DELETE = "DELETE FROM `user` WHERE `user_id` = ?";

    private static Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Override
    public Integer create(User user) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;

        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.createConnectionToDB();
            statement = connection.prepareStatement(SQL_USER_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole().getIdentity());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                logger.error("There is no autoincremented index after trying to add record into table `users`");
                throw new PersistentException();
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
    }


    @Override
    public User read(String login, String password) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER_SQL_NAME, USER_SQL_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.prepareStatement(SQL_ID_ROLE_USER_SELECT);
            statement.setString(1, login);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            User user = null;
            if(resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setLogin(login);
                user.setPassword(password);
                user.setRole(Role.getByIdentity(resultSet.getInt("user_role")));
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
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER_SQL_NAME, USER_SQL_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.prepareStatement(SQL_ALL_USERS_SELECT);
            resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();
            User user = null;
            while(resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setLogin(resultSet.getString("user_login"));
                user.setPassword(resultSet.getString("user_password"));
                user.setRole(Role.getByIdentity(resultSet.getInt("user_role")));
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
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER_SQL_NAME, USER_SQL_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.prepareStatement(SQL_USER_SELECT);
            statement.setInt(1, id);
                    resultSet = statement.executeQuery();
            User user = null;
            if(resultSet.next()) {
                user = new User();
                user.setId(id);
                user.setLogin(resultSet.getString("user_login"));
                user.setPassword(resultSet.getString("user_password"));
                user.setRole(Role.getByIdentity(resultSet.getInt("user_role")));
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
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER_SQL_NAME, USER_SQL_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.prepareStatement(SQL_USER_UPDATE);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole().getIdentity());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

//    @Override
//    public void delete(Integer id) throws PersistentException {
//        PreparedStatement statement = null;
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(URL, USER_SQL_NAME, USER_SQL_PASSWORD);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            statement = connection.prepareStatement(SQL_USER_DELETE);
//            statement.setInt(1, id);
//            statement.executeUpdate();
//        } catch(SQLException e) {
//            throw new PersistentException(e);
//        } finally {
//            try {
//                statement.close();
//            } catch(SQLException | NullPointerException e) {}
//        }
//    }

        @Override
    public void delete(Integer id) throws PersistentException {
//        PreparedStatement statement = null;
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(URL, USER_SQL_NAME, USER_SQL_PASSWORD);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
          ConnectionPool connectionPool = ConnectionPool.getInstance();
            connectionPool.getConnection();

//        try {
//            statement = connection.prepareStatement(SQL_USER_DELETE);
//            statement.setInt(1, id);
//            statement.executeUpdate();
//        } catch(SQLException e) {
//            throw new PersistentException(e);
//        } finally {
//            try {
//                statement.close();
//            } catch(SQLException | NullPointerException e) {}
//        }
    }
}
