use Furama_Resort_Management;

insert into degree(degree_name) values('Intermediate'),('Associate'),('College'),('Postgraduate');
insert into office(office_name) values('Receptionist'),('Service Staff'),('Specialist'),('Supervisor'),('Manager'),('Director');
insert into department(department_name) values('Sale-Marketing'),('Administrative staff'),('Service'),('Management');
insert into customer_type(customer_type_name) values('Member'),('Silver'),('Gold'),('Platinium'),('Diamond');

insert into employee(`name`,birthday,gender,personal_id,phone_number,email,salary,address,degree_id,office_id,department_id)
values('Ho Van Hung','1995-02-28','M','201710991','0905999888','hung@gmail.com',2000,'Da Nang', (select id from degree where degree_name = 'College'),
(select id from office where office_name = 'Supervisor'),(select id from department where department_name = 'Management'));

insert into employee(`name`,birthday,gender,personal_id,phone_number,email,salary,address,degree_id,office_id,department_id)
values('Phan Hoang Quan','1998-05-28','M','201710956','0905656565','tuan@gmail.com',1000,'Quang Nam', (select id from degree where degree_name = 'College'),
(select id from office where office_name = 'Specialist'),(select id from department where department_name = 'Administrative staff'));

insert into employee(`name`,birthday,gender,personal_id,phone_number,email,salary,address,degree_id,office_id,department_id)
values('Pham Thi Kieu','1992-08-12','F','201719321','0905686868','kieu@gmail.com',3300,'Ha Noi', (select id from degree where degree_name = 'College'),
(select id from office where office_name = 'Manager'),(select id from department where department_name = 'Management'));

insert into employee(`name`,birthday,gender,personal_id,phone_number,email,salary,address,degree_id,office_id,department_id)
values('Phan Le Thanh Hien','1980-10-12','M','201219421','0905666888','quangvu@gmail.com',5000,'Hue', (select id from degree where degree_name = 'College'),
(select id from office where office_name = 'Director'),(select id from department where department_name = 'Management'));

insert into employee(`name`,birthday,gender,personal_id,phone_number,email,salary,address,degree_id,office_id,department_id)
values('Nguyen Van Danh','1992-10-12','M','201129421','0905666999','vanhdanh@gmail.com',1000,'Hue', (select id from degree where degree_name = 'College'),
(select id from office where office_name = 'Director'),(select id from department where department_name = 'Management'));

insert into employee(`name`,birthday,gender,personal_id,phone_number,email,salary,address,degree_id,office_id,department_id)
values('Pham Van Phong','1995-10-12','M','201719421','0905666777','vanhphong@gmail.com',1000,'Hai Chau', (select id from degree where degree_name = 'College'),
(select id from office where office_name = 'Manager'),(select id from department where department_name = 'Management'));

insert into customer(`name`,birthday,gender,personal_id,phone_number,email,customer_type_id,address)
values('Le Thi Hong','1990-02-10','F','200912131','0906123456','hong@gmail.com',(select c.id from customer_type c where customer_type_name = 'Gold'),'Đà Nẵng');

insert into customer(`name`,birthday,gender,personal_id,phone_number,email,customer_type_id,address)
values('Tran Van Chau','1995-02-10','M','200976131','0906654123','chau@gmail.com',(select c.id from customer_type c where customer_type_name = 'Silver'),'Quảng Trị');

insert into customer(`name`,birthday,gender,personal_id,phone_number,email,customer_type_id,address)
values('Ngo Thanh Van','1990-02-10','F','201819992','0905686564','van@gmail.com',(select c.id from customer_type c where customer_type_name = 'Diamond'),'Vinh');

insert into customer(`name`,birthday,gender,personal_id,phone_number,email,customer_type_id,address)
values('Ngo Kinh','2005-02-15','M','2018199432','0905686569','ngokinh@gmail.com',(select c.id from customer_type c where customer_type_name = 'Diamond'),'Đà Nẵng');

insert into customer(`name`,birthday,gender,personal_id,phone_number,email,customer_type_id,address)
values('Ngo Kinh','1990-05-10','M','1994123112','0905987345','ngokinh1990@gmail.com',(select c.id from customer_type c where customer_type_name = 'Platinium'),'Quang Ngai');

