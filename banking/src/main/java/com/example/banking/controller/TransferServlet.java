package com.example.banking.controller;

import com.example.banking.service.CustomerServiceImpl;
import com.example.banking.service.ICustomerService;

import com.example.banking.model.Customer;
import com.example.banking.service.ITransferService;
import com.example.banking.service.TransferServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "TransferServlet", urlPatterns = "/customers/transfer")
public class TransferServlet extends HttpServlet {
    ICustomerService customerService = new CustomerServiceImpl();
    ITransferService transferService = new TransferServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/transaction/transfer.jsp");

        int senderId = Integer.parseInt(req.getParameter("senderId"));
        Customer sender = customerService.findById(senderId);
        req.setAttribute("sender", sender);

        List<Customer> recipients = customerService.findAll();
        recipients.remove(sender);
        req.setAttribute("recipients", recipients);

        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/transaction/transfer.jsp");

        int senderId = Integer.parseInt(req.getParameter("senderId"));
        Customer sender = customerService.findById(senderId);
        req.setAttribute("sender", sender);

        List<Customer> recipients = customerService.findAll();
        recipients.remove(sender);
        req.setAttribute("recipients", recipients);

        int recipientId = Integer.parseInt(req.getParameter("recipientId"));
        req.setAttribute("recipientId", recipientId);

        BigDecimal transferAmount = new BigDecimal(req.getParameter("transferAmount"));
//        req.setAttribute("transactionAmount", transferAmount.multiply(BigDecimal.valueOf(1.1)));

        transferService.transferSp(senderId,recipientId,transferAmount);

        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }


    }
}
