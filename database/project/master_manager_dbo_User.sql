create table [User]
(
    userid   int not null
        constraint user_pk
            primary key nonclustered,
    realname varchar(20),
    username varchar(20),
    password varchar(20),
    subject  varchar(20),
    roleid   int
)
go

create unique index user_userid_uindex
    on [User] (userid)
go

INSERT INTO master_manager.dbo.[User] (userid, realname, username, password, subject, roleid) VALUES (190701404, N'郭云帆', N'tilamisu', N'111111', N'计算机科学与技术', 5);
INSERT INTO master_manager.dbo.[User] (userid, realname, username, password, subject, roleid) VALUES (200607611, N'张三', N'zs', N'123456', N'信息', 6);
INSERT INTO master_manager.dbo.[User] (userid, realname, username, password, subject, roleid) VALUES (2, N'王五', N'wangwu', N'111111', N'木材科学与工程', 1);
INSERT INTO master_manager.dbo.[User] (userid, realname, username, password, subject, roleid) VALUES (3, N'赵六', N'zhaoliu', N'1231', N'金融', 1);
INSERT INTO master_manager.dbo.[User] (userid, realname, username, password, subject, roleid) VALUES (1, N'李四', N'lisi', N'111111', N'材料', 4);
