package com.binary.employeeManagement.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Min(0)
    private Integer id;
    @NotEmpty(message="The name field is required.")
    private String name;
    @NotEmpty(message="The department field is required.")
    private String department;
    @Size(min=2, message = "The role should be min 2 char.")
    @Size(max = 10, message = "The role should be max 10 char.")
    private String role;

}
