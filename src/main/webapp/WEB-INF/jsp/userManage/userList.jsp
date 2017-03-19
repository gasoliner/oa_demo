<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wanzhenghang
  Date: 2017/2/15
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
    <link rel="stylesheet" type="text/css" href="/ui/themes/ui-pepper-grinder/easyui.css">
    <link rel="stylesheet" type="text/css" href="/ui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/ui/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="/ui/sdutoa.css">
    <script type="text/javascript" src="/ui/jquery.min.js"></script>
    <script type="text/javascript" src="/ui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/ui/sdutoa.js"></script>
    <%--<script type="text/javascript">--%>
        <%--$(function () {--%>
            <%--if ($("#role").combobox()!=null){--%>
                <%--$("#role").combobox({--%>
                    <%--valueField: 'rid',--%>
                    <%--textField: 'role',--%>
                    <%--data: [{--%>
                        <%--rid: 'java',--%>
                        <%--role: 'Java'--%>
                    <%--},{--%>
                        <%--rid: 'perl',--%>
                        <%--role: 'Perl'--%>
                    <%--},{--%>
                        <%--rid: 'ruby',--%>
                        <%--role: 'Ruby'--%>
                    <%--}]--%>
                <%--})--%>
            <%--}--%>
        <%--})--%>
    <%--</script>--%>
</head>
<body>

<div align="center">
    <table id="dg" title="获奖情况表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
            fitColumns="true" singleSelect="true" pagination="true"
            data-options="rownumbers:true,
            url:'/user/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="employeenum" width="50">工号</th>
            <th field="username" width="50">用户名</th>
            <th field="role" width="50">角色</th>
            <th field="dep" width="50">系别</th>
            <th field="email" width="50">邮箱</th>
            <th field="phone" width="50">手机号</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
</div>
<div id="userDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#userForm-buttons">
    <div class="ftitle">用户信息</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>工号&nbsp;&nbsp;&nbsp;</label>
            <input name="employeenum" class="easyui-validatebox">
        </div><br/>
        <div class="fitem">
            <label>用户名&nbsp;&nbsp;&nbsp;</label>
            <input name="username" class="easyui-validatebox">
        </div><br/>
        <div class="fitem">
            <label>角色&nbsp;&nbsp;&nbsp;</label>
            <select class="easyui-combobox" name="roleidsstr" style="width: 200px;">
                <c:forEach items="${roles}" var="role">
                    <option value="${role.rid}">${role.role}</option>
                </c:forEach>
            </select>
        </div><br/>
        <div class="fitem">
            <label>系别&nbsp;&nbsp;&nbsp;</label>
            <select class="easyui-combobox" name="deptid" style="width: 200px;">
                <c:forEach items="${depts}" var="dept">
                    <option value="${dept.deptid}">${dept.dep}</option>
                </c:forEach>
            </select>
        </div><br/>
        <div class="fitem">
            <label>邮箱&nbsp;&nbsp;&nbsp;</label>
            <input name="email" class="easyui-validatebox">
        </div><br/>
        <div class="fitem">
            <label>手机号&nbsp;&nbsp;&nbsp;</label>
            <input name="phone" class="easyui-validatebox">
        </div>
    </form>
</div>
<div id="userForm-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#userDialog').dialog('close')">取消</a>
</div>
<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
