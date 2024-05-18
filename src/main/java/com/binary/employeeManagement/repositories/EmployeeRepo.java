package com.binary.employeeManagement.repositories;

import com.binary.employeeManagement.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepo {

    List<Employee> empList = new ArrayList<>();
    private Integer id = 0;

    public EmployeeRepo() {
        /*Employee employee1 = new Employee();
        employee1.setId(id);
        employee1.setName("Bishnu");
        employee1.setRole("Dev");
        employee1.setDepartment("Eng");

        Employee employee2 = new Employee();
        employee2.setId(id);
        employee2.setName("Ram");
        employee2.setRole("HR");
        employee2.setDepartment("Accounts");
        empList.add(employee1);
        empList.add(employee2);
    }*/
    }
    public void addEmployee(Employee employee) {
        employee.setId(id);
        empList.add(employee);
        id++;
    }

    public List<Employee> getAllEmployees() {
        System.out.println(empList);
        return empList;
    }

    public List<Employee> deleteEmployeeById(int id){
        for (int i = 0; i < empList.size(); i++) {

            if(empList.get(i).getId()==id){
                empList.remove(i);
                break;
            }
        }
        return empList;
    }

    public Optional<Employee> getEmpById(int id){
        return empList.stream().filter(employee -> employee.getId()==id).findFirst();
    }

    public void updateEmployee (Employee updateEmp){
        for (int i = 0; i < empList.size(); i++) {
            if(empList.get(i).getId()==(updateEmp.getId())){
                empList.set(i, updateEmp);
                break;
            }
        }
    }

}
