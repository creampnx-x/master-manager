package com.example.mastermanager.module1;

import com.example.mastermanager.module1.DAO.DAOFactory;
import com.example.mastermanager.module1.pojo.Course;
import com.example.mastermanager.module1.pojo.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAOFactory.getInstance().getCourseDAO().update1(1);
        User user = new User(10,"abcd","12","老师","张武","数学");
      //  System.out.println(DAOFactory.getInstance().getStudentDAO().Select2(1));
        DAOFactory.getInstance().getUserDAO().addUser(user);
    }
}
