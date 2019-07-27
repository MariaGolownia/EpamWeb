package by.javatr.service;
import by.javatr.dao.PersistentException;
import by.javatr.entity.Bicycle;
import java.util.List;

public interface BicycleService {

    List<Bicycle> findByCurrentLocation(Integer locationId) throws PersistentException;

    List<Bicycle> findByFreeStatus(Integer idLocation, Boolean ifFree) throws PersistentException;

    Bicycle findById(Integer bicycleId) throws PersistentException;
}
