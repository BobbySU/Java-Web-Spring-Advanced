package com.example.ColaDistributionApp.services;

import com.example.ColaDistributionApp.models.dto.LoggedUser;
import com.example.ColaDistributionApp.models.dto.PlantDTO;
import com.example.ColaDistributionApp.models.dto.UserDTO;
import com.example.ColaDistributionApp.models.entity.Plant;
import com.example.ColaDistributionApp.repository.PlantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantService {
    private final PlantRepository plantRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;
    private final UserService userService;

    @Autowired
    public PlantService(PlantRepository plantRepository, ModelMapper modelMapper, LoggedUser loggedUser, UserService userService) {
        this.plantRepository = plantRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.userService = userService;
    }

    public void addPlant(PlantDTO plantDTO) {
        UserDTO userLog = this.userService.findById(loggedUser.getId());

        Plant plant = this.modelMapper.map(plantDTO.builder()
                .name(plantDTO.getName())
                .description(plantDTO.getDescription())
                .category(plantDTO.getCategory())
                .city(plantDTO.getCity())
                .user(userLog)
                .build(), Plant.class);

        this.plantRepository.saveAndFlush(plant);
    }

    public List<Plant> findAllByUserId() {
        if (loggedUser.isEmpty()) {
            return List.of();
        }
        return this.plantRepository.findAll();
    }
}
