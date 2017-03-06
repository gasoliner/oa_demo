<%--
  Created by IntelliJ IDEA.
  User: 万洪基
  Date: 2017/3/5
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>trainingPaperManage</title>
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
    <table id="dg" title="实训归档管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/office/trainingPaper/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="teacher" width="50">姓名</th>
            <th field="course" width="50">课程</th>
            <th field="classname" width="50">班级</th>
            <th field="spsource" width="50">试题来源</th>
            <th field="sexamineway" width="50">考核方式</th>
            <th field="num" width="50">选课人数</th>
            <th field="tnum" width="50">试卷份数</th>
            <th field="nature" width="50">课程性质</th>
            <th field="sanalyzes" width="50">试卷分析</th>
            <th field="splan" width="50">考核大纲</th>
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
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newTpaper()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editTpaper()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyTpaper()">删除</a>
</div>
<div id="tpaperDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#tpaperForm-buttons">
    <div class="ftitle">实训归档信息</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>姓名&nbsp;&nbsp;&nbsp;</label>
            <input name="teacher" class="easyui-validatebox" required="true">
        </div><br/>
        <div class="fitem">
            <label>授课班级&nbsp;&nbsp;&nbsp;</label>
            <input name="classname" class="easyui-validatebox" required="true">
        </div><br/>
        <div class="fitem">
            <label>课程名称&nbsp;&nbsp;&nbsp;</label>
            <input name="course">
        </div><br/>
        <div class="fitem">
            <label>试题来源</label><div>&nbsp;</div>
            <span class="radioSpan">
                <input name="psource" value="1" type="radio">自拟
                <input name="psource" value="2" type="radio">统一命题
            </span>
        </div><br/>
        <div class="fitem">
            <label>考核方式</label><div>&nbsp;</div>
            <span class="radioSpan">
                <input name="examineway" value="1" type="radio">答辩
            </span>
        </div><br/>
        <div class="fitem">
            <label>选课人数&nbsp;&nbsp;&nbsp;</label>
            <input name="num" class="easyui-validatebox">
        </div><br/>
        <div class="fitem">
            <label>试卷份数&nbsp;&nbsp;&nbsp;</label>
            <input name="tnum" class="easyui-validatebox">
        </div><br/>
        <div class="fitem">
            <label>课程性质&nbsp;&nbsp;&nbsp;</label>
            <input name="nature" value="实践" class="easyui-validatebox">
        </div><br/>
        <div class="fitem">
            <label>试卷分析</label><div>&nbsp;</div>
            <span class="radioSpan">
                <input name="analyzes" value="1" type="radio">有
                <input name="analyzes" value="0" type="radio">无
            </span>
        </div><br/>
        <div class="fitem">
            <label>考试大纲</label><div>&nbsp;</div>
            <span class="radioSpan">
                <input name="plan" value="1" type="radio">有
                <input name="plan" value="0" type="radio">无
            </span>
        </div><br/>
        <div class="fitem">
            <label>评分标准</label><div>&nbsp;</div>
            <span class="radioSpan">
                <input name="standard" value="1" type="radio">有
                <input name="standard" value="0" type="radio">无
            </span>
        </div><br/>
        <div class="fitem">
            <label>成绩单</label><div>&nbsp;</div>
            <span class="radioSpan">
                <input name="score" value="1" type="radio">有
                <input name="score" value="0" type="radio">无
            </span>
        </div><br/>
        <div class="fitem">
            <label>学年</label>
            <input name="schoolyear" class="easyui-validatebox">
        </div><br/>
        <div class="fitem">
            <label>备注</label><div>&nbsp;</div>
            <textarea name="comment" class="textareaComment"></textarea>
        </div>
    </form>
</div>
<div id="tpaperForm-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveTpaper()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#tpaperDialog').dialog('close')">取消</a>
</div>
<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
