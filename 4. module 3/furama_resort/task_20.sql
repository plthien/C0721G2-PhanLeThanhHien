use furama_resort_management;

select e.id, e.`name`, e.email, e.phone_number,e.birthday, e.address, 'employee' as type
from employee e
union
select c.id, c.`name`, c.email, c.phone_number,c.birthday, c.address, 'customer' as type
from customer c