package com.example.ColaDistributionApp.validation.PasswordMatcher;


import com.example.ColaDistributionApp.models.dto.UserRegisterDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatcher implements ConstraintValidator<PasswordMatch, UserRegisterDTO> {
    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserRegisterDTO userRegisterDTO, ConstraintValidatorContext constraintValidatorContext) {
        if (userRegisterDTO.getPassword() != null && userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())) {
            return true;
        }

        constraintValidatorContext.buildConstraintViolationWithTemplate(constraintValidatorContext
                .getDefaultConstraintMessageTemplate())
                .addPropertyNode(userRegisterDTO.getConfirmPassword())
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}
