package com.example.banking.service;

import java.sql.SQLException;
import java.util.List;

public interface IGeneralService<T> {

    List<T> findAll();
    void save(T t);
    T findById(int id);

    boolean updateSp(T t)  throws SQLException;
    boolean remove(int id);

    void insert(T t);
}
