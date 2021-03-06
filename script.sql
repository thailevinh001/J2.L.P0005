USE [motorcyleManagement]
GO
/****** Object:  Table [dbo].[tblBike]    Script Date: 5/31/2021 12:24:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblBike](
	[motocyleID] [varchar](10) NOT NULL,
	[model] [nvarchar](50) NULL,
	[year] [nvarchar](50) NULL,
	[condition] [varchar](50) NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
	[warranty] [nvarchar](50) NULL,
	[brandID] [varchar](10) NULL,
 CONSTRAINT [PK_tblBike] PRIMARY KEY CLUSTERED 
(
	[motocyleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblBrand]    Script Date: 5/31/2021 12:24:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblBrand](
	[brandID] [varchar](10) NOT NULL,
	[brandName] [nvarchar](50) NULL,
	[country] [nvarchar](50) NULL,
	[description] [nvarchar](200) NULL,
 CONSTRAINT [PK_tblBrand] PRIMARY KEY CLUSTERED 
(
	[brandID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 5/31/2021 12:24:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUser](
	[userID] [varchar](10) NOT NULL,
	[fullName] [nvarchar](50) NULL,
	[password] [varchar](50) NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_tblUser] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblBike] ([motocyleID], [model], [year], [condition], [price], [quantity], [warranty], [brandID]) VALUES (N'001', N'1', N'2021', N'New', 1000, 1, N'1', N'001')
INSERT [dbo].[tblBike] ([motocyleID], [model], [year], [condition], [price], [quantity], [warranty], [brandID]) VALUES (N'002', N'2', N'2020', N'New', 2000, 2, N'2', N'002')
GO
INSERT [dbo].[tblBrand] ([brandID], [brandName], [country], [description]) VALUES (N'001', N'HONDA', N'Japan', N'Good')
INSERT [dbo].[tblBrand] ([brandID], [brandName], [country], [description]) VALUES (N'002', N'YAMAHA', N'Japan', N'Good')
INSERT [dbo].[tblBrand] ([brandID], [brandName], [country], [description]) VALUES (N'003', N'VIN-FAST', N'VietNam', N'Good')
INSERT [dbo].[tblBrand] ([brandID], [brandName], [country], [description]) VALUES (N'004', N'LEXUS', N'Japan', N'Good')
GO
INSERT [dbo].[tblUser] ([userID], [fullName], [password], [status]) VALUES (N'sa', N'Le Vinh Thai', N'1234', 1)
GO
