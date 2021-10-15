use furama_resort_management;

select  ctr1.`month`, ctr1.number_of_contract, ctr1.cost
-- ,sum(ctrd.quantity*exs.price) + f.cost as total
from ( 
		select ctr.id , date_format(ctr.check_in_date,'%m-%Y') as `month`, count(ctr.id) as number_of_contract, ctr.facility_id, sum(f.cost) as cost
		from contract ctr 	join facility f on f.id = ctr.facility_id
        group by `month`
    ) ctr1
--     join contract_detail ctrd on ctrd.contract_id = ctr1.id
--     join extra_service exs on exs.id = ctrd.extra_service_id


