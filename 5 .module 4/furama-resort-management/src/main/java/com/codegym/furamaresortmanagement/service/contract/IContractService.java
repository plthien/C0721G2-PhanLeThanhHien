package com.codegym.furamaresortmanagement.service.contract;

import com.codegym.furamaresortmanagement.model.contract.Contract;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public interface IContractService {
    Page<Contract> findContractByDate(int page, int size, String sortField, String sortDirection, LocalDateTime localDateTime);

    Page<Contract> findAllContract(int page, int size, String sortField, String sortDirection);

    Page<Contract> findContractByCustomer(int page, int size, String sortField, String sortDirection, String keyword);
}
