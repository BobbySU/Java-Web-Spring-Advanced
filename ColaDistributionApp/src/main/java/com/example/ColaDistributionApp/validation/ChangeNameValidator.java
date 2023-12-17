package com.example.ColaDistributionApp.validation;

import com.example.ColaDistributionApp.models.dto.UserDTO;
import com.example.ColaDistributionApp.models.dto.LoggedUser;
import com.example.ColaDistributionApp.models.dto.UserNameChangeDTO;
import com.example.ColaDistributionApp.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class ChangeNameValidator implements ConstraintValidator<ChangeNameValid, UserNameChangeDTO> {
    private final LoggedUser loggedUser;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public ChangeNameValidator(LoggedUser loggedUser, UserService userService, PasswordEncoder passwordEncoder) {
        this.loggedUser = loggedUser;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void initialize(ChangeNameValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserNameChangeDTO userNameChangeDTO, ConstraintValidatorContext constraintValidatorContext) {
        UserDTO userDTO = this.userService.findById(loggedUser.getId());
        return userDTO.getId() != null && passwordEncoder.matches(userNameChangeDTO.getPassword(),userDTO.getPassword());
    }
}
