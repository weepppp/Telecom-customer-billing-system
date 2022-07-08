<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form class="form-inline">
    <div class="form-group">
        <label class="sr-only">主叫号</label>
        <input class="form-control" type="text" id="callNamber" placeholder="请输入主叫号">
    </div>
    <div class="form-group">
        <label class="sr-only">被叫号</label>
        <input type="text" class="form-control" id="calledNamber" placeholder="请输入被叫号">
    </div>
    <div class="form-group">
        <label class="sr-only">通话时长</label>
        <input type="text" class="form-control" id="callTime" placeholder="请输入通话时长">
    </div>
    <div class="form-group">
        <button class="btn btn-default" onclick="addBIll()">提交</button>
    </div>
</form>
<div>
    <a href="index">上一页</a>
</div>
<script>
    function addBIll() {
        let callNamber = $("#callNamber").val();
        let calledNamber = $("#calledNamber").val();
        let callTime = $("#callTime").val();
        let data = {callNamber:callNamber,calledNamber:calledNamber,callTime:callTime};
        $.ajax({
            url:'/Telecom_customer_billing_system/bill/insert',
            type:'post',
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify(data),
            success:function (data) {
                if (data.code == 200) {
                    alert("添加成功！");
                    $("#callNamber").val('');
                    $("#calledNamber").val('');
                    $("#callTime").val('');
                } else {
                    alert("添加失败!");
                }
            }
        })
    }
</script>
</body>
</html>
