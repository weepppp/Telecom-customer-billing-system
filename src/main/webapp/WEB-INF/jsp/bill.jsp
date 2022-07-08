<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
</head>
<body>
<div>
    <form action="/Telecom_customer_billing_system/bill/search">
        请输入电话号码：
        主叫号： <input type="text" name="callNamber">
        被叫号：<input type="text" name="calledNamber">
        <input type="submit" value="查找">
    </form>
</div>
<hr>
<div id="bill">
</div>
<div>
    <a href="index">上一页</a>
</div>
<script>
    function loadBill() {
        $.get('/Telecom_customer_billing_system/bill/get', function (data) {
            $("#bill").html(data);
        });
    };
    loadBill();
</script>
</body>
</html>
