package com.codegym.furamaresortmanagement.repository;

import com.codegym.furamaresortmanagement.model.Employee;
import com.codegym.furamaresortmanagement.model.EmployeeOffice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value="select * from employees where match(address,email,gender,`name`,personal_id,phone_number) against(:keyword) ", nativeQuery=true)
    Page<Employee> findEmployeeByKeyword(Pageable pageable, @Param("keyword") String keyword);

//    @Query(value=" select * from employees where employee_office_id = :officeId",nativeQuery=true)
    Page<Employee> findAllByEmployeeOffice_Id(Pageable pageable,@Param("officeId") Integer officeId);
}
