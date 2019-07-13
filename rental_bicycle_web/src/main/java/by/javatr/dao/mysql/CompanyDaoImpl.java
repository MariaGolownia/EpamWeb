package by.javatr.dao.mysql;

import by.javatr.dao.CompanyDao;
import by.javatr.dao.PersistentException;
import by.javatr.dao.pool.ConnectionSQL;
import by.javatr.entity.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CompanyDaoImpl extends BaseDaoImpl implements CompanyDao {
        private static final String SQL_SELECT_COMPANY_BY_ID =
            "SELECT `company_name`, `company_accountNumberOfPayer` FROM `company` WHERE `company_id` = ?";

    @Override
    public Company readByAccountNumberOfPayer(Integer search) throws PersistentException {
        return null;
    }

    @Override
    public Integer create(Company entity) throws PersistentException {
        return null;
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
                company.setAccountNumberOfPayer(resultSet.getString("company_accountNumberOfPayer"));
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
                company.setAccountNumberOfPayer(resultSet.getString("company_accountNumberOfPayer"));
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
    public void update(Company entity) throws PersistentException {

    }

    @Override
    public void delete(Integer identity) throws PersistentException {

    }
}
