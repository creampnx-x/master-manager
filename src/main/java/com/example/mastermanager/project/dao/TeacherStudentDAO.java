package com.example.mastermanager.project.dao;

import com.example.mastermanager.project.po.User;

import java.util.List;

public interface TeacherStudentDAO {
    /*
    * 查询老师的学生
    * */
    public List<User> getStudent(User user);
}
