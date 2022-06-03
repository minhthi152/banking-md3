package com.example.banking.model;

import java.math.BigDecimal;
import java.util.Date;

public class Withdraw {
    private int id;
    private Date createAt;
    private int createBy;
    private boolean deleted;
    private Date updateAt;
    private int updateBy;
    private int customerId;
    private BigDecimal transactionAmount;

    public Withdraw() {
    }

    public Withdraw(int id, Date createAt, int createBy, boolean deleted, Date updateAt, int updateBy, int customerId, BigDecimal transactionAmount) {
        this.id = id;
        this.createAt = createAt;
        this.createBy = createBy;
        this.deleted = deleted;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
        this.customerId = customerId;
        this.transactionAmount = transactionAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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
}
