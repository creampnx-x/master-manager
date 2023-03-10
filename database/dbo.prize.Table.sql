USE [master_manager]
GO
/****** Object:  Table [dbo].[prize]    Script Date: 2023/1/10 20:49:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[prize](
	[id] [int] NOT NULL,
	[name] [nchar](10) NULL,
	[prize_level] [nchar](10) NULL,
	[awards_rank] [nchar](10) NULL,
	[rank] [nchar](10) NULL,
	[time] [date] NULL,
	[resource] [varchar](50) NULL,
 CONSTRAINT [PK_prize] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
