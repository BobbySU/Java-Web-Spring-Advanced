package com.example.ColaDistributionApp.validation;

import com.example.ColaDistributionApp.models.dto.UserDTO;
import com.example.ColaDistributionApp.models.dto.UserNameChangeDTO;
import com.example.ColaDistributionApp.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class NameChangeValidator implements ConstraintValidator<NameChangeValid, UserNameChangeDTO> {
    private final UserService userService;

    @Autowired
    public NameChangeValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(NameChangeValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserNameChangeDTO userNameChangeDTO, ConstraintValidatorContext constraintValidatorContext) {
        UserDTO userDTO=this.userService.findByUsername(userNameChangeDTO.getUsername());
        return userDTO.getUsername() == null;
    }
}
