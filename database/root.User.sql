USE [master_manager]
GO
/****** Object:  User [root]    Script Date: 2023/1/10 20:49:28 ******/
CREATE USER [root] FOR LOGIN [root] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [root]
GO
