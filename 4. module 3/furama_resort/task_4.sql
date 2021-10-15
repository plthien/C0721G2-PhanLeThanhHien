use Furama_Resort_Management;

select c.id as customer_id, c.`name`, count(ct.id) as number_of_contracts
from customer c
left join contract ct on c.id = ct.customer_id 
where c.customer_type_id in (select cty.id from customer_type cty where cty.customer_type_name = 'Diamond')
group by c.id 
order by number_of_contracts ;
