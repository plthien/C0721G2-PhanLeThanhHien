use furama_resort_management;

delimiter //
create trigger tr_1 
after delete
on contract for each  row
begin
	declare msg varchar(100);
	set msg = concat('Number of records in contract table is ', (select count(contract.id) from contract));
    
	signal sqlstate '00002'
    set message_text =  msg;
	
    
end;
// delimiter ;

drop trigger tr_1;

set foreign_key_checks = 0;
delete from contract
where contract.id = 3;
set foreign_key_checks = 1;
