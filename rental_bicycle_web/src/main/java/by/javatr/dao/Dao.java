package by.javatr.dao;
import by.javatr.entity.Entity;

import java.sql.SQLException;

public interface Dao<Type extends Entity > {

    Integer create(Type entity) throws PersistentException, SQLException;

    Type read(Integer identity) throws PersistentException, SQLException;

    void update(Type entity) throws PersistentException;

    void delete(Integer identity) throws PersistentException;
}
