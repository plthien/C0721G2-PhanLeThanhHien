create database FuramaResortManagement;
use FuramaResortManagement;

create table Employee(
employeeID int not null primary key,
`name` varchar(45),
birthday date,
gender enum('M','F'),
personalID varchar(20),
phoneNumber varchar(10),
email varchar(45),
degree enum('Intermediate','Associate','College','Postgraduate'),
office enum('Receptionist','Service Staff','Specialist','Supervisor','Manager','Director'),
salary double
);

create table Customer(
customerID int not null primary key,
`name` varchar(45),
birthday date,
gender enum('M','F'),
personalID varchar(20),
phoneNumber varchar(10),
email varchar(45),
customerTypes enum('Member','Silver','Gold','Platinium','Diamond'),
address varchar(45)
);

