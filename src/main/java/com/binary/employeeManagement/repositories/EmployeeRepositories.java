package com.binary.employeeManagement.repositories;

import com.binary.employeeManagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepositories extends JpaRepository<Employee, Integer> {

}
