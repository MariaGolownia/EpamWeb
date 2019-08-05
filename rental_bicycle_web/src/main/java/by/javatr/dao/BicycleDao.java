package by.javatr.dao;
import by.javatr.entity.Bicycle;
import by.javatr.entity.Location;
import by.javatr.entity.PersistentException;

import java.sql.SQLException;
import java.util.List;

public interface BicycleDao extends Dao<Bicycle> {

    List<Bicycle> readByCurrentLocation(Location search) throws SQLException;

    List<Bicycle> readByCurrentLocation(Integer idLocation) throws SQLException;

    List<Bicycle> readByCurrentLocationAndFreedom(Integer idLocation, Boolean ifFree) throws SQLException;

    void changeFreeStatus(Integer idBicycle, Boolean ifFree) throws SQLException;
}
