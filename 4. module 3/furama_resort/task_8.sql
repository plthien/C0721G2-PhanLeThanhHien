use furama_resort_management;

select distinct c.`name` as customer_name
from customer c;

select c.`name` as customer_name
from customer c
group by c.`name`;

select c1.`name` as customer_name
from customer c1
union
select c2.`name` as customer_name
from customer c2
;