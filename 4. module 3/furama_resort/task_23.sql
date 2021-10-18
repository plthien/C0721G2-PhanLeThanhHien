use furama_resort_management;

delimiter //
create procedure sp_1(customer_id int)
begin
	set foreign_key_checks = 0;
	delete from customer c
    where c.id = customer_id;
    set foreign_key_checks = 1;
end;
// delimiter ;

drop procedure sp_1;

call sp_1(1);
