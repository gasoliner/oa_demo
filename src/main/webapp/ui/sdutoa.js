//重写formatter函数，重新设置时间格式
// $.fn.datebox.defaults.formatter = function(date){
//     var y = date.getFullYear();
//     var m = date.getMonth()+1;
//     var d = date.getDate();
//     return y+'-'+m+'-'+d;
// }
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
    $("#fm").form("clear");
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
    $("#fm").form("clear");
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
function newTopaper() {
    $("#fm").form("clear");
    $("#topaperDialog").dialog("open").dialog("setTitle","教研课题--新建");
    url = "/office/topicPaper/addition";
}
function editTopaper() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#topaperDialog").dialog("open").dialog("setTitle","教研课题--编辑");
        $("#fm").form("load",row);
        url = "/office/topicPaper/updates/"+row.uuid;
    }
}
function destroyTopaper() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/office/topicPaper/deletion/"+row.uuid,
                    success: function (res) {
                        alert(res);
                        $("#topaperDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveTopaper() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#topaperDialog").dialog("close");
            $("#dg").datagrid("reload");
        }
    })
}
function newTepaper() {
    $("#fm").form("clear");
    $("#tepaperDialog").dialog("open").dialog("setTitle","教研论文--新建");
    url = "/office/teachingPaper/addition";
}
function editTepaper() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#tepaperDialog").dialog("open").dialog("setTitle","教研论文--编辑");
        $("#fm").form("clear");
        $("#fm").form("load",row);
        url = "/office/teachingPaper/updates/"+row.uuid;
    }
}
function destroyTepaper() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/office/teachingPaper/deletion/"+row.uuid,
                    success: function (res) {
                        alert(res);
                        $("#tepaperDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveTepaper() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#tepaperDialog").dialog("close");
            $("#dg").datagrid("reload");
        }
    })
}
function showTePaper(u) {
    $("#imgDialog").dialog({
        title:"查看",
        width: 550,
        height: 550,
        closed: false,
        cache: false,
        modal: true
    });
    $("#imgTePaper").attr("src","/office/teachingPaper/showTePaper/"+u);
}
//设置下拉列表框
$(function () {
    $('#searchInput').combobox({
        onChange: function(){
            $("#dg").datagrid({
                url:'/system/dictionary/list/'+$("#searchInput").combobox("getValue")
            });
            $("#dg").datagrid("load");
        }
    });
});
//设置下拉列表框end
function newSystemDDL(){
    $("#fm").form("clear");
    $("#sysDDLDialog").dialog("open").dialog("setTitle","字典管理--新建");
    url = "/system/dictionary/addition";
}
function editSystemDDL(){
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#sysDDLDialog").dialog("open").dialog("setTitle","字典管理--编辑");
        $("#fm").form("clear");
        $("#fm").form("load",row);
        url = "/system/dictionary/updates/"+row.uuid;
    }
}
function destroySystemDDL(){
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/system/dictionary/deletion/"+row.uuid,
                    success: function (res) {
                        alert(res);
                        $("#sysDDLDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveSysDDL(){
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#sysDDLDialog").dialog("close");
            $("#dg").datagrid("reload");
        }
    })
}

function newNotice() {
    $("#fm").form("clear");
    $("#noticeDialog").dialog("open").dialog("setTitle", "通知管理--新建");
    url = "/system/notice/addition";
}
function destroyNotice(){
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/system/notice/deletion/"+row.uuid,
                    success: function (res) {
                        alert(res);
                        $("#noticeDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveNotice(){
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#noticeDialog").dialog("close");
            $("#dg").datagrid("reload");
        }
    })
}
function showNotice(u) {
    $.get("/system/notice/"+u,null,function (res) {
        $("#noticeDialog").dialog({
            title: "查看",
            width: 550,
            height: 550,
            closed: false,
            cache: false,
            modal: true,
            content:res
        });
    });

}
