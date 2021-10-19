use furama_resort_management;

delimiter //
create function func_1()
returns int
deterministic
begin
	declare count int;
    set count = (select count(*) from (
			select  f.`name` as facility_name, (sum(ctrd.quantity*exs.price) + f.cost) as total
			from customer c
				left join customer_type cty on c.customer_type_id = cty.id
				left join contract ctr on c.id = ctr.customer_id
				left join facility f on f.id = ctr.facility_id
				left join contract_detail ctrd on ctrd.contract_id  = ctr.id 
				left join extra_service exs on exs.id = ctrd.extra_service_id
			group by f.`name`
			having (total > 2000000) )t
    );
    return count;
end;
// delimiter ;

select func_1() 

delimiter //
create function func_2(customer_id_p int)
returns int
deterministic
begin
	declare period int;
    set period = (select max(t.distance) from (
			select datediff(c.check_out_date,c.check_in_date) as distance
			from contract c
			where c.customer_id = customer_id_p) t
    );
    return period;
end;
// delimiter ;
select func_2(3)