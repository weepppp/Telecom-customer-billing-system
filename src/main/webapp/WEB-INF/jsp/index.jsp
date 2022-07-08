<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%--<div class="btn-group">--%>
<%--    <button type="button" class="btn btn-default" onclick="click1()">电信工作人员</button>--%>
<%--    <button type="button" class="btn btn-default" onclick="click2()">用户</button>--%>
<%--</div>--%>
<%--<script>--%>
<%--    function click1() {--%>
<%--        window.location.href = "staff.jsp";--%>
<%--    }--%>

<%--    function click2() {--%>
<%--        window.location.href = "billClient.jsp";--%>
<%--    }--%>
<%--</script>--%>

<div>
    <div><shiro:guest>你没有登录 去登录<a href="/Telecom_customer_billing_system/login"></a></shiro:guest></div>
    <div><shiro:authenticated><shiro:principal/>，欢迎进入电信计费系统，请点击下列选项进入操作界面：</shiro:authenticated></div>
    <div><shiro:hasPermission name="staff:customer"><a href="/Telecom_customer_billing_system/customer">客户资料管理</a></shiro:hasPermission></div>
    <div><shiro:hasPermission name="staff:account"><a href="/Telecom_customer_billing_system/account">账户资料管理</a></shiro:hasPermission></div>
    <div><shiro:hasPermission name="staff:phone"><a href="/Telecom_customer_billing_system/phone">用户电话信息管理</a></shiro:hasPermission></div>
    <div><shiro:hasPermission name="staff:bill"><a href="/Telecom_customer_billing_system/bill">账单查询</a></shiro:hasPermission></div>
    <div><shiro:hasPermission name="customer:bill"><a href="/Telecom_customer_billing_system/billClient">接打电话</a></shiro:hasPermission></div>
    <div><shiro:user><a href="/Telecom_customer_billing_system/logout">注销登录</a></shiro:user></div>
</div>
</body>
</html>
