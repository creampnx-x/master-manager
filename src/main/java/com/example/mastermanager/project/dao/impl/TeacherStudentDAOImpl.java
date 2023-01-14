package com.example.mastermanager.project.dao.impl;

import com.example.mastermanager.project.dao.TeacherStudentDAO;
import com.example.mastermanager.project.po.User;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeacherStudentDAOImpl extends DAOBase implements TeacherStudentDAO {
    private Connection conn;

    private static final String STUDENT_SELECT_SQL = "select userid, realname, subject, roleid from [User], TeacherStudent where TeacherStudent.teacherid = ? and TeacherStudent.studentid = [User].userid";
    @Override
    public List<User> getStudent(User user) {
        conn = null;
        List<User> result = new ArrayList<>();
        try {
            conn = getConnection();
            PreparedStatement pt = conn.prepareStatement(STUDENT_SELECT_SQL);
            System.out.println(user);
            pt.setInt(1, user.getUid());
            ResultSet rs = pt.executeQuery();
            int i = 1;
            while (rs.next()) {
                User user1 = new User();
//                user1.setUid(rs.getInt("studentid"));
//                user1 = DAOFactory.getInstance().getUserDAO().getUser(user1);
                user1.setUid(rs.getInt("userid"));
                user1.setRealname(rs.getString("realname"));
                user1.setSubject(rs.getString("subject"));
                user1.setRid(rs.getInt("roleid"));
                result.add(user1);
                System.out.println(i++ + ": " + user1);
            }
            pt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
