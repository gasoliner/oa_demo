<%--
  Created by IntelliJ IDEA.
  User: 万洪基
  Date: 2017/3/6
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>topicPaperManage</title>
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
    <table id="dg" title="教研课题管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/office/topicPaper/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="name" width="50">项目名称</th>
            <th field="type" width="50">类别</th>
            <th field="principal" width="50">负责人</th>
            <th field="member" width="50">课题组成员</th>
            <th field="starttime" width="50">立项时间</th>
            <th field="endtime" width="50">结题时间</th>
            <th field="evaluate" width="50">结题评价</th>
            <th field="gradation" width="50">项目层次</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newTopaper()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editTopaper()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyTopaper()">删除</a>
</div>
<div id="topaperDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#topaperForm-buttons">
    <div class="ftitle">教研课题管理表</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>项目名称&nbsp;&nbsp;&nbsp;</label>
            <input name="name" class="easyui-validatebox" >
        </div><br/>
        <div class="fitem">
            <label>类别&nbsp;&nbsp;&nbsp;</label>
            <input name="type" class="easyui-validatebox" >
        </div><br/>
        <div class="fitem">
            <label>负责人&nbsp;&nbsp;&nbsp;</label>
            <input name="principal" class="easyui-validatebox" >
        </div><br/>
        <div class="fitem">
            <label>课题组成员</label>
            <input name="member" class="easyui-validatebox" >
        </div><br/>
        <div class="fitem">
            <label>立项时间</label>
            <input name="starttime" type="text" class="easyui-datebox" >
        </div><br/>
        <div class="fitem">
            <label>结题时间&nbsp;&nbsp;&nbsp;</label>
            <input name="endtime" type="text" class="easyui-datebox" >
        </div><br/>
        <div class="fitem">
            <label>结题评价&nbsp;&nbsp;&nbsp;</label>
            <input name="evaluate" class="easyui-validatebox">
        </div><br/>
        <div class="fitem">
            <label>项目层次&nbsp;&nbsp;&nbsp;</label>
            <input name="gradation" class="easyui-validatebox">
        </div>
        <div class="fitem">
            <label>学年&nbsp;&nbsp;&nbsp;</label>
            <input name="schoolyear" class="easyui-combobox"
                   data-options="
                           valueField:'syid',
                           textField:'schoolyear',
                           width:300,
                           url:'${pageContext.request.contextPath}/public/syddl'" />
        </div>
    </form>
</div>
<div id="topaperForm-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveTopaper()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#topaperDialog').dialog('close')">取消</a>
</div>
<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
