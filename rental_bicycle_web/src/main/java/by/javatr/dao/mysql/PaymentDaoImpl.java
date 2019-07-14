package by.javatr.dao.mysql;

import by.javatr.dao.PaymentDao;
import by.javatr.dao.PersistentException;
import by.javatr.entity.Payment;

import java.util.Date;
import java.util.List;

public class PaymentDaoImpl extends BaseDaoImpl implements PaymentDao {
    @Override
    public List<Payment> readByDate(Date search) throws PersistentException {
        return null;
    }

    @Override
    public List<Payment> readByIfPaid(Boolean search) throws PersistentException {
        return null;
    }

    @Override
    public Integer create(Payment entity) throws PersistentException {
        return null;
    }

    @Override
    public Payment read(Integer identity) throws PersistentException {
        return null;
    }

    @Override
    public void update(Payment entity) throws PersistentException {

    }

    @Override
    public void delete(Integer identity) throws PersistentException {

    }
}
