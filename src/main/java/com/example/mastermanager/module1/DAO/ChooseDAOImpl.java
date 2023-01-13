package com.example.mastermanager.module1.DAO;

import com.example.mastermanager.module1.pojo.Choose;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChooseDAOImpl extends DAOBase implements ChooseDAO{

    private static final String chooseInsertSQL = "INSERT INTO [Choose] (mname,mid,cname,cid,tid,state) VALUES(?,?,?,?,?,?) ";

    private static final String chooseSelectSQL = "SELECT * FROM [Choose] WHERE tid = ? AND state = 0";

    private static final String chooseUpdateSQL = "UPDATE [Choose] SET state = ? WHERE cid = ? AND mid = ?";

    private static final String chooseSelect1 = "SELECT * FROM [Choose] WHERE tid = ? and state = 1";

    private static final String chooseSelect2 = "SELECT * FROM [Choose] WHERE tid = ? and mid = ?";
    @Override
    public void addChoose(Choose choose) {
        Connection con = null;
        try{
            con = getConnection();//通过
            PreparedStatement psmt = con.prepareStatement(chooseInsertSQL);
            psmt.setString(1, choose.getMname());
            psmt.setInt(2, choose.getMid());
            psmt.setString(3, choose.getCname());
            psmt.setInt(4, choose.getCid());
            psmt.setInt(5, choose.getTid());
            psmt.setInt(6, choose.getState());
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
    public List<Choose> selectByTid(int tid){
        Connection con = null;
        List<Choose> list = new ArrayList<>();
        try {
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(chooseSelectSQL);
            psmt.setInt(1,tid);
            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
                Choose choose = new Choose(rs.getString("mname"),rs.getInt("mid"),rs.getString("cname"), rs.getInt("cid"),rs.getInt("tid"),rs.getInt("state"));
                list.add(choose);
            }
            psmt.close();
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateChoose(Choose choose) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(chooseUpdateSQL);
            psmt.setInt(1, choose.getState());
            psmt.setInt(2, choose.getCid());
            psmt.setInt(3, choose.getMid());
            psmt.executeUpdate();
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
    public List<Choose> selectByTid1(int tid){
        Connection con = null;
        List<Choose> list = new ArrayList<>();
        try {
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(chooseSelect1);
            psmt.setInt(1,tid);
            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
                Choose choose = new Choose(rs.getString("mname"),rs.getInt("mid"),rs.getString("cname"), rs.getInt("cid"),rs.getInt("tid"),rs.getInt("state"));
                list.add(choose);
            }
            psmt.close();
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public Choose selectOne(int tid, int mid){
        Connection con = null;
        List<Choose> list = new ArrayList<>();
        try {
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(chooseSelect2);
            psmt.setInt(1,tid);
            psmt.setInt(2,mid);
            ResultSet rs = psmt.executeQuery();
            rs.next();
            Choose choose = new Choose(rs.getString("mname"),rs.getInt("mid"),rs.getString("cname"), rs.getInt("cid"),rs.getInt("tid"),rs.getInt("state"));
            psmt.close();
            return choose;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

}
