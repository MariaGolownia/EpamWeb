package by.javatr.dao;
import by.javatr.entity.Company;


public interface CompanyDao extends Dao<Company> {

    Company readByAccountNumberOfPayer(Integer search) throws PersistentException;
}
