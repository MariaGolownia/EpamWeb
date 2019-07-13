package by.javatr.dao.mysql;

import by.javatr.dao.PersistentException;
import by.javatr.dao.PriceDao;
import by.javatr.entity.Price;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

public class PriceDaoImpl extends BaseDaoImpl implements PriceDao {
    private static final String SQL_SELECT_PRICE_BY_ID =
            "SELECT `user_login`, `user_password`, `user_role`, `user_status` FROM `user` WHERE `user_id` = ?";

    @Override
    public List<Price> readByCurrency(Currency currency) throws PersistentException {
        return null;
    }

    @Override
    public List<Price> readByMaxRate(BigDecimal search) throws PersistentException {
        return null;
    }

    @Override
    public Integer create(Price entity) throws PersistentException {
        return null;
    }

    @Override
    public Price read(Integer identity) throws PersistentException {


    }

    @Override
    public void update(Price entity) throws PersistentException {

    }

    @Override
    public void delete(Integer identity) throws PersistentException {

    }
}
