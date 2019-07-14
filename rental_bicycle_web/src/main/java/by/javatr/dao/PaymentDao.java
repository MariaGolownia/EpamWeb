package by.javatr.dao;
import by.javatr.entity.Payment;
import java.util.Date;
import java.util.List;

public interface PaymentDao extends Dao<Payment> {

    List<Payment> readByDate(Date search) throws PersistentException;

    List<Payment> readByIfPaid(Boolean search) throws PersistentException;
}
