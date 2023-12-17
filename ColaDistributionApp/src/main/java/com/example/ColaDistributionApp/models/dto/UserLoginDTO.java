package com.example.ColaDistributionApp.models.dto;

import com.example.ColaDistributionApp.validation.ValidateLoginForm;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@ValidateLoginForm
public class UserLoginDTO {
    @NotNull
    private String username;
    @NotNull
    private String password;
}