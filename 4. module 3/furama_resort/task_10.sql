use Furama_Resort_Management;

select c1.id as contract_id, c1.check_in_date, c1.check_out_date, c1.deposit, count(c2.id) as number_of_extra_service
from contract c1
	join contract_detail c2 on c1.id = c2.contract_id
    group by c1.id