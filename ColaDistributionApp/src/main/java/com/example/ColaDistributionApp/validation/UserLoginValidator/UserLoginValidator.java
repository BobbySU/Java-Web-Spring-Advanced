package com.example.ColaDistributionApp.validation.UserLoginValidator;


import com.example.ColaDistributionApp.models.dto.UserDTO;
import com.example.ColaDistributionApp.models.dto.UserLoginDTO;
import com.example.ColaDistributionApp.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserLoginValidator implements ConstraintValidator<ValidateLoginForm, UserLoginDTO> {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @Autowired
    public UserLoginValidator(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    public void initialize(ValidateLoginForm constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLoginDTO userLoginDTO, ConstraintValidatorContext constraintValidatorContext) {
        UserDTO userDTO = this.userService.findByUsername(userLoginDTO.getUsername());
        return userDTO.getId() != null && passwordEncoder.matches(userLoginDTO.getPassword(),userDTO.getPassword());
    }
}
