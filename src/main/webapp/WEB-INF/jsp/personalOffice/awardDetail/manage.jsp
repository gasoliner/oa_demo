<%--
  Created by IntelliJ IDEA.
  User: 万洪基
  Date: 2016/12/27
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <table id="dg" title="获奖情况表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
           url:'/office/award/list',
           method:'get',
           pageSize:15,
           pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="voCompetition" width="50">竞赛项目</th>
            <th field="achievement" width="50">成果展示</th>
            <th field="voLevel" width="50">获奖级别</th>
            <th field="voGrade" width="50">获奖等级</th>
            <th field="stuname" width="50">参赛学生</th>
            <th field="specialty" width="50">专业</th>
            <th field="classes" width="50">班级</th>
            <th field="teacher" width="50">指导老师</th>
            <th field="atime" width="50">获奖时间</th>
            <th field="prizeunit" width="50">颁奖单位</th>
            <th field="comment" width="50">备注</th>
            <th field="voState" width="50">状态</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newAward()">申请</a>
</div>
<div id="awardDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#awardForm-buttons">
    <div class="ftitle">获奖情况表</div>
    <form id="fm" method="post" enctype="multipart/form-data">
        <div class="fitem">
            <label>竞赛项目&nbsp;&nbsp;&nbsp;</label>
            <select class="easyui-combobox" name="competitionid" style="width:200px;">
                <option value="">请选择</option>
                <c:forEach items="${competitions}" var="competition">
                    <option value="${competition.competitionid}">${competition.competition}</option>
                </c:forEach>
            </select>
        </div><br/>
        <div class="fitem">
            <label>获奖级别&nbsp;&nbsp;&nbsp;</label>
            <select class="easyui-combobox" name="level" style="width:200px;">
                <option value="">请选择</option>
                <c:forEach items="${awardLevels}" var="awardLevel">
                    <option value="${awardLevel.awardlevelid}">${awardLevel.awardlevel}</option>
                </c:forEach>
            </select>
        </div><br/>
        <div class="fitem">
            <label>获奖等级&nbsp;&nbsp;&nbsp;</label>
            <select class="easyui-combobox" name="grade" style="width:200px;">
                <option value="">请选择</option>
                <c:forEach items="${grades}" var="grade">
                    <option value="${grade.gradeid}">${grade.grade}</option>
                </c:forEach>
            </select>
        </div><br/>
        <div class="fitem">
            <label>成果名称</label>
            <input name="achievement" type="text" class="easyui-validatebox" >
        </div><br/>
        <div class="fitem">
            <label>参赛学生</label>
            <input name="stuname" type="text" class="easyui-validatebox" >
        </div><br/>
        <div class="fitem">
            <label>专业&nbsp;&nbsp;&nbsp;</label>
            <input name="specialty" type="text" class="easyui-validatebox" >
        </div><br/>
        <div class="fitem">
            <label>班级&nbsp;&nbsp;&nbsp;</label>
            <input name="classes" type="text" class="easyui-validatebox">
        </div><br/>
        <div class="fitem">
            <label>指导老师&nbsp;&nbsp;&nbsp;</label>
            <input name="teacher" type="text" class="easyui-validatebox">
        </div><br/>
        <div class="fitem">
            <label>获奖时间&nbsp;&nbsp;&nbsp;</label>
            <input name="atime" type="text" class="easyui-datebox" >
        </div><br/>
        <div class="fitem">
            <label>颁奖单位&nbsp;&nbsp;&nbsp;</label>
            <input name="prizeunit" class="easyui-validatebox" >
        </div><br/>
        <div class="fitem">
            <label>学年&nbsp;&nbsp;&nbsp;</label>
            <select class="easyui-combobox" name="schoolyear" style="width:200px;">
                <option value="">请选择</option>
                <c:forEach items="${schoolyears}" var="schoolyear">
                    <option value="${schoolyear.syid}">${schoolyear.schoolyear}</option>
                </c:forEach>
            </select>
        </div><br/>
        <div class="fitem">
            <label>备注&nbsp;&nbsp;&nbsp;</label>
            <textarea name="comment" class="textareaComment"></textarea>
        </div><br/>
        <div class="fitem">
            <label>附件&nbsp;&nbsp;&nbsp;</label>
            <input name="file" type="file">
        </div>
    </form>
</div>
<div id="awardForm-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveAward()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#awardDialog').dialog('close')">取消</a>
</div>
<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
<%--<div id="imgDialog">--%>
    <%--<img id="imgAward">--%>
<%--</div>--%>

</body>
</html>
