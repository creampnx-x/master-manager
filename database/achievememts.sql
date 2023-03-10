USE [master]
GO
/****** Object:  Database [master_manager]    Script Date: 2023/1/14 12:02:05 ******/
CREATE DATABASE [master_manager]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'master_manager', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\master_manager.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'master_manager_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\master_manager_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [master_manager] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [master_manager].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [master_manager] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [master_manager] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [master_manager] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [master_manager] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [master_manager] SET ARITHABORT OFF 
GO
ALTER DATABASE [master_manager] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [master_manager] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [master_manager] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [master_manager] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [master_manager] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [master_manager] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [master_manager] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [master_manager] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [master_manager] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [master_manager] SET  DISABLE_BROKER 
GO
ALTER DATABASE [master_manager] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [master_manager] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [master_manager] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [master_manager] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [master_manager] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [master_manager] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [master_manager] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [master_manager] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [master_manager] SET  MULTI_USER 
GO
ALTER DATABASE [master_manager] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [master_manager] SET DB_CHAINING OFF 
GO
ALTER DATABASE [master_manager] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [master_manager] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [master_manager] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [master_manager] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [master_manager] SET QUERY_STORE = OFF
GO
USE [master_manager]
GO
/****** Object:  User [root]    Script Date: 2023/1/14 12:02:05 ******/
CREATE USER [root] FOR LOGIN [root] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [root]
GO
/****** Object:  Table [dbo].[achievements_identificate]    Script Date: 2023/1/14 12:02:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[achievements_identificate](
	[id] [int] NOT NULL,
	[sponsor] [int] NOT NULL,
	[achievements] [int] NOT NULL,
	[initial_status] [nchar](10) NULL,
	[final_status] [nchar](10) NULL,
	[mentor] [int] NULL,
	[user_type] [varchar](50) NULL,
 CONSTRAINT [PK_achievements_identificate] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[doctor_achievements]    Script Date: 2023/1/14 12:02:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[doctor_achievements](
	[id] [int] NOT NULL,
	[paper] [int] NULL,
	[prize] [int] NULL,
	[standard] [varchar](50) NULL,
	[others] [varchar](50) NULL,
 CONSTRAINT [PK_doctor_achievements] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[master_achievements]    Script Date: 2023/1/14 12:02:05 ******/
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
/****** Object:  Table [dbo].[paper]    Script Date: 2023/1/14 12:02:05 ******/
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
/****** Object:  Table [dbo].[prize]    Script Date: 2023/1/14 12:02:05 ******/
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
USE [master]
GO
ALTER DATABASE [master_manager] SET  READ_WRITE 
GO
