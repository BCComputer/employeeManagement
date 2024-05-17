package com.binary.employeeManagement.controller;

import com.binary.employeeManagement.model.Employee;
import com.binary.employeeManagement.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeManagementController {
    private final EmployeeService employeeService;

    @GetMapping({"", "/list"})
    public String employee(Model m) {
        m.addAttribute("employeesList", employeeService.findAllEmployee());
        return "employees/displayEmployeePage";
    }

    @GetMapping({"/create"})
    public String createEmployee(Model model) {
        model.addAttribute("createEmployee", new Employee());
        return "employees/createEmployeePage";
    }

    @PostMapping({"/create"})
    public String createEmployee(@ModelAttribute("createEmployee") Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePostPage(@PathVariable("id") Integer id) {
        return "employees/deleteEmployeePage";
    }

    @PostMapping({"/delete/{id}"})
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees/list";
    }



}



