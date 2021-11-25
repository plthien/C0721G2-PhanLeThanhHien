package com.codegym.furamaresortmanagement.controller;

import com.codegym.furamaresortmanagement.model.Employee;
import com.codegym.furamaresortmanagement.model.EmployeeOffice;
import com.codegym.furamaresortmanagement.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @ModelAttribute("offices")
    public List<EmployeeOffice> offices() {
        return iEmployeeService.findAllOffice();
    }

    @GetMapping()
    public String viewPageEmployee(@RequestParam(name = "page", defaultValue = "0") int page,
                                       @RequestParam(value = "sortField", defaultValue = "name") String sortField,
                                       @RequestParam(value = "sortDirection", defaultValue = "asc") String sortDirection,
                                       Optional<String> keyword,
                                       Optional<Integer> officeId,
                                       Model model
    ) {
        int size = 5;
        Page<Employee> employeePage;
        if (!keyword.isPresent() || keyword.get().equals("")) {
            if (officeId.isPresent()) {
                employeePage = iEmployeeService.findEmployeeByOfficeId(page, size, sortField, sortDirection, officeId.get());
                model.addAttribute("officeId",officeId.get());
            } else {
                employeePage = iEmployeeService.findAllEmployee(page, size, sortField, sortDirection);
            }
        } else {
            employeePage = iEmployeeService.findEmployeeByKeyword(page, size, sortField, sortDirection, keyword.get());
            model.addAttribute("keyword", keyword.get());
        }
        model.addAttribute("employees", employeePage);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("reverseSortDir", sortDirection.equals("asc") ? "desc" : "asc");
        return "employee/list";
    }
}
