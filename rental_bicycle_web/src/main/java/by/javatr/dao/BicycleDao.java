package by.javatr.dao;
import by.javatr.entity.Bicycle;
import by.javatr.entity.Location;
import by.javatr.entity.Price;
import java.util.List;

public interface BicycleDao extends Dao<Bicycle> {

    List<Bicycle> readByCurrentLocation(Location search) throws PersistentException;
}
