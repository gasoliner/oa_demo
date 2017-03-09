<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8"/>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="ui/themes/ui-pepper-grinder/easyui.css">
    <link rel="stylesheet" type="text/css" href="ui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="ui/demo/demo.css">
    <script type="text/javascript" src="ui/jquery.min.js"></script>
    <script type="text/javascript" src="ui/jquery.easyui.min.js"></script>
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
<div class="easyui-layout" style="width:100%;height: 723px;">
    <div region="north" split="false" style="width: 100%;height: 50px;border: 0px">
        <jsp:include page="north.jsp"/>
    </div>
    <div region="west" split="false" title="常用功能" style="width: 270px;height:100%;">
        <jsp:include page="west.jsp"/>
    </div>
    <div region="center" title="主体任务区" style="padding:5px;height: auto;">
        <div id="tt" class="easyui-tabs" style="width: 100%;height: 100%;">
            <div title="Home">
                <div style="height: auto;margin-top: 60px;margin-left: 60px;" align="left">
                    <iframe allowtransparency="true" frameborder="0" width="565" height="98" scrolling="no" src="//tianqi.2345.com/plugin/widget/index.htm?s=2&z=3&t=1&v=0&d=3&bd=0&k=000000&f=008080&q=1&e=1&a=1&c=54830&w=565&h=98&align=center"></iframe>
                </div>
                <div style="height: auto;margin-right: 20px;" align="right">
                    <div class="easyui-calendar" style="width:250px;height:250px;"></div>
                </div>
            </div>
        </div>
    </div>
    <div region="south" split="true" style="width: 100%;height: 50px;border: 0px;">
        <jsp:include page="south.jsp"/>
    </div>
</div>

</body>
</html>
