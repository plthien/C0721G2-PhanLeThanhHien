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

delimiter //
create procedure get_user_by_id(in user_id int)
begin
	select `name`, email, country
    from users u
    where u.id = user_id;
end;
// delimiter ;

delimiter //
create procedure insert_user(in user_name varchar(120), in user_email varchar(120), in user_country varchar(120))
begin
	insert into users(`name`, email, country)
    values(user_name, user_email, user_country);
end;
// delimiter ;

create table Permision(

id int(11) primary key,

name varchar(50)

);

create table User_Permision(

permision_id int(11),

user_id int(11)

);

insert into Permision(id, name) values(1, 'add');

insert into Permision(id, name) values(2, 'edit');

insert into Permision(id, name) values(3, 'delete');

insert into Permision(id, name) values(4, 'view');