package by.javatr.dao;
import by.javatr.entity.Currency;
import by.javatr.entity.Price;
import java.math.BigDecimal;


import java.util.List;

public interface PriceDao extends Dao<Price> {

    List<Price> readByCurrency(Currency currency) throws PersistentException;

}
