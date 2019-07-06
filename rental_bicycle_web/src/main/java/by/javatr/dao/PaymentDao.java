package by.javatr.dao;

import by.javatr.entity.Payment;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Date;
import java.util.List;

public interface PaymentDao extends Dao<Payment> {

    List<Payment> readByDate(Date search) throws PersistentException;

    List<Payment> readByIfPaid(Boolean search) throws PersistentException;
}
