<%--
  Created by IntelliJ IDEA.
  User: zoeak
  Date: 2022/7/6
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
请选择下列功能：
<div class="btn-group">
    <button type="button" class="btn btn-default" onclick="click1()">客户资料管理 </button>
    <button type="button" class="btn btn-default" onclick="click2()"> 账户资料管理 </button>
    <button type="button" class="btn btn-default" onclick="click3()">用户电话信息管理</button>
    <button type="button" class="btn btn-default" onclick="click4()"> 账单查询</button>
    <button type="button" class="btn btn-default" onclick="click5()">返回主页面</button>
</div>
<script>
    function click1() {
        window.location.href = "customer.jsp";
    }

    function click2() {
        window.location.href = "";
    }
    function click3() {
        window.location.href = "";
    }
    function click4() {
        window.location.href = "";
    }
    function click5() {
        window.location.href = "index.jsp";
    }
</script>
</body>
</html>
