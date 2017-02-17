<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wanzhenghang
  Date: 2017/2/15
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户添加</title>
    <link rel="stylesheet" type="text/css" href="/ui/themes/ui-pepper-grinder/easyui.css">
    <link rel="stylesheet" type="text/css" href="/ui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/ui/demo/demo.css">
    <script type="text/javascript" src="/ui/jquery.min.js"></script>
    <script type="text/javascript" src="/ui/jquery.easyui.min.js"></script>
    <script type="application/javascript" src="/ui/sdutoa.js"></script>
</head>
<body>

<div style="width: 900px;height: auto;margin: 0 auto">
    <div class="easyui-panel" title="用户添加" style="width: 900px;height: auto;">
        <table class="table-view" align="center" width="47%">
            <div>
                <label >工号: </label>
                <input class="easyui-validatebox" type="text" name="employeenum" data-options="required:true" />
            </div>
            <div>
                <label >用户名: </label>
                <input class="easyui-validatebox" type="text" name="name" data-options="validType:'email'" />
            </div>
            <div>
                <label >角色: </label>
                <input id="roleSelect" class="easyui-combobox"
                       name="role"
                       data-options="
                       valueField:'rid',
                       textField:'role',
                       url:'${pageContext.request.contextPath}/public/rddl'" />
                <%--<input id="cc" class="easyui-combobox" name="dept"--%>
                       <%--data-options="valueField:'id',textField:'text',url:'get_data.php'" />--%>
            </div>
            <div>
                <label >系别: </label>
                <input class="easyui-validatebox" type="text" name="name" data-options="required:true" />
            </div>
            <div>
                <label >邮箱: </label>
                <input class="easyui-validatebox" type="text" name="name" data-options="required:true" />
            </div>
            <div>
                <label >手机号: </label>
                <input class="easyui-validatebox" type="text" name="name" data-options="required:true" />
            </div>
        </table>
    </div>
</div>



</body>
</html>
