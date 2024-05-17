package com.binary.employeeManagement.repositories;

import com.binary.employeeManagement.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepo {

    List<Employee> empList = new ArrayList<>();
    private int id = 0;

    public EmployeeRepo() {
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("Bishnu");
        employee1.setRole("Dev");
        employee1.setDepartment("Eng");

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setName("Ram");
        employee2.setRole("HR");
        employee2.setDepartment("Accounts");
        empList.add(employee1);
        empList.add(employee2);
    }

    public void addEmployee(Employee employee) {
        empList.add(employee);
        id++;
    }

    public List<Employee> getAllEmployees() {
        System.out.println(empList);
        return empList;
    }

}
