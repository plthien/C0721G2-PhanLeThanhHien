package com.codegym.springsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto {
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Invalid name: Valid name only contains alphanumeric characters!")
    private String name;
    @NotBlank
    @Pattern(regexp = "[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)",
            message = "Invalid email: Valid email only contain latin letters, numbers, '@' and '.' ! ")
    private String email;
    @NotBlank
    @Pattern(regexp = "^[0]\\d{9}$",
            message = "Invalid phone number: Valid Phone number must starts with 0 and should be 10 digit number! ")
    private String phoneNumber;
    @NotBlank
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[~^&*!@#$%]).{8,20}",
            message = "Invalid password: Valid password must contains one digit, one lowercase characters, " +
                    "one uppercase characters, one special symbols and length at least 8 characters and maximum of 20 !")
    private String password;
    @NotBlank
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[~^&*!@#$%]).{8,20}",
            message = "Invalid password: Valid password must contains one digit, one lowercase characters, " +
            "one uppercase characters, one special symbols and length at least 8 characters and maximum of 20 ! ")
    private String rPassword;

}
