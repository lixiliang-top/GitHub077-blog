<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/9/22
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/addUser" enctype="multipart/form-data" method="post">
    <p>用户名：<input type="text" name="nickname" ></p>
    <p>密码：<input type="password" name="password" ></p>
    <p>昵称：<input type="text" name="username" ></p>
    <p>年龄：<input type="text" name="age" ></p>
    <p>性别：
        <select name="sex">
            <option>--请选择--</option>
            <option value="0">男</option>
            <option value="1">女</option>
        </select>
    </p>
    <p>手机：<input type="text" name="mobile" ></p>
    <p>地址：<input type="text" name="address" >
            <input type="hidden" name="supper" value="1"></p>
    <p>头像：<input type="file" name="pic" ></p>
    <p><input type="submit" value="提交"></p>
</form>
</body>
</html>
