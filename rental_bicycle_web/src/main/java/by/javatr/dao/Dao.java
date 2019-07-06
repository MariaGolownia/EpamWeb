package by.javatr.dao;

import by.javatr.entity.Entity;

public interface Dao<Type extends Entity> {

    Integer create(Type entity) throws PersistentException;

    Type read(Integer identity) throws PersistentException;

    void update(Type entity) throws PersistentException;

    void delete(Integer identity) throws PersistentException;
}
