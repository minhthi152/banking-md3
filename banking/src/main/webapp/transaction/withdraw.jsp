
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Document</title>
    <%@ include file="/layout/head.jsp"%>
    <style>
        .footer{
            position: fixed;
            bottom: 0;
            width: 100%;
            height: 100px;
            margin-bottom: 0;
            border-bottom: 0;
            background-color: #f8d7da;
            line-height: 100px;
            display: none;
        }
    </style>
</head>
<body>
<div class = "container">
    <div class = "table-title mb-4">
        <div class = "row">
            <div class = "col-sm-8">
                <h1>Withdraw money from the customer's account</h1>
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
                <input type="text" readonly class="form-control" id="customerId" name="customerId" value="${existingCustomer.getId()}">
            </div>
            <div class="col-md-6">
                <label class="form-label">Full name</label>
                <input type="text" readonly class="form-control" id="fullName" name="fullName" value="${existingCustomer.getFullName()}">
            </div>
            <div class="col-md-6">
                <label class="form-label">Current balance ($)</label>
                <input type="tel" readonly class="form-control" id="balance" name="balance" value="${existingCustomer.getBalance()}">
            </div>
            <div class="col-md-6">
                <label class="form-label">Transaction Amount ($)</label>
                <input type="text" class="form-control" id="transactionAmount" name="transactionAmount" value="">
            </div>

            <div class="col-md-12" style="margin-top: 15px">
                <button type="submit" id="btnCreateCustomer" class="btn btn-outline-warning" onclick="showMessage()">
                    <i class="fa-solid fa-minus"></i>
                    Withdraw
                </button>
            </div>
        </fieldset>
    </form>



</div>
<div class="footer" id ="footer">
    <div id="message-alert">
        <div class="alert-danger">
            <h5>${withdrawMessage}</h5>
        </div>
    </div>
</div>
<script>

</script>
</body>
</html>