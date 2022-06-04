package com.example.banking.service;

import com.example.banking.model.Deposit;
import com.example.banking.utils.MySQLConnection;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DepositServiceImpl implements IDepositService {

    private static final String  SP_DEPOSIT = "CALL i_banking.sp_deposit(?, ?);";
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

    @Override
    public boolean depositSp(int customerId, BigDecimal amount) {
        try {
            Connection connection = MySQLConnection.getConnection();
            CallableStatement callableStatement = connection.prepareCall(SP_DEPOSIT);

            callableStatement.setInt(1, customerId);
            callableStatement.setBigDecimal(2, amount);
            callableStatement.executeUpdate();

        } catch (SQLException e) {
            return false;
        }

        return true;
    }

}
