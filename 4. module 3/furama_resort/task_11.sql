use furama_resort_management;

select e.id,  e.`name` as extra_service_name, e.price, e.unit, e.`status`
from extra_service e 
	join contract_detail c1 on e.id = c1.extra_service_id
    join contract c2 on c1.contract_id = c2.id
where c2.customer_id in (
	select c3.id
    from customer c3 
    where c3.address in ('Vinh','Quang Ngai') 
			and c3.customer_type_id in (
            select c4.id 
            from customer_type c4 
            where c4.customer_type_name = 'Diamond'
            )
)
group by e.id;