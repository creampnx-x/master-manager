package com.example.mastermanager.project.servlet;

import com.example.mastermanager.project.dao.impl.DAOFactory;
import com.example.mastermanager.project.po.Contribution;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.image.renderable.ContextualRenderedImageFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

@WebServlet("/addSProject")
public class addSProject extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String forWardUrl = "";

        int pid = Integer.parseInt(request.getParameter("pid"));
        int uid = Integer.parseInt(request.getParameter("uid"));
        Date btime = Date.valueOf(request.getParameter("begintime"));
        Date etime = Date.valueOf(request.getParameter("endtime"));
        String work = request.getParameter("work");
        Double fund = Double.parseDouble(request.getParameter("fund"));

        Contribution contribution = new Contribution();
        contribution.setPid(pid);
        contribution.setUid(uid);
        contribution.setBegintime(btime);
        contribution.setEndtime(etime);
        contribution.setWork(work);
        contribution.setFund(fund);
        contribution.setLeader(false);
        contribution.setTeacher(false);
        contribution.setSubmit(false);
        DAOFactory.getInstance().getContributionDAO().addContribution(contribution);

        forWardUrl = "project/studentAdmin.jsp?success=2";

        RequestDispatcher dispatcher = request.getRequestDispatcher(forWardUrl);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }
}