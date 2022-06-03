
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="/layout/head.jsp"%>
    <title>Document</title>
</head>
<body>
<div class="container">
    <div class="table-title mb-4">
        <div class="row">
            <div class="col-sm-6">
                <h1>Transfer money Information</h1>
            </div>
            <div class="col-sm-6">
                <a href="/customers" class="btn btn-outline-light"><i class="fa fa-list" aria-hidden="true"></i> <span>Customer list</span></a>
            </div>
        </div>
    </div>
    <form id="frmTransfer" method="post" novalidate="novalidate">
        <fieldset class="row g-3">
            <div class="form-group row">
                <div class="mb-3 col-md-3">
                    <label class="col-sm-12 col-form-label">Sender ID</label>
                    <div class="col-sm-12">
                        <input type="text" class="form-control" readonly="" id="senderId" name="senderId" value="${sender.getId()}">
                    </div>
                </div>
                <div class="mb-3 col-md-3">
                    <label class="col-sm-12 col-form-label">Sender Name</label>
                    <div class="col-sm-12">
                        <input type="text" class="form-control" readonly="" id="senderName" name="senderName" value="${sender.getFullName()}">
                    </div>
                </div>
                <div class="mb-3 col-md-3">
                    <label class="col-sm-12 col-form-label">Email</label>
                    <div class="col-sm-12">
                        <input type="email" class="form-control" readonly="" id="senderEmail" name="senderEmail" value="${sender.getEmail()}">
                    </div>
                </div>
                <div class="mb-3 col-md-3">
                    <label class="col-sm-12 col-form-label">Sender balance</label>
                    <div class="col-sm-12">
                        <input type="text" class="form-control num-space" readonly="" id="balance" name="balance" value="${sender.getBalance()}">
                    </div>
                </div>
            </div>
            <div class="form-group row mb-4">
                <div class="mb-3 col-md-3">
                    <label for="recipient_id" class="col-sm-12 col-form-label">Recipient Name</label>
                    <div class="col-sm-12">
                        <select id="recipient_id" class="form-select" name="recipientId">
                            <option value="385">(385) Sierra Abbott</option>
                            <option value="395">(395) Brian Frazier</option>
                            <option value="405">(405) Emmanuel Owen</option>
                            <option value="415">(415) Lionel Malone</option>
                            <option value="425">(425) Colorado Abbott</option>
                            <option value="435">(435) Valentine Luna</option>
                        </select>
                    </div>
                </div>
                <div class="mb-3 col-md-3">
                    <label class="col-sm-12 col-form-label">Transfer Amount ($)</label>
                    <div class="col-sm-12">
                        <input type="text" id="transferAmount" class="form-control num-space" name="transferAmount" value="">
                    </div>
                </div>
                <div class="mb-3 col-md-3">
                    <label class="col-sm-12 col-form-label">Fees (%)</label>
                    <div class="col-sm-12">
                        <input type="text" class="form-control num-space" value="10" readonly="">
                    </div>
                </div>
                <div class="mb-3 col-md-3">
                    <label class="col-sm-12 col-form-label" style = "width: 253px;height: 38px;padding-right: 0px;padding-left: 0px;">Total amount of transaction ($)</label>
                    <div class="col-sm-12">
                        <input type="text" class="form-control num-space" readonly="" id="transactionAmount" name="transactionAmount" value="">
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <div class="mb-3 col-md-12">
                    <div class="col-sm-4">
                        <button type="submit" class="btn btn-outline-primary">
                            <i class="fa fa-exchange" aria-hidden="true"></i>
                            Transfer
                        </button>
                    </div>
                </div>
            </div>
        </fieldset>
    </form>
</div>

</body>
</html>