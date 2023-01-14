package com.example.mastermanager.project.dao.impl;

import com.example.mastermanager.project.dao.ContributionDAO;
import com.example.mastermanager.project.dao.ProjectDAO;
import com.example.mastermanager.project.dao.TeacherStudentDAO;
import com.example.mastermanager.project.dao.UserDAO;
import com.example.mastermanager.project.po.User;


public class DAOFactory {
    private static DAOFactory daoFactory;
    static {
        daoFactory = new DAOFactory();
    }

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return daoFactory;
    }

    public ProjectDAO getProjectDAO() {
        return new ProjectDAOImpl();
    }

    public ContributionDAO getContributionDAO() {
        return new ContributionDAOImpl();
    }

    public UserDAO getUserDAO() {return new UserDAOImpl();}

    public TeacherStudentDAO getTeacherStudentDAO() {return new TeacherStudentDAOImpl();}
}
