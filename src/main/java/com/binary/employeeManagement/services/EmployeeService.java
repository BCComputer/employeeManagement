package com.binary.employeeManagement.services;

import com.binary.employeeManagement.model.Employee;
import com.binary.employeeManagement.repositories.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Employee> deleteEmployeeById(int id){
        return repo.deleteEmployeeById(id);

    }
    public Optional<Employee> findById(int id){
        return repo.getEmpById(id);
    }
    public void updateEmployee(Employee employee){
        repo.updateEmployee(employee);

    }
}
