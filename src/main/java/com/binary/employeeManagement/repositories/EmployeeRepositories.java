package com.binary.employeeManagement.repositories;

import com.binary.employeeManagement.model.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeRepositories extends JpaRepository<Employee, Integer> {
    /*List<Employee> findByIdOrDepartmentContainingOrNameContainingOrRoleContainingOrSalary(
            Integer id, String department, String name, String role, Integer salary);*/
}
