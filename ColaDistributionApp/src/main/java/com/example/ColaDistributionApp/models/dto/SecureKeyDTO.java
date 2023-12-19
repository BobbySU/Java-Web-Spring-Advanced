package com.example.ColaDistributionApp.models.dto;

import com.example.ColaDistributionApp.validation.SecureKeyValid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@SecureKeyValid
public class SecureKeyDTO {
    @NotNull
    private String secureKey;
}
