function perInf1() {

    alert("perInf1");
    $.post("/user/personalInfo",{uid:"133", employeenum:$("#empNum").val(), phone:$("#phoneNum").val(), email:$("#email").val()},function (data) {
        alert(data);
    });
}
function subNewUser() {
    $.post("/user/addition",{
        employeenum:$("#employeenum").val(),
        username:$("#username").val(),
        roleidsstr:$("#roleSelect").val(),
        deptid:$("#depSelect").val(),
        email:$("#email").val(),
        phone:$("#phone").val(),
    },function (backresult) {
        alert(backresult);
    })
}
function newQpaper() {
    $("fm").form("clear");
    $("#qpaperDialog").dialog("open").dialog("setTitle","试卷归档--新建");
    url = "/office/testPaper/addition";
}
function editQpaper() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#qpaperDialog").dialog("open").dialog("setTitle","试卷归档--编辑");
        $("#fm").form("load",row);
        url = "/office/testPaper/updates/"+row.qid;
    }
}
function destroyQpaper() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/office/testPaper/deletion/"+row.qid,
                    success: function (res) {
                        alert(res);
                        $("#qpaperDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveQpaper() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#qpaperDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}
function newTpaper() {
    $("fm").form("clear");
    $("#tpaperDialog").dialog("open").dialog("setTitle","实训归档--新建");
    url = "/office/trainingPaper/addition";
}
function editTpaper() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#tpaperDialog").dialog("open").dialog("setTitle","实训归档--编辑");
        $("#fm").form("load",row);
        url = "/office/trainingPaper/updates/"+row.tid;
    }
}
function destroyTpaper() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/office/trainingPaper/deletion/"+row.tid,
                    success: function (res) {
                        alert(res);
                        $("#tpaperDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveTpaper() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#tpaperDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}