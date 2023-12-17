package com.example.ColaDistributionApp.services;

import com.example.ColaDistributionApp.models.dto.LoggedUser;
import com.example.ColaDistributionApp.models.dto.ShopDTO;
import com.example.ColaDistributionApp.models.dto.UserDTO;
import com.example.ColaDistributionApp.models.entity.Shop;
import com.example.ColaDistributionApp.repository.ShopRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    private final ShopRepository shopRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;
    private final UserService userService;

    @Autowired
    public ShopService(ShopRepository shopRepository, ModelMapper modelMapper, LoggedUser loggedUser, UserService userService) {
        this.shopRepository = shopRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.userService = userService;
    }

    public void addShop(ShopDTO shopDTO) {
        UserDTO userLog = this.userService.findById(loggedUser.getId());

        Shop shop = this.modelMapper.map(shopDTO.builder()
                .name(shopDTO.getName())
                .description(shopDTO.getDescription())
                .classification(shopDTO.getClassification())
                .city(shopDTO.getCity())
                .user(userLog)
                .build(), Shop.class);

        this.shopRepository.saveAndFlush(shop);
    }

    public List<Shop> findAllByUserId() {
        if (loggedUser.isEmpty()) {
            return List.of();
        }
        return this.shopRepository.findAll();
    }
}
