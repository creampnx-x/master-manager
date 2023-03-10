USE [master_manager]
GO
/****** Object:  Table [dbo].[master_achievements]    Script Date: 2023/1/10 20:49:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[master_achievements](
	[id] [int] NOT NULL,
	[paper] [int] NULL,
	[textbook] [varchar](50) NULL,
	[standard] [varchar](50) NULL,
	[patent] [varchar](50) NULL,
	[report] [varchar](50) NULL,
	[dev_certificate] [varchar](50) NULL,
 CONSTRAINT [PK_master_achievements] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
