package com.example.banking.service;
import com.example.banking.model.Transfer;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public interface ITransferService extends IGeneralService <Transfer> {

    List<Transfer> findAll();

    void save(Transfer transfer);

    Transfer findById(int id);

    boolean updateSp(Transfer transfer) throws SQLException;

    boolean remove(int id);

    void insert(Transfer transfer);

    String transferSp(int senderId, int recipientId, BigDecimal amount);
}
