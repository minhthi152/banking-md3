
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="/layout/head.jsp"%>
    <title>Document</title>
</head>
<body>
<div class = "container">
    <div class = "table-title">
        <div class = "row">
            <div class = "col-sm-6">
                <h1>Transfer money Information</h1>
            </div>
            <div class = "col-sm-6">
                <a href= "/customers" class = "btn btn-outline-light">
                    <i class="fa-solid fa-list"></i>
                    <span>Customers list</span>
                </a>

            </div>
        </div>
    </div>

    <table class = "table table-hover">
        <thead>
        <tr>
            <th class="text-center">#</th>
            <th class="text-center">Sender ID</th>
            <th class="text-center">Sender Name</th>
            <th class="text-center">Recipient ID</th>
            <th class="text-center">Recipient Name</th>
            <th class="text-center">Transfer amount ($)</th>
            <th class="text-center">Fees (%)</th>
            <th class="text-center">Fees Amount ($)</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class ="text-center">1</td>
            <td class ="text-center">10</td>
            <td>Titanium Kim</td>
            <td class ="text-center">5</td>
            <td>Cocain Avil</td>
            <td class = "text-end num-comma pr-20">5,000,000</td>
            <td class =  "text-center">10</td>
            <td class = "text-end num-comma pr-20">500,000</td>
        </tr>

        <tr>
            <td class ="text-center">1</td>
            <td class ="text-center">10</td>
            <td>Titanium Kim</td>
            <td class ="text-center">5</td>
            <td>Cocain Avil</td>
            <td class = "text-end num-comma pr-20">5,000,000</td>
            <td class =  "text-center">10</td>
            <td class = "text-end num-comma pr-20">500,000</td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="5"></td>
            <td class="text-center fw-bold">Total Fees Amount:</td>
            <td colspan="2" class="text-end fw-bold num-comma pr-20" style="font-size: 24px">1,501,505</td>
        </tr>
        </tfoot>
    </table>

</div>
</body>
</html>
