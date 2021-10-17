use furama_resort_management;

select ct.id as contract_id, st.service_type_name, es.`name`, count(ct.id) as number_of_use
from service_type st 
	join facility f on st.id = f.service_type_id
    join contract ct on f.id =ct.facility_id
    join contract_detail ctd on ct.id = ctd.contract_id
    join extra_service es on es.id = ctd.extra_service_id
group by es.id
having number_of_use =1
