package com.example.banking.model;

import java.math.BigDecimal;
import java.util.Date;

public class Deposit {
    private int id;
    private int customerId;
    private BigDecimal transactionAmount;
    private boolean deleted;
    private Date createAt;
    private int createBy;
    private Date updateAt;
    private int updateBy;

    public Deposit() {
    }

    public Deposit(int id, int customerId, BigDecimal transactionAmount, boolean deleted, Date createAt, int createBy, Date updateAt, int updateBy) {
        this.id = id;
        this.customerId = customerId;
        this.transactionAmount = transactionAmount;
        this.deleted = deleted;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public int getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }
}
