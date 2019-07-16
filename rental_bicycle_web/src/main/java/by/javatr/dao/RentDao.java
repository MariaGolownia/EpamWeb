package by.javatr.dao;
import by.javatr.entity.Bicycle;
import by.javatr.entity.Rent;
import java.math.BigInteger;
import java.util.List;

public interface RentDao extends Dao<Rent> {

    List<Rent> readByUserId(Integer search) throws PersistentException;

    Rent readByBicycle(Bicycle search) throws PersistentException;

    List<Rent> readInProcess(Boolean search) throws PersistentException;
}
