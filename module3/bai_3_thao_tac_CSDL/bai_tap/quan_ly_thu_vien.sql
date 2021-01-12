drop database if exists library_manager;

create database library_manager;

use library_manager;

create table sinh_vien (
id int primary key not null,
ten_sv varchar(30) not null,
ngay_sinh date not null,
lop varchar(10) not null,
email varchar(20) not null,
hinh_anh blob not null
);

create table dia_chi (
thanh_pho varchar(10) not null,
quan varchar(10),
phuong varchar(10),
id_sv int not null,
foreign key (id_sv) references sinh_vien(id)
);

create table trang_thai_the (
id int primary key not null,
trang_thai varchar(10)
);

create table the_thu_vien (
id int primary key not null,
id_sv int not null unique,
ngay_muon date not null,
ngay_tra date not null,
id_trang_thai int not null,
so_luong_muon int,
foreign key (id_sv) references sinh_vien(id),
foreign key (id_trang_thai) references trang_thai_the(id)
);

create table loai_sach (
id int primary key not null,
ten_loai_sach varchar(20) not null
);

create table sach (
id int primary key not null,
ten_sach varchar(30) not null,
so_luong int,
id_the_thu_vien int not null,
id_loai_sach int not null,
foreign key (id_loai_sach) references loai_sach(id),
foreign key (id_the_thu_vien) references the_thu_vien(id)
);