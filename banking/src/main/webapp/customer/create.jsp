<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <title>Create</title>
    <%@ include file="/layout/head.jsp"%>
</head>
<body>
<div class="container">
    <div class="table-title">
        <div class="row">
            <div class="col-sm-5">
                <h1>Create customer</h1>
            </div>
            <div class="col-sm-7">
                <a href="/customers" class="btn btn-outline-light">
                    <i class="fa-solid fa-bars"></i>
                    <span>List of customers</span>
                </a>
            </div>
        </div>
    </div>
    <div>
        <form method="post">
            <div class="row mt-3">
                <div class="col-md-6 mb-3">
                    <label for="fullName" class="form-label">Full Name</label>
                    <input name = "fullName" type="text" class="form-control" id="fullName">
                </div>
                <div class="col-md-6 mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input name = "email" type="email" class="form-control" id="email">
                </div>

            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="phone" class="form-label">Phone</label>
                    <input name = "phone" type="text" class="form-control" id="phone">
                </div>
                <div class="col-md-6 mb-3">
                    <label for="address" class="form-label">Address</label>
                    <input name = "address" type="text" class="form-control" id="address">
                </div>
            </div>

            <button type="submit" class="btn btn-outline-primary">Create</button>
        </form>
    </div>
</div>
</body>
</html>
