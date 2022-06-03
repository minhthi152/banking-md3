package com.example.banking.controller;

import com.example.banking.service.CustomerServiceImpl;
import com.example.banking.service.ICustomerService;

import com.example.banking.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TransferServlet", urlPatterns = "/customers/transfer")
public class TransferServlet extends HttpServlet {
    ICustomerService customerService = new CustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int senderId = Integer.parseInt(req.getParameter("senderId"));
        int recipientId = Integer.parseInt(req.getParameter("recipientId"));

        Customer sender = customerService.findById(senderId);
        Customer recipient = customerService.findById(recipientId);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/transaction/transfer.jsp");
        req.setAttribute("sender", sender);
        req.setAttribute("recipient", recipient);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
