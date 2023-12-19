package com.example.ColaDistributionApp.validation;

import com.example.ColaDistributionApp.models.dto.LoggedUser;
import com.example.ColaDistributionApp.models.dto.SecureKeyDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class SecureKeyValidator implements ConstraintValidator<SecureKeyValid, SecureKeyDTO> {
    private final LoggedUser loggedUser;

    @Autowired
    public SecureKeyValidator(LoggedUser loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Override
    public void initialize(SecureKeyValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(SecureKeyDTO secureKeyDTO, ConstraintValidatorContext constraintValidatorContext) {
        return secureKeyDTO.getSecureKey() != null && secureKeyDTO.getSecureKey().equals(loggedUser.getSecureKey());
    }
}
