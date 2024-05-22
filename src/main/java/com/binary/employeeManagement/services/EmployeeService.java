package com.binary.employeeManagement.services;

import com.binary.employeeManagement.model.Employee;
import com.binary.employeeManagement.repositories.EmployeeRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepositories employeeRepository;

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }
    public Optional<Employee> findById(Integer id){
        return employeeRepository.findById(id);
    }

    public void delete(Employee byId){
         employeeRepository.delete(byId);
    }
}
