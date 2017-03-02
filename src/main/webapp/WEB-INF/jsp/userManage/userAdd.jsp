<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wanzhenghang
  Date: 2017/2/15
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户添加</title>
    <link rel="stylesheet" type="text/css" href="/ui/themes/ui-pepper-grinder/easyui.css">
    <link rel="stylesheet" type="text/css" href="/ui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/ui/demo/demo.css">
    <script type="text/javascript" src="/ui/jquery.min.js"></script>
    <script type="text/javascript" src="/ui/jquery.easyui.min.js"></script>
    <script type="application/javascript" src="/ui/sdutoa.js"></script>
</head>
<body>
<div style="width: 900px;height: auto;margin: 0 auto">
        <div class="messager-body" style="width: auto;height: auto;margin: 0 auto">
            <div class="messager-input" style="height: 56px; margin: 10px;">
                <p align="center" style="font-size: 16px;">
                   <label for="employeenum" >工&nbsp;&nbsp;号: </label>
                    <input id="employeenum" class="easyui-textbox" style="width: 300px;height: 32px"/>
                </p>
            </div>
            <div class="messager-input" style="height: 56px; margin: 10px;">
                <p align="center" style="font-size: 16px;">
                    <label for="username" >用户名: </label>
                    <input id="username" class="easyui-textbox" style="width: 300px;height: 32px"/>
                </p>
            </div>
            <div class="messager-input" style="height: 56px; margin: 10px;">
                <p align="center" style="font-size: 16px;">
                    <label for="roleSelect" >角&nbsp;&nbsp;色: </label>
                    <input id="roleSelect" class="easyui-combobox"
                           name="role"
                           data-options="
                           valueField:'rid',
                           textField:'role',
                           width:300,
                           url:'${pageContext.request.contextPath}/public/rddl'" />
                </p>
            </div>
            <div class="messager-input" style="height: 56px; margin: 10px;">
                <p align="center" style="font-size: 16px;">
                    <label for="depSelect" >系&nbsp;&nbsp;别: </label>
                    <input id="depSelect" class="easyui-combobox"
                           name="dep"
                           data-options="
                           valueField:'deptid',
                           textField:'dep',
                           width:300,
                           url:'${pageContext.request.contextPath}/public/dddl'" />
                </p>
            </div>
            <div class="messager-input" style="height: 56px; margin: 10px;">
                <p align="center" style="font-size: 16px;">
                    <label for="email" >邮&nbsp;&nbsp;箱: </label>
                    <input id="email" class="easyui-textbox" style="width: 300px;height: 32px"/>
                </p>
            </div>
            <div class="messager-input" style="height: 56px; margin: 10px;">
                <p align="center" style="font-size: 16px;">
                    <label for="phone" >手机号: </label>
                    <input id="phone" class="easyui-textbox" style="width: 300px;height: 32px"/>
                </p>
            </div>
            <div class="messager-button" style="height: 56px; margin: 10px;">
                <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="subNewUser()">
                    <span style="font-size: 16px">保存</span>
                </a>
            </div>
        </div>
</div>



</body>
</html>
