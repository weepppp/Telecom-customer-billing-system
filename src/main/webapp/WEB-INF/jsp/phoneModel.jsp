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
        <td>id</td>
        <td>电话号码</td>
        <td>电话地址</td>
        <td>结算账号</td>
        <td>操作1</td>
        <td>操作2</td>
    </tr>
    <c:forEach items="${phone}" var="phone">
        <tr>
            <td>${phone.pid}</td>
            <td>${phone.phoneNumber}</td>
            <td>${phone.phoneAddress}</td>
            <td>${phone.aid}</td>
            <td><button onclick="deleteByPid(${phone.pid})">删除</button></td>
            <td>电话号码:<input type="text" id="phoneNumber1"> 电话地址:<input type="text" id="phoneAddress1">结算账号:<input type="text" id="aid1"><button onclick="updatePhone(${phone.pid})">修改</button></td>
        </tr>
    </c:forEach>
</table>
<script>
    // 修改某条记录
    function updatePhone(pid) {
        let phoneNumber= $("#phoneNumber1").val();
        let phoneAddress = $("#phoneAddress1").val();
        let aid = $("#aid1").val();
        let data = {phoneNumber:phoneNumber,phoneAddress:phoneAddress,aid:aid,pid:pid}
        $.ajax({
            url:'/Telecom_customer_billing_system/phone/update',
            type:'put',
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify(data),
            success:function (data) {
                if (data.code == 200) {
                    // 增加了再刷新页面
                    loadPhone();
                    $("#phoneNumber1").val('');
                    $("#phoneAddress1").val('');
                    $("#aid1").val('');
                } else {
                    alert("请输入已录入系统的号码和账号！")
                }
            }
        })
    }
    // 删除
    function deleteByPid(pid) {
        $.ajax({
            url: '/Telecom_customer_billing_system/phone/delete/' + pid,
            type:'delete',
            success:function (data) {
                if (data.code == 200) {
                    //说明删除成功
                    loadPhone();
                } else {
                    alert("该用户无法删除！")
                }
            }
        })
    }
</script>
</body>
</html>
