package com.mdbytes.jpa.dao;

import java.util.List;

public interface DAO<T> {
    void save(T t);

    T get(int id);

    List<T> getAll();

    void update(T t);

    void delete(int id);

    int deleteAll();

}
