<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
</head>
<body>
<div>
    姓名<input type="text" id="uname">
    类型<input type="text" id="utype">
    <button onclick="addUser()">添加</button>
</div>
<hr>
<div id="customer">
</div>
<script>
    function loadCustomer() {
        $.get('/Telecom_customer_billing_system/customer/get', function (data) {
            $("#customer").html(data);
        });
    }

    // 查询所有
    loadCustomer();
</script>
</body>
</html>
