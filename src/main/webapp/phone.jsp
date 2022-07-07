<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
</head>
<body>
<div>
    电话号码:<input type="text" id="phoneNumber">
    电话地址:<input type="text" id="phoneAddress">
    结算账号:<input type="text" id="aid">
    <button onclick="addPhone()">添加</button>
</div>
<hr>
<div id="phone">
</div>
<div>
    <a href="staff.jsp">回到上一页</a>
</div>
<script>
    // 增加
    function addPhone() {
        let phoneNumber = $("#phoneNumber").val();
        let phoneAddress = $("#phoneAddress").val();
        let aid = $("#aid").val();
        let data = {phoneNumber:phoneNumber,phoneAddress:phoneAddress,aid:aid};
        $.ajax({
            url:'/Telecom_customer_billing_system/phone/insert',
            type:'post',
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify(data),
            success:function (data) {
                if (data.code == 200) {
                    // 增加了再刷新页面
                    loadPhone();
                    $("#phoneNumber").val('');
                    $("#phoneAddress").val('');
                    $("#aid").val('');
                } else {
                    alert("请增加已录入系统的号码和账号！")
                }
            }
        })
    }

    function loadPhone() {
        $.get('/Telecom_customer_billing_system/phone/get', function (data) {
            $("#phone").html(data);
        });
    }
    // 查询所有
    loadPhone();
</script>
</body>
</html>
