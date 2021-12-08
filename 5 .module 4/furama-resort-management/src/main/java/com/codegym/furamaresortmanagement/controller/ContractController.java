package com.codegym.furamaresortmanagement.controller;

import com.codegym.furamaresortmanagement.model.contract.Contract;
import com.codegym.furamaresortmanagement.model.contract.ContractDetail;
import com.codegym.furamaresortmanagement.model.customer.Customer;
import com.codegym.furamaresortmanagement.model.employee.Employee;
import com.codegym.furamaresortmanagement.service.contract.IContractDetailService;
import com.codegym.furamaresortmanagement.service.contract.IContractService;
import com.codegym.furamaresortmanagement.service.customer.ICustomerService;
import com.codegym.furamaresortmanagement.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contracts")
public class ContractController {
    @Autowired
    private IContractService iContractService;

    @Autowired
    private IContractDetailService iContractDetailService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IEmployeeService iEmployeeService;


    @ModelAttribute("contractDetails")
    public List<ContractDetail> contractDetails(){
        return iContractDetailService.findAll();
    }

    @ModelAttribute("customers")
    public List<Customer> customers(){
        return iCustomerService.findAll();
    }

    @ModelAttribute("employees")
    public List<Employee> employees(){
        return iEmployeeService.findAll();
    }

    @GetMapping()
    public String viewPageContract(@RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(value = "sortField", defaultValue = "name") String sortField,
                                   @RequestParam(value = "sortDirection", defaultValue = "asc") String sortDirection,
                                   Optional<String> keyword,
                                   Optional<LocalDateTime> dateSearch,
                                   Model model
    ) {
        int size = 5;
        Page<Contract> contractPage;
        if (!keyword.isPresent() || keyword.get().equals("")) {
            if (dateSearch.isPresent()) {
                contractPage = iContractService.findContractByDate(page, size, sortField, sortDirection, dateSearch.get());
                model.addAttribute("dateSearch", dateSearch.get());
            } else {
                contractPage = iContractService.findAllContract(page, size, sortField, sortDirection);
            }
        } else {
            contractPage = iContractService.findContractByCustomer(page, size, sortField, sortDirection, keyword.get());
            model.addAttribute("keyword", keyword.get());
        }
        model.addAttribute("contracts", contractPage);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("reverseSortDir", sortDirection.equals("asc") ? "desc" : "asc");
        return "contract/list";
    }
}
