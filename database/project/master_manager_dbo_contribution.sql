create table contribution
(
    contribution_id int identity
        constraint contribution_pk
            primary key nonclustered,
    project_id      int,
    userid          int,
    begintime       date,
    endtime         date,
    work            varchar(50),
    fund            float,
    leader_confirm  bit,
    teacher_confirm bit,
    submit          bit
)
go

create unique index contribution_contribution_id_uindex
    on contribution (contribution_id)
go

INSERT INTO master_manager.dbo.contribution (contribution_id, project_id, userid, begintime, endtime, work, fund, leader_confirm, teacher_confirm, submit) VALUES (1, 1, 190701404, N'2023-01-03', N'2023-02-03', N'前后端开发', 6, 1, 1, 1);
INSERT INTO master_manager.dbo.contribution (contribution_id, project_id, userid, begintime, endtime, work, fund, leader_confirm, teacher_confirm, submit) VALUES (2, 2, 190701404, N'2023-02-03', N'2023-03-03', N'前后端开发', 7, 0, 0, 0);
INSERT INTO master_manager.dbo.contribution (contribution_id, project_id, userid, begintime, endtime, work, fund, leader_confirm, teacher_confirm, submit) VALUES (3, 4, 190701404, N'2023-01-03', N'2023-03-03', N'前后端开发', 10, 0, 0, 0);
