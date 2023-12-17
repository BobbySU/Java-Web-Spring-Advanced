package com.example.ColaDistributionApp.models.dto;

import com.example.ColaDistributionApp.models.entity.enums.Position;
import com.example.ColaDistributionApp.models.entity.enums.Role;
import com.example.ColaDistributionApp.validation.EmailValid;
import com.example.ColaDistributionApp.validation.NameValid;
import com.example.ColaDistributionApp.validation.PasswordMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@PasswordMatch
@EmailValid
@NameValid
public class UserRegisterDTO {
    @Size(min = 5, max = 10)
    @NotNull
    private String username;
    @Size(min = 5, max = 10)
    @NotNull
    private String password;
    @Size(min = 5, max = 10)
    @NotNull
    private String confirmPassword;
    @Size(min = 5, max = 10)
    @NotNull
    private String fullName;
    @Email
    @NotNull
    private String email;
    @NotNull
    private Role role;
    @NotNull
    private Position position;
    @NotNull
    private Date created = new Date();
}
