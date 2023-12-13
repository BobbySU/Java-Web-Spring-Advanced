package com.example.ColaDistributionApp.services;

import com.example.ColaDistributionApp.models.dto.UserDTO;
import com.example.ColaDistributionApp.models.entity.User;
import com.example.ColaDistributionApp.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @PostConstruct
    private void postConstructUser() {
        if (userRepository.count() == 0) {
            this.userRepository.saveAndFlush(this.modelMapper.map(UserDTO.builder()
                    .username("bobby")
                    .password("12345")
                    .fullName("Bobbyto")
                    .email("bobby@abv.bg")
                    .role(ADMINISTRATOR)
                    .position(MANUFACTURER)
                    .created(new Date())
                    .build(), User.class));
            this.userRepository.saveAndFlush(this.modelMapper.map(UserDTO.builder()
                    .username("peppy")
                    .password("12345")
                    .fullName("Peppyto")
                    .email("petar@abv.bg")
                    .role(USER)
                    .position(SELLER)
                    .created(new Date())
                    .build(), User.class));
        }
    }
}
