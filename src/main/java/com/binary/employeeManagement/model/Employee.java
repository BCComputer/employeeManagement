package com.binary.employeeManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Department is mandatory")
    private String department;
    @NotBlank(message = "Role is mandatory")
    private String role;
    @NotNull(message = "Salary is mandatory")
    @Min(value = 4, message = "Salary must be a positive number")
    private Integer salary;
}
