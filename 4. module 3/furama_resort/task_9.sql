use furama_resort_management;

select  date_format(ctr.check_in_date,'%m-%Y') as `month`, count(ctr.id) as number_of_contract, sum(f.cost + ctrd2.cost_2) as total
from contract ctr 	
	join facility f on f.id = ctr.facility_id
	join ( 
		select ctrd.contract_id, sum(ctrd.quantity*exs.price) as cost_2
        from  contract_detail ctrd join extra_service exs on exs.id = ctrd.extra_service_id
        group by ctrd.contract_id
    ) ctrd2 on ctr.id = ctrd2.contract_id
where year(ctr.check_in_date) = '2019'
group by `month`

