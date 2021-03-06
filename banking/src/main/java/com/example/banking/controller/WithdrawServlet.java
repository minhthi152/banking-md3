package com.example.banking.controller;

import com.example.banking.model.Customer;
import com.example.banking.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "WithdrawServlet", urlPatterns = "/customers/withdraw" )
public class WithdrawServlet extends HttpServlet {
    ICustomerService customerService = new CustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            int id = Integer.parseInt(req.getParameter("id"));

            Customer existingCustomer = customerService.findById(id);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/transaction/withdraw.jsp");
            req.setAttribute("existingCustomer", existingCustomer);
            try {
                dispatcher.forward(req, resp);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/transaction/withdraw.jsp");

        IWithdrawService withdrawService = new WithdrawServiceImpl();
        int id = Integer.parseInt(req.getParameter("customerId"));
        Customer existingCustomer = customerService.findById(id);
        req.setAttribute("existingCustomer", existingCustomer);

        BigDecimal transactionAmount = new BigDecimal(req.getParameter("transactionAmount"));
        String withdrawMessage = withdrawService.withdrawSp(id,transactionAmount);
        req.setAttribute("withdrawMessage", withdrawMessage);

        dispatcher.forward(req, resp);
    }
}
