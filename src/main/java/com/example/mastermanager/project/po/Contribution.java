package com.example.mastermanager.project.po;

import lombok.Data;

import java.sql.Date;

/*
* contribution表的持久化类
* */
@Data
public class Contribution {
    /*
    * 贡献表id
    * */
    private Integer cid;

    /*
    * 项目id
    * */
    private Integer pid;

    /*
    * 贡献人id
    * */
    private Integer uid;

    /*
    * 开始参与时间
    * */
    private Date begintime;

    /*
    * 结束参与时间
    * */
    private Date endtime;

    /*
    * 承担工作
    * */
    private String work;

    /*
    * 承担工作折合经费
    * */
    private Double fund;

    /*
    * 负责人是否签字确认
    * */
    private boolean leader;

    /*
    * 导师是否签字确认
    * */
    private boolean teacher;

    /*
    * 学生是否提交
    * */
    private boolean submit;
}
