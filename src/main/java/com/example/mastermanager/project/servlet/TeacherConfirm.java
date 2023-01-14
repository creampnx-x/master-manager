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

@WebServlet("/TeacherConfirm")
public class TeacherConfirm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String forWardUrl = "";

        int cid = Integer.parseInt(request.getParameter("cid"));
        Contribution contribution = new Contribution();
        contribution.setCid(cid);
        contribution = DAOFactory.getInstance().getContributionDAO().getContributionByCid(contribution);
        if (contribution.isTeacher()) {
            forWardUrl = "project/teacherProject.jsp?error=2";
        } else {
            contribution.setTeacher(true);
            contribution.setLeader(true);
            DAOFactory.getInstance().getContributionDAO().updateContribution(contribution);
            forWardUrl = "project/teacherProject.jsp?success=2";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(forWardUrl);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }
}