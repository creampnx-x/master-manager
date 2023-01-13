package com.example.mastermanager.project.servlet;

import com.example.mastermanager.project.dao.impl.DAOFactory;
import com.example.mastermanager.project.po.Project;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;

@WebServlet("/addTProject")
public class addTProject extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String forWardUrl = "";

        int lid = Integer.parseInt(request.getParameter("lid"));
        String num = request.getParameter("num");
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        Double fund = Double.parseDouble(request.getParameter("fund"));
        Date btime = Date.valueOf(request.getParameter("begintime"));
        Date etime = Date.valueOf(request.getParameter("endtime"));

        Project project = new Project();
        project.setLeader(lid);
        project.setPnum(num);
        project.setPtype(type);
        project.setPname(name);
        project.setFund(fund);
        project.setBegintime(btime);
        project.setEndtime(etime);

        DAOFactory.getInstance().getProjectDAO().addProject(project);
        forWardUrl = "project/studentAdmin.jsp?success=1";

        RequestDispatcher dispatcher = request.getRequestDispatcher(forWardUrl);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }
}