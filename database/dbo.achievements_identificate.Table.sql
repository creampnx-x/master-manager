USE [master_manager]
GO
/****** Object:  Table [dbo].[achievements_identificate]    Script Date: 2023/1/10 20:49:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[achievements_identificate](
	[id] [int] NOT NULL,
	[sponsor] [int] NOT NULL,
	[achievements] [int] NOT NULL,
	[initial_status] [nchar](10) NULL,
	[finnal_status] [nchar](10) NULL,
 CONSTRAINT [PK_achievements_identificate] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
