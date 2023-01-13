package com.example.mastermanager.module1.pojo;

public class Evaluate {
    private int sid; //学生学号
    private String sname; //学生姓名
    private String cname; //课程名
    private int num;//授课人数
    private String subject;//学生学科
    private String property;//性质
    private String object;//授课对象
    private String tname; //授课老师
    private String time; //授课时间
    private String self;//自述
    private String comment;//评价是否通过


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Evaluate(int sid, String sname, String cname, int num, String subject, String property, String object, String tname, String time, String self, String comment) {
        this.sid = sid;
        this.sname = sname;
        this.cname = cname;
        this.num = num;
        this.subject = subject;
        this.property = property;
        this.object = object;
        this.tname = tname;
        this.time = time;
        this.self = self;
        this.comment = comment;
    }

}

