package com.example.ColaDistributionApp.validation;

import com.example.ColaDistributionApp.models.dto.*;
import com.example.ColaDistributionApp.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ChangeValidator implements ConstraintValidator<ChangeValid, UserPassChangeDTO> {
    private final LoggedUser loggedUser;
    private final UserService userService;

    @Autowired
    public ChangeValidator(LoggedUser loggedUser, UserService userService) {
        this.loggedUser = loggedUser;
        this.userService = userService;
    }

    @Override
    public void initialize(ChangeValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserPassChangeDTO userPassChangeDTO, ConstraintValidatorContext constraintValidatorContext) {
        UserDTO userDTO = this.userService.findById(loggedUser.getId());
       return userDTO.getId() != null && userDTO.getPassword().equals(userPassChangeDTO.getOldPassword()) &&
                userPassChangeDTO.getPassword() != null &&
                userPassChangeDTO.getPassword().equals(userPassChangeDTO.getConfirmPassword());
    }
}
