use furama_resort_management;

delimiter //
create trigger tr_2
before update 
on contract for each row
begin
	if ( datediff(new.check_out_date,old.check_in_date) < 2 )
    then 
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'The checkout date is greater than checkin date at least 2 days';
	end if;
end;
// delimiter ;
update contract 
set check_out_date = '2019-01-20'
where id = 1;