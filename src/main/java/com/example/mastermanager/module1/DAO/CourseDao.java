package com.example.mastermanager.module1.DAO;

import com.example.mastermanager.module1.pojo.Course;

import java.util.List;

public interface CourseDao {
    public List<Course> select1(); //查询研究生可选择助教的课程
    public void update1(int cid);//更新课程的助教情况,state改为1
    public void addCourse(Course course);//添加课程
    public List<Course> select2(int tid); //查询老师可以进行工作评定的课程
    public Course select3(int cid);
}
