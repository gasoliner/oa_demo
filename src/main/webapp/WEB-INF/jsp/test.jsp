<%--
  Created by IntelliJ IDEA.
  User: 万洪基
  Date: 2016/12/27
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
    <link rel="stylesheet" type="text/css" href="http://www.w3cschool.cc/try/jeasyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="http://www.w3cschool.cc/try/jeasyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="http://www.w3cschool.cc/try/jeasyui/demo/demo.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="http://www.w3cschool.cc/try/jeasyui/jquery.easyui.min.js"></script>

    <script type="text/javascript">
        function addTab(title, url){
            if ($('#tt').tabs('exists', title)){
                $('#tt').tabs('select', title);
            } else {
                var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
                $('#tt').tabs('add',{
                    title:title,
                    content:content,
                    closable:true
                });
            }
        }
    </script>
</head>
<body>
<div class="easyui-layout"style="width:100%;height:700px;">
    <div id="content" region="center" title="哈哈" style="padding: 5px">
        <div id="tt" class="easyui-tabs" style="width:400px;height:250px;">
            <div title="Home">
            </div>
        </div>
    </div>

</div>


<div>
    <p align="center">Copyright &copy; 2016.Person wan All rights reserved.&nbsp;&nbsp;<a href="http://www.miitbeian.gov.cn">鲁ICP备16050684号</a></p>
</div>

</body>
</html>
