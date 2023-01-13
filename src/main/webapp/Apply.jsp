<%@ page import="com.example.mastermanager.module1.pojo.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: mid
  Date: 2022/12/2
  Time: 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>全部用户</title>

    <!-- 引入 Bootstrap 然后去使用css样式-->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <!--%
                    User user = (User)session.getAttribute("loguser");
                    out.print("<h1>"+user.getUsername()+"</h1>");
                %-->
                <h1>
                    <small>您好,请选择您要申报助教的课程 </small>
                </h1>
            </div>
            <%!
                List<Course> list = new ArrayList<>();

            %>
            <%
                HttpSession session1 = request.getSession();
                list = (List<Course>) session1.getAttribute("list");
            %>
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>课程id</th>
                    <th>课程名</th>
                    <th>教师id</th>
                    <th>教师名</th>
                    <th>授课时间</th>
                    <th>授课对象</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="course" items="${list}">
                    <tr>
                        <td>${course.cid}</td>
                        <td>${course.cname}</td>
                        <td>${course.tid}</td>
                        <td>${course.tname}</td>
                        <td>${course.date}</td>
                        <td>
                            <c:choose>
                            <c:when test="${course.property==0}">必修</c:when>
                            <c:when test="${course.property==1}">选修</c:when>
                            </c:choose>
                        </td>
                        <td>
                            <a class="btn btn-default" href="StartApply?id=${course.getCid()}&cname=${course.getCname()}&tid=${course.getTid()}">申请</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
