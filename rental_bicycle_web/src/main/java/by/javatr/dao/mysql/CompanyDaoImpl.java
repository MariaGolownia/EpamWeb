package by.javatr.dao.mysql;
import by.javatr.dao.CompanyDao;
import by.javatr.dao.PersistentException;
import by.javatr.dao.pool.ConnectionSQL;
import by.javatr.dao.valid.SQLValidation;
import by.javatr.dao.valid.ValidationException;
import by.javatr.entity.Company;
import org.apache.logging.log4j.LogManager;

import java.sql.*;

public class CompanyDaoImpl extends BaseDaoImpl implements CompanyDao {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();
     private static final String SQL_SELECT_COMPANY_BY_ID =
            "SELECT `company_name`, `company_accountNumberOfPayer` FROM `company` WHERE `company_id` = ?";
    private static final String SQL_SELECT_COMPANY_BY_ACCOUNT_NUMBER_OF_PAYER =
            "SELECT `company_id`, `company_name` FROM `company` WHERE `company_accountNumberOfPayer` = ?";
    private static final String SQL_COMPANY_UPDATE =
            "UPDATE `company` SET `company_name` = ?, `company_accountNumberOfPayer` = ? WHERE `company_id` = ?";
    private static final String SQL_COMPANY_INSERT =
            "INSERT INTO `company` (`company_name`, `company_accountNumberOfPayer`) VALUES (?, ?)";
    private static final String SQL_COMPANY_DELETE = "DELETE FROM `company` WHERE `company_id` = ?";

    @Override
    public Company readByAccountNumberOfPayer(Integer search) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            statement = connection.prepareStatement(SQL_SELECT_COMPANY_BY_ACCOUNT_NUMBER_OF_PAYER);
            statement.setInt(1, search);
            resultSet = statement.executeQuery();
            Company company = new Company();
            while(resultSet.next()) {
                Integer companyID = resultSet.getInt("company_id");
                company.setId(companyID);
                company.setName(resultSet.getString("company_name"));
                company.setAccountNumberOfPayer(search);
            }
            if (company==null) try {
                throw new ValidationException("Contact the developer to add your company to the software application!");
            } catch (ValidationException e) {
                e.printStackTrace();
            }
            return company;
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


    public Company readByAccountNumberOfPayer(Integer search, Connection connection) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_COMPANY_BY_ACCOUNT_NUMBER_OF_PAYER);
            statement.setInt(1, search);
            resultSet = statement.executeQuery();
            Company company = new Company();
            while(resultSet.next()) {
                company.setId(resultSet.getInt("company_id"));
                company.setName(resultSet.getString("company_name"));
                company.setAccountNumberOfPayer(search);
            }
            if (company==null) try {
                throw new ValidationException("Contact the developer to add your company to the software application!");
            } catch (ValidationException e) {
                e.printStackTrace();
            }
            return company;
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public Integer create(Company company) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer idOfCompany = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            SQLValidation SQLValidation = new SQLValidation();
            if (!SQLValidation.ifСompanyNumberExist(company.getAccountNumberOfPayer(), connection)) {
                statement = connection.prepareStatement(SQL_COMPANY_INSERT, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, company.getName());
                statement.setInt(2, company.getAccountNumberOfPayer());
                statement.executeUpdate();
                resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    idOfCompany = resultSet.getInt(1);
                } else {
                    logger.error("There is no autoincremented index after trying to add record into table `users`");
                    throw new PersistentException();
                }
            }
            else {
                try {
                    throw new ValidationException("This company already exists!");
                } catch (ValidationException e) {
                    logger.debug("ValidationException: This company already exists!");
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
        return idOfCompany;
    }

    @Override
    public Company read(Integer id) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            statement = connection.prepareStatement(SQL_SELECT_COMPANY_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Company company = null;
            if(resultSet.next()) {
                company = new Company();
                company.setId(id);
                company.setName(resultSet.getString("company_name"));
                company.setAccountNumberOfPayer(resultSet.getInt("company_accountNumberOfPayer"));
            }
            return company;
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

    public Company read(Integer id, Connection connection) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_COMPANY_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Company company = null;
            if(resultSet.next()) {
                company = new Company();
                company.setId(id);
                company.setName(resultSet.getString("company_name"));
                company.setAccountNumberOfPayer(resultSet.getInt("company_accountNumberOfPayer"));
            }
            return company;
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public void update(Company company) throws PersistentException {
        PreparedStatement statement = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            statement = connection.prepareStatement(SQL_COMPANY_UPDATE);
            statement.setString(1, company.getName());
            statement.setInt(2, company.getAccountNumberOfPayer());
            statement.setInt(3, company.getId());
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

    @Override
    public void delete(Integer id) throws PersistentException {
        PreparedStatement statement = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            statement = connection.prepareStatement(SQL_COMPANY_DELETE);
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
