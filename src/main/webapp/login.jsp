<%--
  Created by IntelliJ IDEA.
  User: 13407
  Date: 2023/1/10
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Login</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <div class="header">
        <h2>用户登录</h2>
    </div>
    <form class="form" action="GetLogin" method="POST" onSubmit="return Check(this)">
        <!-- 用户id	text -->
        <div class="form_control">
            <label for="">id</label>
            <input type="number" placeholder="请输入账户id" id="id" name="id">
        </div>
        <!-- 密码	password -->
        <div class="form_control">
            <label for="">密码</label>
            <input type="password" placeholder="请输入密码" id="password" name="pwd">
        </div>
        <input type="submit" class="submit" value="Submit">
        <!-- <button class="submit" onclick="CAS()">Submit</button> -->
    </form>
</div>
<script>
    function Check(form){
        console.log("Check")
        if(form.id.value === ""){
            window.alert('用户名不能为空！');
            form.id.focus();
            return false;
        }
        if(form.password.value === ""){
            window.alert('密码不能为空！');
            form.password.focus();
            return false;
        }
        if(form.password.value.length < 6){
            window.alert('密码至少为6位，请重新输入！');
            form.password.focus();
            return false;
        }
        return true;
    }
    // 取出后端传回来的参数error
    var error_type = '<%= request.getParameter("error")%>'
    if (error_type === '1'){
        setTimeout(function () {
            window.alert("用户名或密码输入错误！")
        }, 200)
    }
</script>
</body>
</html>