use Furama_Resort_Management;

select f.id, f.`name`, f.usable_area, f.customer_max, f.cost, st.service_type_name
from facility f
	join service_type st on f.service_type_id = st.id
where f.id in (
	select ctr.facility_id from contract ctr 
    where ctr.check_in_date between '2018-01-01' and '2018-12-31'
) and f.id not in (
	select ctr.facility_id from contract ctr 
    where ctr.check_in_date between '2019-01-01' and '2019-12-31'
)