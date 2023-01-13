package com.example.mastermanager.project.servlet;

import com.example.mastermanager.project.dao.impl.DAOFactory;
import com.example.mastermanager.project.po.Contribution;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/GetAllocate")
public class GetAllocate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String forWardUrl = "";
        int pid = (Integer) request.getSession().getAttribute("pid");

        int uid = Integer.parseInt(request.getParameter("uid"));
        String work = request.getParameter("work");
        Double fund = Double.parseDouble(request.getParameter("fund"));
        Date begintime = Date.valueOf(request.getParameter("begintime"));
        Date endtime = Date.valueOf(request.getParameter("endtime"));

        Contribution contribution = new Contribution();
        contribution.setPid(pid);
        contribution.setUid(uid);
        contribution.setBegintime(begintime);
        contribution.setEndtime(endtime);
        contribution.setWork(work);
        contribution.setFund(fund);
        contribution.setLeader(false);
        contribution.setTeacher(false);
        contribution.setSubmit(false);
        DAOFactory.getInstance().getContributionDAO().addContribution(contribution);
        forWardUrl = "project/teacherProject.jsp?success=1";

        RequestDispatcher dispatcher = request.getRequestDispatcher(forWardUrl);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }
}