<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
</head>
<body>
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
</body>
</html>
