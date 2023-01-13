package com.example.mastermanager.module1.pojo;

public class Course {
    private int cid;
    private String cname; //课程名
    private int teachObject;//授课对象 0本科 1硕士
    private int property;//授课性质 0必修 1选修
    private String tname;//教师姓名
    private int tid;//教师id
    private String date;//授课时间
    private int num;//授课人数
    private int state;//是否有助教  0表示无 1表示有

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getTeachObject() {
        return teachObject;
    }

    public void setTeachObject(int teachObject) {
        this.teachObject = teachObject;
    }

    public int getProperty() {
        return property;
    }

    public void setProperty(int property) {
        this.property = property;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Course(int cid, String cname, int teachObject, int property, String tname, int tid, String date, int num, int state) {
        this.cid = cid;
        this.cname = cname;
        this.teachObject = teachObject;
        this.property = property;
        this.tname = tname;
        this.tid = tid;
        this.date = date;
        this.num = num;
        this.state = state;
    }
}