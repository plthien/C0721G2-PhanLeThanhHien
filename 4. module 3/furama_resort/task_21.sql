use furama_resort_management;

create view v_employee as
select * from employee
where address = 'Hai Chau' and id in (
	select c.employee_id
    from contract c
    where c.check_in_date = '2019-12-12'
);
select * from v_employee ;