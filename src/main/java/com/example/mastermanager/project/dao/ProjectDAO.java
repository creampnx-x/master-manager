package com.example.mastermanager.project.dao;

import com.example.mastermanager.project.po.Project;
import com.example.mastermanager.project.po.User;

import java.util.List;

public interface ProjectDAO {
    /*
    * 添加一个项目
    * */
    public void addProject(Project project);

    /*
    * 删除一个项目
    * */
    public void deleteProject(Project project);

    /*
    * 修改一个项目信息
    * */
    public void updateProject(Project project);

    /*
    * 查询一个项目信息
    * */
    public Project getProjectByPid(Project project);

    /*
    * 根据负责人查询项目信息
    * */
    public List<Project> getProjectByLeader(User user);
}
