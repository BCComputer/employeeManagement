package com.binary.employeeManagement.services;

import com.binary.employeeManagement.model.Employee;
import com.binary.employeeManagement.repositories.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepo repo;

    public void addEmployee(Employee employee) {
        repo.addEmployee(employee);
    }

    public List<Employee> findAllEmployee() {
       return repo.getAllEmployees();
    }
}
