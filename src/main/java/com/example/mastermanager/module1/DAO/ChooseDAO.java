package com.example.mastermanager.module1.DAO;

import com.example.mastermanager.module1.pojo.Choose;

import java.util.List;

public interface ChooseDAO {
    void addChoose(Choose choose);//添加一门课程

    List<Choose> selectByTid(int tid);//通过老师id查找选课列表

    void updateChoose(Choose choose);//老师批准某一门课 根据主键查找state改为1

    public List<Choose> selectByTid1(int tid);//根据老师查申请表

    public Choose selectOne(int tid, int mid);

}
