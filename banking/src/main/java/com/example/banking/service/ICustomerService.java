package com.example.banking.service;

import com.example.banking.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService extends IGeneralService <Customer> {

    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    boolean updateSp(Customer customer) throws SQLException;

    boolean remove(int id);

    void insert(Customer customer);
}
