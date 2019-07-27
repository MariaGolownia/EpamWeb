package by.javatr.dao;
import by.javatr.entity.Bicycle;
import by.javatr.entity.Location;
import java.util.List;

public interface BicycleDao extends Dao<Bicycle> {

    List<Bicycle> readByCurrentLocation(Location search) throws PersistentException;

    List<Bicycle> readByCurrentLocation(Integer idLocation) throws PersistentException;

    List<Bicycle> readByCurrentLocationAndFreedom(Integer idLocation, Boolean ifFree) throws PersistentException;

}
