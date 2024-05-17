package com.binary.employeeManagement.controller;

import com.binary.employeeManagement.model.Employee;
import com.binary.employeeManagement.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class EmployeeManagementController {
    private final EmployeeService employeeService;
    @GetMapping({"employee/list"})
    public String employee(Model m) {
        m.addAttribute("employees", employeeService.findAllEmployee());
        return "displayEmployee";
    }

    @GetMapping({"employee/create"})
    public String createEmployee(Model model){
        model.addAttribute("createEmployee", new Employee());
        return "/createEmployeePage";
    }


    /*@GetMapping({"/emp"})
    public String employee1() {
        return "employees";
    }*/
}



