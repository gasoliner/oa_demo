<%--
  Created by IntelliJ IDEA.
  User: 万洪基
  Date: 2016/12/27
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/ui/themes/ui-pepper-grinder/easyui.css">
    <link rel="stylesheet" type="text/css" href="/ui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/ui/demo/demo.css">
    <script type="text/javascript" src="/ui/jquery.min.js"></script>
    <script type="text/javascript" src="/ui/jquery.easyui.min.js"></script>
</head>
<body>
<div style="width: 900px;height: auto;margin: 0 auto">
    <div class="easyui-panel" title="获奖详情申请" style="width: 900px;height: auto;">
        <form>
            <table class="table-view" align="center" width="47%">
                <div style="margin: 39px;">
                    <tr>
                        <th class="title">成果名称：</th>
                        <td><input class="easyui-textbox" style="width: 300px;height: 32px"/></td>
                    </tr>
                    <tr>
                        <th class="title">参赛学生：</th>
                        <td><input class="easyui-textbox" style="width: 300px;height: 32px"/>
                        </th>
                    </tr>
                    <tr>
                        <th class="title">专业：</th>
                        <td><input class="easyui-textbox" style="width: 300px;height: 32px"/>
                        </th>
                    </tr>
                    <tr>
                        <th class="title">班级：</th>
                        <td><input class="easyui-textbox" style="width: 300px;height: 32px"/>
                        </th>
                    </tr>
                    <tr>
                        <th class="title">指导老师：</th>
                        <td><input class="easyui-textbox" style="width: 300px;height: 32px"/>
                        </th>
                    </tr>
                    <tr>
                        <th class="title">获奖时间：</th>
                        <td><input class="easyui-textbox" style="width: 300px;height: 32px"/>
                        </th>
                    </tr>
                    <tr>
                        <th class="title">颁奖单位：</th>
                        <td><input class="easyui-textbox" style="width: 300px;height: 32px"/>
                        </th>
                    </tr>
                    <tr>
                        <th class="title">备注：</th>
                        <td><input class="easyui-textbox" style="width: 300px;height: 32px"/>
                        </th>
                    </tr>
                </div>
                <tr>
                    <th colspan="2">
                        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:void (0)">保存&nbsp&nbsp</a>
                    </th>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
