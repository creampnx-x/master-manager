<%--
  Created by IntelliJ IDEA.
  User: mid
  Date: 2022/12/8
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>老师</title>

    <!-- 引入 Bootstrap 然后去使用css样式-->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-9 column">
            <div class="page-header">
                <h1>
                    <small>教师页面</small>
                </h1>
            </div>
            <div class="form-group">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/choose">查看助教申请</a>
            </div>
            <div class="form-group">
                <a class="btn btn-success" href="${pageContext.request.contextPath}/evaluate">填写课程工作评定</a>
            </div>
        </div>

    </div>
</div>
</body>
</html>
