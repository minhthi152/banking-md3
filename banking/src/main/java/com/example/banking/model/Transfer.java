package com.example.banking.model;

import java.math.BigDecimal;
import java.util.Date;

public class Transfer {
    private int id;
    private int senderId;
    private int recipientId;
    private BigDecimal transactionAmount;
    private int fees;
    private BigDecimal feeAmount;
    private BigDecimal transferAmount;

    private boolean deleted;
    private Date createAt;
    private int createBy;
    private Date updateAt;
    private int updateBy;

    public Transfer() {
    }

    public Transfer(int id, int senderId, int recipientId, BigDecimal transactionAmount, int fees, BigDecimal feeAmount, BigDecimal transferAmount, boolean deleted, Date createAt, int createBy, Date updateAt, int updateBy) {
        this.id = id;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.transactionAmount = transactionAmount;
        this.fees = fees;
        this.feeAmount = feeAmount;
        this.transferAmount = transferAmount;
        this.deleted = deleted;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }
}
