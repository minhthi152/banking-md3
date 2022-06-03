package com.example.banking.service;
import com.example.banking.model.Withdraw;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public interface IWithdrawService extends IGeneralService <Withdraw> {

    List<Withdraw> findAll();

    void save(Withdraw withdraw);

    Withdraw findById(int id);

    boolean updateSp(Withdraw withdraw) throws SQLException;

    boolean remove(int id);

    void insert(Withdraw withdraw);

    boolean withdrawSp(int customerId, BigDecimal amount);
}
