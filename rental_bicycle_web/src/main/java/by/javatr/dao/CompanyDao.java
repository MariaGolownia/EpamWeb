package by.javatr.dao;
import by.javatr.entity.Company;

import java.math.BigInteger;
import java.util.List;

public interface CompanyDao extends Dao<Company> {

    Company readByAccountNumberOfPayer(Integer search) throws PersistentException;
}
