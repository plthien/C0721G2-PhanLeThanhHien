package com.codegym.furamaresortmanagement.service.contract.impl;

import com.codegym.furamaresortmanagement.model.contract.Contract;
import com.codegym.furamaresortmanagement.repository.contract.IContractRepository;
import com.codegym.furamaresortmanagement.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<Contract> findContractByDate(int page, int size, String sortField, String sortDirection, LocalDateTime localDateTime) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(page,size,sort);
        return iContractRepository.findAllByCheckInDateOrCheckOutDateEquals(localDateTime,localDateTime,pageable);
    }

    @Override
    public Page<Contract> findAllContract(int page, int size, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(page,size,sort);
        return iContractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> findContractByCustomer(int page, int size, String sortField, String sortDirection, String keyword) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(page,size,sort);
        return iContractRepository.findAllByCustomer_NameOrCustomer_Id(keyword,keyword,pageable);


    }
}
