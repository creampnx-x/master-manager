<%@ page import="com.example.mastermanager.project.po.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.mastermanager.project.dao.impl.DAOFactory" %>
<%@ page import="com.example.mastermanager.project.po.Contribution" %>
<%@ page import="com.example.mastermanager.project.po.Project" %><%--
  Created by IntelliJ IDEA.
  User: 13407
  Date: 2023/1/10
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>teacherProject</title>
</head>
<body>
    <center>
        <h1>导师项目管理页面</h1>
        <h2>我的学生：</h2>
        <%
            // 从bean中获取老师信息
            User teacher = (User) request.getSession().getAttribute("teacherBean");
            System.out.println("teacher:" + teacher);
            // 查询老师学生
            List<User> result = DAOFactory.getInstance().getTeacherStudentDAO().getStudent(teacher);
            if (result.size() == 0) {
                out.println("<h2>您还没有培养学生！</h2>");
            } else {
                out.println("<table border='1px solid' width='1000px' height='50px'>");
                    out.println("<tr>");
                        out.println("<td>");
                        out.println("学号");
                        out.println("</td>");

                        out.println("<td>");
                        out.println("姓名");
                        out.println("</td>");

                        out.println("<td>");
                        out.println("学科");
                        out.println("</td>");

                        out.println("<td>");
                        out.println("角色");
                        out.println("</td>");

                        out.println("<td>");
                        out.println("操作");
                        out.println("</td>");
                    out.println("</tr>");

                    for (User user : result) {
                        out.println("<tr>");

                            out.println("<td>");
                            out.println(user.getUid());
                            out.println("</td>");

                            out.println("<td>");
                            out.println(user.getRealname());
                            out.println("</td>");

                            out.println("<td>");
                            out.println(user.getSubject());
                            out.println("</td>");

                            out.println("<td>");
                            if (user.getRid() == 5)
                                out.println("硕士研究生");
                            else if (user.getRid() == 6)
                                out.println("博士研究生");
                            out.println("</td>");

                            out.println("<td>");
                                out.println("<form action='Examine' method='POST'>");
                                    out.println("<input type='submit' value='审批'>");
                                    out.print("<input type='hidden' value='");
                                    out.print(user.getUid());
                                    out.println("' name='uid'>");
                                out.println("</form>");
                            out.println("</td>");

                        out.println("</tr>");
                    }

                out.println("</table>");
            }
        %>
        <h2>我的项目：</h2>
        <%
            // 查询老师的项目
            List<Project> presult = DAOFactory.getInstance().getProjectDAO().getProjectByLeader(teacher);
            if (presult.size() == 0) {
                out.println("<h2>您还没有承担项目！</h2>");
            } else {
                out.println("<table border='1px solid' width='1000px' height='50px'>");
                out.println("<tr>");
                out.println("<td>");
                out.println("项目id");
                out.println("</td>");

                out.println("<td>");
                out.println("负责人id");
                out.println("</td>");

                out.println("<td>");
                out.println("项目编号");
                out.println("</td>");

                out.println("<td>");
                out.println("项目类型");
                out.println("</td>");

                out.println("<td>");
                out.println("项目名称");
                out.println("</td>");

                out.println("<td>");
                out.println("折合经费（万元）");
                out.println("</td>");

                out.println("<td>");
                out.println("项目开始时间");
                out.println("</td>");

                out.println("<td>");
                out.println("项目结束时间");
                out.println("</td>");

                out.println("<td>");
                out.println("操作");
                out.println("</td>");

                out.println("</tr>");

                for (Project project : presult) {
                    out.println("<tr>");

                        out.println("<td>");
                        out.println(project.getPid());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(project.getLeader());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(project.getPnum());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(project.getPtype());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(project.getPname());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(project.getFund());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(project.getBegintime());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(project.getEndtime());
                        out.println("</td>");

                        out.println("<td>");
                        out.println("<form action='Allocate' method='POST'>");
                        out.println("<input type='submit' value='分配学生'>");
                        out.print("<input type='hidden' value='");
                        out.print(project.getPid());
                        out.println("' name='pid'>");
                        out.println("</form>");
                        out.println("</td>");

                    out.println("</tr>");
                }

                out.println("</table>");
            }
        %>
        <h2>待审批项目：</h2>
        <%
            // 遍历我的项目，submit为真的为未审批
            out.println("<table border='1px solid' width='1300px' height='50px'>");
            out.println("<tr>");

            out.println("<td>");
            out.println("贡献表id");
            out.println("</td>");

            out.println("<td>");
            out.println("项目id");
            out.println("</td>");

            out.println("<td>");
            out.println("学生id");
            out.println("</td>");

            out.println("<td>");
            out.println("项目编号");
            out.println("</td>");

            out.println("<td>");
            out.println("项目类型");
            out.println("</td>");

            out.println("<td>");
            out.println("项目名称");
            out.println("</td>");

            out.println("<td>");
            out.println("学生工作");
            out.println("</td>");

            out.println("<td>");
            out.println("开始参与时间");
            out.println("</td>");

            out.println("<td>");
            out.println("结束参与时间");
            out.println("</td>");

            out.println("<td>");
            out.println("承担工作折合经费（万元）");
            out.println("</td>");

            out.println("<td>");
            out.println("负责人已确认");
            out.println("</td>");

            out.println("<td>");
            out.println("导师已确认");
            out.println("</td>");

            out.println("<td>");
            out.println("操作");
            out.println("</td>");

            out.println("</tr>");
            for (Project project : presult) {
                Contribution contribution = DAOFactory.getInstance().getContributionDAO().getContributionByPid(project.getPid());
                if (contribution != null && !contribution.isTeacher() && contribution.isSubmit()) {

                    out.println("<tr>");

                        out.println("<td>");
                        out.println(contribution.getCid());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(contribution.getPid());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(contribution.getUid());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(project.getPnum());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(project.getPtype());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(project.getPname());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(contribution.getWork());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(contribution.getBegintime());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(contribution.getEndtime());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(contribution.getFund());
                        out.println("</td>");

                        out.println("<td>");
                        if (contribution.isLeader())
                            out.println("是");
                        else
                            out.println("否");
                        out.println("</td>");

                        out.println("<td>");
                        if (contribution.isTeacher())
                            out.println("是");
                        else
                            out.println("否");
                        out.println("</td>");


                        out.println("<td>");
                        out.println("<form action='TeacherConfirm' method='POST'>");
                        out.println("<input type='submit' value='确认'>");
                        out.print("<input type='hidden' value='");
                        out.print(contribution.getCid());
                        out.println("' name='cid'>");
                        out.println("</form>");
                        out.println("</td>");

                    out.println("</tr>");

                }
            }
            out.println("</table>");
        %>
        <h2>已审批项目：</h2>
        <%
            out.println("<table border='1px solid' width='1300px' height='50px'>");
            out.println("<tr>");

            out.println("<td>");
            out.println("贡献表id");
            out.println("</td>");

            out.println("<td>");
            out.println("项目id");
            out.println("</td>");

            out.println("<td>");
            out.println("学生id");
            out.println("</td>");

            out.println("<td>");
            out.println("项目编号");
            out.println("</td>");

            out.println("<td>");
            out.println("项目类型");
            out.println("</td>");

            out.println("<td>");
            out.println("项目名称");
            out.println("</td>");

            out.println("<td>");
            out.println("学生工作");
            out.println("</td>");

            out.println("<td>");
            out.println("开始参与时间");
            out.println("</td>");

            out.println("<td>");
            out.println("结束参与时间");
            out.println("</td>");

            out.println("<td>");
            out.println("承担工作折合经费（万元）");
            out.println("</td>");

            out.println("<td>");
            out.println("负责人已确认");
            out.println("</td>");

            out.println("<td>");
            out.println("导师已确认");
            out.println("</td>");

            out.println("</tr>");
            // 遍历我的项目，submit为真的为未审批
            for (Project project : presult) {
                Contribution contribution = DAOFactory.getInstance().getContributionDAO().getContributionByPid(project.getPid());
                if (contribution != null && contribution.isTeacher() && contribution.isSubmit()) {

                    out.println("<tr>");

                    out.println("<td>");
                    out.println(contribution.getCid());
                    out.println("</td>");

                    out.println("<td>");
                    out.println(contribution.getPid());
                    out.println("</td>");

                    out.println("<td>");
                    out.println(contribution.getUid());
                    out.println("</td>");

                    out.println("<td>");
                    out.println(project.getPnum());
                    out.println("</td>");

                    out.println("<td>");
                    out.println(project.getPtype());
                    out.println("</td>");

                    out.println("<td>");
                    out.println(project.getPname());
                    out.println("</td>");

                    out.println("<td>");
                    out.println(contribution.getWork());
                    out.println("</td>");

                    out.println("<td>");
                    out.println(contribution.getBegintime());
                    out.println("</td>");

                    out.println("<td>");
                    out.println(contribution.getEndtime());
                    out.println("</td>");

                    out.println("<td>");
                    out.println(contribution.getFund());
                    out.println("</td>");

                    out.println("<td>");
                    if (contribution.isLeader())
                        out.println("是");
                    else
                        out.println("否");
                    out.println("</td>");

                    out.println("<td>");
                    if (contribution.isTeacher())
                        out.println("是");
                    else
                        out.println("否");
                    out.println("</td>");


                    out.println("</tr>");

                }
            }
            out.println("</table>");
        %>
    </center>
</body>
<script>
    var error_type = '<%= request.getParameter("error")%>'
    if (error_type === '1'){
        setTimeout(function () {
            window.alert("学号输入错误！")
        }, 200)
    } else if (error_type === '2') {
        setTimeout(function () {
            window.alert("已确认表单请勿重复确认！")
        }, 200)
    }

    var success_type = '<%= request.getParameter("success")%>'
    if (success_type === '1'){
        setTimeout(function () {
            window.alert("分配成功！")
        }, 200)
    } else if (success_type === '2'){
        setTimeout(function () {
            window.alert("已确认！")
        }, 200)
    }
</script>
</html>
