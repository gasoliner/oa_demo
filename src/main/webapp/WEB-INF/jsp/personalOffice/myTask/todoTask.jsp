<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
    <table id="dg" title="待办任务管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/office/myTask/todoTaskList',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="id" width="50">ID</th>
            <th field="processName" width="50">流程名称</th>
            <th field="currentActiviti" width="50">节点</th>
            <th field="owner" width="50">受理人</th>
            <th field="applyTime" width="50">申请时间</th>
            <th field="voAction" width="50">操作</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="doTask()">办理</a>
</div>
<div id="taskDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#taskForm-buttons">
    <div class="ftitle">待办任务管理表</div>
    <%--有activitis:* 权限的用户，先用hasRole代替--%>
    <shiro:hasRole name="1">
        <form id="fm1" class="oa_form">
            <div class="fitem">
                <label>竞赛项目&nbsp;&nbsp;&nbsp;</label>
                <input readonly="readonly" name="voCompetition" type="text" class="easyui-validatebox" >
            </div><br/>
            <div class="fitem">
                <label>获奖级别&nbsp;&nbsp;&nbsp;</label>
                <input readonly="readonly" name="voLevel" type="text" class="easyui-validatebox" >
            </div><br/>
            <div class="fitem">
                <label>获奖等级&nbsp;&nbsp;&nbsp;</label>
                <input readonly="readonly" name="voGrade" type="text" class="easyui-validatebox" >
            </div><br/>
            <div class="fitem">
                <label>成果名称</label>
                <input readonly="readonly" name="achievement" type="text" class="easyui-validatebox" >
            </div><br/>
            <div class="fitem">
                <label>参赛学生</label>
                <input readonly="readonly" name="stuname" type="text" class="easyui-validatebox" >
            </div><br/>
            <div class="fitem">
                <label>专业&nbsp;&nbsp;&nbsp;</label>
                <input readonly="readonly" name="specialty" type="text" class="easyui-validatebox" >
            </div><br/>
            <div class="fitem">
                <label>班级&nbsp;&nbsp;&nbsp;</label>
                <input readonly="readonly" name="classes" type="text" class="easyui-validatebox">
            </div><br/>
            <div class="fitem">
                <label>指导老师&nbsp;&nbsp;&nbsp;</label>
                <input readonly="readonly" name="teacher" type="text" class="easyui-validatebox">
            </div><br/>
            <div class="fitem">
                <label>获奖时间&nbsp;&nbsp;&nbsp;</label>
                <input readonly="readonly" name="atime" type="text" class="easyui-datebox" >
            </div><br/>
            <div class="fitem">
                <label>颁奖单位&nbsp;&nbsp;&nbsp;</label>
                <input readonly="readonly" name="prizeunit" class="easyui-validatebox" >
            </div><br/>
            <div class="fitem">
                <label>备注&nbsp;&nbsp;&nbsp;</label>
                <textarea readonly="readonly" name="comment" class="textareaComment"></textarea>
            </div>
        </form>
        <form id="fm" method="post" class="oa_form">
            <div class="fitem">
                <label>审批批注</label><div>&nbsp;</div>
                <textarea name="postil" class="textareaComment"></textarea>
            </div>
            <div class="fitem">
                <label>审批意见</label><div>&nbsp;</div>
                <input id="state" name="voAuditOpinion">
            </div>
        </form>
    </shiro:hasRole>
    <shiro:hasRole name="2">
        <form id="fm" class="oa_form" method="post" enctype="multipart/form-data">
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
        <form id="fm1" method="post" class="oa_form">
            <div class="fitem">
                <label>审批批注</label><div>&nbsp;</div>
                <textarea readonly="readonly" name="postil" class="textareaComment"></textarea>
            </div>
        </form>
    </shiro:hasRole>
</div>
<div id="taskForm-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="completeTask()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#taskDialog').dialog('close')">取消</a>
</div>
<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
