package com.example.banking.service;

import com.example.banking.model.Transfer;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class TransferServiceImpl implements ITransferService{

    private static final String  SP_TRANSFER = "CALL i_banking.sp_thi_transfer(1, 2, 345, @message);";

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
    public boolean transferSp(int customerId, BigDecimal amount) {
        return false;
    }
}
