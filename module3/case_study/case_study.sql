drop database if exists furama_resort;

create database furama_resort;

use furama_resort;

create table vi_tri(
id_vi_tri int auto_increment primary key,
ten_vi_tri varchar(45)
);
create table trinh_do(
id_trinh_do int auto_increment primary key,
trinh_do varchar(45)
);
create table bo_phan(
id_bo_phan int auto_increment primary key,
ten_bo_phan varchar(45)
);
create table nhan_vien(
id_nhan_vien int auto_increment primary key,
ho_ten varchar(45),
id_vi_tri int,
id_trinh_do int,
id_bo_phan int,
ngay_sinh date,
so_cmtnd varchar(45),
luong decimal(9.2),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key (id_vi_tri) references vi_tri(id_vi_tri),
foreign key (id_trinh_do) references trinh_do(id_trinh_do),
foreign key (id_bo_phan) references bo_phan(id_bo_phan)
);

create table dich_vu_di_kem(
id_dich_vu_di_kem int auto_increment primary key,
ten_dich_vu_di_kem varchar(45),
gia decimal(6,2),
don_vi varchar(45),
trang_thai_kha_dung varchar(45)
);

create table loai_khach(
id_loai_khach int auto_increment primary key,
ten_loai_khach varchar(45)
);

create table khach_hang(
id_khach_hang int auto_increment primary key,
id_loai_khach int,
ho_ten varchar(45),
ngay_sinh date,
so_cmtnd varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key (id_loai_khach) references loai_khach(id_loai_khach)
);

create table loai_dich_vu(
id_loai_dich_vu int auto_increment primary key,
ten_loai_dich_vu varchar(45)
);

create table kieu_thue(
id_kieu_thue int auto_increment primary key,
ten_kieu_thue varchar(45),
gia decimal(6,2)
);

create table dich_vu(
id_dich_vu int auto_increment primary key,
ten_dich_vu varchar(45),
dien_tich int,
so_tang int,
so_nguoi_toi_da int,
chi_phi_thue decimal(6,2),
id_kieu_thue int,
id_loai_dich_vu int,
trang_thai varchar(45),
foreign key (id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu),
foreign key (id_kieu_thue) references kieu_thue(id_kieu_thue)
);

create table hop_dong(
id_hop_dong int auto_increment primary key,
id_nhan_vien int,
id_khach_hang int,
id_dich_vu int,
ngay_lam_hop_dong varchar(45),
ngay_ket_thuc varchar(45),
tien_dat_coc int,
tong_tien decimal(9,2),
foreign key (id_nhan_vien) references nhan_vien(id_nhan_vien),
foreign key (id_khach_hang) references khach_hang(id_khach_hang),
foreign key (id_dich_vu) references dich_vu(id_dich_vu)
);

create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet int auto_increment,
id_hop_dong int,
id_dich_vu_di_kem int,
so_luong int not null,
primary key (id_hop_dong_chi_tiet),
foreign key (id_hop_dong) references hop_dong(id_hop_dong),
foreign key (id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem)
);

-- task_1
-- thêm thông tin 

insert into vi_tri (ten_vi_tri)
values
('le_tan'),

('bao_ve'),

('phuc_vu'),

('chuyen_vien'),

('giam_sat'),

('quan_ly'),

('giam_doc');

insert into trinh_do(trinh_do)
values
('trung_cap'),

('cao_dang'),

('dai_hoc'),

('sau_dai_hoc');

insert into bo_phan(ten_bo_phan)
values
('sale_marketing'),

('an_ninh'),

('hanh_chinh'),

('phuc_vu'),

('quan_ly');

insert into nhan_vien(ho_ten,id_vi_tri,id_trinh_do,id_bo_phan,ngay_sinh,so_cmtnd,luong,sdt,email,dia_chi)
values
('tuan',4,3,1,'1995-12-12',0123456789,700,0123456789,'tuan@tuan.tuan','da_nang'),

('kien',4,3,1,'1991-2-2',0123456789,700,0123456789,'kien@kien.kien','nghe_an'),

('son',7,3,5,'1997-10-24',0321456789,1500,0321456789,'son@son.son','tay_ninh'),