insert into customer(`name`,birthday,gender,personal_id,phone_number,email,customer_type_id,address)
values('Chau Dai Phat','1985-05-10','M','1204123562','0905987654','chaudaiphat@gmail.com',(select c.id from customer_type c where customer_type_name = 'Member'),'Ca Mau');

insert into renting_by(renting_by_name)
values('Year'),('Month'),('Day'),('Hour');

insert into service_type(service_type_name)
values('Villa'),('House'),('Room');

insert into facility(`name`,usable_area,number_of_floors,cost,customer_max,renting_by_id,service_type_id,`status`)
values('SVVL-1000',300,3,5000000,10,3,1,'Good');

insert into facility(`name`,usable_area,number_of_floors,cost,customer_max,renting_by_id,service_type_id,`status`)
values('SVHO-1001',200,2,4000000,5,3,2,'Good');

insert into facility(`name`,usable_area,number_of_floors,cost,customer_max,renting_by_id,service_type_id,`status`)
values('SVRO-1002',50,1,1000000,2,4,3,'Good');

insert into extra_service(`name`,price,unit,`status`)
values('Massage',1000000,'Ticket','Available'),('Karaoke',500000,'Hour','Available'),('Pepsi',50000,'Can','Available'),('Potato Snack',40000,'Package','Available');

insert into contract(customer_id,employee_id,facility_id,check_in_date,check_out_date,deposit,payment)
values(1,1,1,'2019-01-19','2019-01-25',50,500);

insert into contract_detail(contract_id, extra_service_id, quantity)
values(1,2,5),(1,3,4),(1,4,5);

insert into contract(customer_id,employee_id,facility_id,check_in_date,check_out_date,deposit,payment)
values(2,3,2,'2018-11-05','2018-11-08',30,200);

insert into contract_detail(contract_id, extra_service_id, quantity)
values(2,1,2),(2,3,2);

insert into contract(customer_id,employee_id,facility_id,check_in_date,check_out_date,deposit,payment)
values(3,2,1,'2018-10-27','2018-10-30',50,400);

insert into contract_detail(contract_id, extra_service_id, quantity)
values(3,2,4),(3,3,8),(3,4,10);

insert into contract(customer_id,employee_id,facility_id,check_in_date,check_out_date,deposit,payment)
values(3,3,2,'2021-11-12','2021-11-15',40,400);

insert into contract_detail(contract_id, extra_service_id, quantity)
values(4,3,3),(4,4,5);

insert into contract(customer_id,employee_id,facility_id,check_in_date,check_out_date,deposit,payment)
values(3,3,2,'2019-10-12','2019-10-15',40,400);

insert into contract_detail(contract_id, extra_service_id, quantity)
values(5,3,3),(5,4,5);

insert into contract(customer_id,employee_id,facility_id,check_in_date,check_out_date,deposit,payment)
values(4,3,1,'2019-11-05','2019-11-08',30,200);

insert into contract_detail(contract_id, extra_service_id, quantity)
values(6,1,2),(6,4,2);

insert into contract(customer_id,employee_id,facility_id,check_in_date,check_out_date,deposit,payment)
values(3,2,1,'2019-10-01','2019-10-05',30,200);

insert into contract_detail(contract_id, extra_service_id, quantity)
values(7,1,4),(7,2,4);

insert into contract(customer_id,employee_id,facility_id,check_in_date,check_out_date,deposit,payment)
values(6,3,1,'2015-10-01','2015-10-05',30,200);

insert into contract_detail(contract_id, extra_service_id, quantity)
values(8,1,4),(8,2,4);

insert into contract(customer_id,employee_id,facility_id,check_in_date,check_out_date,deposit,payment)
values(4,6,1,'2019-12-12','2019-12-15',30,200);

insert into contract_detail(contract_id, extra_service_id, quantity)
values(9,1,4),(9,2,4);

insert into contract(customer_id,employee_id,facility_id,check_in_date,check_out_date,deposit,payment)
values(1,1,3,'2015-12-12','2015-12-15',30,200);

insert into contract_detail(contract_id, extra_service_id, quantity)
values(10,1,4),(10,2,4);

update contract_detail
set extra_service_id = 2
where id = 4;

update customer
set customer_type_id = 4
where id = 3;

update customer
set customer_type_id = 4
where id = 1;