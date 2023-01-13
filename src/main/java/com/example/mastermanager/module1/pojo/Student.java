package com.example.mastermanager.module1.pojo;

public class Student {
    private int uid;  //学号
    private int tanum; //助教申请次数
    private String ta;//助教任务是否合格

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getTanum() {
        return tanum;
    }

    public void setTanum(int tanum) {
        this.tanum = tanum;
    }

    public String getTa() {
        return ta;
    }

    public void setTa(String ta) {
        this.ta = ta;
    }

    public Student(int uid, int tanum, String ta) {
        this.uid = uid;
        this.tanum = tanum;
        this.ta = ta;
    }
}
