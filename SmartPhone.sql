Create Database SmartPhone
GO

--tao bang login
Create Table Supplier(
	[SupplierId] [int] IDENTITY(1,1) NOT NULL primary key,
	[SupplierName] [nvarchar](300) 
)
GO
--tao bang login
create table [Login](
	[LoginID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[User] [nvarchar](70) NOT NULL,
	[Pass] [nvarchar](70) NOT NULL,
	[Gender] [nvarchar](70) NOT NULL, 
	[Birth] [date] NOT NULL,
	[Phone] [nvarchar](11),
	[Email] [nvarchar](100),
	[Admin] [bit] NOT NULL
)
GO
--tao bang Function
create table [Function](
	[FunctionId] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[FunctionName] [nvarchar](300) 
) 
GO
--tạo bang Categories
create table Categories(
	[CategorieID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[FunctionId] [int] FOREIGN KEY REFERENCES [Function]([FunctionId]),
	[CategorieName] [nvarchar](300) 
) 
GO
--tao bang product
create table Products(
	[ProductID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[ProductName] [nvarchar](300) NOT NULL,
	[SupplierId] [int] FOREIGN KEY REFERENCES Supplier([SupplierId]),
	[Quantity] [int],
	[Price] [money],
	[img] [nvarchar](2000),
)
GO
--tao bang detail quan he nhieu nhieu bảng Categories voi bang Product
create table Detail(
	[ProductID] [int] FOREIGN KEY REFERENCES Products([ProductID]),
	[CategorieID] [int] FOREIGN KEY REFERENCES Categories([CategorieID]),
	[FunctionId] [int] FOREIGN KEY REFERENCES [Function]([FunctionId]),
	[Description] [nvarchar](2000),
	PRIMARY KEY ([ProductID],[CategorieID],[FunctionId])
) 
GO
--tao bang shippers
create table [shippers](
	[shipperID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[shipperName] [nvarchar](300) NOT NULL,
)
GO
--tao bang order
create table [Order](
	[OrderID] [int] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[CustomerName] [nvarchar](300) NOT NULL,
	[LoginID] [int] FOREIGN KEY REFERENCES [Login]([LoginID]),
	[shipperID] [int] FOREIGN KEY REFERENCES [shippers]([shipperID]),
	[Address] [nvarchar](500) NOT NULL,
	[Phone] [nvarchar](11),
	[Orderdate] [date] NOT NULL,
	[ShippedDate] [date] NOT NULL,
)
GO
--tao bang order detail
create table [Orderdetail](
	[OrderID] [int] FOREIGN KEY REFERENCES [Order]([OrderID]),
	[ProductID] [int] FOREIGN KEY REFERENCES [Products]([ProductID]),
	[Quantity] [int],
	[Price] [money],
	PRIMARY KEY ([ProductID],[OrderID])
)
GO
--Du lieu bang login
insert into [Login]("User","Pass","Gender","Birth","Phone","Email","Admin") values (N'NguyenVanA', 'jqk', 'Male', N'1999-5-20','0926229735','nguyenvana@gmail.com',0)
insert into [Login]("User","Pass","Gender","Birth","Phone","Email","Admin") values (N'dunghdhe153770', 'hoangdung', 'Male', N'2001-10-11','0384886512','hoangdung@gmail.com',1)
--Du lieu bang supplier
GO
insert into Supplier(SupplierName) values (N'Apple')
insert into Supplier(SupplierName) values (N'SamSung')
insert into Supplier(SupplierName) values (N'OPPO')
insert into Supplier(SupplierName) values (N'ViVo')
insert into Supplier(SupplierName) values (N'Vsmart')
--Du lieu bang Function
GO
insert into [Function]([FunctionName]) values (N'Chức Năng')
insert into [Function]([FunctionName]) values (N'PIN')
insert into [Function]([FunctionName]) values (N'Màn hình')
insert into [Function]([FunctionName]) values (N'CHIP')
--Du lieu bang Categories
GO
insert into Categories([FunctionId],CategorieName) values (1,N'Bảo mật vân tay')
insert into Categories([FunctionId],CategorieName) values (1,N'Nhận diện khuôn mặt')
insert into Categories([FunctionId],CategorieName) values (1,N'Chống nước & bụi')
insert into Categories([FunctionId],CategorieName) values (1,N'Sạc nhanh')
insert into Categories([FunctionId],CategorieName) values (2,N'Dưới 3000 mah')
insert into Categories([FunctionId],CategorieName) values (2,N'Từ 3000 - 4000 mah')
insert into Categories([FunctionId],CategorieName) values (2,N'Trên 4000 mah')
insert into Categories([FunctionId],CategorieName) values (3,N'Dưới 6.0 inch')
insert into Categories([FunctionId],CategorieName) values (3,N'Trên 6.0 inch')
insert into Categories([FunctionId],CategorieName) values (4,N'Apple A')
insert into Categories([FunctionId],CategorieName) values (4,N'Exynos')
insert into Categories([FunctionId],CategorieName) values (4,N'Snapdragon')
insert into Categories([FunctionId],CategorieName) values (4,N'Spreadtrum')
insert into Categories([FunctionId],CategorieName) values (4,N'MediaTek Helio')
insert into Categories([FunctionId],CategorieName) values (4,N'MediaTek Dimensity')
insert into Categories([FunctionId],CategorieName) values (4,N'Helio')
--Du lieu bang Products
GO
insert into Products(ProductName,SupplierId,Quantity,Price,img) values (N'iPhone 11 64GB', 1, 20, '16,990,000', N'https://cdn1.viettelstore.vn/images/Product/ProductImage/medium/286885732.jpeg')
insert into Products(ProductName,SupplierId,Quantity,Price,img) values (N'iPhone 13 Pro Max 128GB', 1, 10, '30,690,000', N'https://cdn.tgdd.vn/Products/Images/42/230521/iphone-13-pro-sierra-blue-600x600.jpg')
--insert into Products(ProductName,SupplierId,Quantity,Price,img) values (N'OPPO A95', 3, 32, '6,990,000', N'https://cdn.tgdd.vn/Products/Images/42/251703/oppo-a95-4g-bac-2-600x600.jpg')
--insert into Products(ProductName,SupplierId,Quantity,Price,img) values (N'Samsung Galaxy Z Flip3 5G 128GB', 2, 12, '23,740,000', N'https://didongviet.vn/pub/media/catalog/product//s/a/samsung-galaxy-z-flip-3-green-didongviet.jpg')
--insert into Products(ProductName,SupplierId,Quantity,Price,img) values (N'Samsung Galaxy A52', 2, 30, '8,125,000', N'https://cdn.tgdd.vn/Products/Images/42/228967/samsung-galaxy-a52-8gb-256gb-thumb-violet-600x600-200x200.jpg')
--insert into Products(ProductName,SupplierId,Quantity,Price,img) values (N'Vsmart Aris Pro 8GB-128GB', 5, 13, '4,990,000', N'https://cdn.tgdd.vn/Products/Images/42/230413/vsmart-aris-xam-600x600-200x200.jpg')

--Du lieu bang Detail
GO
insert into Detail(ProductID,CategorieID,FunctionId,[Description]) values (1,10,4,N'Apple A13 Bionic')
insert into Detail(ProductID,CategorieID,FunctionId,[Description]) values (1,9,3,N'IPS LCD6.1"Liquid Retina')
insert into Detail(ProductID,CategorieID,FunctionId,[Description]) values (1,6,2,N'3110 mAh18 W')
insert into Detail(ProductID,CategorieID,FunctionId,[Description]) values (1,1,1,N'Bảo mật vân tay')
insert into Detail(ProductID,CategorieID,FunctionId,[Description]) values (1,2,1,N'Nhận diện khuôn mặt')
insert into Detail(ProductID,CategorieID,FunctionId,[Description]) values (1,3,1,N'Chống nước & bụi')
insert into Detail(ProductID,CategorieID,FunctionId,[Description]) values (1,4,1,N'Sạc nhanh')

insert into Detail(ProductID,CategorieID,FunctionId,[Description]) values (2,1,1,N'Bảo mật vân tay')
insert into Detail(ProductID,CategorieID,FunctionId,[Description]) values (2,2,1,N'Nhận diện khuôn mặt')
insert into Detail(ProductID,CategorieID,FunctionId,[Description]) values (2,3,1,N'Chống nước & bụi')
insert into Detail(ProductID,CategorieID,FunctionId,[Description]) values (2,4,1,N'Sạc nhanh')
insert into Detail(ProductID,CategorieID,FunctionId,[Description]) values (2,9,3,N'OLED6.7"Super Retina XDR')
insert into Detail(ProductID,CategorieID,FunctionId,[Description]) values (2,7,2,N'4352 mAh20 W')
insert into Detail(ProductID,CategorieID,FunctionId,[Description]) values (2,10,4,N'Apple A15 Bionic')

--Du lieu bang shippers
GO
insert into shippers(shipperName) values (N'Viettel Post')
insert into shippers(shipperName) values (N'Việt Nam Spot')
insert into shippers(shipperName) values (N'Giao Hàng Nhanh')
insert into shippers(shipperName) values (N'Giao Hàng Tiết Kiệm')
insert into shippers(shipperName) values (N'Kerry Express')
insert into shippers(shipperName) values (N'SShip')
insert into shippers(shipperName) values (N'Shipchung')
--select * from Detail where ProductID = 1
select * from [Function]
