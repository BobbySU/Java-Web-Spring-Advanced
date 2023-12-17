package com.example.ColaDistributionApp.models.dto;

import com.example.ColaDistributionApp.validation.ChangeNameValid;
import com.example.ColaDistributionApp.validation.NameChangeValid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@ChangeNameValid
@NameChangeValid
public class UserNameChangeDTO {
    @NotNull
    @Size(min = 5, max = 10)
    private String username;
    @NotNull
    @Size(min = 5, max = 10)
    private String password;
}
