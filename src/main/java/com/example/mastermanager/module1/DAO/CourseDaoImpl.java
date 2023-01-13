package com.example.mastermanager.module1.DAO;

import com.example.mastermanager.module1.pojo.Course;
import com.example.mastermanager.module1.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl extends DAOBase implements CourseDao {
    private static final String STUDENT_SELECT1_SQL = "SELECT * FROM [Course] WHERE state = 0";
    private static final String STUDENT_SELECT2_SQL = "SELECT * FROM [Course] WHERE state = 0 AND tid = ?";
    private static final String STUDENT_UPDATE1_SQL = "UPDATE [Course] SET state = 1 WHERE cid = ?";
    private static final String STUDENT_INSERT_SQL = "INSERT INTO [Course] (cid,teachObject,property,tname,tid,date,num,state,cname) VALUES(?,?,?,?,?,?,?,?,?) ";
    private static final String STUDENT_SELECT3_SQL = "SELECT * FROM [Course] WHERE cid = ?";
    @Override
    public List<Course> select1() {
        Connection con = null;
        List<Course> list = new ArrayList<>();
        try {
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(STUDENT_SELECT1_SQL);
            ResultSet rs = psmt.executeQuery();
           while(rs.next()){
               Course course = new Course(rs.getInt("cid"),rs.getString("cname"),rs.getInt("teachObject"),rs.getInt("property"),rs.getString("tname"),rs.getInt("tid"),rs.getString("date"),rs.getInt("num"),rs.getInt("state"));
               list.add(course);
           }
            psmt.close();
           return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public void update1(int cid) {
        Connection con = null;
        User user = new User();
        try {
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(STUDENT_UPDATE1_SQL);
            psmt.setInt(1,cid);
            psmt.executeUpdate();
            System.out.println("成功");

            psmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addCourse(Course course) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(STUDENT_INSERT_SQL);
            psmt.setInt(1, course.getCid());
            psmt.setInt(2, course.getTeachObject());
            psmt.setInt(3, course.getProperty());
            psmt.setString(4, course.getTname());
            psmt.setInt(5, course.getTid());
            psmt.setString(6, course.getDate());
            psmt.setInt(7, course.getNum());
            psmt.setInt(8, course.getState());
            psmt.setString(9, course.getCname());
            psmt.executeUpdate();
            System.out.println("添加成功");
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Course> select2(int tid) {
        Connection con = null;
        List<Course> list = new ArrayList<>();
        try {
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(STUDENT_SELECT2_SQL);
            psmt.setInt(1,tid);
            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
                Course course = new Course(rs.getInt("cid"),rs.getString("cname"),rs.getInt("teachObject"),rs.getInt("property"),rs.getString("tname"),rs.getInt("tid"),rs.getString("date"),rs.getInt("num"),rs.getInt("state"));
                list.add(course);
            }
            psmt.close();
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    @Override
    public Course select3(int cid) {
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(STUDENT_SELECT3_SQL);
            psmt.setInt(1,cid);
            ResultSet rs = psmt.executeQuery();
            rs.next();
            Course course = new Course(rs.getInt("cid"),rs.getString("cname"),rs.getInt("teachObject"),rs.getInt("property"),rs.getString("tname"),rs.getInt("tid"),rs.getString("date"),rs.getInt("num"),rs.getInt("state"));
            psmt.close();
            return course;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
