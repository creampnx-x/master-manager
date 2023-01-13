package com.example.mastermanager.module1.pojo;

public class User {
    private int uid;  //用户id
    private String username;  //用户名
    private String password;  //密码
    private String realname; //真实姓名
    private String ident;   //身份
    private String subject; //学科

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public User(int uid, String username, String password, String realname, String ident, String subject) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.ident = ident;
        this.subject = subject;
    }
    public User(){}
}
