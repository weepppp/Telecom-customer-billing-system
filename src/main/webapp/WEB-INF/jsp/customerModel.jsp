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
            <td>姓名:<input type="text" id="uname1"> 类型:<input type="text" id="utype1"><button onclick="updateCustomer(${customer.uid})">修改</button></td>
        </tr>
    </c:forEach>
</table>
<script>
    // 修改某条记录
    function updateCustomer(uid) {
        let uname= $("#uname1").val();
        let utype = $("#utype1").val();
        let data = {uname:uname,utype:utype,uid:uid}
        $.ajax({
            url:'/Telecom_customer_billing_system/customer/update',
            type:'put',
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify(data),
            success:function (data) {
                if (data.code == 200) {
                    // 增加了再刷新页面
                    loadCustomer();
                    $("#uname1").val('');
                    $("#utype1").val('');
                } else {
                    alert("无法更新为已有用户")
                }
            }
        })
    }
    // 删除
    function deleteByUid(uid) {
        $.ajax({
            url: '/Telecom_customer_billing_system/customer/delete/' + uid,
            type:'delete',
            success:function (data) {
                if (data.code == 200) {
                    //说明删除成功
                    loadCustomer();
                } else {
                    alert("该用户无法删除！")
                }
            }
        })
    }
</script>
</body>
</html>