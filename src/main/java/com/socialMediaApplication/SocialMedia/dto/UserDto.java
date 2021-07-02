package com.socialMediaApplication.SocialMedia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserDto {
    private Long id;
    @NotEmpty(message = "User Name is Mandatory")
    private String username;
    @NotEmpty(message = "You Have To Enter The Password")
    @Size(min = 8, max = 20, message = "Password length should be in between 8 to 20")
    @JsonProperty
    private String password;


    @NotEmpty(message = "Phone Number is Mandatory")
    @Pattern(regexp = "^(?:\\+?88)?01[135-9]\\d{8}$", message = "invalid mobile number.")
    @Size(max = 11, message = "digits should be 11")
    private String phone;
    @NotEmpty(message = "Email field should not be empty")
    @Email(regexp = "^(.+)@(.+)$", message = "Invalid Email Pattern")
    private String email;
}
