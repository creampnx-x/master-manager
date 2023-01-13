package com.example.mastermanager.module1.DAO;

public interface StudentDao {
    public void Choice(int uid);//指提交了一次申请，申请次数自增一次
    public void Evaluate(String ta,int uid);//指助教工作是否合格，根据老师评价设置

    public int Select1(int uid);//查询提交次数
    public String Select2(int uid);//查询是否合格

    public void addStudent(int uid);//添加学生
}
