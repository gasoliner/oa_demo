<%--
  Created by IntelliJ IDEA.
  User: wanzhenghang
  Date: 2017/2/15
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
    <link rel="stylesheet" type="text/css" href="/ui/themes/ui-pepper-grinder/easyui.css">
    <link rel="stylesheet" type="text/css" href="/ui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/ui/demo/demo.css">
    <script type="text/javascript" src="/ui/jquery.min.js"></script>
    <script type="text/javascript" src="/ui/jquery.easyui.min.js"></script>
</head>
<body>
<div align="center">
    <table title="获奖情况表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
            fitColumns="true" singleSelect="true" pagination="true"
            data-options="rownumbers:true,
            url:'/user/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="uid" width="50">序号</th>
            <th field="employeenum" width="50">工号</th>
            <th field="username" width="50">用户名</th>
            <th field="role" width="50">角色</th>
            <th field="dep" width="50">系别</th>
            <th field="email" width="50">邮箱</th>
            <th field="phone" width="50">手机号</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New User</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove User</a>
</div>
</body>
</html>
