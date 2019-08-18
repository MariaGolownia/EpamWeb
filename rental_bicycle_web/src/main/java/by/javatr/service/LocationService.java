package by.javatr.service;
import by.javatr.entity.PersistentException;
import by.javatr.entity.Location;
import by.javatr.entity.en_um.City;
import by.javatr.entity.en_um.Country;

import java.util.List;

public interface LocationService {

    List<String> findByCountryAndCity (String country, String city) throws PersistentException;

    List<Location> findByCountryAndCity (Country country, City city) throws PersistentException;

    Location findById (Integer locationId) throws PersistentException;
}