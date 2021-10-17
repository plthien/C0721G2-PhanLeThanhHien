use furama_resort_management;

select ct.id as contract_id, e.`name` as employee_name, c.`name` as customer_name,
		c.phone_number as phone_number_customer, f.`name` as facility_name, count(ctd.id) as number_of_extra_service, ct.deposit
from employee e 
	join contract ct on e.id = ct.employee_id
    join customer c on c.id = ct.customer_id
    join facility f on f.id = ct.facility_id
    join contract_detail ctd on ct.id = ctd.contract_id
where ct.check_in_date between '2019-10-01' and '2019-12-31' 
group by ct.id
having facility_name not in (
	select f.`name` from facility f
		join contract c on f.id = c.facility_id
        where c.check_in_date between '2019-01-01' and '2019-06-30'
)
