<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
</head>
<body>
<div>
    客户ID:<input type="text" id="uid">
    银行账号:<input type="text" id="bankAccount">
    开户行:<input type="text" id="openBank">
    支行:<input type="text" id="subBank">
    预存余额:<input type="text" id="readyAmount">
    消费总额:<input type="text" id="costAmount">
    当月消费额:<input type="text" id="curMonthAmount">
    <button onclick="addAccount()">添加</button>
</div>
<hr>
<div id="account">
</div>
<div>
    <a href="index">上一页</a>
</div>
<script>
    // 增加
    function addAccount() {
        let uid = $("#uid").val();
        let bankAccount = $("#bankAccount").val();
        let openBank = $("#openBank").val();
        let subBank = $("#subBank").val();
        let readyAmount = $("#readyAmount").val();
        let costAmount = $("#costAmount").val();
        let curMonthAmount = $("#curMonthAmount").val();
        let data = {uid:uid,bankAccount:bankAccount,openBank:openBank,subBank:subBank,readyAmount:readyAmount,costAmount:costAmount,curMonthAmount:curMonthAmount};
        $.ajax({
            url:'/Telecom_customer_billing_system/account/insert',
            type:'post',
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify(data),
            success:function (data) {
                if (data.code == 200) {
                    // 增加了再刷新页面
                    loadAccount();
                    $("#uname").val('');
                    $("#utype").val('');
                } else {
                    alert("添加有误，请绑定已存在客户或新建未存在账户！")
                }
            }
        })
    }

    function loadAccount() {
        $.get('/Telecom_customer_billing_system/account/get', function (data) {
            $("#account").html(data);
        });
    }
    // 查询所有
    loadAccount();
</script>
</body>
</html>
