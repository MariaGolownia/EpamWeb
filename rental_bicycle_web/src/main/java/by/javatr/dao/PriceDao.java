package by.javatr.dao;
import by.javatr.entity.en_um.Currency;
import by.javatr.entity.Price;

import java.sql.SQLException;
import java.util.List;

public interface PriceDao extends Dao<Price> {

    List<Price> readByCurrency(Currency currency) throws SQLException;

}
