package org.example.dao;

import java.util.List;

public interface GeneralDao<T> {
    void update(T obj);

    void save(T obj);

    void delete(T obj);

    void deleteAll(T obj);

    List<T> findAll();

    T findById(Long id);

    T findByName(String name);
}
