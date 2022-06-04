package com.example.banking.controller;

import com.example.banking.model.Customer;
import com.example.banking.service.CustomerServiceImpl;
import com.example.banking.service.ICustomerService;
import com.example.banking.service.IWithdrawService;
import com.example.banking.service.WithdrawServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name  = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private final ICustomerService customerService= new CustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(req, resp);
            case "update":
                showUpdateForm(req, resp);
                break;
            case "suspend":
                showSuspendForm(req, resp);
                break;
            default:
                showCustomersList(req,resp);
                break;
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewCustomer(req, resp);
                break;
            case "update":
                updateCustomer(req, resp);
            case "suspend":
                break;
        }
    }

    private void showCustomersList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/list.jsp");
        List<Customer> customers = customerService.findAll();
        req.setAttribute("customers", customers);
        dispatcher.forward(req, resp);
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp){
        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/create.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void createNewCustomer(HttpServletRequest req, HttpServletResponse resp){

        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        Customer newCustomer = new Customer(fullName, email, phone, address);

        customerService.insert(newCustomer);

        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/create.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));

        Customer existingCustomer = customerService.findById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/customer/update.jsp");
        req.setAttribute("existingCustomer", existingCustomer);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void updateCustomer(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = null;
        try{
            int id = Integer.parseInt(req.getParameter("id"));
            String fullName = req.getParameter("fullName");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");
            Customer customer = new Customer(id, fullName, email, phone, address);
            dispatcher = req.getRequestDispatcher("/customer/update.jsp");
            //validate
            boolean updated = customerService.updateSp(customer);
            if(updated){
                req.setAttribute("message", "Successfully updated!");
            }else{
                req.setAttribute("message", "Update failed!");
            }
        }catch (Exception e){
            req.setAttribute("message", "Update failed!");
        }

        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showSuspendForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/customer/suspend.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
