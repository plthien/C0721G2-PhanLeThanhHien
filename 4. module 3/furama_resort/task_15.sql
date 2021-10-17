use furama_resort_management;

select e.id, e.`name`, d.degree_name, dp.department_name, e.phone_number, e.address
from degree d 
	join employee e on d.id = e.degree_id
    join department dp on dp.id = e.department_id
    join contract c on e.id = c.employee_id
where c.check_in_date between '2018-01-01' and '2019-12-31'
group by e.id
having count(c.id) <= 3
