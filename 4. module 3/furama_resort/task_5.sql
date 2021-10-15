use Furama_Resort_Management;

select c.id as customer_id, c.`name` as customer_name, cty.customer_type_name, ctr.id as contract_id, f.`name` as facility_name,
		ctr.check_in_date, ctr.check_out_date, (sum(ctrd.quantity*exs.price) + f.cost) as total
from customer c
	left join customer_type cty on c.customer_type_id = cty.id
	left join contract ctr on c.id = ctr.customer_id
	left join facility f on f.id = ctr.facility_id
	left join contract_detail ctrd on ctrd.contract_id  = ctr.id 
	left join extra_service exs on exs.id = ctrd.extra_service_id
group by c.`name`;
