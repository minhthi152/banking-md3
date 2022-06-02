package com.example.banking.service;

import com.example.banking.model.Customer;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.banking.utils.MySQLConnection.getConnection;
import static com.example.banking.utils.MySQLConnection.printSQLException;

public class CustomerServiceImpl implements ICustomerService{
    private static final String SELECT_ALL_CUSTOMERS = ""+
            "SELECT " +
                "c.id, " +
                "c.full_name, " +
                "c.email, " +
                "c.phone, " +
                "c.address, " +
                "c.balance " +
            "FROM customers AS c " +
            "WHERE c.deleted = 0";

    private static final String INSERT_NEW_CUSTOMER = "" +
            "INSERT INTO customers (full_name, email, phone, address) " +
            "VALUES (?, ?, ?, ?);";

    private static final String UPDATE_CUSTOMER_SP = "CALL i_banking.sp_update_customer(?, ?, ?, ?, ?);";

    private static final String FIND_CUSTOMER_BY_ID = "CALL i_banking.sp_find_customer_by_id(?);";
    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();

        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String fullName = rs.getString("full_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                BigDecimal balance = rs.getBigDecimal("balance");
                customers.add(new Customer(id, fullName, email, phone, address, balance ));
            }

        } catch (SQLException e){
            printSQLException(e);
        }
        return customers;
    }

    public void insert(Customer newCustomer) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_CUSTOMER);

            preparedStatement.setString(1, newCustomer.getFullName());
            preparedStatement.setString(2, newCustomer.getEmail());
            preparedStatement.setString(3, newCustomer.getPhone());
            preparedStatement.setString(4, newCustomer.getAddress());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public Customer findById(int id) {

        Customer customer = null;

        try {
            Connection connection = getConnection();

            CallableStatement callableStatement = connection.prepareCall(FIND_CUSTOMER_BY_ID);

            callableStatement.setInt(1, id);

            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                String fullName = rs.getString("full_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                BigDecimal balance = new BigDecimal( rs.getString("balance"));

                customer= new Customer(id, fullName, email,phone, address, balance);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }


    @Override
    public boolean remove(int id) {
        return false;
    }

    public boolean updateSp(Customer customer) throws SQLException {
        boolean rowUpdated = false;
        // try-with-resource statement will auto close the connection.
        try {
            Connection connection = getConnection();

            CallableStatement callableStatement = connection.prepareCall(UPDATE_CUSTOMER_SP);

            callableStatement.setInt(1, customer.getId());
            callableStatement.setString(2, customer.getFullName());
            callableStatement.setString(3, customer.getEmail());
            callableStatement.setString(4, customer.getPhone());
            callableStatement.setString(5, customer.getAddress());

            rowUpdated = callableStatement.execute();
//            callableStatement.close();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }
}
