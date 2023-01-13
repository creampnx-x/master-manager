package com.example.mastermanager.project.dao;

import com.example.mastermanager.project.po.Contribution;
import com.example.mastermanager.project.po.User;

import java.util.List;

public interface ContributionDAO {
    /*
    * 添加一个贡献表
    * */
    public void addContribution(Contribution contribution);

    /*
    * 删除一个贡献表
    * */
    public void deleteContribution(Contribution contribution);

    /*
    * 修改一个贡献表
    * */
    public void updateContribution(Contribution contribution);

    /*
    * 查询一个贡献表
    * 根据id
    * */
    public Contribution getContributionByCid(Contribution contribution);

    /*
    * 查询一个学生的贡献表
    * */
    public List<Contribution> getStudentContribution(User user);

    /*
    * 查询一个老师的学生的贡献表
    * 根据Pid
    * */
    public Contribution getContributionByPid(Integer pid);
}
