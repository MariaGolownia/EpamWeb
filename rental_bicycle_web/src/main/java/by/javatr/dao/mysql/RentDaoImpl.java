package by.javatr.dao.mysql;

import by.javatr.dao.PersistentException;
import by.javatr.dao.RentDao;
import by.javatr.entity.Rent;

import java.math.BigInteger;
import java.util.List;

public class RentDaoImpl extends BaseDaoImpl implements RentDao {
    @Override
    public List<Rent> readByUserId(BigInteger search) throws PersistentException {
        return null;
    }

    @Override
    public Rent readByBicycleId(BigInteger search) throws PersistentException {
        return null;
    }

    @Override
    public List<Rent> readInProcess(Boolean search) throws PersistentException {
        return null;
    }

    @Override
    public Integer create(Rent entity) throws PersistentException {
        return null;
    }

    @Override
    public Rent read(Integer identity) throws PersistentException {
        return null;
    }

    @Override
    public void update(Rent entity) throws PersistentException {

    }

    @Override
    public void delete(Integer identity) throws PersistentException {

    }
}
