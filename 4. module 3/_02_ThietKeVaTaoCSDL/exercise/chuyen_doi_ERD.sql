drop database if exists quan_ly_xuat_nhap;
create database quan_ly_xuat_nhap;
use quan_ly_xuat_nhap;

create table phieu_xuat(
so_phieu_xuat int auto_increment primary key,
ngay_xuat date
);

create table vat_tu(
ma_vat_tu int auto_increment primary key,
ten_vat_tu varchar(50)
);

create table phieu_nhap(
so_phieu_nhap int auto_increment primary key,
ngay_nhap date
);

create table so_dien_thoai_nha_cc(
ma_sdt int auto_increment primary key,
so_dien_thoai varchar(10)
);

create table nha_cung_cap(
ma_nha_cc int primary key,
ten_nha_cc varchar(50),
dia_chi varchar(50),
ma_sdt int,

foreign key (ma_sdt) references so_dien_thoai_nha_cc(ma_sdt)
);

create table don_dat_hang(
so_dat_hang int auto_increment primary key,
ngay_dat_hang date,
ma_nha_cc int,

foreign key (ma_nha_cc) references nha_cung_cap (ma_nha_cc)
);

create table chi_tiet_phieu_xuat(
so_phieu_xuat int,
ma_vat_tu int,
don_gia_xuat int,
so_luong int,

primary key(so_phieu_xuat,ma_vat_tu),
foreign key (so_phieu_xuat) references phieu_xuat(so_phieu_xuat),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);

create table chi_tiet_phieu_nhap(
so_phieu_nhap int,
ma_vat_tu int,
don_gia_nhap int,
so_luong int,

primary key(so_phieu_nhap,ma_vat_tu),
foreign key (so_phieu_nhap) references phieu_nhap(so_phieu_nhap),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);

create table chi_tiet_don_dat_hang(
ma_vat_tu int,
so_dat_hang int,

primary key(ma_vat_tu,so_dat_hang),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key(so_dat_hang) references don_dat_hang(so_dat_hang)
);
