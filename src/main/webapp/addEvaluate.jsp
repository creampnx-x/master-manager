
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详细信息</title>
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
                    <small>请输入助教工作评定相关信息</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <form class="form-horizontal" role="form" action="addEvaluate" method="post">
            <div class="form-group">
                <label for="fname" class="col-sm-2 control-label">学号</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" id="fname" name="sid" />
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">课程名称</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" id="lastname" name="cname" />
                </div>
            </div>
            <div class="form-group">
                <label for="1" class="col-sm-2 control-label">研究生姓名</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" id="1" name="sname" />
                </div>
            </div>
            <div class="form-group">
                <label for="2" class="col-sm-2 control-label">授课人数</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" id="2" name="num" />
                </div>
            </div>
            <div class="form-group">
                <label for="3" class="col-sm-2 control-label">研究生所在学科</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" id="3"  name="subject" />
                </div>
            </div>
            <div class="form-group">
                <label for="4" class="col-sm-2 control-label">课程性质 0必修 1选修</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" id="4"  name="property" />
                </div>
            </div>
            <div class="form-group">
                <label for="5" class="col-sm-2 control-label">授课对象 0本科生 1研究生</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" id="5"  name="object" />
                </div>
            </div>
            <div class="form-group">
                <label for="6" class="col-sm-2 control-label">授课教师</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" id="6"  name="tname" />
                </div>
            </div>
            <div class="form-group">
                <label for="7" class="col-sm-2 control-label">授课时间</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" id="7"  name="time" />
                </div>
            </div>
            <div class="form-group">
                <label for="8" class="col-sm-2 control-label">助教工作自述</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" id="8"  name="self" />
                </div>
            </div>
            <div class="form-group">
                <label for="9" class="col-sm-2 control-label">授课教师评价</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" id="9"  name="comment" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-2 col-sm-10">
                    <button class="btn btn-primary" type="submit">提交申请</button>
                </div>
            </div>
        </form>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/teacher.jsp">取消</a>
        </div>
    </div>
</div>