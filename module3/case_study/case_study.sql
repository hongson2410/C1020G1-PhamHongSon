create database furama_resort;
-- drop database furama_resort;

use furama_resort;

create table vi_tri(
id_vi_tri int,
ten_vi_tri varchar(45)
);

create table trinh_do(
id_trinh_do int,
trinh_do varchar(45)
);

create table bo_phan(
id_bo_phan int,
ten_bo_phan varchar(45)
);

create table nhan_vien(
id_nhan_vien int,
ho_ten varchar(45),
id_vi_tri int,
id_trinh_do int,
id_bo_phan int,
ngay_sinh date,
so_cmtnd varchar(45),
luong decimal(9.2),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45)
);

create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet int,
id_hop_dong int,
id_dich_vu_di_kem int,
so_luong int
);

create table dich_vu_di_kem(
id_dich_vu_di_kem int,
ten_dich_vu_di_kem varchar(45),
gia decimal(6,2),
don_vi varchar(45),
trang_thai_kha_dung varchar(45)
);

create table hop_dong(
id_hop_dong int,
in_nhan_vien int,
id_khach_hang int,
id_dich_vu int,
ngay_lam_hop_dong varchar(45),
ngay_ket_thuc varchar(45),
tien_dat_coc int,
tong_tien decimal(9,2)
);

create table khach_hang(
id_khach_hang int,
id_loai_khach int,
ho_ten varchar(45),
ngay_sinh date,
so_cmtnd varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45)
);

create table dich_vu(
id_dich_vu int,
ten_dich_vu varchar(45),
dien_tich int,
so_tang int,
so_nguoi_toi_da int,
chi_phi_thue decimal(6,2),
id_kieu_thue varchar(45),
id_loai_dich_vu int,
trang_thai varchar(45)
);

create table loai_dich_vu(
id_loai_dich_vu int,
ten_loai_dich_vu varchar(45)
);

create table kieu_thue(
id_kieu_thue int,
ten_kieu_thue varchar(45),
gia decimal(6,2)
);

create table loai_khach(
id_loai_khach int,
ten_loai_khach varchar(45)
);

insert into bo_phan
values 
(1,'le_tan'),
(2,'an_ninh');

select * from bo_phan;
