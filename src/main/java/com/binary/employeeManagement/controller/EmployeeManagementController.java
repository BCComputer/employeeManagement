package com.binary.employeeManagement.controller;

import com.binary.employeeManagement.model.Employee;
import com.binary.employeeManagement.model.EmployeeDto;
import com.binary.employeeManagement.repositories.EmployeeRepositories;
import com.binary.employeeManagement.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeManagementController {
    private final EmployeeService employeeService;
    @GetMapping({"", "/list"})
    public String employee(Model m) {
        m.addAttribute("employeesList", employeeService.findAll());
        return "employees/displayEmployeePage";
    }
    @GetMapping({"/home"})
    public String employeeHome(Model m) {
        return "employees/home";
    }
    @GetMapping({"/create"})
    public String createEmployee(Model model) {
        model.addAttribute("createEmployee", new EmployeeDto());
        return "employees/createEmployeePage";
    }
    @PostMapping({"/create"})
    public String createEmployee(@Valid @ModelAttribute("createEmployee")
                                     EmployeeDto employeeDto, BindingResult result) {
        if(result.hasErrors()){
            return "employees/createEmployeePage";
        }
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setRole(employeeDto.getRole());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setSalary(employeeDto.getSalary());
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePostPage(@PathVariable("id") int id) {

        return "employees/deleteEmployeePage";
    }
    @PostMapping({"/delete/{id}"})
    public String deleteEmployee(@PathVariable("id") int id) {
        Employee byId = employeeService.findById(id).get();
        employeeService.delete(byId);
        return "redirect:/employees/list";
    }

    @GetMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable("id") int id, Model model) {

        Optional<Employee> optionalEmployee = employeeService.findById(id);

        Employee  updatedEmployee = null;
        if (optionalEmployee.isPresent()) {
            updatedEmployee = optionalEmployee.get();
        } else {
            return "redirect:/employees/List";
        }
        model.addAttribute("updateEmployee", updatedEmployee);
        return "employees/updateEmpPage";
    }

    @PostMapping("/updateEmployee/{id}")
    public String updateEmployee(@Valid @PathVariable("id") int id, @ModelAttribute("updateEmployee")
                                EmployeeDto employeeDto, BindingResult result) {
        if (result.hasErrors()) {
            return "employees/updateEmpPage";
        }
        Employee employee = new Employee();

        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setRole(employeeDto.getRole());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setSalary(employeeDto.getSalary());
        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam(required = false) String searchBy,
                         @RequestParam(required = false) String keyword,
                         Model model) {
        List<Employee> employees = employeeService.findAll();

        if (searchBy != null && !searchBy.isEmpty() && keyword != null && !keyword.isEmpty()) {
            switch (searchBy) {
                case "id":
                    employees = employees.stream()
                            .filter(employee -> employee.getId().toString().contains(keyword))
                            .collect(Collectors.toList());
                    break;
                case "name":
                    employees = employees.stream()
                            .filter(employee -> employee.getName().toLowerCase().contains(keyword.toLowerCase()))
                            .collect(Collectors.toList());
                    break;
                case "department":
                    employees = employees.stream()
                            .filter(employee -> employee.getDepartment().toLowerCase().contains(keyword.toLowerCase()))
                            .collect(Collectors.toList());
                    break;
                case "role":
                    employees = employees.stream()
                            .filter(employee -> employee.getRole().toLowerCase().contains(keyword.toLowerCase()))
                            .collect(Collectors.toList());
                    break;
                case "salary":
                    try {
                        double salary = Double.parseDouble(keyword);
                        employees = employees.stream()
                                .filter(employee -> employee.getSalary() == salary)
                                .collect(Collectors.toList());
                    } catch (NumberFormatException e) {
                        System.out.println("Number mismatch.");
                    }
                    break;
            }
        }

        model.addAttribute("employees", employees);
        return "employees/employeeSearchPage";
    }
}



