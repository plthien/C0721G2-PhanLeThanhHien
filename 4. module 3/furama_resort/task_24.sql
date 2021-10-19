use furama_resort_management;

delimiter //
create procedure sp_2(
						customer_id_p int ,
						employee_id_p int ,
                        facility_id_p int ,
                        check_in_date_p date,
                        check_out_date_p date 
						,deposit_p double,
                        payment_p double, out result varchar(50))
begin
	if (customer_id_p in (select c.id from customer c) and
		employee_id_p in (select e.id from employee e) and
        facility_id_p in (select f.id from facility f)
		) then 
			insert into contract(customer_id,employee_id,facility_id,check_in_date,check_out_date,deposit,payment)
			values(customer_id_p,employee_id_p,facility_id_p ,check_in_date_p ,check_out_date_p 
								,deposit_p ,payment_p );
	else 
    set result = 'Data invalid !';
    select result;
    end if;

end;
// delimiter ;

call sp_2(2,2,2,'2021-10-19','2021-10-22',100,500,@result)