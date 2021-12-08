package com.codegym.furamaresortmanagement.repository.contract;

import com.codegym.furamaresortmanagement.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
@Transactional
public interface IContractRepository extends JpaRepository<Contract, Long> {

    Page<Contract> findAllByCheckInDateOrCheckOutDateEquals(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);


    Page<Contract> findAllByCustomer_NameOrCustomer_Id(String customer_name, String customer_id, Pageable pageable);
}
