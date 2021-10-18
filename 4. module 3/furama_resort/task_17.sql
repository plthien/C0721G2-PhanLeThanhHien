use furama_resort_management;

update customer c1
set c1.customer_type_id = 5
where c1.customer_type_id = 4 and c1.id in (
		select t.id from (
			select c2.id, (sum(ctrd.quantity*exs.price) + f.cost) as total
			from customer c2
				join contract ctr on c2.id = ctr.customer_id
				join facility f on f.id = ctr.facility_id
				join contract_detail ctrd on ctrd.contract_id  = ctr.id 
				join extra_service exs on exs.id = ctrd.extra_service_id
			where ctr.check_in_date between '2019-01-01' and '2019-12-31'
			group by c2.id
				) t
		where  t.total > 10000000
		)