package com.codegym.furamaresortmanagement.service.impl;

import com.codegym.furamaresortmanagement.model.Employee;
import com.codegym.furamaresortmanagement.model.EmployeeOffice;
import com.codegym.furamaresortmanagement.repository.IEmployeeRepository;
import com.codegym.furamaresortmanagement.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findAllEmployee(int page, int size, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(page,size,sort);
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findEmployeeByKeyword(int page, int size, String sortField, String sortDirection, String keyword) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(page,size,sort);
        return iEmployeeRepository.findEmployeeByKeyword(pageable,keyword);
    }


    @Override
    public Page<Employee> findEmployeeByOfficeId(int page, int size, String sortField, String sortDirection, Integer officeId) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(page,size,sort);
        return  iEmployeeRepository.findAllByEmployeeOffice_Id(pageable,officeId);
    }
}
