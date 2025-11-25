CREATE DATABASE QlyStore;
use QlyStore;

CREATE TABLE admin (
                       id_admin int primary key  auto_increment,
                       username varchar(100) not null unique,
                       password varchar(100) not null
);

create table sanpham (
                         idsanpham int primary key auto_increment,
                         tensanpham varchar(100)not null ,
                         thuonghieu varchar(100),
                         gia decimal(15, 2) not null,
                         soluong int default 0,
                         mota text
);

create table khachhang (
                           idkhachhang int primary key auto_increment,
                           tenkhachhang varchar(100) not null,
                           sodienthoai varchar(15),
                           diachi varchar(300)
);

create table hoadon (
                        idhoadon int primary key auto_increment,
                        idkhachhang int not null,
                        ngay date not null,
                        tongtien decimal,
                        foreign key (idkhachhang) references khachhang(idkhachhang)
);

create table chitiethoadon (
                               idchitieithoadon int primary key auto_increment,
                               idhoadon int not null,
                               idsanpham int not null,
                               soluong int not null,
                               gia decimal(15, 2) not null,
                               foreign key (idhoadon) references hoadon(idhoadon),
                               foreign key (idsanpham) references sanpham(idsanpham)
);

insert into admin (username, password) values
                                           ('chumanhquynh', '2509'),
                                           ('cmq', '123');

insert into sanpham (tensanpham, thuonghieu, gia, soluong, mota) values
                                                                     ('iPhone 14 Pro Max', 'Apple', 28990000, 20, 'Điện thoại cao cấp Apple'),
                                                                     ('iPhone 13', 'Apple', 18990000, 15, 'iPhone 13 bản tiêu chuẩn'),
                                                                     ('Samsung Galaxy S23 Ultra', 'Samsung', 24990000, 18, 'Flagship Samsung'),
                                                                     ('Xiaomi 13T', 'Xiaomi', 10990000, 25, 'Điện thoại hiệu năng cao'),
                                                                     ('OPPO Reno8', 'OPPO', 8990000, 30, 'Camera đẹp, pin tốt'),
                                                                     ('Vivo V25', 'Vivo', 7990000, 28, 'Thiết kế đẹp, chụp ảnh tốt'),
                                                                     ('Nokia G21', 'Nokia', 3990000, 40, 'Pin trâu, bền'),
                                                                     ('Realme 11 Pro', 'Realme', 9990000, 22, 'Màn cong đẹp'),
                                                                     ('Asus ROG Phone 6', 'Asus', 20990000, 10, 'Điện thoại gaming'),
                                                                     ('Samsung A54', 'Samsung', 8990000, 35, 'Tầm trung nổi bật');

INSERT INTO khachhang (tenkhachhang, sodienthoai, diachi) VALUES
                                                              ('Nguyễn Văn A', '0901123456', 'Hà Nội'),
                                                              ('Trần Thị B', '0902234567', 'Hồ Chí Minh'),
                                                              ('Lê Văn C', '0903345678', 'Đà Nẵng'),
                                                              ('Phạm Thị D', '0904456789', 'Hải Phòng'),
                                                              ('Hoàng Văn E', '0905567890', 'Cần Thơ'),
                                                              ('Ngô Thị F', '0906678901', 'Huế'),
                                                              ('Đỗ Văn G', '0907789012', 'Quảng Ninh'),
                                                              ('Vũ Thị H', '0908890123', 'Bình Dương'),
                                                              ('Bùi Văn I', '0909901234', 'Nha Trang'),
                                                              ('Phan Thị K', '0910012345', 'Vũng Tàu');

INSERT INTO khachhang (tenkhachhang, sodienthoai, diachi) VALUES
                                                              ('Nguyễn Văn A', '0901123456', 'Hà Nội'),
                                                              ('Trần Thị B', '0902234567', 'Hồ Chí Minh'),
                                                              ('Lê Văn C', '0903345678', 'Đà Nẵng'),
                                                              ('Phạm Thị D', '0904456789', 'Hải Phòng'),
                                                              ('Hoàng Văn E', '0905567890', 'Cần Thơ'),
                                                              ('Ngô Thị F', '0906678901', 'Huế'),
                                                              ('Đỗ Văn G', '0907789012', 'Quảng Ninh'),
                                                              ('Vũ Thị H', '0908890123', 'Bình Dương'),
                                                              ('Bùi Văn I', '0909901234', 'Nha Trang'),
                                                              ('Phan Thị K', '0910012345', 'Vũng Tàu');

INSERT INTO hoadon (idkhachhang, ngay, tongtien) VALUES
                                                     (1, '2025-01-01', 28990000),
                                                     (2, '2025-01-02', 18990000),
                                                     (3, '2025-01-03', 24990000),
                                                     (4, '2025-01-04', 10990000),
                                                     (5, '2025-01-05', 8990000),
                                                     (6, '2025-01-06', 7990000),
                                                     (7, '2025-01-07', 3990000),
                                                     (8, '2025-01-08', 9990000),
                                                     (9, '2025-01-09', 20990000),
                                                     (10, '2025-01-10', 8990000);

INSERT INTO chitiethoadon (idhoadon, idsanpham, soluong, gia) VALUES
                                                                  (1, 1, 1, 28990000),
                                                                  (2, 2, 1, 18990000),
                                                                  (3, 3, 1, 24990000),
                                                                  (4, 4, 1, 10990000),
                                                                  (5, 5, 1, 8990000),
                                                                  (6, 6, 1, 7990000),
                                                                  (7, 7, 1, 3990000),
                                                                  (8, 8, 1, 9990000),
                                                                  (9, 9, 1, 20990000),
                                                                  (10, 10, 1, 8990000);

select * from admin;
select * from sanpham;
select * from khachhang;
select * from hoadon;
select * from chitiethoadon;