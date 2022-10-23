package com.springboot.springboot.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateUserRequest {

    @NotBlank(message = "First Name is required")
    public String FirstName;

    @NotBlank(message = "Last Name is required")
    public String LastName;

    @NotBlank(message = "Username is required")
    public String UserName;

    @NotBlank(message = "Password is required")
    public String Password;

    @NotNull(message = "Role is required")
    public UUID RoleId;

    public CreateUserRequest(@NotBlank(message = "First Name is required") String firstName,
            @NotBlank(message = "Last Name is required") String lastName,
            @NotBlank(message = "Username is required") String userName,
            @NotBlank(message = "Password is required") String password,
            @NotNull(message = "Role is required") UUID roleId) {
        FirstName = firstName;
        LastName = lastName;
        UserName = userName;
        Password = password;
        RoleId = roleId;
    }

}
