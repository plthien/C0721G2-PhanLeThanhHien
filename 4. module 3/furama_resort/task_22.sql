use furama_resort_management;

update employee e
set e.address = 'Lien Chieu'
where e.id in (
		select t.id from (
			select v.id from v_employee v
            ) t
	) 