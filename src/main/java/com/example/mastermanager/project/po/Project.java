package com.example.mastermanager.project.po;

import lombok.Data;

import java.sql.Date;

/*
* project表的持久化类
* */
@Data
public class Project {
    /*
    * 项目id
    * */
    private Integer pid;

    /*
    * 负责人id
    * */
    private Integer leader;

    /*
    * 项目编号
    * */
    private String pnum;

    /*
    * 项目类型
    * */
    private String ptype;

    /*
    * 项目名称
    * */
    private String pname;

    /*
    * 项目经费
    * */
    private Double fund;

    /*
    * 项目开始时间
    * */
    private Date begintime;

    /*
    * 项目结束时间
    * */
    private Date endtime;
}
