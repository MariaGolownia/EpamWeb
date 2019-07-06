package by.javatr.dao;

import by.javatr.entity.Company;
import by.javatr.entity.Location;

import java.math.BigInteger;
import java.util.List;

public interface LocationDao extends Dao<Location> {

    List<Location> readByCompanyId(BigInteger search) throws PersistentException;

    List<Location> readByCompany(Company search) throws PersistentException;

    List<Location> readByCompanyName(String search) throws PersistentException;

    Company readByLocationId (BigInteger search) throws PersistentException;

    List<Location> readByCountry(String search) throws PersistentException;

    List<Location> readByCity(String search) throws PersistentException;

    List<Location> readByStreet(String search) throws PersistentException;

}
