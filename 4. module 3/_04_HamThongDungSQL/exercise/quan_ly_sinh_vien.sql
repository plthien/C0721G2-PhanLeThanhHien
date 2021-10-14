drop database if exists quan_ly_sinh_vien;
create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;

create table class(
id int auto_increment primary key,
class_name varchar(60) not null,
start_date datetime not null,
`status` bit 
);

create table student(
id int auto_increment primary key,
student_name varchar(30)  not null,
address varchar(50),
phone varchar(20),
`status` bit,
class_id int not null,
foreign key (class_id) references class (id) 
);

create table `subject`(
id int auto_increment primary key,
sub_name varchar(30) not null,
credit tinyint not null default 1 check(credit >= 1),
`status` bit default 1
);

create table mark(
id int auto_increment primary key,
sub_id int not null,
student_id int not null,
mark float default 0 check(mark >= 0 and mark <= 100),
exam_times tinyint default 1,

unique key (sub_id,student_id),
foreign key (sub_id) references `subject` (id),
foreign key (student_id) references student (id)

);

insert into class(class_name,start_date,`status`) 
values	('A1','2008-12-20',1),
		('A2','2008-12-22',1),
		('B3',current_date(),0);
insert into student(student_name,address,phone,`status`,class_id)
 values	('Hung','Ha Noi','0912113113',1,1),
		('Hoa','Hai Phong',null,1,1),
        ('Manh','HCM','0123123123',0,2);
insert into `subject`(sub_name,credit,`status`)
values	('CF',5,1),
		('C',6,1),
        ('HDJ',5,1),
        ('RDBMS',10,1);
insert into mark(sub_id,student_id,mark,exam_times)
values	(1,1,8,1),
		(1,2,20,2),
        (2,1,12,1);


select * from student;

select * from student where `status` = 1;

select * from `subject` where credit < 10;

select student.id, student_name, class_name
from student join class on student.class_id = class.id
where class_name = 'A1';

select student.id, student_name, sub_name, mark
from student join mark on student.id = mark.student_id join `subject` on mark.sub_id = `subject`.id
where `subject`.sub_name = 'CF';

select class_name, count(student.id) as student_count
from student right join class on student.class_id = class.id
group by class_name; 

select student.id, student_name, address, phone,student.`status`, class_name
from student join class on student.class_id = class.id;

select s.address, count(s.id) as number_of_student
from student s
group by s.address;

select s.student_name, avg(m.mark) as avg_mark
from student s join mark m on s.id= m.student_id
group by s.student_name;

select s.student_name, avg(m.mark) as avg_mark
from student s join mark m on s.id= m.student_id
group by s.student_name
having avg_mark > 15;

select s.id, s.student_name, s.address, s.phone,  avg(m.mark) as avg_mark
from student s join mark m on s.id= m.student_id
group by s.student_name
having  avg_mark >= all (select avg(mark.mark) from mark group by mark.student_id) ;

select * from `subject`
where credit >= all (select credit from `subject`);

select s.id, s.sub_name, s.credit, s.`status`, m.mark as max_mark
from `subject` s
join mark m on s.id = m.sub_id
where m.mark >= all (select m.mark from mark m);

select s.id, s.student_name, s.address, s.phone, avg(m.mark) as avg_mark
from student s
join mark m on s.id = m.student_id
group by s.id 
order by avg_mark desc;