drop database if exists quan_ly_ban_hang;
create database quan_ly_ban_hang;
use quan_ly_ban_hang;

create table customer(
id int auto_increment primary key,
`name` varchar(50),
age int
);

create table `order`(
id int auto_increment primary key,
buy_of_date date,
payment int,
customer_id int,

foreign key(customer_id) references customer(id)
);

create table product(
id int auto_increment primary key,
`name` varchar(50),
price int
);

create table order_detail(
order_id int,
product_id int,
quantity int,

primary key(order_id,product_id),
foreign key(order_id) references `order`(id),
foreign key(product_id) references product(id)
);

insert into customer(`name`, age)
values('Minh Quan',10),('Ngoc Oanh',20),('Hong Ha',50);

insert into `order`(buy_of_date,payment,customer_id)
values('2006-03-21',null,1),('2006-03-23',null,2),('2006-03-16',null,1);

insert into product(`name`,price)
values('May Giat',3),('Tu Lanh',5),('Dieu Hoa',7),('Quat',1),('Bep Dien',2);

insert into order_detail(order_id,product_id,quantity)
values(1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(2,5,4),(2,3,3);

select `order`.id, buy_of_date, payment from `order`;

select customer.id, customer.`name`, customer.age, product.`name` as product_name, order_detail.quantity
from customer
join `order` on customer.id = `order`.customer_id
join order_detail on `order`.id = order_detail.order_id
join product on order_detail.product_id = product.id;

-- lay ten khach hang khong mua bat ky sp nao
select c1.id, c1.`name`
from customer c1
where not exists( 
select * 
from customer c2
join `order` on c2.id = `order`.customer_id  and `order`.customer_id = c1.id
);

-- lay ten khach hang khong mua bat ky sp nao cach 2
select c1.id, c1.`name`
from customer c1
where c1.id not in ( 
select c2.id 
from customer c2 
join `order` on c2.id = `order`.customer_id
);
-- cách 3
select c.id, c.`name`
from customer c
left join `order` o on c.id = o.customer_id 
where o.id is null;

--  cách 4
select c.id, c.`name`
from customer c
where c.id not in (
  select `order`.customer_id 
  from `order`
  where customer_id is not null
);

select o.id as order_id, o.buy_of_date, sum(od.quantity*p.price) as payment
from `order` o
join order_detail od on o.id = od.order_id
join product p on od.product_id = p.id
group by o.id;