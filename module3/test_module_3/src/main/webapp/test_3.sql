drop database if exists codegym;

create database codegym;

use codegym;

create table product (
product_id int auto_increment primary key,
product_name varchar(45) not null,
price int not null,
discount int not null,
stock int not null
);

create table employee (
employee_id int auto_increment primary key,
employee_name varchar(45) not null,
employee_birthday date not null,
employee_address varchar(45) not null
);

create table customer (
customer_id int auto_increment primary key,
customer_name varchar(45) not null,
customer_birthday date not null,
customer_phone varchar(45) not null,
customer_address varchar(45) not null,
customer_email varchar(45) not null
);

create table don_hang (
ma_don_hang int auto_increment primary key,
phuong_thuc_thanh_toan varchar(45) not null,
customer_id int not null,
employee_id int not null,
ngay_dat_hang date not null,
ngay_giao_hang date not null,
dia_chi_giao_hang varchar(45) not null,
san_pham int not null,
foreign key (san_pham) references product (product_id),
foreign key ( customer_id) references customer(customer_id),
foreign key( employee_id) references employee(employee_id)
);

insert into product (product_name,price,discount,stock)
value 
('tivi-toshiba',500,5,10),
('tivi-samsung',700,10,10),
('iphone-7',300,5,15),
('ipod-pro',250,10,20),
('samsung-s7',200,15,15),
('fan-asanyo',150,20,20),
('iphone-x',600,5,10),
('ipad-pro',350,5,15),
('tivi-aqua',500,5,10),
('iphone-12',600,5,10),
('iphone-11',400,5,15)
;

insert into employee (employee_name,employee_birthday,employee_address)
value 
('Kien','1991-01-01','Nghe An'),
('Tung','1994-01-01','Da Nang'),
('Thanh','1995-01-01','Quang Nam'),
('Dung','1996-01-01','Nghe An'),
('Long','1997-01-01','Hue'),
('Giang','1998-01-01','Quang Tri'),
('Ha','1990-01-01','Gia Lai'),
('Linh','1993-01-01','Da Nang'),
('Hai','1996-01-01','Da Nang'),
('Tien','2000-01-01','Binh Dinh')
;

insert into customer (customer_name,customer_birthday,customer_phone,customer_address,customer_email)
value
('Son','1997-10-24','0912345781','Tay Ninh','son@gamil.com'),
('Trang','1998-10-24','0912345999','Da Nang','trang@gamil.com'),
('Huy','2000-10-24','0912366666','Tay Ninh','huy@gamil.com'),
('Truong','1995-10-24','0912399999','Quang Tri','truong@gamil.com'),
('Thinh','1991-10-24','0912311111','Ha Noi','thinh@gamil.com'),
('Nguyen','1994-10-24','0912336365','Hoi An','nguyen@gamil.com'),
('Tuan','1992-10-24','0912312345','Ha Tinh','tuan@gamil.com'),
('Minh','1999-10-24','0912314125','Da Nang','minh@gamil.com'),
('Nhan','2001-10-24','0912342222','Da Nang','nhan@gamil.com'),
('Doan','2002-10-24','0912348888','Quang Nam','doan@gamil.com')
;

insert into don_hang (phuong_thuc_thanh_toan,customer_id,employee_id,ngay_dat_hang,ngay_giao_hang,dia_chi_giao_hang,san_pham)
value
('tien mat',1,2,'2021-01-01','2021-01-05','Da Nang',1),
('the',5,5,'2021-01-01','2021-01-05','Da Nang',2),
('tien mat',2,1,'2021-01-01','2021-01-05','Da Nang',3),
('tien mat',3,3,'2021-01-01','2021-01-05','Da Nang',4),
('tien mat',4,4,'2021-01-01','2021-01-05','Da Nang',5),
('tien mat',6,6,'2021-01-01','2021-01-05','Da Nang',6),
('the',7,7,'2021-01-01','2021-01-05','Da Nang',7),
('tien mat',8,8,'2021-01-01','2021-01-05','Da Nang',8),
('tien mat',9,9,'2021-01-01','2021-01-05','Da Nang',9),
('the',10,10,'2021-01-01','2021-01-05','Da Nang',10)
;