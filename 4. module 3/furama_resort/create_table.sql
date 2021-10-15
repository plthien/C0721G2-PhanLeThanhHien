drop database if exists Furama_Resort_Management;
create database Furama_Resort_Management;
use Furama_Resort_Management;


create table degree(
id int auto_increment primary key,
degree_name enum('Intermediate','Associate','College','Postgraduate')
);

create table office(
id int auto_increment primary key,
office_name enum('Receptionist','Service Staff','Specialist','Supervisor','Manager','Director')
);

create table department(
id int auto_increment primary key,
department_name enum('Sale-Marketing','Administrative staff','Service','Management')
);

create table employee(
id int auto_increment primary key,
`name` varchar(45),
birthday date,
gender enum('M','F'),
personal_id varchar(20),
phone_number varchar(10),
email varchar(45),
salary double,
degree_id int,
office_id int,
department_id int,

foreign key(degree_id) references degree(id),
foreign key(office_id) references office(id),
foreign key(department_id) references department(id)

);

create table customer_type(
id int auto_increment primary key,
customer_type_name enum('Member','Silver','Gold','Platinium','Diamond')
);

create table customer(
id int auto_increment primary key,
`name` varchar(45),
birthday date,
gender enum('M','F'),
personal_id varchar(20),
phone_number varchar(10),
email varchar(45),
customer_type_id int,
address varchar(45),

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
id int auto_increment primary key,
`name` varchar(10),
usable_area double,
number_of_floors int,
cost double,
customer_max int,
renting_by_id int,
service_type_id int,
`status` varchar(45),

foreign key(renting_by_id) references renting_by(id),
foreign key(service_type_id) references service_type(id)
);

create table extra_service(
id int auto_increment primary key,
`name` varchar(45),
price double,
unit varchar(45),
`status` varchar(45)
);

create table contract(
id int auto_increment primary key,
customer_id int,
employee_id int,
facility_id int,
check_in_date date,
check_out_date date,
deposit double,
payment double,

foreign key(customer_id) references customer(id),
foreign key(employee_id) references employee(id),
foreign key(facility_id) references facility(id)

);

create table contract_detail(
id int auto_increment primary key,
contract_id int,
extra_service_id int,
quantity int,

foreign key(contract_id) references contract(id),
foreign key(extra_service_id) references extra_service(id)

);





