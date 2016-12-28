<%--
  Created by IntelliJ IDEA.
  User: 万洪基
  Date: 2016/12/26
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>

    <link rel="stylesheet" type="text/css" href="ui/themes/ui-pepper-grinder/easyui.css">
    <link rel="stylesheet" type="text/css" href="ui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="ui/demo/demo.css">
    <script type="text/javascript" src="ui/jquery.min.js"></script>
    <script type="text/javascript" src="ui/jquery.easyui.min.js"></script>
</head>
<body>
<div class="easyui-layout" style="width: 100%;height: 700px;">
    <div region="north" split="true" style="width: 100%;height: 70px;border: 0px">
        <jsp:include page="north.jsp"/>
    </div>
    <div region="center" style="padding: 5px;border-left: 0px;border-right: 0px;border-top: 0px;">

        <div style="width: 25%;margin: 20px auto">
            <div>账号：</div>
            <input class="easyui-textbox" style="width: 100%;height: 32px"/>
        </div>
        <div style="width: 25%;margin: 20px auto">
            <div>密码：</div>
            <input class="easyui-textbox" style="width: 100%;height: 32px" type="password"/>
        </div>
        <div style="margin: 20px"></div>
        <div style="width: 25%;margin: 20px auto;">
            <a href="index.jsp" class="easyui-linkbutton" iconCls="icon-ok" style="width: 100%;height: 32px;">登录</a>
        </div>

    </div>
    <div region="south" split="true" style="width: 100%;height: 60px;border: 0px;">
        <jsp:include page="south.jsp"/>
    </div>
</div>
</body>
</html>
