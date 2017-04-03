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
    <title>todoTask</title>
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
    <table id="dg" title="我的任务管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/office/myTask/todoTaskList',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="title" width="50">论文题目</th>
            <th field="author" width="50">第一作者</th>
            <th field="particpants" width="50">参与者</th>
            <th field="level" width="50">刊物级别</th>
            <th field="publisheddate" width="50">发表时间</th>
            <th field="type" width="50">检索类型</th>
            <th field="volumeperiod" width="50">卷期</th>
            <th field="voAnnex" width="50">附件</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newTepaper()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editTepaper()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyTepaper()">删除</a>
</div>
<div id="tepaperDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#tepaperForm-buttons">
    <div class="ftitle">教研论文管理表</div>
    <form id="fm" method="post" enctype="multipart/form-data">
        <div class="fitem">
            <label>论文题目&nbsp;&nbsp;&nbsp;</label>
            <input name="title" class="easyui-validatebox" >
        </div><br/>
        <div class="fitem">
            <label>第一作者&nbsp;&nbsp;&nbsp;</label>
            <input name="author" class="easyui-validatebox" >
        </div><br/>
        <div class="fitem">
            <label>参与者&nbsp;&nbsp;&nbsp;</label>
            <input name="particpants" class="easyui-validatebox" >
        </div><br/>
        <div class="fitem">
            <label>刊物级别</label>
            <input name="level" class="easyui-combobox"
                   data-options="
                           valueField:'blid',
                           textField:'booklevel',
                           width:300,
                           url:'${pageContext.request.contextPath}/public/blddl'" />
        </div><br/>
        <div class="fitem">
            <label>发表时间</label>
            <input name="publisheddate" type="text" class="easyui-datebox" >
        </div><br/>
        <div class="fitem">
            <label>检索类型&nbsp;&nbsp;&nbsp;</label>
            <input name="type" class="easyui-combobox"
                   data-options="
                           valueField:'stid',
                           textField:'searchtype',
                           width:300,
                           url:'${pageContext.request.contextPath}/public/stddl'" />
        </div><br/>
        <div class="fitem">
            <label>卷期&nbsp;&nbsp;&nbsp;</label>
            <input name="volumeperiod" class="easyui-validatebox">
        </div><br/>
        <div class="fitem">
            <label>学年&nbsp;&nbsp;&nbsp;</label>
            <input name="schoolyear" class="easyui-combobox"
                   data-options="
                           valueField:'syid',
                           textField:'schoolyear',
                           width:300,
                           url:'${pageContext.request.contextPath}/public/syddl'" />
        </div>
        <div class="fitem">
            <label>附件&nbsp;&nbsp;&nbsp;</label>
            <input name="file" type="file">
        </div>
    </form>
</div>
<div id="tepaperForm-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveTepaper()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#tepaperDialog').dialog('close')">取消</a>
</div>
<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
<div id="imgDialog">
    <img id="imgTePaper">
</div>
</body>
</html>
