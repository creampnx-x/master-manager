package com.example.mastermanager.module1.DAO;

import com.example.mastermanager.module1.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl extends DAOBase implements StudentDao{
    private static final String STUDENT_UPDATE1_SQL = "UPDATE [Student] SET tanum = ? WHERE uid = ?";
    private static final String STUDENT_UPDATE2_SQL = "UPDATE [Student] SET ta = ? WHERE uid = ?";
    private static final String STUDENT_SELECT1_SQL = "SELECT tanum FROM [Student] WHERE uid = ?";
    private static final String STUDENT_SELECT2_SQL = "SELECT ta FROM [Student] WHERE uid = ?";
    private static final String STUDENT_INSERT_SQL = "INSERT INTO [Student] (uid,tanum,ta) VALUES(?,?,?) ";
    @Override
    public void Choice(int uid) {
        Connection con = null;
        User user = new User();
        try {
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(STUDENT_SELECT1_SQL);
            psmt.setInt(1, uid);
            ResultSet rs = psmt.executeQuery();
            rs.next();
            int num = rs.getInt("tanum") + 1;

            psmt = con.prepareStatement(STUDENT_UPDATE1_SQL);
            psmt.setInt(1,num);
            psmt.setInt(2,uid);
            psmt.executeUpdate();
            System.out.println("成功");

            psmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void Evaluate(String ta,int uid) {
        Connection con = null;
        User user = new User();
        try {
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(STUDENT_UPDATE2_SQL);
            psmt.setString(1,ta);
            psmt.setInt(2,uid);
            psmt.executeUpdate();
            System.out.println("成功");

            psmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public int Select1(int uid) {
        Connection con = null;
        User user = new User();
        try {
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(STUDENT_SELECT1_SQL);
            psmt.setInt(1, uid);
            ResultSet rs = psmt.executeQuery();
            rs.next();
            int num = rs.getInt("tanum");
            psmt.close();
            return num;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }

    @Override
    public String Select2(int uid) {
        Connection con = null;
        User user = new User();
        try {
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(STUDENT_SELECT2_SQL);
            psmt.setInt(1, uid);
            ResultSet rs = psmt.executeQuery();
            rs.next();
            String ta = rs.getString("ta");
            psmt.close();
            return ta;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public void addStudent(int uid) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(STUDENT_INSERT_SQL);
            psmt.setInt(1, uid);
            psmt.setInt(2, 0);
            psmt.setString(3, "未合格");
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
}
