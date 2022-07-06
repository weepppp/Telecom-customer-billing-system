<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
欢迎进入电信计费系统，请点击下列选项进入操作界面：
<div class="btn-group">
    <button type="button" class="btn btn-default" onclick="click1()">电信工作人员</button>
    <button type="button" class="btn btn-default" onclick="click2()">用户角色</button>
</div>
<script>
    function click1() {
        window.location.href = "staff.jsp";
    }

    function click2() {
        window.location.href = "";
    }
</script>
</body>
</html>
