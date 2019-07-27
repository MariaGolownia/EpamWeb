package by.javatr.dao;
import by.javatr.entity.Company;
import by.javatr.entity.Location;
import by.javatr.entity.en_um.City;
import by.javatr.entity.en_um.Country;

import java.util.List;

public interface LocationDao extends Dao<Location> {

    List<Location> readByCompanyId(Integer search) throws PersistentException;

    List<Location> readByCountry(String search) throws PersistentException;

    List<Location> readByCity(String search) throws PersistentException;

    List<String> readByCountryAndCity(String country, String city) throws PersistentException;

    List<Location> readByCountryAndCity(Country country, City city) throws PersistentException;

}
