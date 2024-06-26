USE [buoi_1_SPB]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 5/6/2024 9:48:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[id] [int] NOT NULL,
	[maNV] [nchar](10) NULL,
	[tenNV] [nvarchar](max) NULL,
	[diaChi] [nvarchar](max) NULL,
	[gioiTinh] [nvarchar](max) NULL,
	[phongBan] [int] NULL,
	[chucVu] [nvarchar](max) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhongBan]    Script Date: 5/6/2024 9:48:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhongBan](
	[id] [int] NOT NULL,
	[maPB] [nchar](10) NULL,
	[tenPB] [nchar](10) NULL,
 CONSTRAINT [PK_PhongBan] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_PhongBan] FOREIGN KEY([phongBan])
REFERENCES [dbo].[PhongBan] ([id])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_PhongBan]
GO
-- Chèn dữ liệu cho bảng PhongBan
INSERT INTO [dbo].[PhongBan] ([id], [maPB], [tenPB])
VALUES (1, N'PB001', N'Phòng A'),
       (2, N'PB002', N'Phòng B'),
       (3, N'PB003', N'Phòng C');
GO
-- Chèn dữ liệu cho bảng NhanVien
INSERT INTO [dbo].[NhanVien] ([id], [maNV], [tenNV], [diaChi], [gioiTinh], [phongBan], [chucVu])
VALUES (1, N'NV001', N'Nguyễn Văn A', N'Hà Nội', N'Nam', 1, N'Nhân viên'),
       (2, N'NV002', N'Trần Thị B', N'Hồ Chí Minh', N'Nữ', 2, N'Nhân viên'),
       (3, N'NV003', N'Lê Văn C', N'Đà Nẵng', N'Nam', 3, N'Trưởng phòng'),
       (4, N'NV004', N'Phạm Thị D', N'Hải Phòng', N'Nữ', 1, N'Nhân viên'),
       (5, N'NV005', N'Hoàng Văn E', N'Cần Thơ', N'Nam', 2, N'Nhân viên'),
       (6, N'NV006', N'Mai Thị F', N'Hà Tĩnh', N'Nữ', 3, N'Nhân viên'),
       (7, N'NV007', N'Trần Văn G', N'Quảng Ninh', N'Nam', 1, N'Nhân viên'),
       (8, N'NV008', N'Nguyễn Thị H', N'Hải Dương', N'Nữ', 2, N'Nhân viên'),
       (9, N'NV009', N'Hồ Văn I', N'Bắc Giang', N'Nam', 3, N'Nhân viên'),
       (10, N'NV010', N'Đỗ Thị K', N'Nam Định', N'Nữ', 1, N'Nhân viên');
SELECT * FROM NhanVien
SELECT * FROM PhongBan