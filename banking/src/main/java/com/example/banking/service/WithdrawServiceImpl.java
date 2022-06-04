package com.example.banking.service;

import com.example.banking.model.Withdraw;
import com.example.banking.utils.MySQLConnection;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class WithdrawServiceImpl implements IWithdrawService {

    private static final String  SP_WITHDRAW = "CALL i_banking.sp_thi_withdraw(?, ?, ?);";
    @Override
    public List<Withdraw> findAll() {
        return null;
    }

    @Override
    public void save(Withdraw withdraw) {

    }

    @Override
    public Withdraw findById(int id) {
        return null;
    }

    @Override
    public boolean updateSp(Withdraw withdraw) throws SQLException {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public void insert(Withdraw withdraw) {

    }

    @Override
    public String withdrawSp(int customerId, BigDecimal amount) {
        try {
            Connection connection = MySQLConnection.getConnection();
            //SP_WITHDRAW = "CALL i_banking.sp_thi_withdraw(?, ?, ?);";
            CallableStatement callableStatement = connection.prepareCall(SP_WITHDRAW);


            callableStatement.setInt(1, customerId);
            callableStatement.setBigDecimal(2, amount);

            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);

            callableStatement.executeUpdate();
            String message = callableStatement.getString(3);
            System.out.println(this.getClass() + " message: " + message);

            return message;
        } catch (SQLException e) {
            return null;
        }

    }

}
