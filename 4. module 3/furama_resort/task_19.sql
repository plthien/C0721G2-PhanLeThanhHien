use furama_resort_management;

update extra_service
set price = price * 2
where id in (
		select ct.extra_service_id
		from contract_detail ct 
		group by ct.extra_service_id
		having count(ct.extra_service_id) >= 5
		
)