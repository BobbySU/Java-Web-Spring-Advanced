package com.example.ColaDistributionApp.validation;

import com.example.ColaDistributionApp.models.dto.*;
import com.example.ColaDistributionApp.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class ChangeValidator implements ConstraintValidator<ChangeValid, UserPassChangeDTO> {
    private final LoggedUser loggedUser;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ChangeValidator(LoggedUser loggedUser, UserService userService, PasswordEncoder passwordEncoder) {
        this.loggedUser = loggedUser;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void initialize(ChangeValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserPassChangeDTO userPassChangeDTO, ConstraintValidatorContext constraintValidatorContext) {
        UserDTO userDTO = this.userService.findById(loggedUser.getId());
       return userDTO.getId() != null && passwordEncoder.matches(userPassChangeDTO.getOldPassword(),userDTO.getPassword()) &&
                userPassChangeDTO.getPassword() != null &&
               userPassChangeDTO.getConfirmPassword()!= null &&
                userPassChangeDTO.getPassword().equals(userPassChangeDTO.getConfirmPassword());
    }
}
