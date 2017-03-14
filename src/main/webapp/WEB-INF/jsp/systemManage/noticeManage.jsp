<%--
  Created by IntelliJ IDEA.
  User: 万洪基
  Date: 2017/3/12
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>noticeManage</title>
    <link rel="stylesheet" href="/ui/kindeditor-4.1.7/themes/default/default.css" />
    <script charset="utf-8" src="/ui/kindeditor-4.1.7/kindeditor.js"></script>
    <script charset="utf-8" src="/ui/kindeditor-4.1.7/lang/zh_CN.js"></script>
    <link rel="stylesheet" type="text/css" href="/ui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="/ui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/ui/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="/ui/sdutoa.css">
    <script type="text/javascript" src="/ui/jquery.min.js"></script>
    <script type="text/javascript" src="/ui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/ui/sdutoa.js"></script>
    <script type="text/javascript">
        $(function () {
            KindEditor.ready(function(K) {
                var editor = K.create('#content', {
                    cssPath : '/ui/kindeditor-4.1.7/plugins/code/prettify.css',
                    allowFileManager : true,
                    resizeType:0,
                    langType : 'zh_CN',
                    allowImageUpload:false,
                    items:[
                        'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
                        'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
                        'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
                        'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
                        'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
                        'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|',
                        'table', 'hr', 'emoticons', 'pagebreak',
                        'anchor', 'link', 'unlink', '|', 'about'
                    ],
                    afterBlur:function(){this.sync();}
                });
            });
        });
    </script>
</head>
<body>
<div align="center">
    <table id="dg" title="通知管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/system/notice/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="title" width="50">标题</th>
            <th field="begindate" width="50">发布时间</th>
            <th field="user" width="50">发布人</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newNotice()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyNotice()">删除</a>
</div>
<div id="noticeDialog" class="easyui-dialog" style="width:770px;height:650px;padding:10px 20px"
     closed="true" buttons="#noticeForm-buttons">
    <div class="ftitle">通知管理表</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>标题&nbsp;&nbsp;&nbsp;</label>
            <input name="title" class="easyui-validatebox">
        </div>
        <div class="fitem">
            <label>内容&nbsp;&nbsp;&nbsp;</label>
            <textarea id="content" name="content" style="height: 550px;width: 500px;"></textarea>
        </div>
    </form>
</div>
<div id="noticeForm-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveNotice()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#noticeDialog').dialog('close')">取消</a>
</div>
<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
