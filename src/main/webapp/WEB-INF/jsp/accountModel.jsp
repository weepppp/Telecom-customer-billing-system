<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>账号ID</td>
        <td>客户ID</td>
        <td>银行账号</td>
        <td>开户行</td>
        <td>支行</td>
        <td>预存余额</td>
        <td>消费总额</td>
        <td>当月消费额</td>
        <td>操作1</td>
        <td>操作2</td>
    </tr>
    <c:forEach items="${account}" var="account">
        <tr>
            <td >${account.aid}</td>
            <td>${account.uid}</td>
            <td>${account.bankAccount}</td>
            <td>${account.openBank}</td>
            <td>${account.subBank}</td>
            <td>${account.readyAmount}</td>
            <td>${account.costAmount}</td>
            <td>${account.curMonthAmount}</td>
            <td><button onclick="deleteByAid('${account.aid}')">删除</button></td>
            <td>客户ID<input type="text" id="uid1"> 银行账号:<input type="text" id="bankAccount1">开户行:<input type="text" id="openBank1">支行:<input type="text" id="subBank1">预存余额:<input type="text" id="readyAmount1">消费总额:<input type="text" id="costAmount1">当月消费额:<input type="text" id="curMonthAmount1"><button onclick="updateAccount('${account.aid}')">修改</button></td>
        </tr>
    </c:forEach>
</table>
<script>
    function updateAccount(aid) {
        let uid = $("#uid1").val();
        let bankAccount = $("#bankAccount1").val();
        let openBank = $("#openBank1").val();
        let subBank = $("#subBank1").val();
        let readyAmount = $("#readyAmount1").val();
        let costAmount = $("#costAmount1").val();
        let curMonthAmount = $("#curMonthAmount1").val();
        let data = {uid:uid,bankAccount:bankAccount,openBank:openBank,subBank:subBank,readyAmount:readyAmount,costAmount:costAmount,curMonthAmount:curMonthAmount,aid:aid};
        $.ajax({
            url:'/Telecom_customer_billing_system/account/update',
            type:'put',
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify(data),
            success:function (data) {
                if (data.code == 200) {
                    loadAccount();
                    $("#uid").val('');
                    $("#bankAccount").val('');
                    $("#openBank").val('');
                    $("#subBank").val('');
                    $("#readyAmount").val('');
                    $("#costAmount").val('');
                    $("#curMonthAmount").val('');
                } else {
                    alert("无法修改")
                }
            }
        })
    }

    function deleteByAid(aid) {
        $.ajax({
            url: '/Telecom_customer_billing_system/account/delete/'+aid,
            type:'delete',
            success:function (data) {
                if (data.code == 200) {
                    loadAccount();
                } else {
                    alert("该用户无法删除！")
                }
            }
        })
    }
</script>
</body>
</html>
