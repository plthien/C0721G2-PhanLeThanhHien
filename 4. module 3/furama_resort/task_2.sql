use Furama_Resort_Management;


select e.`name`, e.birthday, e.gender, e.personal_id, e.phone_number, e.email, e.salary, d.degree_name, o.office_name, dp.department_name
from employee e 
join degree d on e.degree_id = d.id
join office o on e.office_id = o.id
join department dp on e.department_id = dp.id
where e.`name` regexp '^(?=.{0,15}$)(.*[TKH][a-z]*)$';

