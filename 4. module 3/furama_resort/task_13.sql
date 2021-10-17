use furama_resort_management;

select es.id, es.`name` , es.price, es.unit, es.`status`,  count(ct.id) as number_of_use
from extra_service es 
		join contract_detail ct on es.id = ct.extra_service_id
group by es.id
having number_of_use = (select max(t2.number_of_use) 
							from (
								select count(ct.id) as number_of_use
								from extra_service es 
									join contract_detail ct on es.id = ct.extra_service_id
								group by es.id
							) t2
						)
