package com.example.ColaDistributionApp.services;

import com.example.ColaDistributionApp.models.dto.LoggedUser;
import com.example.ColaDistributionApp.models.dto.ProductDTO;
import com.example.ColaDistributionApp.models.dto.UserDTO;
import com.example.ColaDistributionApp.models.entity.Product;
import com.example.ColaDistributionApp.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;
    private final UserService userService;

    @Autowired
    public ProductService(ProductRepository productRepository, ModelMapper modelMapper, LoggedUser loggedUser, UserService userService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.userService = userService;
    }

    public void addProduct(ProductDTO productDTO) {
        UserDTO userLog = this.userService.findById(loggedUser.getId());

        Product product = this.modelMapper.map(productDTO.builder()
                .name(productDTO.getName())
                        .description(productDTO.getDescription())
                        .category(productDTO.getCategory())
                        .quantity(productDTO.getQuantity())
                        .pack(productDTO.getPack())
                        .price(productDTO.getPrice())
                        .created(productDTO.getCreated())
//                -- Add Plant
//                        .plant(userLog.getPlants().get())
                .build(), Product.class);

        this.productRepository.saveAndFlush(product);
    }
}