('thanh',2,1,2,'1993-4-4',0123654789,300,0123654789,'thanh@thanh.thanh','quang_nam'),

('cao',6,4,5,'2000-1-1',0123456987,1000,0123456987,'cao@cao.cao','hue');

insert into loai_khach(ten_loai_khach)
values
('diamond'),

('platinium'),

('gold'),

('silver'),

('member');

insert into khach_hang(id_loai_khach,ho_ten,ngay_sinh,so_cmtnd,sdt,email,dia_chi)
values
(1,'dung','1996-1-1',0123456789,0123456789,'dung@dung.dung','nghe_an'),

(2,'thinh','1997-2-2',0321456789,0321456789,'thinh@thinh.thinh','quang_nam'),

(3,'phin','1998-3-3',0123654789,0123654789,'phin@phin.phin','da_nang'),

(1,'hai','2000-5-5',0123789456,0123789456,'hai@hai.hai','quang_nam'),

(1,'phin','1998-3-3',1234567898,0123456789,'phinkotex@phin.phin','quy_nhon'),

(4,'tung','1980-2-2',0123654789,0123654789,'tung@tung.tung','quang_nam');

insert into loai_dich_vu(ten_loai_dich_vu)
values
('villa'),

('house'),

('room');

insert into kieu_thue(ten_kieu_thue,gia)
values
('nam',100),

('thang',200),

('ngay',300),

('gio',400);

insert into dich_vu(ten_dich_vu,dien_tich,so_tang,so_nguoi_toi_da,chi_phi_thue,id_kieu_thue,id_loai_dich_vu,trang_thai)
values
('xanh',60,2,10,500,1,1,'con_phong'),

('trang',70,3,11,700,2,2,'con_phong'),

('do',80,4,12,750,3,3,null),

('hong',50,3,5,400,4,2,null),

('vang',50,4,5,300,1,3,'con_phong');

insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung)
values
('massage',10,'dollar','dang kha dung'),

('karaoke',20,'dollar','dang kha dung'),

('thuc_an',30,'dollar','dang kha dung'),

('nuoc_uong',40,'dollar','dang kha dung'),

('xe',50,'dollar','dang kha dung');

insert into hop_dong(id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc)
values
(1,3,5,'2020-8-8','2020-8-21',50),

(2,5,1,'2020-9-11','2020-9-21',100),

(2,1,1,'2020-10-12','2020-12-21',100),

(2,5 ,2,'2020-11-11','2020-11-21',50);

insert into hop_dong_chi_tiet(id_hop_dong,id_dich_vu_di_kem,so_luong)
values
(1,2,2),

(2,2,3),

(3,1,1),

(4,4,3);

-- task_2

select *
from nhan_vien
where (ho_ten like 'K%' or ho_ten like 'h%' or ho_ten like 't%') and length(ho_ten)<15;

-- task_3

select *
from khach_hang
where (curdate()- ngay_sinh > (18*30*365) and curdate()- ngay_sinh<(50*30*365))  and dia_chi in ('quang_nam','da_nang');

-- task_4

select khach_hang.ho_ten, count(hop_dong.id_hop_dong) as so_lan_dat_phong
from khach_hang
inner join hop_dong on khach_hang.id_khach_hang = hop_dong.id_khach_hang
where khach_hang.id_loai_khach = 1
group by khach_hang.id_khach_hang order by so_lan_dat_phong;

-- task_5
-- kết quả bị sai dù làm giống demo :((

select khach_hang.id_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach, hop_dong.id_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc,
dich_vu.ten_dich_vu,
sum(dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia) as tong_tien
from khach_hang
left join loai_khach on khach_hang.id_loai_khach= loai_khach.id_loai_khach
left join hop_dong on khach_hang.id_khach_hang= hop_dong.id_khach_hang
left join dich_vu on hop_dong.id_dich_vu=dich_vu.id_dich_vu
left join hop_dong_chi_tiet on hop_dong.id_hop_dong= hop_dong_chi_tiet.id_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem= dich_vu_di_kem.id_dich_vu_di_kem
group by hop_dong.id_hop_dong order by khach_hang.id_khach_hang;

select * from khach_hang;