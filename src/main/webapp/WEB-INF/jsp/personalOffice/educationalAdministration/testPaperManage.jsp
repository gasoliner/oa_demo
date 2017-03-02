<%--
  Created by IntelliJ IDEA.
  User: 万洪基
  Date: 2017/2/26
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>testPaperManage</title>
    <link rel="stylesheet" type="text/css" href="/ui/themes/ui-pepper-grinder/easyui.css">
    <link rel="stylesheet" type="text/css" href="/ui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/ui/demo/demo.css">
    <script type="text/javascript" src="/ui/jquery.min.js"></script>
    <script type="text/javascript" src="/ui/jquery.easyui.min.js"></script>
</head>
<body>
<div align="center">
    <table title="试卷归档管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/office/testPaperList',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="qid" width="50">序号</th>
            <th field="teacher" width="50">授课教师</th>
            <th field="classname" width="50">授课班级</th>
            <th field="course" width="50">课程名称</th>
            <th field="spsource" width="50">试题来源</th>
            <th field="sexamineway" width="50">考核方式</th>
            <th field="num" width="50">人数</th>
            <th field="pnum" width="50">试卷份数</th>
            <th field="sanalyzes" width="50">试卷考核</th>
            <th field="splan" width="50">考核大纲</th>
            <th field="sinvigilation" width="50">监考记录</th>
            <th field="sab" width="50">AB卷</th>
            <th field="sanswer" width="50">标准答案</th>
            <th field="sstandard" width="50">评分标准</th>
            <th field="sscore" width="50">成绩单</th>
            <th field="comment" width="50">备注</th>
            <th field="schoolyear" width="50">归档号</th>
            <th field="ischange" width="50">状态</th>
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
