package com.example.ColaDistributionApp.validation;

import com.example.ColaDistributionApp.models.dto.UserDTO;
import com.example.ColaDistributionApp.models.dto.UserRegisterDTO;
import com.example.ColaDistributionApp.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailValidator implements ConstraintValidator<EmailValid, UserRegisterDTO> {
    private final UserService userService;

    @Autowired
    public EmailValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(EmailValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserRegisterDTO userRegisterDTO, ConstraintValidatorContext constraintValidatorContext) {
        UserDTO userDTO=this.userService.findUserByEmail(userRegisterDTO.getEmail());
        return userDTO.getEmail() == null;
    }
}
