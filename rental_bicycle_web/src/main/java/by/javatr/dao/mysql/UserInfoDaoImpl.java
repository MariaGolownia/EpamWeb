package by.javatr.dao.mysql;
import by.javatr.dao.PersistentException;
import by.javatr.dao.UserInfoDao;
import by.javatr.dao.pool.ConnectionSQL;
import by.javatr.entity.User;
import by.javatr.entity.UserInfo;
import by.javatr.entity.en_um.Country;
import org.apache.logging.log4j.LogManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDaoImpl extends BaseDaoImpl implements UserInfoDao {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();
    private static final String SQL_USER_INFO_INSERT =
            "INSERT INTO `userinfo` " +
                    "(`userInfo_surname`, `userInfo_name`, `userInfo_secondName`, `userInfo_birthDate`,`userInfo_country`," +
                    " `userInfo_passportIssueDate`, `userInfo_passportIssuingAuthority`, `userInfo_passportIdentificationNumber` ," +
                    " `userInfo_passportSerialNumber`,`userInfo_passportAdressRegistration`,`userInfo_passportAdressResidence`" +
                    ",`userInfo_phoneNumber`,`userInfo_secondPhoneNumber`,`userInfo_email`)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_SELECT_USER_INFO =
            "SELECT  userInfo_surname`, `userInfo_name`, `userInfo_secondName`, `userInfo_birthDate`,`userInfo_country`," +
                    "`userInfo_passportIssueDate`, `userInfo_passportIssuingAuthority`, `userInfo_passportIdentificationNumber`, " +
                    "`userInfo_passportSerialNumber`,`userInfo_passportAdressRegistration`,`userInfo_passportAdressResidence`," +
                    "`userInfo_phoneNumber`,`userInfo_secondPhoneNumber`,`userInfo_email` FROM `userinfo` WHERE `userInfo_id` = ?";
    private static final String SQL_SELECT_USER_INFO_BY_COUNTRY =
            "SELECT `userInfo_id`, `userInfo_surname`, `userInfo_name`, `userInfo_secondName`, `userInfo_birthDate`," +
                    "`userInfo_passportIssueDate`, `userInfo_passportIssuingAuthority`, `userInfo_passportIdentificationNumber`," +
                    "`userInfo_passportSerialNumber`,`userInfo_passportAdressRegistration`,`userInfo_passportAdressResidence`," +
                    "`userInfo_phoneNumber`,`userInfo_secondPhoneNumber`,`userInfo_email` FROM `userinfo` WHERE `userInfo_country` = ?";
        private static final String SQL_USER_INFO_UPDATE =
            "UPDATE `userinfo` SET `userInfo_surname` = ?, `userInfo_name` = ?, `userInfo_secondName`= ?, " +
                    "`userInfo_birthDate` = ?,`userInfo_country` = ?, `userInfo_passportIssueDate` = ?," +
                    " `userInfo_passportIssuingAuthority` = ?, `userInfo_passportIdentificationNumber` = ?," +
                    "`userInfo_passportSerialNumber` = ?,`userInfo_passportAdressRegistration`  = ?," +
                    "`userInfo_passportAdressResidence` = ?, `userInfo_phoneNumber`  = ?,`userInfo_secondPhoneNumber` = ?," +
                    "`userInfo_email` = ? WHERE `userInfo_id` = ?";
    private static final String SQL_USER_INFO_DELETE = "DELETE FROM `userinfo` WHERE `userInfo_id` = ?";

    @Override
    public UserInfo readByUser(User user) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            statement = connection.prepareStatement(SQL_SELECT_USER_INFO);
            statement.setInt(1, user.getId());
            resultSet = statement.executeQuery();
            UserInfo userInfo = new UserInfo();
            while(resultSet.next()) {
                userInfo = new UserInfo();
                userInfo.setSurname(resultSet.getString("userInfo_surname"));
                userInfo.setName(resultSet.getString("userInfo_name"));
                userInfo.setSecondName(resultSet.getString("userInfo_secondName"));
                userInfo.setBirthDate(resultSet.getDate("userInfo_birthDate"));
                userInfo.setCountry(Country.getCountry(resultSet.getString("userInfo_country")));
                userInfo.setPassportIssueDate(resultSet.getDate("userInfo_passportIssueDate"));
                userInfo.setPassportIssuingAuthority(resultSet.getString("userInfo_passportIssuingAuthority"));
                userInfo.setPassportIdentificationNumber(resultSet.getString("userInfo_passportIdentificationNumber"));
                userInfo.setPassportSerialNumber(resultSet.getString("userInfo_passportSerialNumber"));
                userInfo.setPassportAdressRegistration(resultSet.getString("userInfo_passportAdressRegistration"));
                userInfo.setPassportAdressResidence(resultSet.getString("userInfo_passportAdressResidence"));
                userInfo.setPhoneNumber(resultSet.getLong("userInfo_phoneNumber"));
                userInfo.setSecondPhoneNumber(resultSet.getLong("userInfo_secondPhoneNumber"));
                userInfo.setEmail(resultSet.getString("userInfo_email"));
            }
            return userInfo;
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
    public List<UserInfo> readByCountry(String country) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            statement = connection.prepareStatement(SQL_SELECT_USER_INFO_BY_COUNTRY);
            statement.setString(1, country);
            resultSet = statement.executeQuery();
            List<UserInfo> userInfoList = new ArrayList<>();
            UserInfo userInfo = new UserInfo();
            while(resultSet.next()) {
                userInfo = new UserInfo();
                userInfo.setId(resultSet.getInt("userInfo_id"));
                userInfo.setSurname(resultSet.getString("userInfo_surname"));
                userInfo.setName(resultSet.getString("userInfo_name"));
                userInfo.setSecondName(resultSet.getString("userInfo_secondName"));
                userInfo.setBirthDate(resultSet.getDate("userInfo_birthDate"));
                userInfo.setCountry(Country.getCountry(country));
                userInfo.setPassportIssueDate(resultSet.getDate("userInfo_passportIssueDate"));
                userInfo.setPassportIssuingAuthority(resultSet.getString("userInfo_passportIssuingAuthority"));
                userInfo.setPassportIdentificationNumber(resultSet.getString("userInfo_passportIdentificationNumber"));
                userInfo.setPassportSerialNumber(resultSet.getString("userInfo_passportSerialNumber"));
                userInfo.setPassportAdressRegistration(resultSet.getString("userInfo_passportAdressRegistration"));
                userInfo.setPassportAdressResidence(resultSet.getString("userInfo_passportAdressResidence"));
                userInfo.setPhoneNumber(resultSet.getLong("userInfo_phoneNumber"));
                userInfo.setSecondPhoneNumber(resultSet.getLong("userInfo_secondPhoneNumber"));
                userInfo.setEmail(resultSet.getString("userInfo_email"));
                userInfoList.add(userInfo);
            }
            return userInfoList;
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
    public Integer create(UserInfo userInfo) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer idOfLocation = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            statement = connection.prepareStatement(SQL_USER_INFO_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, userInfo.getSurname());
            statement.setString(2, userInfo.getName());
            statement.setString(3, userInfo.getSecondName());
            statement.setDate(4, userInfo.getBirthDate());
            statement.setString(5, userInfo.getCountry().getName());
            statement.setDate(6, userInfo.getPassportIssueDate());
            statement.setString(7, userInfo.getPassportIssuingAuthority());
            statement.setString(8, userInfo.getPassportIdentificationNumber());
            statement.setString(9, userInfo.getPassportSerialNumber());
            statement.setString(10, userInfo.getPassportAdressRegistration());
            statement.setString(11, userInfo.getPassportAdressResidence());
            statement.setLong(12, userInfo.getPhoneNumber());
            statement.setLong(13, userInfo.getSecondPhoneNumber());
            statement.setString(14, userInfo.getEmail());
                    statement.executeUpdate();
                    resultSet = statement.getGeneratedKeys();
                    if (resultSet.next()) {
                        idOfLocation = resultSet.getInt(1);
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
        return idOfLocation;
    }

    @Override
    public UserInfo read(Integer id) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            statement = connection.prepareStatement(SQL_SELECT_USER_INFO);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            UserInfo userInfo = new UserInfo();
            while(resultSet.next()) {
                userInfo = new UserInfo();
                userInfo.setSurname(resultSet.getString("userInfo_surname"));
                userInfo.setName(resultSet.getString("userInfo_name"));
                userInfo.setSecondName(resultSet.getString("userInfo_secondName"));
                userInfo.setBirthDate(resultSet.getDate("userInfo_birthDate"));
                userInfo.setCountry(Country.getCountry(resultSet.getString("userInfo_country")));
                userInfo.setPassportIssueDate(resultSet.getDate("userInfo_passportIssueDate"));
                userInfo.setPassportIssuingAuthority(resultSet.getString("userInfo_passportIssuingAuthority"));
                userInfo.setPassportIdentificationNumber(resultSet.getString("userInfo_passportIdentificationNumber"));
                userInfo.setPassportSerialNumber(resultSet.getString("userInfo_passportSerialNumber"));
                userInfo.setPassportAdressRegistration(resultSet.getString("userInfo_passportAdressRegistration"));
                userInfo.setPassportAdressResidence(resultSet.getString("userInfo_passportAdressResidence"));
                userInfo.setPhoneNumber(resultSet.getLong("userInfo_phoneNumber"));
                userInfo.setSecondPhoneNumber(resultSet.getLong("userInfo_secondPhoneNumber"));
                userInfo.setEmail(resultSet.getString("userInfo_email"));
            }
            return userInfo;
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
    public void update(UserInfo userInfo) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            statement = connection.prepareStatement(SQL_USER_INFO_UPDATE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, userInfo.getSurname());
            statement.setString(2, userInfo.getName());
            statement.setString(3, userInfo.getSecondName());
            statement.setDate(4, userInfo.getBirthDate());
            statement.setString(5, userInfo.getCountry().getName());
            statement.setDate(6, userInfo.getPassportIssueDate());
            statement.setString(7, userInfo.getPassportIssuingAuthority());
            statement.setString(8, userInfo.getPassportIdentificationNumber());
            statement.setString(9, userInfo.getPassportSerialNumber());
            statement.setString(10, userInfo.getPassportAdressRegistration());
            statement.setString(11, userInfo.getPassportAdressResidence());
            statement.setLong(12, userInfo.getPhoneNumber());
            statement.setLong(13, userInfo.getSecondPhoneNumber());
            statement.setString(14, userInfo.getEmail());
            statement.setInt(15, userInfo.getId());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
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
    public void delete(Integer identity) throws PersistentException {

    }
}
