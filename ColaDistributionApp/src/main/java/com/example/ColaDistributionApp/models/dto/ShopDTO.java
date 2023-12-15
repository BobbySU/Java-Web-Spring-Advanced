package com.example.ColaDistributionApp.models.dto;

import com.example.ColaDistributionApp.models.entity.Product;
import com.example.ColaDistributionApp.models.entity.User;
import com.example.ColaDistributionApp.models.entity.enums.City;
import com.example.ColaDistributionApp.models.entity.enums.Classification;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopDTO {
    @Size(min = 5, max = 10)
    @NotNull
    private String name;
    @Size(min = 5, max = 25)
    @NotNull
    private String description;
    @NotNull
    private Classification classification;
    @NotNull
    private City city;
//    @NotNull
    private UserDTO user;

    private List<Product> products;
}
