<%--
  Created by IntelliJ IDEA.
  User: 万洪基
  Date: 2016/12/26
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<style type="text/css">
    .menu-last{
        margin-bottom: 5px;
    }
</style>
<body>
<div class="easyui-accordion" style="width:auto;height: 350px;border: 0px;">
<shiro:hasRole name="1">
    <div title="系统管理" iconCls="icon-cog" style="overflow: auto;padding: 10px;">
    <%--<div title="系统管理" iconCls="icon-cog" style="overflow: auto;padding: 10px;">--%>
        <%--<div class="easyui-accordion" style="width: auto;height: auto">--%>
            <%--<div title="流程管理" iconCls="icon-cog" style="overflow: auto;padding: 10px;">--%>
                <div class="menu-last">
                    <a href="#" class="easyui-linkbutton" onclick="addTab('流程管理','system/processManage')">流程管理</a><br/>
                </div>
                <%--<div class="menu-last">--%>
                    <%--<a href="#" class="easyui-linkbutton" onclick="addTab('流程部署','')">流程部署</a>--%>
                <%--</div>--%>
            <%--</div>--%>
                <div class="menu-last">
                    <a href="#" class="easyui-linkbutton" onclick="addTab('字典管理','system/dictionaryManage')">字典管理</a><br/>
                </div>
            <%--<div title="角色管理" iconCls="icon-cog" style="overflow: auto;padding: 10px;">--%>
                <div class="menu-last">
                    <a href="#" class="easyui-linkbutton" onclick="addTab('角色管理','system/roleManage')">角色管理</a><br/>
                </div>
                <%--<div class="menu-last">--%>
                    <%--<a href="#" class="easyui-linkbutton" onclick="addTab('角色添加','')">角色添加</a>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div title="通知管理" iconCls="icon-cog" style="overflow: auto;padding: 10px;">--%>
                <div class="menu-last">
                    <a href="#" class="easyui-linkbutton" onclick="addTab('通知管理','system/noticeManage')">通知管理</a><br/>
                </div>
                <%--<div class="menu-last">--%>
                    <%--<a href="#" class="easyui-linkbutton" onclick="addTab('添加通知','')">添加通知</a>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    </div>
</shiro:hasRole>
    <div title="个人办公" iconCls="icon-computer" style="overflow:auto;padding:10px;">
        <div class="easyui-accordion" style="width: auto;height: auto">
            <div title="我的任务" iconCls="icon-computer" style="overflow: auto;padding: 10px;">
                <div class="menu-last">
                    <a href="#" class="easyui-linkbutton" onclick="addTab('待办任务','myTask/todoTask')">待办任务</a>
                </div>
                <div class="menu-last">
                    <a href="#" class="easyui-linkbutton" onclick="addTab('已办任务','myTask/assignedTask')">已办任务</a>
                </div>
            </div>
            <div title="教务管理" iconCls="icon-computer" style="overflow: auto;padding: 10px;">
                <div class="menu-last">
                    <a href="#" class="easyui-linkbutton" onclick="addTab('试卷归档管理','educationalAdministration/testPaperManage')">试卷归档管理</a>
                </div>
                <div class="menu-last">
                    <a href="#" class="easyui-linkbutton" onclick="addTab('实训归档管理','educationalAdministration/trainingPaperManage')">实训归档管理</a>
                </div>
                <div class="menu-last">
                    <a href="#" class="easyui-linkbutton" onclick="addTab('教研论文管理','educationalAdministration/teachingPaperManage')">教研论文管理</a>
                </div>
                <div class="menu-last">
                    <a href="#" class="easyui-linkbutton" onclick="addTab('教研课题管理','educationalAdministration/topicPaperManage')">教研课题管理</a>
                </div>
            </div>
            <div title="获奖详情管理" iconCls="icon-computer" style="overflow: auto;padding: 10px;">
                <%--<div class="menu-last">--%>
                    <%--<a href="#" class="easyui-linkbutton" onclick="addTab('获奖申请','awardDetail/addition')">填写获奖申请</a>--%>
                <%--</div>--%>
                <div class="menu-last">
                    <a href="#" class="easyui-linkbutton" onclick="addTab('获奖情况管理','awardDetail/manage')">获奖情况管理</a>
                </div>
                <div class="menu-last">
                    <a href="#" class="easyui-linkbutton" onclick="addTab('获奖情况列表','awardDetail/listAll')">获奖情况列表</a>
                </div>
            </div>
        </div>
    </div>
    <shiro:hasRole name="1">
    <div title="人员管理" iconCls="icon-man" style="overflow: auto;padding: 10px;">
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('用户列表','userManageUI/userList')">用户列表</a>
        </div>
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('用户添加','userManageUI/userAdd')">用户添加</a>
        </div>
    </div>
    </shiro:hasRole>
    <div title="个人信息管理" iconCls="icon-mini-edit" selected="true" style="padding:10px;">
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('个人信息','personalManageUI/personalInfo')">个人信息</a>
        </div>
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('密码修改','')">密码修改</a>
        </div>
    </div>
</div>
</body>
