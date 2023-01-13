<%--
  Created by IntelliJ IDEA.
  User: mid
  Date: 2022/12/2
  Time: 4:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="form row">
        <div class="page-header">
            <h1>
                <small>登录页面</small>
            </h1>
        </div>
        <div class="col-sm-12 col-md-12">
            <form action="Login" method="post">
                <div class="form-group">
                    <input class="form-control" type="text" name="username" id="username" placeholder="请输入用户名">
                </div>
                <div class="form-group">
                    <input class="form-control " type="password" name="password" id="password" placeholder="请输入密码">
                </div>
                <div class="form-group">
                    <input type="submit" value="登录" class="btn btn-success pull-left">
                </div>
                <br><br>
            </form>
        </div>
    </div>
</div>
</body>

</html>
