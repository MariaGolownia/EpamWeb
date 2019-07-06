package by.javatr.dao;

import by.javatr.entity.Price;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Currency;
import java.util.List;

public interface PriceDao extends Dao<Price> {

    List<Price> readByCurrency(Currency currency) throws PersistentException;

    List<Price> readByMaxRate(BigDecimal search) throws PersistentException;
}
