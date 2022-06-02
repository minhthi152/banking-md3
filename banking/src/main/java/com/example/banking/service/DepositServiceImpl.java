package com.example.banking.service;

import com.example.banking.model.Deposit;

import java.sql.SQLException;
import java.util.List;

public class DepositServiceImpl implements IDepositService {
    @Override
    public List<Deposit> findAll() {
        return null;
    }

    @Override
    public void save(Deposit deposit) {

    }

    @Override
    public Deposit findById(int id) {
        return null;
    }

    @Override
    public boolean updateSp(Deposit deposit) throws SQLException {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public void insert(Deposit deposit) {

    }
}
