
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>List of customers</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <%@ include file = "/layout/head.jsp"%>
</head>

<body>
<div class="container">
    <div class="table-title">
        <div class="row">
            <div class="col-sm-5">
                <h1>List of customers</h1>
            </div>
            <div class="col-sm-7">
                <a href="/customers?action=create" class="btn btn-outline-light" data-bs-toggle="modal"
                        data-bs-target="#createModal">
                    <i class="fa-solid fa-plus"></i>
                    <span>Add New Customer</span>
                </a>
                <a href="/customers?action=transferHistory" class="btn btn-outline-light">
                    <i class="fa fa-history" aria-hidden="true"></i>
                    <span>Transfer money Information</span>
                </a>
            </div>
        </div>
    </div>
    <div>
        <table class="table table-hover table-borderless">
            <thead>
            <tr>
                <th>#</th>
                <th>Full Name</th>
                <th>Email</th>
                <th>phone</th>
                <th>Address</th>
                <th>Balance</th>
                <th colspan="5" class="text-center">Action</th>
            </tr>
            </thead>
            <tbody id="tbCustomer">

            <c:forEach var="customer" items="${customers}">
               <tr>
                   <td>${customer.getId()}</td>
                   <td>${customer.getFullName()}</td>
                   <td>${customer.getEmail()}</td>
                   <td>${customer.getPhone()}</td>
                   <td>${customer.getAddress()}</td>
                   <td>${customer.getBalance()}</td>
                   <td>
                       <a href="/customers?action=update&id=${customer.getId()}">
                        <button class="btn btn-outline-secondary">
                            <i class="fas fa-edit"></i>
                        </button>
                       </a>
                   </td>
                   <td>
                       <a href="/customers?action=deposit&id=${customer.getId()}">
                           <button class="btn btn-outline-success">
                               <i class="fa fa-plus" aria-hidden="true"></i>
                           </button>
                       </a>
                   </td>
                   <td>
                       <a href = "/customers?action=withdraw&id=${customer.getId()}">
                           <button class="btn btn-outline-warning">
                               <i class="fa fa-minus" aria-hidden="true"></i>
                           </button>
                       </a>
                   </td>
                   <td>
                       <a href = "/customers?action=transfer&id=${customer.getId()}">
                           <button class="btn btn-outline-primary">
                               <i class="fa fa-exchange" aria-hidden="true"></i>
                           </button>
                       </a>
                   </td>
                   <td>
                       <a href = "/customers?action=suspend&id=${customer.getId()}">
                           <button class="btn btn-outline-danger">
                               <i class="fa fa-ban" aria-hidden="true"></i>
                           </button>
                       </a>
                   </td>
               </tr>

            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%@ include file = "/layout/script.jsp"%>
</body>

</html>
