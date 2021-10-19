use furama_resort_management;

delimiter //
create procedure sp_3()
begin
	set foreign_key_checks = 0;
	delete f , c , cd
    from service_type st 
		join facility f on st.id = f.service_type_id
        join contract c on f.id = c.facility_id
        join contract_detail cd on c.id = cd.contract_id
	where st.service_type_name = 'Room' and c.check_in_date between '2015-01-01' and '2019-12-31';
    	set foreign_key_checks = 1;

end;
// delimiter ;

drop procedure sp_3;
call sp_3