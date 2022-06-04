package com.example.banking.service;

import com.example.banking.model.Transfer;
import com.example.banking.utils.MySQLConnection;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TransferServiceImpl implements ITransferService{

    private static final String  SP_TRANSFER = "CALL i_banking.sp_thi_transfer(?, ?, ?, ?);";

    @Override
    public List<Transfer> findAll() {
        return null;
    }

    @Override
    public void save(Transfer transfer) {

    }

    @Override
    public Transfer findById(int id) {
        return null;
    }

    @Override
    public boolean updateSp(Transfer transfer) throws SQLException {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public void insert(Transfer transfer) {

    }

    @Override
    public String transferSp(int senderId, int recipientId, BigDecimal transferAmount) {
        try {
            Connection connection = MySQLConnection.getConnection();
            //SP_TRANSFER = "CALL i_banking.sp_thi_transfer(?, ?, ?, ?);";
            CallableStatement callableStatement = connection.prepareCall(SP_TRANSFER);


            callableStatement.setInt(1, senderId);
            callableStatement.setInt(2, recipientId);
            callableStatement.setBigDecimal(3, transferAmount);

            callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);

            callableStatement.executeUpdate();
            String message = callableStatement.getString(4);

            return message;
        } catch (SQLException e) {
            return null;
        }
    }
}
