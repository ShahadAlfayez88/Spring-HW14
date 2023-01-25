package com.example.springday4.Pogo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employees {
    @NotEmpty(message = "ID is required!!")
    @Size(min=3 , max=9 , message = "id size must be from 3 to 9")
    private String id;

    @NotEmpty(message = "Name is required!!")
    @Size(min=5 , max = 30,message = "Name size must be from 5 to 30")
    private String name;
    @NotNull(message = "Age is required!!")
    @Min(value = 26 , message = "it must be more than 25")
    @Max(value = 55 , message = "it must be less than 56")

    @Positive(message = "it must be a number")
    private int age;
    @NotEmpty(message = "Role is required!!")
    @Pattern( regexp = "^supervisor|coordinator$" ,message = "Role field only allow input: supervisor or coordinator" )
    private String role;

    @Pattern(regexp ="^(false)$", message = "onLeave field only allow input: false")
    private String onLeave;
    @NotNull(message = "employment Year is required!!")
    @Min(value = 1990 , message = "Please enter a valid year from 1990 to 2023")
    @Max(value = 2023 , message = "Please enter a valid year from 1990 to 2023")
    @Positive(message = "it must be a number")
    private int employmentYear;

    @NotNull(message = "annualLeave Year is required!!")
    @Min(value = 0 , message = "annual balance is less than the required")
    @Max(value = 22, message = "Annual leaves only 22 days please enter a number similar")
    private int annualLeave;

}
