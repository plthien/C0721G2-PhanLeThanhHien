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