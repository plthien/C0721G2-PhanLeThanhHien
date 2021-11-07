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
	select e.id, e.`name`, e.gender, e.birthday, e.email, e.address, e.personal_id, e.phone_number, e.salary, e.degree_id, e.office_id, e.department_id,d.degree_name, o.office_name, dp.department_name 
    from employee e 
		join degree d on e.degree_id = d.id 
        join office o on e.office_id = o.id
        join department dp on e.department_id = dp.id
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
	select c.id, c.`name`, c.gender, c.birthday, c.email, c.address, c.personal_id, c.phone_number, c.customer_type_id, ct.customer_type_name
    from customer c 
		join customer_type ct on c.customer_type_id = ct.id
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
	select f.id,f.`name`,f.usable_area,f.number_of_floors,f.cost,f.customer_max,f.renting_by_id,f.service_type_id, st.service_type_name, r.renting_by_name
    from facility f 
		join service_type st on f.service_type_id = st.id
        join renting_by r on f.renting_by_id = r.id
	where f.id = p_id and f.`status` = 1;
end;
// delimiter ;

delimiter //
create procedure get_facility_by_name(in p_name varchar(120))
begin
	select f.id, f.`name`, f.usable_area, f.number_of_floors,f.cost,f.customer_max, r.renting_by_name, st.service_type_name
    from facility f
		join service_type st on f.service_type_id = st.id
        join renting_by r on f.renting_by_id = r.id
	where f.`status` = 1 and f.`name` like concat('%' , p_name , '%');
end;
// delimiter ;

delimiter //
create procedure get_all_contract()
begin
	select ct.id, ct.customer_id,ct.employee_id,ct.facility_id,ct.check_in_date,ct.check_out_date,ct.deposit,ct.payment,c.`name`as customer_name, e.`name` as employee_name, f.`name` as facility_name
    from contract ct
		join customer c  on c.id=ct.customer_id
        join employee e on e.id=ct.employee_id
        join facility f on f.id = ct.facility_id
	where ct.`status` = 1;
end;
// delimiter ;

delimiter //
create procedure get_all_contract_detail()
begin
	select ctd.id, ctd.contract_id, ctd.extra_service_id, ctd.quantity, e.`name` as extra_service_name, e.unit, e.price, (ctd.quantity*e.price) as total
    from contract_detail ctd
		join extra_service e  on e.id = ctd.extra_service_id
	where ctd.`status` = 1 and e.`status` = 1;
end;
// delimiter ;

delimiter //
create procedure get_contract_by_id(in p_id int)
begin
	select ct.id, ct.customer_id,ct.employee_id,ct.facility_id,ct.check_in_date,ct.check_out_date,ct.deposit,ct.payment,c.`name`as customer_name, e.`name` as employee_name, f.`name` as facility_name
    from contract ct
		join customer c  on c.id=ct.customer_id
        join employee e on e.id=ct.employee_id
        join facility f on f.id = ct.facility_id
	where ct.`status` = 1 and ct.id = p_id;
end;
// delimiter ;

delimiter //
create procedure delete_contract(in p_id int)
begin
	update contract c
    set c.`status` = 0
	where c.id = p_id;
    update contract_detail cd
    set cd.`status` = 0
    where cd.contract_id = p_id;
end;
// delimiter ;

delimiter //
create procedure get_contract_detail_by_id(in p_id int)
begin
	select c.id, c.quantity, c.contract_id, e.id as extra_service_id , e.`name`, e.unit, e.price, (c.quantity*e.price) as total
    from contract_detail c 
        join extra_service e on e.id = c.extra_service_id
	where c.`status` = 1 and c.id = p_id and e.`status` = 1;
end;
// delimiter ;