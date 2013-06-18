USE [JavaJSF]
GO

/****** Object:  Table [dbo].[contato]    Script Date: 05/21/2013 08:19:20 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[contato](
	[idcontato] [int] IDENTITY(1,1) NOT NULL,
	[nome] [varchar](70) NULL,
	[email] [varchar](40) NULL,
	[telefone] [varchar](15) NULL
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO