package com.codegym.furamaresortmanagement.repository;

import com.codegym.furamaresortmanagement.model.EmployeeOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeOfficeRepository extends JpaRepository<EmployeeOffice, Integer> {

    @Query(value="select * from employee_office",nativeQuery=true)
    List<EmployeeOffice> findAllOffice();
}
