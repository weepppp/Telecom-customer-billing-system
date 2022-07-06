<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
</head>
<body>
<div>
    姓名:<input type="text" id="uname">
    类型:<input type="text" id="utype">
    <button onclick="addCustomer()">添加</button>
</div>
<hr>
<div id="customer">
</div>
<div>
    <a href="staff.jsp">回到上一页</a>
</div>
<script>
    // 增加
    function addCustomer() {
        let uname = $("#uname").val();
        let utype = $("#utype").val();
        let data = {uname:uname,utype:utype};
        $.ajax({
            url:'/Telecom_customer_billing_system/customer/insert',
            type:'post',
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify(data),
            success:function (data) {
                if (data.code == 200) {
                    // 增加了再刷新页面
                    loadCustomer();
                    $("#uname").val('');
                    $("#utype").val('');
                }
            }
        })
    }

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
