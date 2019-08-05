package by.javatr.service.impl;
import by.javatr.dao.BicycleDao;
import by.javatr.entity.PersistentException;
import by.javatr.dao.mysql.DaoException;
import by.javatr.dao.mysql.DaoSql;
import by.javatr.dao.mysql.FactoryDaoSql;
import by.javatr.entity.Bicycle;
import by.javatr.service.BicycleService;
import by.javatr.service.Service;
import com.google.gson.internal.bind.SqlDateTypeAdapter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BicycleServiceImpl extends Service implements BicycleService {
    @Override
    public List<Bicycle> findByCurrentLocation(Integer idLocation) {
        BicycleDao dao = null;
        List<Bicycle> bicycles = new ArrayList<>();
        try {
            try {
                dao = FactoryDaoSql.getInstance().get(DaoSql.BicycleDao);
                bicycles = dao.readByCurrentLocation(idLocation);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return bicycles;
    }

    @Override
    public List<Bicycle> findByFreeStatus(Integer idLocation, Boolean ifFree) {
        BicycleDao dao = null;
        List<Bicycle> bicycles = new ArrayList<>();
            try {
                dao = FactoryDaoSql.getInstance().get(DaoSql.BicycleDao);
                bicycles = dao.readByCurrentLocationAndFreedom(idLocation, ifFree);
        } catch (DaoException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return bicycles;
    }

    @Override
    public Bicycle findById(Integer bicycleId) {
        BicycleDao dao = null;
        Bicycle bicycle = new Bicycle();
            try {
                dao = FactoryDaoSql.getInstance().get(DaoSql.BicycleDao);
                try {
                    bicycle = dao.read(bicycleId);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }
        return bicycle;
    }

    @Override
    public void changeFreeStatus(List <Integer> bicyclesId, Boolean freeStatus) {
        BicycleDao dao = null;
        Bicycle bicycle = new Bicycle();
        try {
            dao = FactoryDaoSql.getInstance().get(DaoSql.BicycleDao);
            try {
                for (Integer id : bicyclesId) {
               dao.changeFreeStatus(id, freeStatus); }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
