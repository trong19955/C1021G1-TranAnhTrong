drop database if exists quan_ly_vat_tu;

create database quan_ly_vat_tu;

use quan_ly_vat_tu;

create table phieu_xuat(
so_px int primary key,
ngay_xuat date
);

create table vat_tu(
ma_vat_tu int primary key,
ten_vt varchar(50)
);

create table phieu_nhap(
so_pn int primary key,
ngay_nhap date
);
create table sdt(
ma_sdt int primary key,
sdt varchar(50)
);
create table nha_cung_cap(
ma_ncc int primary key,
ten_ncc varchar(50),
dia_chi varchar(50),
ma_sdt int,
foreign key (ma_sdt) references sdt(ma_sdt)
);
create table vattu_px(
so_px int,
ma_vat_tu int,
don_gia_xuat varchar(50),
sl_xuat varchar(50),
primary key (so_px, ma_vat_tu),
foreign key (so_px) references phieu_xuat(so_px),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);
create table vattu_pn(
ma_vat_tu int,
so_pn int,
don_gia_nhap varchar(50),
sl_nhap varchar(50),
primary key (so_pn, ma_vat_tu),
foreign key (so_pn) references phieu_nhap(so_pn),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);

create table don_dh(
so_dh int primary key,
ngay_dh varchar(50),
ma_ncc int,
foreign key (ma_ncc) references nha_cung_cap(ma_ncc)
);
create table vattu_dondh(
so_dh int,
ma_vat_tu int,
primary key (so_dh, ma_vat_tu),
foreign key (so_dh) references don_dh(so_dh),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
); 