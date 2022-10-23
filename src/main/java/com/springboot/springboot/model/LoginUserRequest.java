package com.springboot.springboot.model;

import javax.validation.constraints.NotBlank;

public class LoginUserRequest {

    @NotBlank(message = "Username is required")
    public String UserName;

    @NotBlank(message = "Password is required")
    public String Password;

    public LoginUserRequest(@NotBlank(message = "Username is required") String userName,
            @NotBlank(message = "Password is required") String password) {
        UserName = userName;
        Password = password;
    }
}
