drop database if exists user_management;
create database user_management;

use user_management;
create table users (
 id  int(3) AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

insert into users(name, email, country) values('Neymar Jr','neymarjr@gmail.com','Brazil');
insert into users(name, email, country) values('NGolo Kante','kante@che.uk','Kenia');
insert into users(name, email, country) values('Cristiano Ronaldo','ronaldo@che.uk','Portugal');
insert into users(name, email, country) values('Lionel Messi','messi@gmail.com','Argentina');