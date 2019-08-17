package by.javatr.service.impl;

import by.javatr.dao.PriceDao;
import by.javatr.dao.mysql.DaoException;
import by.javatr.dao.mysql.DaoSql;
import by.javatr.dao.mysql.FactoryDaoSql;
import by.javatr.entity.Price;
import by.javatr.service.PriceService;
import by.javatr.service.Service;

import java.sql.SQLException;

public class PriceServiceImpl extends Service implements PriceService {
    @Override
    public Price read(Integer identity) {
        PriceDao dao = null;
        Price price = new Price();
        try {
            dao = FactoryDaoSql.getInstance().get(DaoSql.PriceDao);
            price = dao.read(identity);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return price;
    }
}
