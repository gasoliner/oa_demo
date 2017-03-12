<%--
  Created by IntelliJ IDEA.
  User: 万洪基
  Date: 2016/12/27
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>awardDetailManage</title>
    <link rel="stylesheet" type="text/css" href="/ui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="/ui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/ui/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="/ui/sdutoa.css">
    <script type="text/javascript" src="/ui/jquery.min.js"></script>
    <script type="text/javascript" src="/ui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/ui/sdutoa.js"></script>
</head>
<body>
<div align="center">
    <table title="获奖情况表" class="easyui-datagrid" style="width: 100%;height:auto"
           url="/data/datagrid_data.json"
           toolbar="#toolbar"
           rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
        <tr>
            <th field="workname" width="50">成果名称</th>
            <th field="studentname" width="50">参赛学生</th>
            <th field="major" width="50">专业</th>
            <th field="class" width="50">班级</th>
            <th field="teacher" width="50">指导老师</th>
            <th field="time" width="50">获奖时间</th>
            <th field="place" width="50">颁奖单位</th>
            <th field="comments" width="50">备注</th>
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
