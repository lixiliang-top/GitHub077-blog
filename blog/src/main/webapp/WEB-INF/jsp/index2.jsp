<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2020/9/22
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
   <div align="center">
       <span>${userSession.username}你好！欢迎访问微博信息管理系统！</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)">注销</a>
   </div>
    <table class="table-fenye" width="800" border="1" align="center">
        <tr align="center">
            <td><h1>微博首页</h1></td>
        </tr>
        <tr>
        <tr align="center">
            <td>微博编号</td>
            <td>微博内容</td>
            <td>发布时间</td>
            <td>操作</td>
        </tr>
    </table>
    <p></p>
    <table class="table" width="800" border="1" align="center">
        <tr align="center">
            <td class="zong">1</td>
            <td class="mei">1</td>
            <td><a href="javascript:void(0)" class="shou">首页</a></td>
            <td><a href="javascript:void(0)" class="shang">上一页</a></td>
            <td class="ye">1/1</td>
            <td><a href="javascript:void(0)" class="xia">下一页</a></td>
            <td><a href="javascript:void(0)" class="wei">尾页</a></td>
        </tr>
    </table>
    <script type="text/javascript" src="/statics/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="/statics/js/list2.js"></script>


</div>
</body>
</html>
