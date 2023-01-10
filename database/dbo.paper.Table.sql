USE [master_manager]
GO
/****** Object:  Table [dbo].[paper]    Script Date: 2023/1/10 20:49:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[paper](
	[id] [int] NOT NULL,
	[name] [varchar](50) NOT NULL,
	[publication] [varchar](50) NULL,
	[status] [varchar](50) NULL,
	[index_type] [varchar](50) NULL,
	[time] [date] NULL,
	[repo] [varchar](50) NULL,
	[resource] [varchar](50) NULL,
 CONSTRAINT [PK_paper] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
