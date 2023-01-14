create table project
(
    project_id     int identity
        constraint project_pk2
            primary key nonclustered,
    leader         int,
    project_number varchar(20),
    project_type   varchar(20),
    project_name   varchar(20),
    fund           float,
    begintime      date,
    endtime        date
)
go

create unique index project_project_id_uindex
    on project (project_id)
go

INSERT INTO master_manager.dbo.project (project_id, leader, project_number, project_type, project_name, fund, begintime, endtime) VALUES (1, 1, N'KC00001', N'国家自然科学基金项目', N'A研究', 6.2, N'2023-01-02', null);
INSERT INTO master_manager.dbo.project (project_id, leader, project_number, project_type, project_name, fund, begintime, endtime) VALUES (2, 1, N'KF00002', N'国家重点研发项目', N'B研究', 10, N'2022-04-13', null);
INSERT INTO master_manager.dbo.project (project_id, leader, project_number, project_type, project_name, fund, begintime, endtime) VALUES (3, 1, N'YF001', N'青年人才托举工程`', N'C研究', 5, N'2023-01-10', null);
INSERT INTO master_manager.dbo.project (project_id, leader, project_number, project_type, project_name, fund, begintime, endtime) VALUES (4, 1, N'test001', N'testType', N'testName', 99, N'2003-02-03', N'2023-02-03');
