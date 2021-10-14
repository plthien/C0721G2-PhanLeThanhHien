drop database if exists QuanLySinhVien;
create database QuanLySinhVien;
use QuanLySinhVien;

create table Class(
classID int not null auto_increment primary key,
className varchar(60) not null,
startDate datetime not null,
`status` bit 
);

create table Student(
studentId int not null auto_increment primary key,
studentName varchar(30)  not null,
address varchar(50),
phone varchar(20),
`status` bit,
classId int not null,
foreign key (classID) references Class (classID) 
);

create table `Subject`(
subId int not null auto_increment primary key,
subName varchar(30) not null,
credit tinyint not null default 1 check(credit >= 1),
`status` bit default 1
);

create table Mark(
markId int not null auto_increment primary key,
subId int not null unique key,
studentId int not null unique key,
mark float default 0 check(mark >= 0 and mark <= 100),
examTimes tinyint default 1,
foreign key (subId) references `Subject` (subId),
foreign key (studentId) references Student (studentId)

);