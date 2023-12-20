package com.example.ColaDistributionApp.services;

import com.example.ColaDistributionApp.models.dto.*;
import com.example.ColaDistributionApp.models.entity.User;
import com.example.ColaDistributionApp.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

import static com.example.ColaDistributionApp.models.entity.enums.Position.MANUFACTURER;
import static com.example.ColaDistributionApp.models.entity.enums.Position.SELLER;
import static com.example.ColaDistributionApp.models.entity.enums.Role.ADMINISTRATOR;
import static com.example.ColaDistributionApp.models.entity.enums.Role.USER;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper, LoggedUser loggedUser, PasswordEncoder passwordEncoder, EmailService emailService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    public void registerUser(UserRegisterDTO userRegisterDTO) {
        User user = this.modelMapper.map(userRegisterDTO, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
//       --- if you want to send to real Mail---
//        this.emailService.sendEmail(user.getEmail(),user.getUsername(),
//        "Hello You have successfully registered " + user.getFullName());
//        --- or ---
//        this.emailService.sendEmail(("colaapp12@gmail.com"), user.getUsername(),
        this.emailService.sendEmail((user.getEmail()), user.getUsername(),
                "Hello " + user.getUsername() + " You have successfully registered.");
        this.userRepository.saveAndFlush(user);
    }

    public void loginUser(UserLoginDTO userLoginDTO) {
        User user = this.userRepository.findByUsername(userLoginDTO.getUsername()).get();
        this.loggedUser.setUsername(user.getUsername());
        Random random = new Random();
        this.loggedUser.setSecureKey(String.format("%06d", random.nextInt(1000000)));
//        this.emailService.sendEmail(("colaapp12@gmail.com"), loggedUser.getUsername(),
        this.emailService.sendEmail((user.getEmail()), user.getUsername(),
                "Hello " + user.getUsername() + " Your secret key is " + loggedUser.getSecureKey());
    }

    public void secure() {
        User user = this.userRepository.findByUsername(loggedUser.getUsername()).get();
        this.loggedUser.setId(user.getId());
        this.loggedUser.setSecureKey(null);
    }

    public void logoutUser() {
        loggedUser.clearUser();
    }

    public UserDTO findByUsername(String username) {
        return this.modelMapper.map(this.userRepository.findByUsername(username).orElse(new User()), UserDTO.class);
    }

    public UserDTO findById(String id) {
        return this.modelMapper.map(this.userRepository.findById(id).orElse(new User()), UserDTO.class);
    }

    public UserDTO findUserByEmail(String email) {
        return this.modelMapper.map(this.userRepository.findUserByEmail(email).orElse(new User()), UserDTO.class);
    }

    public void changePass(UserPassChangeDTO userPassChangeDTO) {
        User changeUser = userRepository.findById(loggedUser.getId()).get();
        changeUser.setPassword(passwordEncoder.encode(userPassChangeDTO.getPassword()));
        this.userRepository.saveAndFlush(changeUser);
    }

    public void changeName(UserNameChangeDTO userNameChangeDTO) {
        User changeUser = userRepository.findById(loggedUser.getId()).get();
        changeUser.setUsername(userNameChangeDTO.getUsername());
        this.userRepository.saveAndFlush(changeUser);
        this.loggedUser.setUsername(changeUser.getUsername());
    }

    @PostConstruct
    private void postConstructUser() {
        if (userRepository.count() == 0) {
            this.userRepository.saveAndFlush(this.modelMapper.map(UserDTO.builder()
                    .username("bobby")
                    .password(passwordEncoder.encode("12345"))
                    .fullName("Bobbyto")
                    .email("bobby@abv.bg")
                    .role(ADMINISTRATOR)
                    .position(MANUFACTURER)
                    .created(new Date())
                    .build(), User.class));
            this.userRepository.saveAndFlush(this.modelMapper.map(UserDTO.builder()
                    .username("peppy")
                    .password(passwordEncoder.encode("12345"))
                    .fullName("Peppyto")
                    .email("petar@abv.bg")
                    .role(USER)
                    .position(SELLER)
                    .created(new Date())
                    .build(), User.class));
            this.userRepository.saveAndFlush(this.modelMapper.map(UserDTO.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("12345"))
                    .fullName("Aeppyto")
                    .email("admin@abv.bg")
                    .role(ADMINISTRATOR)
                    .position(SELLER)
                    .created(new Date())
                    .build(), User.class));
        }
    }
}
