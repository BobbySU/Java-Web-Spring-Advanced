package com.example.ColaDistributionApp.validation;

import com.example.ColaDistributionApp.models.dto.UserDTO;
import com.example.ColaDistributionApp.models.dto.UserRegisterDTO;
import com.example.ColaDistributionApp.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class NameValidator implements ConstraintValidator<NameValid, UserRegisterDTO> {
    private final UserService userService;

    @Autowired
    public NameValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(NameValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserRegisterDTO userRegisterDTO, ConstraintValidatorContext constraintValidatorContext) {
        UserDTO userDTO=this.userService.findByUsername(userRegisterDTO.getUsername());
        return userDTO.getUsername() == null;
    }
}
