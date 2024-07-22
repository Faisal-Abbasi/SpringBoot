package com.faisal.springboottutorial.dto;

import com.faisal.springboottutorial.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDTO {

    private Long id;

    @NotBlank(message="Name of the employee cannot be blank")
    @Size(min =3, max=10,message="Number of characters in name should be in the range: [3,10]")
    private String name;

    @NotBlank(message="Email of the employee cannot be blank")
    @Email(message="Email should be a valid email")
    private String email;

    @NotNull(message= "Age of the employee cannot be blank")
    @Max(value=80, message="Age of employee cannot be greater than 80")
    @Min(value=18, message="Age of employee cannot be less than 18")
    private Integer age;

    @NotBlank(message="Role of the employee cannot be blank")
   // @Pattern(regexp = "^(ADMIN|USER)$", message="Role of Employee can either be USER or ADMIN")
    @EmployeeRoleValidation
    private String role;

    @NotNull(message="Salary of the employee cannot be blank")
    @Positive(message="Salary of Employee should be positive")
    @Digits(integer=6, fraction=2, message= "The salary can be in the form XXXXX.YY")
    @DecimalMax(value="100000.99")
    @DecimalMin(value="100.50")
    private double salary;

    @PastOrPresent(message="Date of Joining field in employee cannot be in future")
    private LocalDate dateOfJoining;

    @AssertTrue(message="Employee should be active")
    private boolean isActive;


}
