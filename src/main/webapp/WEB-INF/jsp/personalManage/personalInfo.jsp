<%--
  Created by IntelliJ IDEA.
  User: 万洪基
  Date: 2017/2/26
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>personalInfo</title>
    <script type="text/javascript" src="/ui/jquery.min.js"></script>
    <script type="text/javascript" src="/ui/sdutoa.js"></script>
</head>
<body>
工号：<input id="empNum" type="text" value="123456" readonly="readonly"/>
用户名：<input id="userName" type="text" value="" readonly="readonly"/>
系别：<input id="dep" type="text" value="" readonly="readonly"/>
邮箱：<input id="email" type="text"/>
手机号：<input id="phoneNum" type="text"/>
<input type="button" onclick="perInf1()" value="提交"/>

<input id="uid" type="hidden" value="133"/>
</body>
</html>
