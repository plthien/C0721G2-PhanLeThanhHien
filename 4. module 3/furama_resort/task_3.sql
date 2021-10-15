use Furama_Resort_Management;

select c.`name`, c.birthday, c.gender, c.personal_id, c.phone_number, c.email, ct.customer_type_name, c.address
 from customer c 
 join customer_type ct on c.customer_type_id = ct.id
 where c.address in ('Đà Nẵng','Quảng Trị') and ( timestampdiff(year,c.birthday,current_date()) between 18 and 50);