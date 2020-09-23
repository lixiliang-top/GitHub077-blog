<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/9/22
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/addBlog" method="post">
    <p>微博信息：<textarea  name ="content" cols ="50" rows ="10"> </textarea></p>
    <p>发布时间：<input type="text" name="publishtime">
    <input type="hidden" name="userid" value="${sessionScope.id}"></p>
    <p><input type="submit" value="添加微博信息"></p>
</form>
</body>
</html>
