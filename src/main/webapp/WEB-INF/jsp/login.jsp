<%--
  Created by IntelliJ IDEA.
  User: zoeak
  Date: 2022/7/8
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    ${error}
</div>
<form action="/Telecom_customer_billing_system/dologin" method="post">
    <input type="text" name="username" value="">
    <input type="text" name="password" value="">
    <input type="checkbox" value="on" name="rememberMe">rememberMe
    <input type="submit" value="登錄">
</form>
</body>
</html>
