<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>申请列表</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>申请课程</th>
                    <th>申请人</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="choose" items="${requestScope.get('list')}">
                    <tr>
                        <td>${choose.getCname()}</td>
                        <td>${choose.getMname()}</td>
                        <td>
                            <c:choose>
                                <c:when test="${choose.getState()==0}">待批准</c:when>
                                <c:when test="${choose.getState()==1}">已批准</c:when>
                                <c:otherwise>已结束</c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${choose.getState()==0}"> <a href="${pageContext.request.contextPath}/chooseApprove?cid=${choose.getCid()}&mid=${choose.getMid()}">批准</a></c:when>
                                <c:otherwise> </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/teacher.jsp">返回主界面</a>
        </div>
    </div>
</div>