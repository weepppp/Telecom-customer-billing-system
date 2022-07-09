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
        主叫号： <input type="text" name="callNamber" id="callNamber">
        被叫号：<input type="text" name="calledNamber" id="calledNamber">
        <input type="submit" value="查找">
    </form>
</div>
<hr>
<table border="1px">
    <tr>
        <td>账单号</td>
        <td>主叫号</td>
        <td>被叫号</td>
        <td>通讯时长（分钟)</td>
        <td>话费(元)</td>
    </tr>
    <c:forEach items="${bill}" var="bill">
        <tr>
            <td>${bill.bid}</td>
            <td>${bill.callNamber}</td>
            <td>${bill.calledNamber}</td>
            <td>${bill.callTime}</td>
            <td>${bill.callFee}</td>
        </tr>
    </c:forEach>
</table>

<div style="margin-left: 200px">
    <a href="/Telecom_customer_billing_system/bill/get?pageNum=1">首页</a>
    <c:if test="${page.pageNum > 1}">
        <a href="/Telecom_customer_billing_system/bill/get?pageNum=${page.pageNum - 1}">上一页</a>
    </c:if>
    <c:if test="${page.pageNum < page.pages}">
        <a href="/Telecom_customer_billing_system/bill/get?pageNum=${page.pageNum + 1}">下一页</a>
    </c:if>
    <a href="/Telecom_customer_billing_system/bill/get?pageNum=${page.pages}">末页</a>
</div>

</body>
</html>
