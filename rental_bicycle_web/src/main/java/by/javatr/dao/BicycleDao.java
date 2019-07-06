package by.javatr.dao;
import by.javatr.entity.Bicycle;
import by.javatr.entity.Location;
import by.javatr.entity.Price;
import java.time.Year;
import java.util.List;

public interface BicycleDao extends Dao<Bicycle> {

    List<Bicycle> readByModel(String search) throws PersistentException;

    List<Bicycle> readByType(Bicycle search) throws PersistentException;

    List<Bicycle> readByProductionYear(Year search) throws PersistentException;

    List<Bicycle> readByProducer(String search) throws PersistentException;

    List<Bicycle> readCurrentLocation(Location search) throws PersistentException;

    List<Bicycle> readCurrentLocation(Price search) throws PersistentException;

}
