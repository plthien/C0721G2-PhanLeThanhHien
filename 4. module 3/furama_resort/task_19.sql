use furama_resort_management;

update extra_service
set price = price * 2
where id in (
	select t.id from (
		select es.id 
		from extra_service es 
			join contract_detail ct on es.id = ct.extra_service_id
		group by es.id
		having count(ct.id) >= 5
		) t
)