package com.example.springday4.Pogo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotEmpty(message = "please provide a username")
    @Size(min = 4 , max = 8, message = "username should be more than 3 letters and not more than 9")
    private String username;
    @NotEmpty(message = "please provide password")
  //  @Pattern(regexp = "  ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$\n")
    private String password;

}
