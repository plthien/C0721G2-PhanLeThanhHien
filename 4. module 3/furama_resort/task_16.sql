use furama_resort_management;

delete from employee
where id not in (
		select c.employee_id
        from contract c 
		where c.check_in_date between '2017-01-01' and '2019-12-31'
)