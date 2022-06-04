package com.example.banking.controller;

import com.example.banking.model.Customer;
import com.example.banking.model.Deposit;
import com.example.banking.service.CustomerServiceImpl;
import com.example.banking.service.DepositServiceImpl;
import com.example.banking.service.ICustomerService;
import com.example.banking.service.IDepositService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.example.banking.utils.MySQLConnection.getConnection;
import static com.example.banking.utils.MySQLConnection.printSQLException;

@WebServlet(name = "DepositServlet", urlPatterns = "/customers/deposit" )
public class DepositServlet extends HttpServlet {
    ICustomerService customerService = new CustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            int id = Integer.parseInt(req.getParameter("id"));

            Customer existingCustomer = customerService.findById(id);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/transaction/deposit.jsp");
            req.setAttribute("existingCustomer", existingCustomer);
            try {
                dispatcher.forward(req, resp);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IDepositService depositService = new DepositServiceImpl();
        int id = Integer.parseInt(req.getParameter("customerId"));
        Customer existingCustomer = customerService.findById(id);


        BigDecimal transactionAmount = new BigDecimal(req.getParameter("transactionAmount"));
        boolean deposited = depositService.depositSp(id,transactionAmount);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/transaction/deposit.jsp");
        req.setAttribute("existingCustomer", existingCustomer);
        req.setAttribute("isSuccessful", deposited);
        dispatcher.forward(req, resp);
    }
}
