<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
</head>
<body>
<table border="1">
    <tr>
        <td>客户id</td>
        <td>客户名称</td>
        <td>客户类型</td>
        <td>操作1</td>
        <td>操作2</td>
    </tr>
    <c:forEach items="${customer}" var="customer">
        <tr>
            <td>${customer.uid}</td>
            <td>${customer.uname}</td>
            <td>${customer.utype}</td>
            <td><button onclick="deleteByUid(${customer.uid})">删除</button></td>
            <td><input type="text" id="uname1"> <button onclick="updateCustomer(${customer.uid})">修改</button></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
