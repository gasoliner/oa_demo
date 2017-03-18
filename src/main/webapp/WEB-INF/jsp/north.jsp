<%--
  Created by IntelliJ IDEA.
  User: 万洪基
  Date: 2016/12/26
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<div style="text-align: center;font-family: 微软雅黑;font-size: 25px;" >某信息管理系统
    <c:if test="${globleUser != null}">
        <span>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎您，${globleUser.username}&nbsp;&nbsp;
            <a class="easyui-linkbutton" iconCls="icon-ok" style="width: 100%;height: 32px;" onclick="logout()">退出</a>
        </span>
    </c:if>
</div>
</body>
</html>
