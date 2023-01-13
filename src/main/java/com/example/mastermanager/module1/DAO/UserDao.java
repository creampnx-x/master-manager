package com.example.mastermanager.module1.DAO;

import com.example.mastermanager.module1.pojo.User;

public interface UserDao {
    public User Login(String username,String password);//登录是否成功，成功返回uid,否则返回-1;
    public void addUser(User user); //添加User

}
