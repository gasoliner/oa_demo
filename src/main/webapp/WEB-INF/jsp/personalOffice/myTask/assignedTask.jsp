<%--
  Created by IntelliJ IDEA.
  User: wanzhenghang
  Date: 2017/4/3
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>assignedTask</title>
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
    </table>
    <table id="dg" title="已办任务列表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/office/myTask/hisTaskList',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="id" width="50">ID</th>
            <th field="currentActiviti" width="50">当前节点</th>
            <th field="processName" width="50">流程名称</th>
            <th field="assignee" width="50">处理人</th>
            <th field="startTime" width="50">开始时间</th>
            <th field="endTime" width="50">开始时间</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>
