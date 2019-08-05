package by.javatr.dao;
import by.javatr.entity.Company;

import java.sql.SQLException;


public interface CompanyDao extends Dao<Company> {

    Company readByAccountNumberOfPayer(Integer search) throws SQLException;
}
