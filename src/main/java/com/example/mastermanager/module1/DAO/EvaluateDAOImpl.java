package com.example.mastermanager.module1.DAO;

import com.example.mastermanager.module1.pojo.Evaluate;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EvaluateDAOImpl extends DAOBase implements EvaluateDAO{

    private static final String evaluateInsertSQL = "INSERT INTO [Evaluate] (sid,cname,sname,num,subject,property,object,tname,time,self,comment) VALUES(?,?,?,?,?,?,?,?,?,?,?) ";

    @Override
    public void addEvaluate(Evaluate evaluate) {
        Connection con = null;
        try{
            con = getConnection();//通过
            PreparedStatement psmt = con.prepareStatement(evaluateInsertSQL);
            psmt.setInt(1, evaluate.getSid());
            psmt.setString(2, evaluate.getCname());
            psmt.setString(3, evaluate.getSname());
            psmt.setInt(4, evaluate.getNum());
            psmt.setString(5, evaluate.getSubject());
            psmt.setString(6, evaluate.getProperty());
            psmt.setString(7, evaluate.getObject());
            psmt.setString(8, evaluate.getTname());
            psmt.setString(9, evaluate.getTime());
            psmt.setString(10, evaluate.getSelf());
            psmt.setString(11, evaluate.getComment());
            psmt.executeUpdate();
            System.out.println(evaluate.getCname()+"添加成功");
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
