package com.example.banking.service;
import com.example.banking.model.Deposit;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public interface IDepositService extends IGeneralService <Deposit> {

    List<Deposit> findAll();

    void save(Deposit deposit);

    Deposit findById(int id);

    boolean updateSp(Deposit deposit) throws SQLException;

    boolean remove(int id);

    void insert(Deposit deposit);

    boolean depositSp(int customerId, BigDecimal amount);
}
