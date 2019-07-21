package by.javatr.service;

import by.javatr.dao.PersistentException;
import by.javatr.entity.Location;

import java.util.List;

public interface LocationService {

    List<Location> findByCountryAndCity (String country, String city) throws PersistentException;
}
