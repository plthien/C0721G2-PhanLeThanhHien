drop database if exists t_complex_management;
create database t_complex_management;
use t_complex_management;

create table trang_thai(
id int auto_increment primary key,
ten_trang_thai varchar(15)
);

create table tang(
id int auto_increment primary key,
ten_tang varchar(5)
);

create table loai_mat_bang(
id int auto_increment primary key,
ten_loai_mat_bang varchar(60) 

);

create table mat_bang(
id varchar(45) primary key,
dien_tich double,
gia_tien double,
ngay_bat_dau date,
ngay_ket_thuc date,
id_trang_thai int,
id_tang int,
id_loai_mat_bang int,
kha_dung int default 1,

foreign key(id_trang_thai) references trang_thai(id),
foreign key(id_tang) references tang(id),
foreign key(id_loai_mat_bang) references loai_mat_bang(id)

);

insert into trang_thai(ten_trang_thai) values('Trống');
insert into trang_thai(ten_trang_thai) values('Hạ tầng');
insert into trang_thai(ten_trang_thai) values('Đầy đủ');

insert into tang(ten_tang) values('1');
insert into tang(ten_tang) values('2');
insert into tang(ten_tang) values('3');
insert into tang(ten_tang) values('4');
insert into tang(ten_tang) values('5');
insert into tang(ten_tang) values('6');
insert into tang(ten_tang) values('7');
insert into tang(ten_tang) values('8');
insert into tang(ten_tang) values('9');
insert into tang(ten_tang) values('10');
insert into tang(ten_tang) values('11');
insert into tang(ten_tang) values('12');
insert into tang(ten_tang) values('13');
insert into tang(ten_tang) values('14');
insert into tang(ten_tang) values('15');

insert into loai_mat_bang(ten_loai_mat_bang) values('Văn phòng chia sẻ');
insert into loai_mat_bang(ten_loai_mat_bang) values('Văn phòng trọn gói');

insert into mat_bang(id,dien_tich,gia_tien,ngay_bat_dau,ngay_ket_thuc,id_trang_thai,id_tang,id_loai_mat_bang) 
	values('MB1-11-11',200,1200000,'2021-01-10','2021-11-11',1,1,1);

delimiter //
create procedure liet_ke_mat_bang()
begin
	select m.id, m.dien_tich, m.gia_tien, date_format(m.ngay_bat_dau,'%d/%m/%Y') as ngay_bat_dau ,date_format(m.ngay_ket_thuc,'%d/%m/%Y') as ngay_ket_thuc , tt.ten_trang_thai, t.ten_tang, l.ten_loai_mat_bang
    from mat_bang m
		join trang_thai tt on tt.id = m.id_trang_thai
        join tang t on t.id = m.id_tang
        join loai_mat_bang l on l.id = m.id_loai_mat_bang
	where m.kha_dung = 1
    order by m.dien_tich asc;
    
end;
// delimiter ;