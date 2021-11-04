drop database if exists Furama_Resort_Management;
create database Furama_Resort_Management;
use Furama_Resort_Management;


create table degree(
id int auto_increment primary key,
degree_name varchar(20)
);

create table office(
id int auto_increment primary key,
office_name varchar(20)
);

create table department(
id int auto_increment primary key,
department_name varchar(20)
);

create table employee(
id int auto_increment primary key,
`name` varchar(45),
birthday date,
gender varchar(10),
personal_id varchar(20),
phone_number varchar(10),
email varchar(45),
salary double,
degree_id int,
office_id int,
department_id int,
address varchar(120),
`status` int default 1,

foreign key(degree_id) references degree(id),
foreign key(office_id) references office(id),
foreign key(department_id) references department(id)

);

create table customer_type(
id int auto_increment primary key,
customer_type_name varchar(20)
);

create table customer(
id varchar(10) primary key,
`name` varchar(45),
birthday date,
gender varchar(10),
personal_id varchar(20),
phone_number varchar(10),
email varchar(45),
customer_type_id int,
address varchar(45),
`status` int default 1,

foreign key(customer_type_id) references customer_type(id)
);

create table renting_by(
id int auto_increment primary key,
renting_by_name enum('Year','Month','Day','Hour')
);

create table service_type(
id int auto_increment primary key,
service_type_name varchar(45) 
);

create table facility(
id varchar(10) primary key,
`name` varchar(120),
usable_area double,
number_of_floors int,
cost double,
customer_max int,
renting_by_id int,
service_type_id int,
`status` int default 1,

foreign key(renting_by_id) references renting_by(id),
foreign key(service_type_id) references service_type(id)
);

create table extra_service(
id int auto_increment primary key,
`name` varchar(45),
price double,
unit varchar(45),
`status` int default 1
);

create table contract(
id int auto_increment primary key,
customer_id varchar(10),
employee_id int,
facility_id varchar(10),
check_in_date date,
check_out_date date,
deposit double,
payment double,
`status` int default 1,

foreign key(customer_id) references customer(id),
foreign key(employee_id) references employee(id),
foreign key(facility_id) references facility(id)

);

create table contract_detail(
id int auto_increment primary key,
contract_id int,
extra_service_id int,
quantity int,
`status` int default 1,

foreign key(contract_id) references contract(id),
foreign key(extra_service_id) references extra_service(id)

);

delimiter //
create procedure get_all_employee()
begin
	select e.id, e.`name`, e.gender, e.birthday, e.email, e.address, e.personal_id, e.phone_number, e.salary, d.degree_name, o.office_name, dp.department_name 
    from employee e 
		join degree d on e.degree_id = d.id 
        join office o on e.office_id = o.id
        join department dp on e.department_id = dp.id
	where e.`status` = 1;
end;
// delimiter ;

delimiter //
create procedure get_employee_by_id(in p_id int)
begin
	select e.id, e.`name`, e.gender, e.birthday, e.email, e.address, e.personal_id, e.phone_number, e.salary, e.degree_id, e.office_id, e.department_id
    from employee e 
	where e.id = p_id and e.`status` = 1;
end;
// delimiter ;

delimiter //
create procedure delete_employee(in p_id int)
begin
	update employee e
    set e.`status` = 0
    where e.id = p_id;
end;
// delimiter ;

delimiter //
create procedure get_employee_by_name(in p_name varchar(45))
begin
	select e.id, e.`name`, e.gender, e.birthday, e.email, e.address, e.personal_id, e.phone_number, e.salary, d.degree_name, o.office_name, dp.department_name 
    from employee e 
		join degree d on e.degree_id = d.id 
        join office o on e.office_id = o.id
        join department dp on e.department_id = dp.id
	where e.`name` like concat('%' , p_name , '%') and e.`status` = 1;
end;
// delimiter ;

delimiter //
create procedure get_all_customer()
begin
	select c.id, c.`name`, c.gender, c.birthday, c.email, c.address, c.personal_id, c.phone_number, ct.customer_type_name 
    from customer c 
		join customer_type ct on c.customer_type_id = ct.id
	where c.`status` = 1;
end;
// delimiter ;

delimiter //
create procedure get_customer_by_id(in p_id varchar(10))
begin
	select c.id, c.`name`, c.gender, c.birthday, c.email, c.address, c.personal_id, c.phone_number, c.customer_type_id
    from customer c
	where c.id = p_id and c.`status` = 1;
end;
// delimiter ;

delimiter //
create procedure delete_customer(in p_id int)
begin
	update customer c
    set c.`status` = 0
	where c.id = p_id;
end;
// delimiter ;

delimiter //
create procedure get_customer_by_name(in p_name varchar(45))
begin
	select c.id, c.`name`, c.gender, c.birthday, c.email, c.address, c.personal_id, c.phone_number, ct.customer_type_name 
    from customer c 
        join customer_type ct on c.customer_type_id = ct.id
	where c.`name` like concat('%' , p_name , '%') and c.`status` = 1;
end;
// delimiter ;

delimiter //
create procedure get_all_facility()
begin
	select f.id, f.`name`, f.usable_area, f.number_of_floors,f.cost,f.customer_max, r.renting_by_name, st.service_type_name
    from facility f
		join service_type st on f.service_type_id = st.id
        join renting_by r on f.renting_by_id = r.id
	where f.`status` = 1;
end;
// delimiter ;

delimiter //
create procedure get_facility_by_id(in p_id varchar(10))
begin
	select f.id,f.`name`,f.usable_area,f.number_of_floors,f.cost,f.customer_max,r.renting_by_name,s.service_type_name
    from facility f 
		join service_type s on s.id = f.service_type_id
        join renting_by r on r.id = f.renting_by_id
	where f.id = p_id and f.`status` = 1;
end;
// delimiter ;