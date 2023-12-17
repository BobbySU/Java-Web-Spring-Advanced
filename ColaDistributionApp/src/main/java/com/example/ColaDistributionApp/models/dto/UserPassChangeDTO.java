package com.example.ColaDistributionApp.models.dto;

import com.example.ColaDistributionApp.validation.ChangeValid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@ChangeValid
public class UserPassChangeDTO {
    @NotNull
    @Size(min = 5, max = 10)
    private String oldPassword;
    @NotNull
    @Size(min = 5, max = 10)
    private String password;
    @NotNull
    @Size(min = 5, max = 10)
    private String confirmPassword;
}
