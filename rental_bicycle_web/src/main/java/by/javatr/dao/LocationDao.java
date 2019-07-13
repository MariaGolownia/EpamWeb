package by.javatr.dao;
import by.javatr.entity.Company;
import by.javatr.entity.Location;
import java.util.List;

public interface LocationDao extends Dao<Location> {

    List<Location> readByCompanyId(Integer search) throws PersistentException;

    List<Location> readByCountry(String search) throws PersistentException;

    List<Location> readByCity(String search) throws PersistentException;


}
