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
}
