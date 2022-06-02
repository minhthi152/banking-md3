<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Document</title>
    <%@ include file="/layout/head.jsp"%>
</head>
<body>
<div class = "container">
    <div class = "table-title mb-4">
        <div class = "row">
            <div class = "col-sm-8">
                <h1>Deposit money into customer's account</h1>
            </div>
            <div class = "col-sm-4">
                <a href="/customers" class = "btn btn-outline-light">
                    <i class="fa-solid fa-list"></i>
                    <span>List of customers</span>
                </a>
            </div>


        </div>
    </div>

    <form id="frmCreateCustomer" method="post" novalidate="novalidate">
        <fieldset class="row g-3">
            <div class="col-md-6">
                <label class="form-label">Customer ID</label>
                <input type="text" class="form-control" id="customerId" name="customerId"
                       value="${existingCustomer.getId()}" readonly>
            </div>
            <div class="col-md-6">
                <label class="form-label">Full name</label>
                <input type="text" class="form-control" id="fullName" name="fullName"
                       value="${existingCustomer.getFullName()}" readonly>
            </div>
            <div class="col-md-6">
                <label class="form-label">Current balance ($)</label>
                <input type="number" class="form-control" id="balance" name="balance"
                       value="${existingCustomer.getBalance()}" readonly>
            </div>
            <div class="col-md-6">
                <label class="form-label">Transaction Amount ($)</label>
                <input type="text" class="form-control" id="transactionAmount" name="transactionAmount" value="">
            </div>

            <div class="col-md-12" style="margin-top: 15px">
                <button type="submit" id="btnCreateCustomer" class="btn btn-outline-primary">
                    <i class="fa-solid fa-plus"></i>
                    Deposit
                </button>
            </div>
        </fieldset>
    </form>

<%--    <div class="footer">--%>
<%--        <div id="message-alert">--%>
<%--            <!-- <div class="alert-danger hide"> -->--%>
<%--            <div class="alert-danger">--%>
<%--                <h5>Please correct errors below FE:</h5>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

</div>
</body>
</html>
