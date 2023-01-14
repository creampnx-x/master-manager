package com.example.mastermanager.project.po;

import lombok.Data;

@Data
public class User {
    /*
    * 用户id
    * */
    private Integer uid;

    /*
    * 真实姓名
    * */
    private String realname;

    /*
    * 用户名
    * */
    private String username;

    /*
    * 密码
    * */
    private String password;

    /*
    * 学科
    * */
    private String subject;

    /*
    * 角色Id
    * 1 研究生培养管理员
    * 2
    * 3
    * 4 导师
    * 5 研究生
    * */
    private Integer rid;
}
