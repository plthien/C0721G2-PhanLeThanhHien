drop database if exists demo;
create database demo;
use demo;

create table products(
id int auto_increment primary key,
product_code varchar(10),
product_name varchar(45),
product_price double,
product_amount int,
product_description varchar(70),
product_status varchar(20)

);

insert into products(product_code,product_name,product_price,product_amount,product_description,product_status)
values('IP13PRM','Iphone 13 Pro max',1500,100,'Dien thoai iphone 13 pro max','Available');

insert into products(product_code,product_name,product_price,product_amount,product_description,product_status)
values('IP13MN','Iphone 13 Mini',1000,120,'Dien thoai iphone 13 mini','Available');

insert into products(product_code,product_name,product_price,product_amount,product_description,product_status)
values('IP13PR','Iphone 13 Pro',1200,110,'Dien thoai iphone 13 Pro','Available');

insert into products(product_code,product_name,product_price,product_amount,product_description,product_status)
values('IP12PRM','Iphone 12 Pro max',1200,200,'Dien thoai iphone 12 Pro Max','Available');

insert into products(product_code,product_name,product_price,product_amount,product_description,product_status)
values('IP12MN','Iphone 12 Mini',700,80,'Dien thoai iphone 12 mini','Available');

insert into products(product_code,product_name,product_price,product_amount,product_description,product_status)
values('IP12PR','Iphone 12 Pro',900,90,'Dien thoai iphone 12 Pro','Available');

explain select *
from products
where product_code = 'IP12PR';

create unique index index_product_code on products(product_code);
drop index index_product_code on products;

explain select *
from products
where product_code = 'IP12PR';

explain select *
from products
where product_name = 'Iphone 12 Pro max';

create unique index index_product_name_price on products(product_name,product_price);
drop index index_product_name_price on products;

explain select *
from products
where product_price = 700 and product_name = 'Iphone 12 Mini';

create view view_product as
select product_code, product_name, product_price, product_status
from products;

create or replace view view_product as
select product_code, product_name, product_price, product_status
from products
where product_code like '%13%'; 

drop view view_product;

delimiter //
create procedure get_product()
begin 
	select *
	from products;
end;
// delimiter ;

call get_product();

drop procedure if exists get_product

delimiter //
create procedure add_product(product_code_v varchar(10),product_name_v varchar(45),
							product_price_v double,product_amount_v int,product_description_v varchar(70),
                            product_status_v varchar(20))
begin
	insert into products(product_code,product_name,product_price,product_amount,product_description,product_status)
	values(product_code_v,product_name_v,product_price_v,product_amount_v,product_description_v,product_status_v);
end;
// delimiter ;

call add_product('IP11PRM','Iphone 11 Pro Max',700,40,'Dien thoai Iphone 11 pro max','Available')
delimiter //
create procedure modify_product(product_id_v int, product_code_v varchar(10),product_name_v varchar(45),
							product_price_v double,product_amount_v int,product_description_v varchar(70),
                            product_status_v varchar(20) )
begin
	update products
    set product_code = product_code_v, product_name = product_name_v, product_price = product_price_v,
		product_amount = product_amount_v, product_description = product_description_v, product_status = product_status_v
	where id = product_id_v;
end;
// delimiter ;
call modify_product(3,'IP13PR','Iphone 13 Pro',1000,90,'Dien thoai iphone 13 Pro','Available');

delimiter //
create procedure remove_product(product_id int)
begin
	delete from products
    where id = product_id;
end;
// delimiter ;

call remove_product(3);