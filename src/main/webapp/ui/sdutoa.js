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
