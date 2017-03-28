<%--
  Created by IntelliJ IDEA.
  User: 万洪基
  Date: 2017/3/27
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>processManage</title>
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
    <table id="dg" title="流程部署列表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/system/process/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="name" width="50">流程名称</th>
            <th field="key" width="50">Key</th>
            <th field="version" width="50">版本</th>
            <th field="deploymentId" width="50">部署ID</th>
            <th field="resourceName" width="50">流程部署规则文件</th>
            <th field="diagramResourceName" width="50">流程规则图片</th>
            <th field="action" width="50">操作</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newProcess()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyProcess()">删除</a>
</div>
<div id="processDialog" class="easyui-dialog" style="width:500px;height:300px;padding:10px 20px"
     closed="true" buttons="#processForm-buttons">
    <div class="ftitle">流程部署管理</div>
    <form id="fm" method="post" enctype="multipart/form-data">
        <div class="fitem">
            <label>流程规则部署文件（.zip）&nbsp;&nbsp;&nbsp;</label>
            <input name="file" type="file">
        </div>
    </form>
</div>
<div id="processForm-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveProcess()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#processDialog').dialog('close')">取消</a>
</div>
<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
<div id="imgDialog">
    <img id="imgPro">
</div>
</body>
</html>
