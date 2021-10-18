use furama_resort_management;

set foreign_key_checks = 0;
delete from customer
where id in (
		select t.id
        from (
			select c.id
            from customer c join contract ctr on c.id = ctr.customer_id
            where ctr.check_in_date < '2016-01-01'
        ) t
	);
set foreign_key_checks = 1;