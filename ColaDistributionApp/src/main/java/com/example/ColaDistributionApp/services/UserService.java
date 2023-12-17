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

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper, LoggedUser loggedUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserRegisterDTO userRegisterDTO){
        User user = this.modelMapper.map(userRegisterDTO, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        this.userRepository.saveAndFlush(user);
    }

    public void loginUser(UserLoginDTO userLoginDTO){
        User user = this.userRepository.findByUsername(userLoginDTO.getUsername()).get();
        this.loggedUser.setId(user.getId());
        this.loggedUser.setUsername(user.getUsername());
    }

    public void logoutUser(){
        loggedUser.clearUser();
    }

    public UserDTO findByUsername(String username) {
        return this.modelMapper.map(this.userRepository.findByUsername(username).orElse(new User()), UserDTO.class);
    }

    public UserDTO findById(String id) {
        return this.modelMapper.map(this.userRepository.findById(id).orElse(new User()), UserDTO.class);
    }

    public void changePass(UserPassChangeDTO userPassChangeDTO) {
        User changeUser = userRepository.findById(loggedUser.getId()).get();
        changeUser.setPassword(userPassChangeDTO.getPassword());
        this.userRepository.saveAndFlush(changeUser);
    }

    @PostConstruct
    private void postConstructUser() {
        if (userRepository.count() == 0) {
            this.userRepository.saveAndFlush(this.modelMapper.map(UserDTO.builder()
                    .username("bobby1")
                    .password(passwordEncoder.encode("12345"))
                    .fullName("Bobbyto")
                    .email("bobby@abv.bg")
                    .role(ADMINISTRATOR)
                    .position(MANUFACTURER)
                    .created(new Date())
                    .build(), User.class));
            this.userRepository.saveAndFlush(this.modelMapper.map(UserDTO.builder()
                    .username("peppy1")
                    .password(passwordEncoder.encode("12345"))
                    .fullName("Peppyto")
                    .email("petar@abv.bg")
                    .role(USER)
                    .position(SELLER)
                    .created(new Date())
                    .build(), User.class));
        }
    }
}
