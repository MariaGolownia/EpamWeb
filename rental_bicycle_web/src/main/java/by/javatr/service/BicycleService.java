package by.javatr.service;
import by.javatr.entity.Bicycle;
import java.sql.SQLException;
import java.util.List;

public interface BicycleService {

    List<Bicycle> findByCurrentLocation(Integer locationId) throws SQLException;

    List<Bicycle> findByCurrentLocationWithPriceAndFreedom(Integer locationId, Boolean ifFree) throws SQLException;

    List<Bicycle> findByFreeStatus(Integer idLocation, Boolean ifFree) throws SQLException;

    Bicycle findById(Integer bicycleId) throws SQLException;

    List<Bicycle> findById(List <Integer> bicyclesId);

    void changeFreeStatus (List <Integer> bicyclesId, Boolean freeStatus) throws SQLException;
}
