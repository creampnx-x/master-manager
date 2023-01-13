package com.example.mastermanager.module1.servlet;

import com.example.mastermanager.module1.DAO.DAOFactory;
import com.example.mastermanager.module1.pojo.Choose;
import com.example.mastermanager.module1.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/StartApply")
public class StartApply extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

     //   DAOFactory.getInstance().getStudentDAO().Choice(user.getUid());
        int id = Integer.valueOf(request.getParameter("id"));
        int tid =  Integer.valueOf(request.getParameter("tid"));
        String cname = request.getParameter("cname");
        Choose choose = new Choose(user.getRealname(),user.getUid(),cname,id,tid,0);
        DAOFactory.getInstance().getChooseDAO().addChoose(choose);
        request.getRequestDispatcher("/suc.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
